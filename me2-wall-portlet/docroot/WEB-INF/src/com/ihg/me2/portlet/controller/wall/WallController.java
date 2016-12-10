package com.ihg.me2.portlet.controller.wall;


import com.ihg.me2.portlet.constants.WallConstants;
import com.ihg.me2.portlet.util.WallPortletUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBBanLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBCategoryServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;


/**
 * 
 * @author Jay Patel
 *
 * 
 * Main Controller class used to show various Threads, Posts based on logged-in user's membership on various Circles.
 */

@Controller("myWallController")
@RequestMapping(value = "VIEW")
public class WallController 
{	
	
	
	/**
	 * Default Render method for Wall Portlet
	 * 
	 * @param request
	 * @param response
	 * @return String
	 * @throws Exception 
	 * 
	 */
	@RenderMapping
	public String showMyWall(RenderRequest request, RenderResponse response) throws Exception
	{
		_log.debug("WallController.showMyWall() ###");
		
		String view = WallConstants.VIEW_MYWALL_POSTS;
		
		Object forward = WallPortletUtil.getForward(request);
		
		if(forward != null && forward.toString().length() > 0){
			view = forward.toString();
		}else{
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			List<MBMessageDisplay> listMsgDisplay = new ArrayList<MBMessageDisplay>();
			long userId = WallConstants.DEFAULT_USER_ID;
			int status = WorkflowConstants.STATUS_APPROVED;
			
			try 
			{	
				PortletPreferences prefs = request.getPreferences();
				int threadsDelta = WallConstants.MAX_DELTA_SIZE_THREAD;
					
				if(prefs != null)
				{
					threadsDelta = Integer.parseInt(prefs.getValue("threadsDelta", String.valueOf(WallConstants.MAX_DELTA_SIZE_THREAD)));
				}
				
				/**
				 * 	Get Default Category Id from a given Site
				 */
				
				long categoryId = WallPortletUtil.getDefaultCategory(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
						WallConstants.NEW_THREAD_PARENT_MESSAGE_ID, WallConstants.MEETING_POINT_FORUM_DEFAULT_CATEGORY);
				
				/**
				 * 	Get actual threads under DEFAULT_MEETING_POINT_CATEGORY
				 */
				
				listMsgDisplay = WallPortletUtil.getOrderedMessageDisplayList(themeDisplay.getScopeGroupId(), categoryId, 
						userId, status, threadsDelta);
				
				/*listMsgDisplay = WallPortletUtil.getMessageDisplayList(themeDisplay.getScopeGroupId(), userId, threadsDelta);*/
				
				/**
				 *  Setting Message Board Category to check subscriptions
				 */
				MBCategory category = null;
				if (categoryId > 0) {
					category = MBCategoryServiceUtil.getCategory(categoryId);
				}
				request.setAttribute("MESSAGE_BOARDS_CATEGORY", category);
				
				
			} 
			catch (PortalException e) 
			{
				_log.error("Error while fetching all the Threads : " + e.getLocalizedMessage(), e);
			} 
			catch (SystemException e) 
			{
				_log.error("Error while fetching all the Threads : " + e.getLocalizedMessage(), e);
			}

			request.setAttribute(WallConstants.PARAM_MESSAGE_BOARDS_DISPLAY_LIST, listMsgDisplay);	
		}

		return view;
	}

	
	/**
	 * Action which starts new Thread
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	@ActionMapping(params = "myAction=startThread")
	public void startThread(ActionRequest request, ActionResponse response)
	{
		_log.debug("WallController.startThread() ### ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
			 /*Get the Files - STARTS*/ 
		
		List<ObjectValuePair<String, InputStream>> files = WallPortletUtil.getFiles(uploadRequest, "uploadFile");
        
        	 /*Get the Files - ENDS*/
		
		String redirect = ParamUtil.getString(uploadRequest, "startThreadRedirect");
		
		MBMessage message = null;
		long categoryId = 0;
		
		String threadBody = ParamUtil.getString(uploadRequest, "myThreadBody");
		double msgPriority = ParamUtil.getDouble(uploadRequest, "msgPriority");
		_log.info("msgPriority while starting thread: " + msgPriority);
		_log.info("msgPriority while starting thread:>>>>>>>>>>>>>>>>>>>>> " + threadBody);
		StringBuilder subject = new StringBuilder(StringPool.BLANK);
		
		if(Validator.isNotNull(threadBody))
		{
			if(threadBody.length() > 4){
				subject.append(threadBody.substring(0, 4));	
			}else{
				subject.append(threadBody);
			}
		}
		
		try 
		{
			/**
			 * 	Get Default Category Id from a given Site
			 */
			
			categoryId = WallPortletUtil.getDefaultCategory(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
					WallConstants.NEW_THREAD_PARENT_MESSAGE_ID, WallConstants.MEETING_POINT_FORUM_DEFAULT_CATEGORY);
			
			if(categoryId > 0)
			{	
				ServiceContext serviceContext = WallPortletUtil.getMBMessageServiceContext(request);
				serviceContext.setAddGroupPermissions(Boolean.TRUE);
				/*serviceContext.setAddGuestPermissions(Boolean.FALSE);*/
				
				message = WallPortletUtil.addMessage(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), categoryId, WallConstants.NEW_THREAD_THREADID, 
					WallConstants.NEW_THREAD_PARENT_MESSAGE_ID, subject.toString(), threadBody, files
					/*WallConstants.DEFAULT_FILES*/, WallConstants.IS_ANONYMUS, msgPriority, 
					WallConstants.DEFAULT_ALLOW_PINGBACKS, serviceContext);
				
				/**
				 * JAY - Do we need to have Circle Admin here?, Since meeting point will NOT have circle feature at all
				 * 
				 * Send Email Notifications for a new Thread
				 */

				PortletPreferences pref = request.getPreferences();
				
				/*if(pref != null)
				{
					String sendEmailNotifications = pref.getValue("sendEmail", WallConstants.SEND_EMAIL_DEFAULT);
					
					if(sendEmailNotifications.equalsIgnoreCase(WallConstants.SEND_EMAIL_YES))
					{
						_log.info("Email will be sent as per preferences set !!!");
						
						String content = message.getBody(Boolean.TRUE);
						
						if(content.length() > WallConstants.DEFAULT_EMAIL_CONTENT_TRIM_INDEX){
							content = new StringBuilder(content.substring(0, WallConstants.DEFAULT_EMAIL_CONTENT_TRIM_INDEX)).append("...").toString();
						}					
						
						String url = SocialPortletCommonsUtil.getCurrentPageURL(themeDisplay);

						WallPortletUtil.sendNewThreadEventEmail(themeDisplay.getScopeGroupId(), themeDisplay.getUser(), url, content, 
												circleAdminRole, circleUserRole, isEventTypePost);		
					}
				}*/
			}
			else
			{
				_log.warn("CategoryId is 0, new Thread can not be added!!!");
			}
			
			_log.debug("redirect after starting new Thread is : " + redirect);
			response.sendRedirect(redirect);
		}
		catch (PortalException e) 
		{
			_log.error("Error while starting a new Thread in CategoryId : " + categoryId + 
					" & by userId : " + themeDisplay.getUser().getFullName() + " & message is : " + e.getLocalizedMessage(), e);
		} 
		catch (SystemException e) 
		{
			_log.error("Error while starting a new Thread in CategoryId : " + categoryId + 
					" & by userId : " + themeDisplay.getUser().getFullName() + " & message is : " + e.getLocalizedMessage(), e);
		} 
		catch (IOException e) 
		{
			_log.error("Error while starting a new Thread in CategoryId : " + categoryId + 
					" & by userId : " + themeDisplay.getUser().getFullName() + " & message is : " + e.getLocalizedMessage(), e);
		}
	}
	
	
	/**
	 * Action which posts comments to the Thread
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	@ActionMapping(params = "myAction=postComments")
	public void postComments(ActionRequest request, ActionResponse response)
	{
		_log.debug("WallController.postComments() ### ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String redirect = ParamUtil.getString(request, "wallPostsRedirect");
		
		String categoryThreadParentMessageId = ParamUtil.getString(request, "categoryThreadParentMessageId");
		_log.info("categoryThreadParentMessageId : " + categoryThreadParentMessageId);
		
		String comments = ParamUtil.getString(request, "hiddenComments");
		_log.info("comments info....................................... " + comments);

		try 
		{
			MBMessage message = null;
			
			if(Validator.isNotNull(categoryThreadParentMessageId))
			{
				String[] arrayIds = categoryThreadParentMessageId.split(StringPool.TILDE);
				
				if(ArrayUtil.isNotEmpty(arrayIds) && arrayIds.length == 3)
				{
					
					long categoryId = Long.valueOf(arrayIds[0]);
					long threadId = Long.valueOf(arrayIds[1]);
					long parentMessageId = Long.valueOf(arrayIds[2]);
					
					_log.info("categoryId : " + categoryId + " threadId : " + threadId + " parentMessageId : " + parentMessageId);
					
					ServiceContext serviceContext = WallPortletUtil.getMBMessageServiceContext(request);
					if(Validator.isNotNull(comments)){
						message = WallPortletUtil.addMessage(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), categoryId, threadId, parentMessageId, 
							WallConstants.SUBJECT_MESSAGE, comments, WallConstants.DEFAULT_FILES, 
							WallConstants.IS_ANONYMUS, WallConstants.DEFAULT_PRIORITY,  
							WallConstants.DEFAULT_ALLOW_PINGBACKS, serviceContext);
					}
					
					/**
					 * Send Email Notifications for a new Thread
					 */
					/*String content = message.getBody(Boolean.TRUE);
					
					if(content.length() > WallConstants.DEFAULT_EMAIL_CONTENT_TRIM_INDEX){
						content = new StringBuilder(content.substring(0, WallConstants.DEFAULT_EMAIL_CONTENT_TRIM_INDEX)).append("...").toString();
					}					
					
					String link = SocialPortletCommonsUtil.getCurrentPageURL(themeDisplay);
					
					MBCategory category = MBCategoryLocalServiceUtil.getCategory(categoryId);
					
					Role circleUserRole = SocialPortletCommonsUtil.getRole(themeDisplay.getCompanyId(), 
							SocialPortletCommonsUtil.getCircleRoleName(category.getName(), Boolean.FALSE));
					
					Role circleAdminRole = SocialPortletCommonsUtil.getRole(themeDisplay.getCompanyId(), 
							SocialPortletCommonsUtil.getCircleRoleName(category.getName(), Boolean.TRUE));
					
					WallPortletUtil.sendPostCommentsEmail(themeDisplay.getScopeGroupId(), themeDisplay.getUser(), link, content, 
							circleAdminRole, circleUserRole);*/
				}
				else
				{
					_log.warn("Something is missing among CategoryId, ThreadId OR ParentMessageId!!!");
				}
			}
			
			_log.debug("redirect after posting comment is : " + redirect);
			response.sendRedirect(redirect);
		} 
		catch (PortalException e) 
		{
			_log.error("Error while posting reply/comment with categoryId : " + e.getLocalizedMessage(), e);
		} 
		catch (SystemException e) 
		{
			_log.error("Error while posting reply/comment with categoryId : " + e.getLocalizedMessage(), e);
		} 
		catch (IOException e) 
		{
			_log.error("Error while posting reply/comment with categoryId : " + e.getLocalizedMessage(), e);
		}
	}

	
	/**
	 * serveResource method for Wall Portlet
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@ResourceMapping
	public String showPopUp(ResourceRequest request, ResourceResponse response)
	{
		String myAction = ParamUtil.getString(request, "myAction");
		
		if(myAction.equalsIgnoreCase("showUserProfile")){
			return WallPortletUtil.showUserProfile(request, response);
		}else{
			return WallPortletUtil.showAllLikers(request, response);
		}
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * 
	 * Fetches attachment for the given Thread
	 */
	@ActionMapping(params = "myAction=getAttachment")
	public void getAttachment(ActionRequest request, ActionResponse response)
	{
		_log.info("WallController.getAttachment()...");
		
		long messageId = ParamUtil.getLong(request, "messageId");
		String fileName = ParamUtil.getString(request, "attachment");

		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);

		try 
		{	
			WallPortletUtil.getFile(messageId, fileName, httpRequest, httpResponse);
			
			String[] mimeTypesContentDispositionAttachment = {"pdf"};
			
			String extension = GetterUtil.getString(FileUtil.getExtension(fileName)).toLowerCase();
			
			if (ArrayUtil.contains(mimeTypesContentDispositionAttachment, extension)) 
			{
				_log.info("Wall File Attachment should NOT be opened inline as extension is:" + extension);
				
				String contentDisposition = "attachment; filename=\"" + fileName + "\"";
				
				httpResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, contentDisposition);
			}
			
		} 
		catch (Exception e) 
		{
			_log.error("Error while getting attachment with messageId:" + messageId + 
					" & attch name:" + fileName + " ,error: " + e.getMessage(), e);
		}

		WallPortletUtil.setForward(request, WallConstants.DEFAULT_ATTACHMENT_VIEW);
	}
	
	
	/**
	 * Deletes selected Thread
	 * 
	 * @param request
	 * @param response
	 */
	@ActionMapping(params = "myAction=deleteThread")
	public void deleteThread(ActionRequest request, ActionResponse response)
	{
		_log.info("WallController.deleteThread()...");
		
		long threadId = ParamUtil.getLong(request, "threadId");
		String redirect = ParamUtil.getString(request, "wallPostsRedirect");
		
		try
		{
			if(threadId > 0)
			{
				MBThreadServiceUtil.deleteThread(threadId);
			}else{
				_log.warn("ThreadId is 0, hence no Thread can be deletd");
			}

			_log.debug("redirect after deleting Thread is : " + redirect);
			response.sendRedirect(redirect);	
		}
		catch(IOException e)
		{
			_log.error("Error while redirecting to : " + redirect, e);
		} catch (PortalException e) {
			_log.error("Error while deleting Thread with threadId:" + threadId + " , msd:" + e.getMessage(), e);
		} catch (SystemException e) {
			_log.error("Error while deleting Thread with threadId:" + threadId + " , msd:" + e.getMessage(), e);
		}
	}
	
	@ActionMapping(params = "myAction=editThread")
	public void editThread(ActionRequest request, ActionResponse response)
	{
		_log.info("WallController.editThread()...");
		
		long threadId = ParamUtil.getLong(request, "editThreadId");
		try {
			MBThread mbThread = MBThreadLocalServiceUtil.getThread(threadId);
			MBMessage mbMessage = MBMessageLocalServiceUtil.getMBMessage(mbThread.getRootMessageId());
			request.setAttribute("editThreadId", threadId);
			request.setAttribute("editThreadBody", mbMessage.getBody());
			request.setAttribute("editThreadPriority", mbMessage.getPriority());
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Edit selected Thread
	 * 
	 * @param request
	 * @param response
	 */
	@ActionMapping(params = "myAction=updateThread")
	public void updateThread(ActionRequest request, ActionResponse response)
	{
		_log.info("WallController.updateThread()...");
		
		long threadId = Long.parseLong(ParamUtil.getString(request, "editThreadId"));
		String body = ParamUtil.getString(request, "editThreadBody");
		double priority = ParamUtil.getDouble(request, "editThreadPriority");
		
		try
		{
			if(threadId > 0)
			{
				MBThread mbThread = MBThreadLocalServiceUtil.getThread(threadId);
				
				MBMessage mbMessage = MBMessageLocalServiceUtil.getMBMessage(mbThread.getRootMessageId());
				mbMessage.setPriority(priority);
				mbMessage.setBody(body);
				
				MBMessageLocalServiceUtil.updateMBMessage(mbMessage);
				
				//mbMessage.setAttachmentsDir(attachmentsDir);
				//mbThread.setPriority(priority);
				//MBThreadLocalServiceUtil.updateMBThread(mbThread);
			}else{
				_log.warn("ThreadId is 0, hence no Thread can be updated");
			}

		}
		catch (PortalException e) {
			_log.error("Error while updating Thread with threadId:" + threadId + " , msd:" + e.getMessage(), e);
		} catch (SystemException e) {
			_log.error("Error while update Thread with threadId:" + threadId + " , msd:" + e.getMessage(), e);
		}
	}
	/**
	 * Deletes selected message
	 * 
	 * @param request
	 * @param response
	 */
	@ActionMapping(params = "myAction=deleteMessage")
	public void deleteMessage(ActionRequest request, ActionResponse response)
	{
		_log.info("WallController.deleteMessage()...");
		long messageId = ParamUtil.getLong(request, "messageId");
		
		try
		{
			if(messageId > 0)
			{
				MBMessageLocalServiceUtil.deleteMessage(messageId);
			}else{
				_log.warn("MessageId is 0, hence no message can be deletd");
			}

		}
		catch (PortalException e) {
			_log.error("Error while deleting message with messageId:" + messageId + " , msd:" + e.getMessage(), e);
		} catch (SystemException e) {
			_log.error("Error while deleting message with messageId:" + messageId + " , msd:" + e.getMessage(), e);
		}
	}
	
	/**
	 * update selected message
	 * 
	 * @param request
	 * @param response
	 */
	@ActionMapping(params = "myAction=saveMessage")
	public void saveMessage(ActionRequest request, ActionResponse response)
	{
		
		
		long messageId = ParamUtil.getLong(request, "messageId");
		String messageBody = ParamUtil.getString(request, "messageBody");
		_log.info("WallController.saveMessage()..."+messageId);
		try
		{
			if(messageId > 0)
			{
				MBMessageLocalServiceUtil.updateMessage(messageId, messageBody);
			}else{
				_log.warn("MessageId is 0, hence no message can be updated!!!");
			}

		}
		catch (PortalException e) {
			_log.error("Error while updating message with messageId:" + messageId + " , msd:" + e.getMessage(), e);
		} catch (SystemException e) {
			_log.error("Error while updating message with messageId:" + messageId + " , msd:" + e.getMessage(), e);
		}
	}
	
	/**
	 * Subscribe user to the category
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@ActionMapping(params = "myAction=subscribeCategory")
	public void subscribeCategory(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		long categoryId = ParamUtil.getLong(request, "mbCategoryId");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

		MBCategoryServiceUtil.subscribeCategory(
				themeDisplay.getScopeGroupId(), categoryId);
		
	}
	
	/**
	 * Unsubscribe user to the category
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@ActionMapping(params = "myAction=unsubscribeCategory")
	public void unsubscribeCategory(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		long categoryId = ParamUtil.getLong(request, "mbCategoryId");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

		MBCategoryServiceUtil.unsubscribeCategory(
				themeDisplay.getScopeGroupId(), categoryId);
	
	}
	
	/**
	 * Subscribe user to the message thread
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@ActionMapping(params = "myAction=subscribeThread")
	public void subscribeThread(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		long messageId = ParamUtil.getLong(request, "messageId");
		MBMessageServiceUtil.subscribeMessage(messageId);
		
	}
	
	/**
	 * Unsubscribe user to the message thread
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@ActionMapping(params = "myAction=unsubscribeThread")
	public void unsubscribeThread(ActionRequest request, ActionResponse response) throws PortalException, SystemException{

		long messageId = ParamUtil.getLong(request, "messageId");
		MBMessageServiceUtil.unsubscribeMessage(messageId);
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(WallController.class);	
}
