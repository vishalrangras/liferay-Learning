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

package com.ihg.me2.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailReminderService}.
 *
 * @author vishal.rangras
 * @see EmailReminderService
 * @generated
 */
public class EmailReminderServiceWrapper implements EmailReminderService,
	ServiceWrapper<EmailReminderService> {
	public EmailReminderServiceWrapper(
		EmailReminderService emailReminderService) {
		_emailReminderService = emailReminderService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _emailReminderService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_emailReminderService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _emailReminderService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.me2.model.EmailReminder getEmailReminderById(
		long EmailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailReminderService.getEmailReminderById(EmailReminderId);
	}

	@Override
	public java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminders()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailReminderService.getEmailReminders();
	}

	@Override
	public java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailReminderService.getEmailReminders(start, end);
	}

	@Override
	public java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminderBySchedule(
		java.util.Date scheduleTimestamp)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailReminderService.getEmailReminderBySchedule(scheduleTimestamp);
	}

	@Override
	public boolean updateEmailReminderStatus(long emailReminderId,
		java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailReminderService.updateEmailReminderStatus(emailReminderId,
			statusCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmailReminderService getWrappedEmailReminderService() {
		return _emailReminderService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmailReminderService(
		EmailReminderService emailReminderService) {
		_emailReminderService = emailReminderService;
	}

	@Override
	public EmailReminderService getWrappedService() {
		return _emailReminderService;
	}

	@Override
	public void setWrappedService(EmailReminderService emailReminderService) {
		_emailReminderService = emailReminderService;
	}

	private EmailReminderService _emailReminderService;
}