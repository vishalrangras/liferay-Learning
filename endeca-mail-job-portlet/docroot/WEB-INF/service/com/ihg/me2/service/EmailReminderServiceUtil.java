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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for EmailReminder. This utility wraps
 * {@link com.ihg.me2.service.impl.EmailReminderServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author vishal.rangras
 * @see EmailReminderService
 * @see com.ihg.me2.service.base.EmailReminderServiceBaseImpl
 * @see com.ihg.me2.service.impl.EmailReminderServiceImpl
 * @generated
 */
public class EmailReminderServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.me2.service.impl.EmailReminderServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.ihg.me2.model.EmailReminder getEmailReminderById(
		long EmailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminderById(EmailReminderId);
	}

	public static java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminders()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminders();
	}

	public static java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminders(start, end);
	}

	public static java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminderBySchedule(
		java.util.Date scheduleTimestamp)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminderBySchedule(scheduleTimestamp);
	}

	public static boolean updateEmailReminderStatus(long emailReminderId,
		java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmailReminderStatus(emailReminderId, statusCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmailReminderService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmailReminderService.class.getName());

			if (invokableService instanceof EmailReminderService) {
				_service = (EmailReminderService)invokableService;
			}
			else {
				_service = new EmailReminderServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EmailReminderServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmailReminderService service) {
	}

	private static EmailReminderService _service;
}