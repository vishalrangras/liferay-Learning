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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the email reminder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see EmailReminderPersistenceImpl
 * @see EmailReminderUtil
 * @generated
 */
public interface EmailReminderPersistence extends BasePersistence<EmailReminder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailReminderUtil} to access the email reminder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the email reminder where emailReminderId = &#63; or throws a {@link com.ihg.me2.NoSuchEmailReminderException} if it could not be found.
	*
	* @param emailReminderId the email reminder ID
	* @return the matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder findByEmailReminderId(
		long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email reminder where emailReminderId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailReminderId the email reminder ID
	* @return the matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchByEmailReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email reminder where emailReminderId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailReminderId the email reminder ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchByEmailReminderId(
		long emailReminderId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the email reminder where emailReminderId = &#63; from the database.
	*
	* @param emailReminderId the email reminder ID
	* @return the email reminder that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder removeByEmailReminderId(
		long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email reminders where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailReminderId(long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the email reminders where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @return the matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.me2.model.EmailReminder> findBySchedule(
		java.util.Date scheduleTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findBySchedule(
		java.util.Date scheduleTimestamp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findBySchedule(
		java.util.Date scheduleTimestamp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder findBySchedule_First(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchBySchedule_First(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder findBySchedule_Last(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last email reminder in the ordered set where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchBySchedule_Last(
		java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.me2.model.EmailReminder[] findBySchedule_PrevAndNext(
		long emailReminderId, java.util.Date scheduleTimestamp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the email reminders where scheduleTimestamp = &#63; from the database.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySchedule(java.util.Date scheduleTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email reminders where scheduleTimestamp = &#63;.
	*
	* @param scheduleTimestamp the schedule timestamp
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public int countBySchedule(java.util.Date scheduleTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the email reminders where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @return the matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String statusCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String statusCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder findByStatus_First(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchByStatus_First(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder findByStatus_Last(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last email reminder in the ordered set where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email reminder, or <code>null</code> if a matching email reminder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchByStatus_Last(
		java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.me2.model.EmailReminder[] findByStatus_PrevAndNext(
		long emailReminderId, java.lang.String statusCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String[] statusCodes)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String[] statusCodes, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findByStatus(
		java.lang.String[] statusCodes, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the email reminders where statusCode = &#63; from the database.
	*
	* @param statusCode the status code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email reminders where statusCode = &#63;.
	*
	* @param statusCode the status code
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email reminders where statusCode = any &#63;.
	*
	* @param statusCodes the status codes
	* @return the number of matching email reminders
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(java.lang.String[] statusCodes)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the email reminder in the entity cache if it is enabled.
	*
	* @param emailReminder the email reminder
	*/
	public void cacheResult(com.ihg.me2.model.EmailReminder emailReminder);

	/**
	* Caches the email reminders in the entity cache if it is enabled.
	*
	* @param emailReminders the email reminders
	*/
	public void cacheResult(
		java.util.List<com.ihg.me2.model.EmailReminder> emailReminders);

	/**
	* Creates a new email reminder with the primary key. Does not add the email reminder to the database.
	*
	* @param emailReminderId the primary key for the new email reminder
	* @return the new email reminder
	*/
	public com.ihg.me2.model.EmailReminder create(long emailReminderId);

	/**
	* Removes the email reminder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder that was removed
	* @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder remove(long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.me2.model.EmailReminder updateImpl(
		com.ihg.me2.model.EmailReminder emailReminder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email reminder with the primary key or throws a {@link com.ihg.me2.NoSuchEmailReminderException} if it could not be found.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder
	* @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder findByPrimaryKey(
		long emailReminderId)
		throws com.ihg.me2.NoSuchEmailReminderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email reminder with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param emailReminderId the primary key of the email reminder
	* @return the email reminder, or <code>null</code> if a email reminder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailReminder fetchByPrimaryKey(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the email reminders.
	*
	* @return the email reminders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.me2.model.EmailReminder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailReminder> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the email reminders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email reminders.
	*
	* @return the number of email reminders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}