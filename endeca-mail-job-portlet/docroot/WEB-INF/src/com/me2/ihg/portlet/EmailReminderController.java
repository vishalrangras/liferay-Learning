package com.me2.ihg.portlet;

import com.ihg.me2.NoSuchEmailAttachmentException;
import com.ihg.me2.model.EmailAttachment;
import com.ihg.me2.model.EmailReminder;
import com.ihg.me2.service.EmailAttachmentLocalServiceUtil;
import com.ihg.me2.service.EmailReminderLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class EmailReminderController
 */
public class EmailReminderController extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(EmailReminderController.class);
	private static final String CREATE = "create";
	private static final String UPDATE = "update";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		// TODO Auto-generated method stub

		try {

			String cmd = renderRequest.getParameter("cmd");

			if (cmd != null) {

				_log.info("The value of cmd is: " + cmd);
				switch (cmd) {

				case "create":
					_log.info("Setting the Operation as Create");
					renderRequest.setAttribute("operation", CREATE);
					break;
				case "edit":
					long emailReminderId = Long.valueOf(renderRequest.getParameter("emailReminderId"));

					EmailReminder emailReminder;

					emailReminder = EmailReminderLocalServiceUtil.getEmailReminder(emailReminderId);

					List<EmailAttachment> emailAttachmentList = EmailAttachmentLocalServiceUtil
							.getEmailAttachmentByReminderId(emailReminderId);

					if (emailAttachmentList.size() > 0) {
						renderRequest.setAttribute("fileName1", emailAttachmentList.get(0).getAttachmentFileName());
					}

					if (emailAttachmentList.size() > 1) {
						renderRequest.setAttribute("fileName2", emailAttachmentList.get(1).getAttachmentFileName());
					}

					if (emailAttachmentList.size() > 2) {
						renderRequest.setAttribute("fileName3", emailAttachmentList.get(2).getAttachmentFileName());
					}
					
					Date date = emailReminder.getScheduleTimestamp();
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					
					String scheduleDate = df.format(date);

					renderRequest.setAttribute("operation", UPDATE);
					renderRequest.setAttribute("emailReminderId", emailReminderId);
					renderRequest.setAttribute("emailReminder", emailReminder);
					renderRequest.setAttribute("scheduleDate", scheduleDate);

					break;
				}
			} else {
				_log.info("In the else block");
				List<EmailReminder> emailReminderList = EmailReminderLocalServiceUtil.getEmailReminders();
				_log.info("Size of emailReminderList: " + emailReminderList.size());
				renderRequest.setAttribute("emailReminderList", emailReminderList);
			}
			renderRequest.setAttribute(WebKeys.PORTLET_DECORATE, Boolean.FALSE);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}

	public void deleteReminder(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long emailReminderId = Long.valueOf((String) actionRequest.getParameter("emailReminderId"));

			EmailReminder emailReminder = EmailReminderLocalServiceUtil.getEmailReminder(emailReminderId);
			emailReminder.setStatusCode("0");
			EmailReminderLocalServiceUtil.updateEmailReminder(emailReminder);

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateReminder(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long emailReminderId = 0;
			UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			String operation = ParamUtil.getString(uploadRequest, "operation");
			
			_log.info("The Operation is:"+operation);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();

			String submitterName = user.getFullName();
			String submitterEmailId = user.getEmailAddress();
			int reminderNumber = Integer.valueOf(ParamUtil.getString(uploadRequest, "type"));
			_log.info(":::::::::::::::::: The type is:::::::::::::    "+ reminderNumber);
			String dateStr = ParamUtil.getString(uploadRequest, "scheduleDate");;
			_log.info("The date is:"+dateStr);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date scheduleTimestamp = df.parse(dateStr);
			String emailSubjectTxt = ParamUtil.getString(uploadRequest, "subject");
			_log.info(":::::::::::::::::: The subject is:::::::::::::    "+ emailSubjectTxt);
			String emailBodyTxt = ParamUtil.getString(uploadRequest, "body");
			_log.info(":::::::::::::::::: The body is:::::::::::::    "+ emailBodyTxt);
			String statusCode = "1";
			String createUserId = String.valueOf(user.getUserId());
			Date createTimestamp = new Date();
			String lastUpdateUserId = String.valueOf(user.getUserId());
			Date lastUpdateTimestamp = createTimestamp;

			String attachment1 = uploadRequest.getFileName("attachment1");
			String attachment2 = uploadRequest.getFileName("attachment2");
			String attachment3 = uploadRequest.getFileName("attachment3");

			File file1 = null; 
			File file2 = null; 
			File file3 = null; 
			
			if(attachment1!=null && !attachment1.equals(""))
			file1 = uploadRequest.getFile("attachment1");
			
			if(attachment2!=null && !attachment2.equals(""))
			file2 = uploadRequest.getFile("attachment2");
			 
			if(attachment3!=null && !attachment3.equals(""))
			file3 = uploadRequest.getFile("attachment3");

			if (operation.equals(CREATE)) {
				
				_log.info("Inside Create Action");

				EmailReminder emailReminder = EmailReminderLocalServiceUtil.addEmailReminder(submitterName,
						submitterEmailId, reminderNumber, scheduleTimestamp, emailSubjectTxt, emailBodyTxt, statusCode,
						createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);

				emailReminderId = emailReminder.getEmailReminderId();
				
				_log.info("The EmailReminderId is"+emailReminderId);

				if (attachment1 != null && file1 != null) {
					InputStream inputStream = new FileInputStream(file1);
					OutputBlob blobData = new OutputBlob(inputStream, file1.length());
					EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachment1, blobData,
							createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
				}

				if (attachment2 != null && file2 != null) {
					InputStream inputStream = new FileInputStream(file2);
					OutputBlob blobData = new OutputBlob(inputStream, file2.length());
					EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachment2, blobData,
							createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
				}

				if (attachment3 != null && file3 != null) {
					InputStream inputStream = new FileInputStream(file3);
					OutputBlob blobData = new OutputBlob(inputStream, file3.length());
					EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachment3, blobData,
							createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
				}

			} else if (operation.equals(UPDATE)) {
				
				_log.info("Inside Update block");
				
				emailReminderId = ParamUtil.getLong(uploadRequest, "emailReminderId");
				
				EmailReminderLocalServiceUtil.updateEmailReminder(emailReminderId, submitterName, submitterEmailId,
						reminderNumber, scheduleTimestamp, emailSubjectTxt, emailBodyTxt, statusCode,
						lastUpdateUserId, lastUpdateTimestamp);
				
				_log.info("The EmailReminderId is"+emailReminderId);
				
				List<EmailAttachment> emailAttachmentList = EmailAttachmentLocalServiceUtil.getEmailAttachmentByReminderId(emailReminderId);
				
				//Attachment Update
				if (attachment1 != null && file1 != null) {
					InputStream inputStream = new FileInputStream(file1);
					OutputBlob blobData = new OutputBlob(inputStream, file1.length());
					
					if(emailAttachmentList.size()>0){
						EmailAttachment Emailattachment1 = emailAttachmentList.get(0);
						EmailAttachmentLocalServiceUtil.updateEmailAttachment(Emailattachment1.getEMAIL_ATTACHMENT_ID(), attachment1, blobData, 
								lastUpdateUserId, lastUpdateTimestamp);
					}else{
						EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachment1, blobData,
								createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
					}
					
					
				}

				if (attachment2 != null && file2 != null) {
					InputStream inputStream = new FileInputStream(file2);
					OutputBlob blobData = new OutputBlob(inputStream, file2.length());
					
					if(emailAttachmentList.size()>1){
						EmailAttachment Emailattachment2 = emailAttachmentList.get(1);
						EmailAttachmentLocalServiceUtil.updateEmailAttachment(Emailattachment2.getEMAIL_ATTACHMENT_ID(), attachment2, blobData, 
								lastUpdateUserId, lastUpdateTimestamp);
					}else{
						EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachment2, blobData,
								createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
					}
				}

				if (attachment3 != null && file3 != null) {
					InputStream inputStream = new FileInputStream(file3);
					OutputBlob blobData = new OutputBlob(inputStream, file3.length());
					if(emailAttachmentList.size()>2){
						EmailAttachment Emailattachment3 = emailAttachmentList.get(2);
						EmailAttachmentLocalServiceUtil.updateEmailAttachment(Emailattachment3.getEMAIL_ATTACHMENT_ID(), attachment3, blobData, 
								lastUpdateUserId, lastUpdateTimestamp);
					}else{
						EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachment3, blobData,
								createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
					}
				}

			}
			
			_log.info("Exiting the action method");
			actionResponse.setRenderParameter("mvcPath", "/html/emailreminder/view.jsp");
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchEmailAttachmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
