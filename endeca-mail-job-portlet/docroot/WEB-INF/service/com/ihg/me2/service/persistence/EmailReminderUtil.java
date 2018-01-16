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

package com.ihg.me2.service.persistence;

import com.ihg.me2.model.EmailReminder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the email reminder service. This utility wraps {@link EmailReminderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see EmailReminderPersistence
 * @see EmailReminderPersistenceImpl
 * @generated
 */
public class EmailReminderUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EmailReminder emailReminder) {
		getPersistence().clearCache(emailReminder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmailReminder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailReminder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailReminder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmailReminder update(EmailReminder emailReminder)
		throws SystemException {
		return getPersistence().update(emailReminder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmailReminder update(EmailReminder emailReminder,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(emailReminder, serviceContext);
	}

	/**
	* Returns the email reminder where emailReminderId = &#63; or throws a {@link com.ihg.me2.NoSuchEmailReminderException} if it could not be found.
	*
	* @param emailReminderId the email reminder ID
	* @return the matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder findByEmailReminderId(
		long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailReminderId(emailReminderId);
	}

	/**
	* Returns the email reminder where emailReminderId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailReminderId the email reminder ID
	* @return the matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchByEmailReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailReminderId(emailReminderId);
	}

	/**
	* Returns the email reminder where emailReminderId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailReminderId the email reminder ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchByEmailReminderId(
		long emailReminderId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailReminderId(emailReminderId, retrieveFromCache);
	}

	/**
	* Removes the email reminder where emailReminderId = &#63; from the database.
	*
	* @param emailReminderId the email reminder ID
	* @return the email reminder that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder removeByEmailReminderId(
		long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByEmailReminderId(emailReminderId);
	}

	/**
	* Returns the number of email reminders where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailReminderId(long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailReminderId(emailReminderId);
	}

	/**
	* Returns all the email reminders where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @return the matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findBySchedule(
		java.util.Date scheduleTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySchedule(scheduleTimestamp);
	}

	/**
	* Returns a range of all the email reminders where scheduleTimestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @return the range of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findBySchedule(
		java.util.Date scheduleTimestamp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySchedule(scheduleTimestamp, start, end);
	}

	/**
	* Returns an ordered range of all the email reminders where scheduleTimestamp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findBySchedule(
		java.util.Date scheduleTimestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySchedule(scheduleTimestamp, start, end,
			orderByComparator);
	}

	/**
	* Returns the first email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder findBySchedule_First(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySchedule_First(scheduleTimestamp, orderByComparator);
	}

	/**
	* Returns the first email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchBySchedule_First(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySchedule_First(scheduleTimestamp, orderByComparator);
	}

	/**
	* Returns the last email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder findBySchedule_Last(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySchedule_Last(scheduleTimestamp, orderByComparator);
	}

	/**
	* Returns the last email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchBySchedule_Last(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySchedule_Last(scheduleTimestamp, orderByComparator);
	}

	/**
	* Returns the email reminders before and after the current email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param emailReminderId the primary key of the current email reminder
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder[] findBySchedule_PrevAndNext(
		long emailReminderId, java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySchedule_PrevAndNext(emailReminderId,
			scheduleTimestamp, orderByComparator);
	}

	/**
	* Removes all the email reminders where scheduleTimestamp = &#63; from the database.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySchedule(java.util.Date scheduleTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySchedule(scheduleTimestamp);
	}

	/**
	* Returns the number of email reminders where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySchedule(java.util.Date scheduleTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySchedule(scheduleTimestamp);
	}

	/**
	* Returns all the email reminders where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @return the matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(statusCode);
	}

	/**
	* Returns a range of all the email reminders where statusCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCode the status code
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @return the range of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String statusCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(statusCode, start, end);
	}

	/**
	* Returns an ordered range of all the email reminders where statusCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCode the status code
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String statusCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(statusCode, start, end, orderByComparator);
	}

	/**
	* Returns the first email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder findByStatus_First(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(statusCode, orderByComparator);
	}

	/**
	* Returns the first email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchByStatus_First(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatus_First(statusCode, orderByComparator);
	}

	/**
	* Returns the last email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder findByStatus_Last(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(statusCode, orderByComparator);
	}

	/**
	* Returns the last email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchByStatus_Last(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(statusCode, orderByComparator);
	}

	/**
	* Returns the email reminders before and after the current email reminder in the ordered set where statusCode = &#63;.
	*
	* @param emailReminderId the primary key of the current email reminder
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder[] findByStatus_PrevAndNext(
		long emailReminderId, java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(emailReminderId, statusCode,
			orderByComparator);
	}

	/**
	* Returns all the email reminders where statusCode = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCodes the status codes
	* @return the matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String[] statusCodes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(statusCodes);
	}

	/**
	* Returns a range of all the email reminders where statusCode = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCodes the status codes
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @return the range of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String[] statusCodes, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(statusCodes, start, end);
	}

	/**
	* Returns an ordered range of all the email reminders where statusCode = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusCodes the status codes
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String[] statusCodes, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(statusCodes, start, end, orderByComparator);
	}

	/**
	* Removes all the email reminders where statusCode = &#63; from the database.
	*
	* @param statusCode the status code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(statusCode);
	}

	/**
	* Returns the number of email reminders where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(statusCode);
	}

	/**
	* Returns the number of email reminders where statusCode = any &#63;.
	*
	* @param statusCodes the status codes
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String[] statusCodes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(statusCodes);
	}

	/**
	* Caches the email reminder in the entity cache if it is enabled.
	*
	* @param emailReminder the email reminder
	*/
	public static void cacheResult(
		com.ihg.me2.model.EmailReminder emailReminder) {
		getPersistence().cacheResult(emailReminder);
	}

	/**
	* Caches the email reminders in the entity cache if it is enabled.
	*
	* @param emailReminders the email reminders
	*/
	public static void cacheResult(
		java.util.List<com.ihg.me2.model.EmailReminder> emailReminders) {
		getPersistence().cacheResult(emailReminders);
	}

	/**
	* Creates a new email reminder with the primary key. Does not add the email reminder to the database.
	*
	* @param emailReminderId the primary key for the new email reminder
	* @return the new email reminder
	*/
	public static com.ihg.me2.model.EmailReminder create(long emailReminderId) {
		return getPersistence().create(emailReminderId);
	}

	/**
	* Removes the email reminder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder that was removed
	* @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder remove(long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(emailReminderId);
	}

	public static com.ihg.me2.model.EmailReminder updateImpl(
		com.ihg.me2.model.EmailReminder emailReminder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(emailReminder);
	}

	/**
	* Returns the email reminder with the primary key or throws a {@link com.ihg.me2.NoSuchEmailReminderException} if it could not be found.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder findByPrimaryKey(
		long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(emailReminderId);
	}

	/**
	* Returns the email reminder with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder, or <code>null</code> if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailReminder fetchByPrimaryKey(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(emailReminderId);
	}

	/**
	* Returns all the email reminders.
	*
	* @return the email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.me2.model.EmailReminder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the email reminders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailReminderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email reminders
	* @param end the upper bound of the range of email reminders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailReminder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the email reminders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of email reminders.
	*
	* @return the number of email reminders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmailReminderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmailReminderPersistence)PortletBeanLocatorUtil.locate(com.ihg.me2.service.ClpSerializer.getServletContextName(),
					EmailReminderPersistence.class.getName());

			ReferenceRegistry.registerReference(EmailReminderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmailReminderPersistence persistence) {
	}

	private static EmailReminderPersistence _persistence;
}