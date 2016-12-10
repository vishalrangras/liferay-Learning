package com.ihg.me2.wall.hook;

import com.ihg.me2.wall.servlet.WallNotificationServlet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceWrapper;
import com.liferay.portlet.messageboards.service.MBStatsUserLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;

import java.util.Date;
import java.util.List;

public class MBMessageLocalServiceImplHook extends MBMessageLocalServiceWrapper {

	public MBMessageLocalServiceImplHook(MBMessageLocalService mbMessageLocalService) {
		super(mbMessageLocalService);
		//Auto-generated constructor stub
	}
	
	@Override
	public MBMessage updateStatus(
			long userId, long messageId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		if(serviceContext.getThemeDisplay()==null || serviceContext.getThemeDisplay().getLayout()==null){
			return super.updateStatus(userId, messageId, status, serviceContext);
		}
		
		long groupId = serviceContext.getThemeDisplay().getLayout().getGroupId();
		List<Long> groupIds = WallNotificationServlet.getGroupIds();
		
		if(!groupIds.contains(groupId)){
			System.out.println("Bypassing hook");
			return super.updateStatus(userId, messageId, status, serviceContext);
		}
		
		System.out.println("Implementing hook");
		
		// Message
		MBMessage message = getMessage(messageId);

		int oldStatus = message.getStatus();
		User user = UserLocalServiceUtil.fetchUser(userId);
		//User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		Date modifiedDate = serviceContext.getModifiedDate(now);

		message.setStatus(status);
		message.setStatusByUserId(userId);
		message.setStatusByUserName(user.getFullName());
		message.setStatusDate(modifiedDate);
		
		MBMessageLocalServiceUtil.updateMBMessage(message);
		
		//mbMessagePersistence.update();

		// Thread
		
		MBThread thread = MBThreadLocalServiceUtil.fetchMBThread(message.getThreadId());
		//MBThread thread = mbThreadPersistence.findByPrimaryKey(message.getThreadId());

		updateThreadStatus(thread, message, user, oldStatus, modifiedDate);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBMessage.class);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (oldStatus != WorkflowConstants.STATUS_APPROVED) {

				// Asset

				if (serviceContext.isAssetEntryVisible() &&
					((message.getClassNameId() == 0) ||
					 (message.getParentMessageId() != 0))) {

					Date publishDate = null;
					
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(message.getWorkflowClassName(), message.getMessageId());
					
					//AssetEntry assetEntry = assetEntryLocalService.fetchEntry(message.getWorkflowClassName(), message.getMessageId());

					if ((assetEntry != null) &&
						(assetEntry.getPublishDate() != null)) {

						publishDate = assetEntry.getPublishDate();
					}
					else {
						publishDate = now;

						serviceContext.setCommand(Constants.ADD);
					}
					
					AssetEntryLocalServiceUtil.updateEntry(message.getWorkflowClassName(), message.getMessageId(), publishDate, true);
					
					//assetEntryLocalService.updateEntry(message.getWorkflowClassName(), message.getMessageId(), publishDate, true);
					
				}

				if (serviceContext.isCommandAdd()) {

					// Social

					JSONObject extraDataJSONObject =
						JSONFactoryUtil.createJSONObject();

					extraDataJSONObject.put("title", message.getSubject());

					if (!message.isDiscussion() ) {
						if (!message.isAnonymous() && !user.isDefaultUser()) {
							long receiverUserId = 0;

							
							MBMessage parentMessage = MBMessageLocalServiceUtil.fetchMBMessage(message.getParentMessageId());
							//MBMessage parentMessage = mbMessagePersistence.fetchByPrimaryKey(message.getParentMessageId());

							if (parentMessage != null) {
								receiverUserId = parentMessage.getUserId();
							}
							
							SocialActivityLocalServiceUtil.addActivity(message.getUserId(), message.getGroupId(), MBMessage.class.getName(), message.getMessageId(), 1,	extraDataJSONObject.toString(), receiverUserId);
							//socialActivityLocalService.addActivity(message.getUserId(), message.getGroupId(), MBMessage.class.getName(), message.getMessageId(), 1,	extraDataJSONObject.toString(), receiverUserId);

							if ((parentMessage != null) &&
								(receiverUserId != message.getUserId())) {
								
								SocialActivityLocalServiceUtil.addActivity(message.getUserId(),
									parentMessage.getGroupId(),
									MBMessage.class.getName(),
									parentMessage.getMessageId(),
									2,
									extraDataJSONObject.toString(), 0);
								
								/*socialActivityLocalService.addActivity(
									message.getUserId(),
									parentMessage.getGroupId(),
									MBMessage.class.getName(),
									parentMessage.getMessageId(),
									2,
									extraDataJSONObject.toString(), 0);*/
							}
						}
					}
					else {
						String className = (String)serviceContext.getAttribute(
							"className");
						long classPK = ParamUtil.getLong(
							serviceContext, "classPK");
						long parentMessageId = message.getParentMessageId();

						if (parentMessageId !=
								MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

							AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(className, classPK);
							
							//AssetEntry assetEntry =	assetEntryLocalService.fetchEntry(className, classPK);

							if (assetEntry != null) {
								extraDataJSONObject.put(
									"messageId", message.getMessageId());
								
								SocialActivityLocalServiceUtil.addActivity(message.getUserId(),
									assetEntry.getGroupId(), className, classPK,
									SocialActivityConstants.TYPE_ADD_COMMENT,
									extraDataJSONObject.toString(),
									assetEntry.getUserId());
								
								/*socialActivityLocalService.addActivity(
									message.getUserId(),
									assetEntry.getGroupId(), className, classPK,
									SocialActivityConstants.TYPE_ADD_COMMENT,
									extraDataJSONObject.toString(),
									assetEntry.getUserId());*/
							}
						}
					}
				}
			}

			// Subscriptions

			//notifySubscribers((MBMessage)message.clone(), serviceContext);
			
			// Indexer

			indexer.reindex(message);

			// Ping

//			pingPingback(message, serviceContext);
		}
		else if (oldStatus == WorkflowConstants.STATUS_APPROVED) {

			// Asset
			
			AssetEntryLocalServiceUtil.updateVisible(message.getWorkflowClassName(), message.getMessageId(), false);
			//assetEntryLocalService.updateVisible(message.getWorkflowClassName(), message.getMessageId(), false);

			// Indexer

			indexer.delete(message);
		}

		// Statistics

		if (!message.isDiscussion()) {
			MBStatsUserLocalServiceUtil.updateStatsUser(message.getGroupId(), userId,
					serviceContext.getModifiedDate(now));
			/*mbStatsUserLocalService.updateStatsUser(
				message.getGroupId(), userId,
				serviceContext.getModifiedDate(now));*/
		}

		return message;
	}
	
	protected void updateThreadStatus(
			MBThread thread, MBMessage message, User user, int oldStatus,
			Date modifiedDate)
		throws PortalException, SystemException {
		
		long companyId = thread.getCompanyId();
		
		final long threadId = thread.getThreadId();
		
		MBCategory category = null;

		int status = message.getStatus();

		if ((thread.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(thread.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			category = MBCategoryLocalServiceUtil.fetchMBCategory(thread.getCategoryId());
			//category = mbCategoryPersistence.findByPrimaryKey(thread.getCategoryId());
		}

		if ((thread.getRootMessageId() == message.getMessageId()) &&
			(oldStatus != status)) {

			thread.setModifiedDate(modifiedDate);
			thread.setStatus(status);
			thread.setStatusByUserId(user.getUserId());
			thread.setStatusByUserName(user.getFullName());
			thread.setStatusDate(modifiedDate);
		}

		if (status == oldStatus) {
			return;
		}

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (message.isAnonymous()) {
				thread.setLastPostByUserId(0);
			}
			else {
				thread.setLastPostByUserId(message.getUserId());
			}

			thread.setLastPostDate(modifiedDate);

			if (category != null) {
				category.setLastPostDate(modifiedDate);
				category = MBCategoryLocalServiceUtil.updateMBCategory(category);
				//category = mbCategoryPersistence.update(category);
			}
		}

		if ((oldStatus == WorkflowConstants.STATUS_APPROVED) ||
				(status == WorkflowConstants.STATUS_APPROVED)) {

				// Thread

				MBUtil.updateThreadMessageCount(
					thread.getCompanyId(), thread.getThreadId());

				// Category

				if ((category != null) &&
					(thread.getRootMessageId() == message.getMessageId())) {

					MBUtil.updateCategoryStatistics(
						category.getCompanyId(), category.getCategoryId());
				}

				if ((category != null) &&
					!(thread.getRootMessageId() == message.getMessageId())) {

					MBUtil.updateCategoryMessageCount(
						category.getCompanyId(), category.getCategoryId());
				}
			}

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBThread.class);

		indexer.reindex(thread);
		
		MBThreadLocalServiceUtil.updateMBThread(thread);
		//mbThreadPersistence.update(thread);
	}
	
	

}
