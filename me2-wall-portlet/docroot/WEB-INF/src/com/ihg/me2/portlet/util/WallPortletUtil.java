package com.ihg.me2.portlet.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihg.me2.portlet.constants.WallConstants;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;
import com.liferay.portlet.ratings.model.RatingsEntry;
import com.liferay.portlet.ratings.service.RatingsEntryLocalServiceUtil;


/**
 * 
 * @author Jay Patel
 * 
 * Main Utility class used for My Wall Portlet
 * 
 */


public class WallPortletUtil 
{		
	
	/**
	 * Gets Forward Path attribute from PortletRequest
	 * 
	 * @param request
	 * @return {@link Object}
	 */
	public static Object getForward(PortletRequest request)
	{
		return request.getAttribute(WallConstants.ATTRIBUTE_FORWARD_PATH);
	}
	
	
	/**
	 * Returns list of MBMessageDisplay based on groupId & userId.
	 * 
	 * @param groupId
	 * @param userId
	 * @return {@link List}
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static List<MBMessageDisplay> getMessageDisplayList(long groupId, long userId, int threadsDelta) 
									throws PortalException, SystemException
	{	
		List<MBMessageDisplay> listMsgDisplay = new ArrayList<MBMessageDisplay>();
		List<MBThread> listMbThread = null;
		
		listMbThread = MBThreadServiceUtil.getGroupThreads(groupId, userId, WorkflowConstants.STATUS_APPROVED, 
				false, false, WallConstants.DEFAULT_DELTA_START_COUNT, threadsDelta);
		_log.debug("MBThread List Size : " + listMbThread.size());
		
		if(Validator.isNotNull(listMbThread) && !listMbThread.isEmpty())
		{
			MBMessageDisplay messageDisplay = null;
			for(MBThread mbThread : listMbThread)
			{
				if(Validator.isNotNull(mbThread))
				{
					_log.debug("Current Thread Id is : " + mbThread.getThreadId() + " & root MBMessage is : " + mbThread.getRootMessageId());
					
					messageDisplay = WallPortletUtil.getMessageDisplayByMessageId(mbThread.getRootMessageId());
					
					if(Validator.isNotNull(messageDisplay))
					{
						listMsgDisplay.add(messageDisplay);
					}
				}	
			}	
		}
		
		return listMsgDisplay;
	}
	
	
	/**
	 * Returns list of MBMessageDisplay based on groupId & userId.
	 * 
	 * @param groupId
	 * @param userId
	 * @return {@link List}
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static List<MBMessageDisplay> getOrderedMessageDisplayList(long groupId, long categoryId, long userId, 
			int status, int threadsDelta) 
									throws PortalException, SystemException
	{	
		List<MBMessageDisplay> listMsgDisplay = new ArrayList<MBMessageDisplay>();
		List<MBThread> listMbThread = null;
		
		
			/* Get Threads based on modified date dsc order & not priority - STARTS */
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MBThread.class, PortalClassLoaderUtil.getClassLoader());
		
		Criterion masterCriterion = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("groupId", groupId), 
				RestrictionsFactoryUtil.eq("categoryId", categoryId)), RestrictionsFactoryUtil.eq("status", status));
		
		Order lastPostDateOrder = OrderFactoryUtil.desc("lastPostDate");
		 
		if(query != null && masterCriterion != null && lastPostDateOrder != null)
		{
			query.add(masterCriterion);
			
			query.addOrder(lastPostDateOrder);
			
			listMbThread = MBThreadLocalServiceUtil.dynamicQuery(query, WallConstants.DEFAULT_DELTA_START_COUNT, threadsDelta);
		}
		
		_log.debug("MBThread List Size : " + listMbThread.size());
		
			/* Get Threads based on modified date dsc order & not priority - ENDS */
		
		
		if(Validator.isNotNull(listMbThread) && !listMbThread.isEmpty())
		{
			MBMessageDisplay messageDisplay = null;
			for(MBThread mbThread : listMbThread)
			{
				if(Validator.isNotNull(mbThread))
				{
					_log.debug("Current Thread Id is : " + mbThread.getThreadId() + " & root MBMessage is : " + mbThread.getRootMessageId());
					
					messageDisplay = WallPortletUtil.getMessageDisplayByMessageId(mbThread.getRootMessageId());
					
					if(Validator.isNotNull(messageDisplay))
					{
						listMsgDisplay.add(messageDisplay);
					}
				}	
			}	
		}
		
		return listMsgDisplay;
	}
	
	
	/**
	 * Returns MBMessageDisplay based on messageId
	 * 
	 * @param rootMessageId
	 * @return {@link MBMessageDisplay}
	 */
	public static MBMessageDisplay getMessageDisplayByMessageId(long rootMessageId)
	{	
		String threadView = WallConstants.DEFAULT_MESSAGE_BOARDS_THREAD_VIEW;  /*"combination";*/
		boolean includePrevAndNext = WallConstants.INCLUDE_PREV_NEXT;
		
		MBMessageDisplay messageDisplay = null;
		try
		{
			messageDisplay = MBMessageServiceUtil.getMessageDisplay(
					rootMessageId, WorkflowConstants.STATUS_ANY, threadView,
					includePrevAndNext);
		} 
		catch (PortalException e) 
		{
			if(e instanceof PrincipalException)
			{
				_log.warn("Logged-in user does not have permission to access current thread with ID : " + rootMessageId + " & Exception type is : " + e.getClass());
			}
			else
			{
				_log.error("Error while getting latest Threads on My Wall & error is : " + e.getLocalizedMessage(), e);	
			}
		} 
		catch (SystemException e) 
		{
			_log.error("Error while getting latest Threads on My Wall & error is : " + e.getLocalizedMessage(), e);
		}
	
		return messageDisplay;
	}
	
	
	/**
	 * Returns MBMessage based on messageId
	 * 
	 * @param messageId
	 * @return {@link MBMessage}
	 */
	public static MBMessage getMessage(long messageId)
	{
		MBMessage message = null;
		
		try{
			message = MBMessageLocalServiceUtil.getMBMessage(messageId);
		}catch(PortalException e){
			_log.error("Error while finding Message based on messageId:" + messageId, e);
		}catch (SystemException e){
			_log.error("Error while finding Message based on messageId:" + messageId, e);
		}
		
		return message;
	}
	
	
	/**
	 * Util method which returns User object based on userId.
	 * 
	 * @param userId
	 * @return {@link User}
	 */
	public static User getUser(long userId)
	{
		User user = null;
		try 
		{
			user = UserLocalServiceUtil.getUser(userId);
		} 
		catch(PortalException e) 
		{
			_log.error("Error while fetching User based on UserId : " + userId, e);
		} 
		catch (SystemException e) 
		{
			_log.error("Error while fetching User based on UserId : " + userId, e);
		}
		
		return user;
	}
	
	
	/**
	 * Shows Date in String format based on parameters passed
	 * 
	 * @param date
	 * @return {@link String}
	 */
	public static String getFormattedDate(Date date/*, Locale locale, TimeZone timeZone*/)
	{
		String formattedDate = StringPool.BLANK;
		
		if(date != null)
		{
			formattedDate = DateUtil.getDate(date, WallConstants.MESSAGE_POST_DATE_FORMAT,
							LocaleUtil.getDefault(), TimeZoneUtil.getDefault());
			_log.debug("formattedDate : " + formattedDate);
		}
		
		return formattedDate;
	}
	
	/**
	 * Shows Date in String format based on parameters passed
	 * 
	 * @param date
	 * @return {@link String}
	 */
	public static String getFormattedDate(Date date, Locale locale, TimeZone timeZone)
	{
		String formattedDate = StringPool.BLANK;
		
		if(date != null)
		{
			formattedDate = DateUtil.getDate(date, WallConstants.MESSAGE_POST_DATE_FORMAT,
							locale, timeZone);
			_log.debug("formattedDate : " + formattedDate);
		}
		
		return formattedDate;
	}
	
	/**
	 * Shows Date in String format based on parameters passed
	 * 
	 * @param date
	 * @return {@link String}
	 */
	public static String getFormattedDateWithTimeZone(Date date, Locale locale, TimeZone timeZone)
	{
		String formattedDate = StringPool.BLANK;
		
		if(date != null)
		{
			formattedDate = DateUtil.getDate(date, WallConstants.MESSAGE_POST_DATE_WITH_TIMEZONE_FORMAT,
							locale, timeZone);
			_log.debug("formattedDate : " + formattedDate);
		}
		
		return formattedDate;
	}
	
	
	/**
	 * Returns Attachment (File) names for the given MBMessage
	 * 
	 * @param MBMessage
	 * @return String[] 
	 */
	public static String[] getMessageAttachments(MBMessage message)
	{
		String[] existingAttachments = null;
		
		try 
		{	
			if ((message != null) && (message.getAttachmentsFileEntriesCount() > 0)) {
				/*existingAttachments = DLLocalServiceUtil.getFileNames(message.getCompanyId(), CompanyConstants.SYSTEM, message.getAttachmentsDir());*/

				List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getFileEntries(message.getGroupId(), message.getAttachmentsFolderId());
				existingAttachments = new String[files.size()];
				for(int i=0; i<files.size(); i++) {
					existingAttachments[i] = files.get(i).getName();
				}
			}
		} 
		catch (PortalException e) 
		{
			_log.error("Error while finding attachments for the given mbMessageId:" + message.getMessageId() + " ,error:" + e.getMessage());
		} 
		catch (SystemException e) 
		{
			_log.error("Error while finding attachments for the given mbMessageId:" + message.getMessageId() + " ,error:" + e.getMessage());
		}
		
		return existingAttachments;
	}
	
	
	/**
	 * Returns MBMessage Service Context
	 * 
	 * @param request
	 * @return {@link ServiceContext}
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ServiceContext getMBMessageServiceContext(PortletRequest request) throws PortalException, SystemException
	{
		return WallPortletUtil.getModelServiceContext(request, MBMessage.class.getName());
	}
	
	
	/**
	 * Return ServiceContext based on Model
	 * 
	 * @param request
	 * @param modelClassName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ServiceContext getModelServiceContext(PortletRequest request, String modelClassName) throws PortalException, SystemException
	{
		return  ServiceContextFactory.getInstance(modelClassName, request);		
	}
	
	
	/**
	 * Based on given params, gets Message Board Attachment & writes response
	 * 
	 * @param messageId
	 * @param fileName
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void getFile(long messageId, String fileName, HttpServletRequest request, 
							HttpServletResponse response) throws Exception 
    {
			MBMessage message = MBMessageServiceUtil.getMessage(messageId);

			DLFileEntry file = DLFileEntryLocalServiceUtil.getFileEntryByName(message.getGroupId(), message.getAttachmentsFolderId(), fileName);
			InputStream is = file.getContentStream();
			int contentLength = (int)file.getSize();
			String contentType = MimeTypesUtil.getContentType(fileName);
			ServletResponseUtil.sendFile(request, response, fileName, is, contentLength, contentType);
	}
	
	
	public static String getFileIconPath(String pathThemeDisplay, String extension) 
	{
 		String path = StringPool.BLANK;
 		if("pdf".equals(extension)) {
 			path = pathThemeDisplay + "/content/one.jpg";
 		} else if("xls".equals(extension)) {
 			path = pathThemeDisplay + "/content/four.jpg";
 		} else if("jpg".equals(extension) || "bmp".equals(extension) || "png".equals(extension) || "jpeg".equals(extension)) {
 			path = pathThemeDisplay + "/content/five.jpg";
 		} else if("mp4".equals(extension) || "flv".equals(extension)) {
 			path = pathThemeDisplay + "/content/two.jpg";
 		}  else if("doc".equals(extension)) {
 			path = pathThemeDisplay + "/content/doc.png";
 		} else if("docx".equals(extension)) {
 			path = pathThemeDisplay + "/content/docx.png";
 		} else if("ppt".equals(extension)) {
 			path = pathThemeDisplay + "/content/ppt.png";
 		}else {
 			path = pathThemeDisplay + "/content/default.png";
 		}
 		return path;
 	}
	
	
	/**
	 * Get files for a given thread
	 * API changed for Liferay 6.2
	 * 
	 * @param message
	 * @return List<FileEntry>
	 */
	public static List<FileEntry> getMBMessageAttachments(MBMessage message) {
		List<FileEntry> attachements = Collections.emptyList();
		try {
			if ((message != null) && (message.getAttachmentsFileEntriesCount() > 0)) {
				attachements = message.getAttachmentsFileEntries();
			} 
		} catch (PortalException e) {
				_log.error("Error while finding attachments for the given mbMessageId:"
						+ message.getMessageId() + " ,error:" + e.getMessage());
			} catch (SystemException e) {
				_log.error("Error while finding attachments for the given mbMessageId:"
						+ message.getMessageId() + " ,error:" + e.getMessage());
			}

			return attachements;
	}
	
	
	/**
	 * Returns list of Files in terms of List of ObjectValuePair, key=FileName & value=bytesArray
	 * 
	 * @param uploadRequest
	 * @param String paramName
	 * @return List<ObjectValuePair<String, byte[]>>
	 */
	public static List<ObjectValuePair<String, InputStream>> getFiles(UploadPortletRequest uploadRequest, String parameterName)
	{
		List<ObjectValuePair<String, InputStream>> files = new ArrayList<ObjectValuePair<String, InputStream>>();
		
		/*Enumeration<String> paramEnum = uploadRequest.getParameterNames();
	    	while(paramEnum.hasMoreElements()){
	    		String parameter = paramEnum.nextElement();
	            if(parameter.startsWith("uploadFile")){
	            	String fileName = uploadRequest.getFileName(parameter);
	                try 
	                {
	                	if(fileName.length() > 0){
                			InputStream is = uploadRequest.getFileAsStream(fileName);
	            			ObjectValuePair<String, InputStream> ovp = new ObjectValuePair<String, InputStream>(fileName, is);
	            			files.add(ovp);
	                	}
	                } 
	                catch(IOException e)
	                {
	                	_log.error("Error while getting attachments:" + e.getMessage(), e);
	                }
	            }
	        }*/

			String fileName = uploadRequest.getFileName(parameterName);
			
			try 
			{
				InputStream inputStream = uploadRequest.getFileAsStream(parameterName);
				if(Validator.isNotNull(inputStream)) {
					ObjectValuePair<String, InputStream> ovp = new ObjectValuePair<String, InputStream>(
							fileName, inputStream);

					files.add(ovp);
				}
			} catch (IOException e) {
				_log.error("Error while getting attachments:" + e.getMessage(), e);
			}	
	    	
        return files;
	}
	
	
	/**
	 * Adds MBMessage in DB
	 * 
	 * @param groupId
	 * @param categoryId
	 * @param threadId
	 * @param parentMessageId
	 * @param subject
	 * @param body
	 * @param files
	 * @param anonymous
	 * @param priority
	 * @param allowPingbacks
	 * @param serviceContext
	 * @return {@link MBMessage}
	 */
	public static MBMessage addMessage(User user, long groupId, long categoryId, long threadId, long parentMessageId, 
			String subject, String body, List<ObjectValuePair<String, InputStream>> files, boolean anonymous, 
			double priority, boolean allowPingbacks, ServiceContext serviceContext)
	{
		MBMessage message = null;
			
		try 
		{
			if(threadId <= 0)
			{
				_log.info("### threadId is : " + threadId);
				
				message = MBMessageLocalServiceUtil.addMessage(user.getUserId(), user.getFullName(), 
						groupId, categoryId, subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, allowPingbacks, serviceContext);
			}
			else
			{	
				/*Issue of Thread priority updated by child post - STARTS*/
			
				_log.info("### Issue of Thread priority updated by child postthreadId is : " + threadId);
				
				MBThread mbThread = null;
				try 
				{
					mbThread = MBThreadLocalServiceUtil.getMBThread(threadId);
					if(Validator.isNotNull(mbThread))
					{
						priority = mbThread.getPriority();
						_log.info("Priority inherited from parent thread while 'Posting Reply':" + priority);
					}
				} 
				catch (Exception e1) 
				{
					_log.error("No thread found with id:" + threadId);
				}
						
				/*Issue of Thread priority updated by child post - ENDS*/
				message = MBMessageLocalServiceUtil.addMessage(user.getUserId(), user.getFullName(), groupId, categoryId, threadId, parentMessageId, 
						subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, allowPingbacks, serviceContext);
			}
		} 
		catch (PortalException e) 
		{
			_log.error("Error while 'posting reply'/'starting thread' with categoryId : " 
					+ categoryId + " & threadId : " + threadId + " & error is : " + e.getLocalizedMessage(), e);
		} 
		catch (SystemException e) 
		{
			_log.error("Error while 'posting reply'/'starting thread' with categoryId : " 
					+ categoryId + " & threadId : " + threadId + " & error is : " + e.getLocalizedMessage(), e);
		}
		
		return message;
	}
	
	
	/**
	 * Returns Role based on companyId & roleName
	 * 
	 * @param companyId
	 * @param roleName
	 * @return Role
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static Role getRole(long companyId, String roleName)
	{
		Role role = null;
		
		try 
		{
			role = RoleLocalServiceUtil.getRole(companyId, roleName);
		} 
		catch (PortalException e) 
		{
			_log.error("No such role with companyId:" + companyId + " & roleName:" + roleName);
		} 
		catch (SystemException e) 
		{
			_log.error("No such role with companyId:" + companyId + " & roleName:" + roleName);
		}
		
		return role;
	}
	
	
	/**
	 * Sets permission on root Message for Circle Roles when new Thread has been started.
	 * 
	 * @param companyId
	 * @param groupId
	 * @param category
	 * @param message
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void setMBMessagePermissions(long companyId, long groupId, MBCategory category, MBMessage message,
			 			Role circleAdminRole, Role circleUserRole) 
						throws PortalException, SystemException
	{	
		String[] mbActions = {ActionKeys.VIEW}; 
			
		if(circleUserRole != null && circleAdminRole != null)
		{
			WallPortletUtil.setModelPermission(companyId, groupId, MBMessage.class.getName(), 
					String.valueOf(message.getMessageId()), new long[] {circleUserRole.getRoleId(), circleAdminRole.getRoleId()}, mbActions);
		}
		else if(circleUserRole != null)
		{
			WallPortletUtil.setModelPermission(companyId, groupId, MBMessage.class.getName(), 
					String.valueOf(message.getMessageId()), new long[] {circleUserRole.getRoleId()}, mbActions);
			_log.warn("setThreadPermissions, circleAdminRole for category:" + category.getName() + " is not created, please create it...");
		}
		else if(circleAdminRole != null)
		{
			WallPortletUtil.setModelPermission(companyId, groupId, MBMessage.class.getName(), 
					String.valueOf(message.getMessageId()), new long[] {circleAdminRole.getRoleId()}, mbActions);
			_log.warn("setThreadPermissions, circleUserRole for category:" + category.getName() + " is not created, please create it...");
		}
	}
	

	
	/**
	 * Adds permission on Model with given PK, Roles & Actions.
	 * 
	 * @param companyId
	 * @param groupId
	 * @param modelResource
	 * @param resourcePrimKey
	 * @param roleIds
	 * @param actionIds
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void setModelPermission(long companyId, long groupId, String modelResource, String resourcePrimKey, 
			long[] roleIds, String[] actionIds) throws PortalException, SystemException
	{
			/*String portletResource = PortletKeys.MESSAGE_BOARDS;
			String modelResource = MBMessage.class.getName();

			String selResource = PortletConstants.getRootPortletId(portletResource);

			if(Validator.isNotNull(modelResource)){
				selResource = modelResource;
			}*/
			
			for(long roleId : roleIds)
			{
				ResourcePermissionServiceUtil.setIndividualResourcePermissions(
					groupId, companyId, modelResource, resourcePrimKey, roleId, actionIds);
			}
	}
	
	
	
	/**
	 * Based on given parameters returns categoryId
	 * 
	 * @param companyId
	 * @param groupId
	 * @param parentCategoryId
	 * @param name
	 * @return categoryId
	 */
	public static long getDefaultCategory(long companyId, long groupId, long parentCategoryId, String name)
	{
		long categoryId = 0;
		
		/**
		 * Get Category
		 */
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MBCategory.class, PortalClassLoaderUtil.getClassLoader());
		
		/*Criterion companyIdCriterion = RestrictionsFactoryUtil.eq("companyId", companyId);
		Criterion groupIdCriterion = RestrictionsFactoryUtil.eq("groupId", groupId);
		Criterion parentCategoryIdCriterion = RestrictionsFactoryUtil.eq("parentCategoryId", parentCategoryId);
		Criterion nameCriterion = RestrictionsFactoryUtil.eq("name", name);*/
		
		Criterion masterCriterion = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("companyId", companyId),
						RestrictionsFactoryUtil.eq("groupId", groupId)), 
				RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("parentCategoryId", parentCategoryId), 
						RestrictionsFactoryUtil.eq("name", name)));
		
		if(query != null && masterCriterion != null)
		{
			try 
			{
				query.add(masterCriterion);
				
				// List resultList = query.list();
				
				List resultList = MBCategoryLocalServiceUtil.dynamicQuery(query);
				
				if(Validator.isNotNull(resultList) && resultList.size() > 0)
				{
					MBCategory category = (MBCategory) resultList.get(0);
					
					if(category != null)
					{
						categoryId = category.getCategoryId();
					}
					else
					{
						_log.error("MBCategory is NULL...");
					}
				}else{
					_log.error("Could NOT retrieve MBCategory with companyId:" + companyId + " ,groupId:" + groupId 
							+ " ,parentCategoryId:" + parentCategoryId + " ,name:" + name);
				}
			} 
			catch (SystemException e) 
			{
				_log.error("Could NOT retrieve MBCategory with companyId:" + companyId + " ,groupId:" + groupId 
						+ " ,parentCategoryId:" + parentCategoryId + " ,name:" + name + " \n message: " + e.getMessage(), e);
			}
		}
		
		_log.info("CategoryId is : " + categoryId);
		
		return categoryId;
	}
	
	
	/**
	 * Called when User Profile is to be shown
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	public static String showUserProfile(ResourceRequest request, ResourceResponse response)
	{
		String view = WallConstants.VIEW_SHOW_USER_PROFILE;
		
		long userId = ParamUtil.getLong(request, "userId");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY); 
			
		_log.info("User Profile to be fetched for userId :" + userId);
		
		try 
		{
			if(userId > 0)
			{
				User user = WallPortletUtil.getUser(userId);
				
				if(user != null)
				{	
					String userFullName = user.getFullName();
					request.setAttribute("userFullName", userFullName);
					
					String portraitUrl = user.getPortraitURL(themeDisplay);
					request.setAttribute("portraitUrl", portraitUrl);
					
					String emailAddress = user.getEmailAddress();
					request.setAttribute("emailAddress", emailAddress);
					
					String jobTitle = user.getJobTitle();
					request.setAttribute("jobTitle", jobTitle);
					
					Serializable department = user.getExpandoBridge().getAttribute("Department");
					String strDept = (department != null) ? department.toString() : StringPool.BLANK;
					request.setAttribute("strDept", strDept);
					
					Serializable locations = user.getExpandoBridge().getAttribute("Locations");
					String strLocation = (locations != null) ? locations.toString() : StringPool.BLANK;
					request.setAttribute("strLocation", strLocation);					
				}
			}
		} 
		catch (PortalException e) 
		{
			_log.error("Error while fetching User Profile " + e.getLocalizedMessage(), e);
		} 
		catch (SystemException e) 
		{
			_log.error("Error while fetching User Profile " + e.getLocalizedMessage(), e);
		}
		
		return view;
	}
	
	
	/**
	 * Called when Pop-Up of "All the Likers" to be shown
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	public static String showAllLikers(ResourceRequest request, ResourceResponse response)
	{
		String view = WallConstants.VIEW_SHOW_LIKERS;
		
		long messageId = ParamUtil.getLong(request, "messageId");
		
		_log.info("Likers to be fetched for MessageId :" + messageId);
		
		List<User> likersList = null;
		
		if(messageId > 0)
		{
			likersList = WallPortletUtil.getAllLikers(MBMessage.class.getName(), messageId);
		}
		
		request.setAttribute("likersList", likersList);
		
		return view;
	}
	
	
	/**
	 * Based on classPK & className, gets all the users who have done rating on the class item.
	 * 
	 * @param className
	 * @param classPK
	 * @return List<User>
	 */
	public static List<User> getAllLikers(String className, long classPK)
	{
		List<User> listUser = new ArrayList<User>();
		
		try 
		{
			List<RatingsEntry> listRatingsEntry = RatingsEntryLocalServiceUtil.getEntries(className, classPK);
			if(listRatingsEntry != null)
			{
				User user = null;
				for(RatingsEntry ratingEntry : listRatingsEntry)
				{
					user = UserLocalServiceUtil.getUser(ratingEntry.getUserId());
					if(user != null){
						listUser.add(user);
					}
				}
			}
		} 
		catch (SystemException e) 
		{
			_log.error("Error while finding all the likers for enity : " + className + " & classPK : " + classPK 
					+ " & error is : " + e.getLocalizedMessage());
		}
		catch (PortalException e) 
		{
			_log.error("Error while finding all the likers for enity : " + className + " & classPK : " + classPK 
					+ " & error is : " + e.getLocalizedMessage());
		}
		
		return listUser;
	}

	
	/**
	 * Set Forward path attribute so that specific View can be rendered.
	 * 
	 * @param request
	 * @param forwardPath 
	 */
	public static void setForward(PortletRequest request, String forwardPath)
	{
		request.setAttribute(WallConstants.ATTRIBUTE_FORWARD_PATH, forwardPath);
	}	
	
	/**
	 * To get the category subscriptions of an user
	 * 
	 * @param userid
	 * 
	 */
	public static Set<Long> getCategorySubscriptionClassPKs(long userId)
			throws SystemException {

			List<Subscription> subscriptions =
				SubscriptionLocalServiceUtil.getUserSubscriptions(
					userId, MBCategory.class.getName());

			Set<Long> classPKs = new HashSet<Long>(subscriptions.size());

			for (Subscription subscription : subscriptions) {
				classPKs.add(subscription.getClassPK());
			}

			return classPKs;
	}
	
	/**
	 * To get the thread subscriptions of an user
	 * 
	 * @param userid
	 * 
	 */
	public static Set<Long> getThreadSubscriptionClassPKs(long userId)
			throws SystemException {

			List<Subscription> subscriptions =
				SubscriptionLocalServiceUtil.getUserSubscriptions(
					userId, MBThread.class.getName());

			Set<Long> classPKs = new HashSet<Long>(subscriptions.size());

			for (Subscription subscription : subscriptions) {
				classPKs.add(subscription.getClassPK());
			}

			return classPKs;
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(WallPortletUtil.class);
}