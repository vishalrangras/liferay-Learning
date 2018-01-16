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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EmailReminder. This utility wraps
 * {@link com.ihg.me2.service.impl.EmailReminderLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author vishal.rangras
 * @see EmailReminderLocalService
 * @see com.ihg.me2.service.base.EmailReminderLocalServiceBaseImpl
 * @see com.ihg.me2.service.impl.EmailReminderLocalServiceImpl
 * @generated
 */
public class EmailReminderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.me2.service.impl.EmailReminderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the email reminder to the database. Also notifies the appropriate model listeners.
	*
	* @param emailReminder the email reminder
	* @return the email reminder that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder addEmailReminder(
		com.ihg.me2.model.EmailReminder emailReminder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmailReminder(emailReminder);
	}

	/**
	* Creates a new email reminder with the primary key. Does not add the email reminder to the database.
	*
	* @param emailReminderId the primary key for the new email reminder
	* @return the new email reminder
	*/
	public static com.ihg.me2.model.EmailReminder createEmailReminder(
		long emailReminderId) {
		return getService().createEmailReminder(emailReminderId);
	}

	/**
	* Deletes the email reminder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder that was removed
	* @throws PortalException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder deleteEmailReminder(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmailReminder(emailReminderId);
	}

	/**
	* Deletes the email reminder from the database. Also notifies the appropriate model listeners.
	*
	* @param emailReminder the email reminder
	* @return the email reminder that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder deleteEmailReminder(
		com.ihg.me2.model.EmailReminder emailReminder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmailReminder(emailReminder);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.me2.model.EmailReminder fetchEmailReminder(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmailReminder(emailReminderId);
	}

	/**
	* Returns the email reminder with the primary key.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder
	* @throws PortalException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder getEmailReminder(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminder(emailReminderId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the email reminders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @return the range of email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminders(start, end);
	}

	/**
	* Returns the number of email reminders.
	*
	* @return the number of email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmailRemindersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailRemindersCount();
	}

	/**
	* Updates the email reminder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailReminder the email reminder
	* @return the email reminder that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder updateEmailReminder(
		com.ihg.me2.model.EmailReminder emailReminder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmailReminder(emailReminder);
	}

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

	public static java.util.List<com.ihg.me2.model.EmailReminder> getEmailReminderBySchedule(
		java.util.Date scheduleTimestamp)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailReminderBySchedule(scheduleTimestamp);
	}

	public static com.ihg.me2.model.EmailReminder addEmailReminder(
		java.lang.String submitterName, java.lang.String submitterEmailId,
		int reminderNumber, java.util.Date scheduleTimestamp,
		java.lang.String emailSubjectTxt, java.lang.String emailBodyTxt,
		java.lang.String statusCode, java.lang.String createUserId,
		java.util.Date createTimestamp, java.lang.String lastUpdateUserId,
		java.util.Date lastUpdateTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmailReminder(submitterName, submitterEmailId,
			reminderNumber, scheduleTimestamp, emailSubjectTxt, emailBodyTxt,
			statusCode, createUserId, createTimestamp, lastUpdateUserId,
			lastUpdateTimestamp);
	}

	public static com.ihg.me2.model.EmailReminder updateEmailReminder(
		long emailReminderId, java.lang.String submitterName,
		java.lang.String submitterEmailId, int reminderNumber,
		java.util.Date scheduleTimestamp, java.lang.String emailSubjectTxt,
		java.lang.String emailBodyTxt, java.lang.String statusCode,
		java.lang.String lastUpdateUserId, java.util.Date lastUpdateTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmailReminder(emailReminderId, submitterName,
			submitterEmailId, reminderNumber, scheduleTimestamp,
			emailSubjectTxt, emailBodyTxt, statusCode, lastUpdateUserId,
			lastUpdateTimestamp);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmailReminderLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmailReminderLocalService.class.getName());

			if (invokableLocalService instanceof EmailReminderLocalService) {
				_service = (EmailReminderLocalService)invokableLocalService;
			}
			else {
				_service = new EmailReminderLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmailReminderLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmailReminderLocalService service) {
	}

	private static EmailReminderLocalService _service;
}