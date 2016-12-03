package com.cd.learning.hook;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.shard.ShardCallable;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackRegistryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.PortletURLFactoryUtil;
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
import com.liferay.util.SerializableUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class MBLocalServiceSubsHook extends MBMessageLocalServiceWrapper{

	public MBLocalServiceSubsHook(MBMessageLocalService mbMessageLocalService) {
		super(mbMessageLocalService);
		// TODO Auto-generated constructor stub
	}
	
	protected String getLayoutURL(
			Layout layout, ServiceContext serviceContext) {

			HttpServletRequest request = serviceContext.getRequest();

			if (request == null) {
				return StringPool.BLANK;
			}

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			try {
				return PortalUtil.getLayoutURL(layout, themeDisplay);
			}
			catch (Exception e) {
				return StringPool.BLANK;
			}
		}
	
	protected String getLayoutURL(
			long groupId, String portletId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long plid = serviceContext.getPlid();

		long controlPanelPlid = PortalUtil.getControlPanelPlid(
			serviceContext.getCompanyId());

		if (plid == controlPanelPlid) {
			plid = PortalUtil.getPlidFromPortletId(groupId, portletId);
		}

		String layoutURL = StringPool.BLANK;

		if (plid != LayoutConstants.DEFAULT_PLID) {
			//Layout layout = layoutPersistence.findByPrimaryKey(plid);
			Layout layout = LayoutLocalServiceUtil.fetchLayout(plid);
			
			layoutURL = getLayoutURL(layout, serviceContext);
		}

		return layoutURL;
	}
	
	protected String getMessageURL(
			MBMessage message, ServiceContext serviceContext)
		throws PortalException, SystemException {

		HttpServletRequest request = serviceContext.getRequest();

		if (request == null) {
			if (Validator.isNull(serviceContext.getLayoutFullURL())) {
				return StringPool.BLANK;
			}

			return serviceContext.getLayoutFullURL() +
				Portal.FRIENDLY_URL_SEPARATOR + "message_boards/view_message/" +
					message.getMessageId();
		}

		String layoutURL = getLayoutURL(
			message.getGroupId(), PortletKeys.MESSAGE_BOARDS, serviceContext);

		if (Validator.isNotNull(layoutURL)) {
			return layoutURL + Portal.FRIENDLY_URL_SEPARATOR +
				"message_boards/view_message/" + message.getMessageId();
		}
		else {
			long controlPanelPlid = PortalUtil.getControlPanelPlid(
				serviceContext.getCompanyId());

			PortletURL portletURL = PortletURLFactoryUtil.create(
				request, PortletKeys.MESSAGE_BOARDS_ADMIN, controlPanelPlid,
				PortletRequest.RENDER_PHASE);

			portletURL.setParameter(
				"struts_action", "/message_boards_admin/view_message");
			portletURL.setParameter(
				"messageId", String.valueOf(message.getMessageId()));

			return portletURL.toString();
		}
	}
	
	protected void notifyDiscussionSubscribers(
			MBMessage message, ServiceContext serviceContext)
		throws SystemException {

		if (!PrefsPropsUtil.getBoolean(
				message.getCompanyId(),
				PropsKeys.DISCUSSION_EMAIL_COMMENTS_ADDED_ENABLED)) {

			return;
		}

		String contentURL = (String)serviceContext.getAttribute("contentURL");

		String userAddress = StringPool.BLANK;
		String userName = (String)serviceContext.getAttribute(
			"pingbackUserName");

		if (Validator.isNull(userName)) {
			userAddress = PortalUtil.getUserEmailAddress(message.getUserId());
			userName = PortalUtil.getUserName(
				message.getUserId(), StringPool.BLANK);
		}

		String fromName = PrefsPropsUtil.getString(
			message.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(
			message.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		String subject = PrefsPropsUtil.getContent(
			message.getCompanyId(), PropsKeys.DISCUSSION_EMAIL_SUBJECT);
		String body = PrefsPropsUtil.getContent(
			message.getCompanyId(), PropsKeys.DISCUSSION_EMAIL_BODY);

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(message.getCompanyId());
		subscriptionSender.setContextAttribute(
			"[$COMMENTS_BODY$]", message.getBody(true), false);
		subscriptionSender.setContextAttributes(
			"[$COMMENTS_USER_ADDRESS$]", userAddress, "[$COMMENTS_USER_NAME$]",
			userName, "[$CONTENT_URL$]", contentURL);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId(
			"mb_discussion", message.getCategoryId(), message.getMessageId());
		subscriptionSender.setScopeGroupId(message.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUserId(message.getUserId());

		String className = (String)serviceContext.getAttribute("className");
		long classPK = ParamUtil.getLong(serviceContext, "classPK");

		subscriptionSender.addPersistedSubscribers(className, classPK);

		subscriptionSender.flushNotificationsAsync();
	}
	
	protected void notifySubscribers(ServiceContext serviceContext) throws SystemException{
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -24);
		Date date = cal.getTime();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class).add(RestrictionsFactoryUtil.ge("modifiedDate", date));
		
		List<MBMessage> messageList = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		for (MBMessage message : messageList){
			System.out.println(message.getBody());
		}
		
	}
	
	protected void notifySubscribers(
			MBMessage message, ServiceContext serviceContext)
		throws PortalException, SystemException {

		String layoutFullURL = serviceContext.getLayoutFullURL();

		if (!message.isApproved() || Validator.isNull(layoutFullURL)) {
			return;
		}

		if (message.isDiscussion()) {
			try {
				notifyDiscussionSubscribers(message, serviceContext);
			}
			catch (Exception e) {
				System.err.println(e);
			}

			return;
		}

		PortletPreferences preferences =
			ServiceContextUtil.getPortletPreferences(serviceContext);

		if (preferences == null) {
			long ownerId = message.getGroupId();
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
			long plid = PortletKeys.PREFS_PLID_SHARED;
			String portletId = PortletKeys.MESSAGE_BOARDS;
			String defaultPreferences = null;

			preferences = PortletPreferencesLocalServiceUtil.getPreferences(
				message.getCompanyId(), ownerId, ownerType, plid, portletId,
				defaultPreferences);
		}

		if (serviceContext.isCommandAdd() &&
			MBUtil.getEmailMessageAddedEnabled(preferences)) {
		}
		else if (serviceContext.isCommandUpdate() &&
				 MBUtil.getEmailMessageUpdatedEnabled(preferences)) {
		}
		else {
			return;
		}

		Company company = CompanyLocalServiceUtil.fetchCompany(message.getCompanyId());
		//Company company = companyPersistence.findByPrimaryKey(message.getCompanyId());
		
		Group group = GroupLocalServiceUtil.fetchGroup(message.getGroupId());
		//Group group = groupPersistence.findByPrimaryKey(message.getGroupId());

		String emailAddress = PortalUtil.getUserEmailAddress(
			message.getUserId());
		String fullName = PortalUtil.getUserName(
			message.getUserId(), message.getUserName());

		if (message.isAnonymous()) {
			emailAddress = StringPool.BLANK;
			fullName = serviceContext.translate("anonymous");
		}

		MBCategory category = message.getCategory();

		String categoryName = category.getName();

		if (category.getCategoryId() ==
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			categoryName = serviceContext.translate("message-boards-home");

			categoryName += " - " + group.getDescriptiveName();
		}

		List<Long> categoryIds = new ArrayList<Long>();

		categoryIds.add(message.getCategoryId());

		if (message.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			categoryIds.addAll(category.getAncestorCategoryIds());
		}

		String fromName = MBUtil.getEmailFromName(
			preferences, message.getCompanyId());
		String fromAddress = MBUtil.getEmailFromAddress(
			preferences, message.getCompanyId());

		String replyToAddress = StringPool.BLANK;

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.POP_SERVER_NOTIFICATIONS_ENABLED))) {
			replyToAddress = MBUtil.getReplyToAddress(
				message.getCategoryId(), message.getMessageId(),
				company.getMx(), fromAddress);
		}

		String subject = null;
		String body = null;
		String signature = null;

		if (serviceContext.isCommandUpdate()) {
			subject = MBUtil.getEmailMessageUpdatedSubject(preferences);
			body = MBUtil.getEmailMessageUpdatedBody(preferences);
			signature = MBUtil.getEmailMessageUpdatedSignature(preferences);
		}
		else {
			subject = MBUtil.getEmailMessageAddedSubject(preferences);
			body = MBUtil.getEmailMessageAddedBody(preferences);
			signature = MBUtil.getEmailMessageAddedSignature(preferences);
		}

		boolean htmlFormat = MBUtil.getEmailHtmlFormat(preferences);

		if (Validator.isNotNull(signature)) {
			String signatureSeparator = null;

			if (htmlFormat) {
				signatureSeparator = "<br />--<br />";
			}
			else {
				signatureSeparator = "\n--\n";
			}

			body += signatureSeparator + signature;
		}

		String messageBody = message.getBody();

		if (htmlFormat && message.isFormatBBCode()) {
			try {
				messageBody = BBCodeTranslatorUtil.getHTML(messageBody);

				HttpServletRequest request = serviceContext.getRequest();

				if (request != null) {
					ThemeDisplay themeDisplay =
						(ThemeDisplay)request.getAttribute(
							WebKeys.THEME_DISPLAY);

					messageBody = MBUtil.replaceMessageBodyPaths(
						themeDisplay, messageBody);
				}
			}
			catch (Exception e) {
				System.err.println(
					"Could not parse message " + message.getMessageId() +
						" " + e.getMessage());
			}
		}

		String inReplyTo = null;

		if (message.getParentMessageId() !=
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

			inReplyTo = PortalUtil.getMailId(
				company.getMx(), MBUtil.MESSAGE_POP_PORTLET_PREFIX,
				message.getCategoryId(), message.getParentMessageId());
		}

		SubscriptionSender subscriptionSenderPrototype =
			new MBSubscriptionSender();

		subscriptionSenderPrototype.setBody(body);
		subscriptionSenderPrototype.setBulk(
				GetterUtil.getBoolean(PropsUtil.get(PropsKeys.MESSAGE_BOARDS_EMAIL_BULK)));
		subscriptionSenderPrototype.setCompanyId(message.getCompanyId());
		subscriptionSenderPrototype.setContextAttribute(
			"[$MESSAGE_BODY$]", messageBody, false);
		subscriptionSenderPrototype.setContextAttributes(
			"[$CATEGORY_NAME$]", categoryName, "[$MAILING_LIST_ADDRESS$]",
			replyToAddress, "[$MESSAGE_ID$]", message.getMessageId(),
			"[$MESSAGE_SUBJECT$]", message.getSubject(), "[$MESSAGE_URL$]",
			getMessageURL(message, serviceContext), "[$MESSAGE_USER_ADDRESS$]",
			emailAddress, "[$MESSAGE_USER_NAME$]", fullName);
		subscriptionSenderPrototype.setFrom(fromAddress, fromName);
		subscriptionSenderPrototype.setHtmlFormat(htmlFormat);
		subscriptionSenderPrototype.setInReplyTo(inReplyTo);
		subscriptionSenderPrototype.setMailId(
			MBUtil.MESSAGE_POP_PORTLET_PREFIX, message.getCategoryId(),
			message.getMessageId());
		subscriptionSenderPrototype.setPortletId(PortletKeys.MESSAGE_BOARDS);
		subscriptionSenderPrototype.setReplyToAddress(replyToAddress);
		subscriptionSenderPrototype.setScopeGroupId(message.getGroupId());
		subscriptionSenderPrototype.setServiceContext(serviceContext);
		subscriptionSenderPrototype.setSubject(subject);
		subscriptionSenderPrototype.setUserId(message.getUserId());

		SubscriptionSender subscriptionSender =
			(SubscriptionSender)SerializableUtil.clone(
				subscriptionSenderPrototype);

		subscriptionSender.addPersistedSubscribers(
			MBCategory.class.getName(), message.getGroupId());

		for (long categoryId : categoryIds) {
			if (categoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
				subscriptionSender.addPersistedSubscribers(
					MBCategory.class.getName(), categoryId);
			}
		}

		subscriptionSender.addPersistedSubscribers(
			MBThread.class.getName(), message.getThreadId());

		notify(
			subscriptionSender, subscriptionSenderPrototype,
			message.getGroupId(), categoryIds);
	}
	
	protected void notify(
			final SubscriptionSender subscriptionSender,
			final SubscriptionSender subscriptionSenderPrototype,
			final long groupId, final List<Long> categoryIds) {

			TransactionCommitCallbackRegistryUtil.registerCallback(
				new Callable<Void>() {

					@Override
					public Void call() throws Exception {
						subscriptionSender.flushNotificationsAsync();
						
						if (!MailingListThreadLocal.isSourceMailingList()) {
							return null;
						}

						for (long categoryId : categoryIds) {
							MBSubscriptionSender
								sourceMailingListSubscriptionSender =
									(MBSubscriptionSender)SerializableUtil.clone(
										subscriptionSenderPrototype);

							sourceMailingListSubscriptionSender.setBulk(false);

							sourceMailingListSubscriptionSender.
								addMailingListSubscriber(groupId, categoryId);

							sourceMailingListSubscriptionSender.
								flushNotificationsAsync();
						}

						return null;
					}

				});
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

//			MBUtil.updateThreadMessageCount(
//				thread.getCompanyId(), thread.getThreadId());
			
			
			
			Callable<Void> callable = new ShardCallable<Void>(companyId) {

				@Override
				protected Void doCall() throws Exception {
					MBThread thread = MBThreadLocalServiceUtil.fetchThread(
						threadId);

					if (thread == null) {
						return null;
					}

					int messageCount =
						MBMessageLocalServiceUtil.getThreadMessagesCount(
							threadId, WorkflowConstants.STATUS_APPROVED);

					thread.setMessageCount(messageCount);

					MBThreadLocalServiceUtil.updateMBThread(thread);

					return null;
				}

			};

			TransactionCommitCallbackRegistryUtil.registerCallback(callable);

			// Category

			if ((category != null) &&
				(thread.getRootMessageId() == message.getMessageId())) {

//				MBUtil.updateCategoryStatistics(
//					category.getCompanyId(), category.getCategoryId());
				
				final long categoryId = category.getCategoryId();
				
				Callable<Void> callable2 = new ShardCallable<Void>(companyId) {

					@Override
					protected Void doCall() throws Exception {
					final MBCategory category =
							MBCategoryLocalServiceUtil.fetchMBCategory(categoryId);

						if (category == null) {
							return null;
						}

						int messageCount = MBMessageLocalServiceUtil.getCategoryMessagesCount(
								category.getGroupId(), category.getCategoryId(),
								WorkflowConstants.STATUS_APPROVED);

						int threadCount =
							MBThreadLocalServiceUtil.getCategoryThreadsCount(
								category.getGroupId(), category.getCategoryId(),
								WorkflowConstants.STATUS_APPROVED);

						category.setMessageCount(messageCount);
						category.setThreadCount(threadCount);

						MBCategoryLocalServiceUtil.updateMBCategory(category);

						return null;
					}

				};

				TransactionCommitCallbackRegistryUtil.registerCallback(callable2);
				
				
				
				
			}

			if ((category != null) &&
				!(thread.getRootMessageId() == message.getMessageId())) {

//				MBUtil.updateCategoryMessageCount(
//					category.getCompanyId(), category.getCategoryId());
				final long categoryId2 = category.getCategoryId();
				Callable<Void> callable3 = new ShardCallable<Void>(companyId) {

					@Override
					protected Void doCall() throws Exception {
					final MBCategory category =
							MBCategoryLocalServiceUtil.fetchMBCategory(categoryId2);

						if (category == null) {
							return null;
						}

						int messageCount = MBMessageLocalServiceUtil.getCategoryMessagesCount(
								category.getGroupId(), category.getCategoryId(),
								WorkflowConstants.STATUS_APPROVED);;

						category.setMessageCount(messageCount);

						MBCategoryLocalServiceUtil.updateMBCategory(category);

						return null;
					}

				};

				TransactionCommitCallbackRegistryUtil.registerCallback(callable3);
				
				
			}
		}

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBThread.class);

		indexer.reindex(thread);
		
		MBThreadLocalServiceUtil.updateMBThread(thread);
		//mbThreadPersistence.update(thread);
	}
	
	@Override
	public MBMessage updateStatus(
			long userId, long messageId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

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
			//notifySubscribers(serviceContext);
			
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
		
		

}
