/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.me2.service.impl;

import com.ihg.me2.NoSuchEmailReminderException;
import com.ihg.me2.model.EmailReminder;
import com.ihg.me2.service.EmailReminderLocalServiceUtil;
import com.ihg.me2.service.base.EmailReminderServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the email reminder remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ihg.me2.service.EmailReminderService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.base.EmailReminderServiceBaseImpl
 * @see com.ihg.me2.service.EmailReminderServiceUtil
 */
public class EmailReminderServiceImpl extends EmailReminderServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.ihg.me2.service.EmailReminderServiceUtil} to access the email
	 * reminder remote service.
	 */

	public EmailReminder getEmailReminderById(long EmailReminderId)
			throws NoSuchEmailReminderException, SystemException {
		return EmailReminderLocalServiceUtil.getEmailReminderById(EmailReminderId);
	}

	public List<EmailReminder> getEmailReminders() throws SystemException {
		return EmailReminderLocalServiceUtil.getEmailReminders();
	}

	public List<EmailReminder> getEmailReminders(int start, int end) throws SystemException {
		return EmailReminderLocalServiceUtil.getEmailReminders(start, end);
	}

	public List<EmailReminder> getEmailReminderBySchedule(Date scheduleTimestamp)
			throws NoSuchEmailReminderException, SystemException {
		return EmailReminderLocalServiceUtil.getEmailReminderBySchedule(scheduleTimestamp);
	}

	/*public EmailReminder addEmailReminder(String submitterName, String submitterEmailId, int reminderNumber,
			Date scheduleTimestamp, String emailSubjectTxt, String emailBodyTxt, String statusCode, String createUserId,
			Date createTimestamp, String lastUpdateUserId, Date lastUpdateTimestamp) throws SystemException {

		return EmailReminderLocalServiceUtil.addEmailReminder(submitterName, submitterEmailId, reminderNumber,
				scheduleTimestamp, emailSubjectTxt, emailBodyTxt, statusCode, createUserId, createTimestamp,
				lastUpdateUserId, lastUpdateTimestamp);
	}*/
	
	public boolean updateEmailReminderStatus(long emailReminderId, String statusCode) throws PortalException, SystemException{
		EmailReminder emailReminder = EmailReminderLocalServiceUtil.getEmailReminder(emailReminderId);
		emailReminder.setStatusCode(statusCode);
		EmailReminderLocalServiceUtil.updateEmailReminder(emailReminder);
		return true;
	}

	


}