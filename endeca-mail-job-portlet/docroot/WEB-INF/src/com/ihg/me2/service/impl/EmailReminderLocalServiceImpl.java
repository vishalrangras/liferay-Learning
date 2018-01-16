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
import com.ihg.me2.service.base.EmailReminderLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the email reminder local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.me2.service.EmailReminderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.base.EmailReminderLocalServiceBaseImpl
 * @see com.ihg.me2.service.EmailReminderLocalServiceUtil
 */
public class EmailReminderLocalServiceImpl
	extends EmailReminderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.me2.service.EmailReminderLocalServiceUtil} to access the email reminder local service.
	 */
	
	public EmailReminder getEmailReminderById(long EmailReminderId) throws NoSuchEmailReminderException, SystemException{
		return emailReminderPersistence.findByEmailReminderId(EmailReminderId);
	}
	
	public List<EmailReminder> getEmailReminders() throws SystemException {
		String status[] = {"1", "2"};
		return emailReminderPersistence.findByStatus(status);
	}
	
	public List<EmailReminder> getEmailReminders(int start, int end) throws SystemException {
		String status[] = {"1", "2"};
		return emailReminderPersistence.findByStatus(status, start, end);
	}
	
	public List<EmailReminder> getEmailReminderBySchedule(Date scheduleTimestamp) throws NoSuchEmailReminderException, SystemException{
		return emailReminderPersistence.findBySchedule(scheduleTimestamp);
	}

	public EmailReminder addEmailReminder(String submitterName, String submitterEmailId,
			int reminderNumber, Date scheduleTimestamp, String emailSubjectTxt, String emailBodyTxt, String statusCode,
			String createUserId, Date createTimestamp, String lastUpdateUserId, Date lastUpdateTimestamp) throws SystemException {
		
		long emailReminderId = CounterLocalServiceUtil.increment(EmailReminder.class.getName());
		EmailReminder emailReminder = emailReminderPersistence.create(emailReminderId);
		emailReminder.setSubmitterName(submitterName);
		emailReminder.setSubmitterEmailId(submitterEmailId);
		emailReminder.setReminderNumber(reminderNumber);
		emailReminder.setScheduleTimestamp(scheduleTimestamp);
		emailReminder.setEmailSubjectText(emailSubjectTxt);
		emailReminder.setEmailBodyText(emailBodyTxt);
		emailReminder.setStatusCode(statusCode);
		emailReminder.setCreateUserId(createUserId);
		emailReminder.setCreateTimestamp(createTimestamp);
		emailReminder.setLastUpdateUserId(lastUpdateUserId);
		emailReminder.setLastUpdateTimestamp(lastUpdateTimestamp);
		emailReminderPersistence.update(emailReminder);
		return emailReminder;

	}
	
	public EmailReminder updateEmailReminder(long emailReminderId, String submitterName, String submitterEmailId,
			int reminderNumber, Date scheduleTimestamp, String emailSubjectTxt, String emailBodyTxt, String statusCode,
			String lastUpdateUserId, Date lastUpdateTimestamp) throws SystemException {
		
		EmailReminder emailReminder = emailReminderPersistence.fetchByEmailReminderId(emailReminderId);
		emailReminder.setSubmitterName(submitterName);
		emailReminder.setSubmitterEmailId(submitterEmailId);
		emailReminder.setReminderNumber(reminderNumber);
		emailReminder.setScheduleTimestamp(scheduleTimestamp);
		emailReminder.setEmailSubjectText(emailSubjectTxt);
		emailReminder.setEmailBodyText(emailBodyTxt);
		emailReminder.setStatusCode(statusCode);
		emailReminder.setLastUpdateUserId(lastUpdateUserId);
		emailReminder.setLastUpdateTimestamp(lastUpdateTimestamp);
		emailReminderPersistence.update(emailReminder);
		return emailReminder;
	}
}