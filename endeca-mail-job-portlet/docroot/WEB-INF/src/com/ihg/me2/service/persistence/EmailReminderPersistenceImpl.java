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

import com.ihg.me2.NoSuchEmailReminderException;
import com.ihg.me2.model.EmailReminder;
import com.ihg.me2.model.impl.EmailReminderImpl;
import com.ihg.me2.model.impl.EmailReminderModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the email reminder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see EmailReminderPersistence
 * @see EmailReminderUtil
 * @generated
 */
public class EmailReminderPersistenceImpl extends BasePersistenceImpl<EmailReminder>
	implements EmailReminderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmailReminderUtil} to access the email reminder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmailReminderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILREMINDERID = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailReminderId", new String[] { Long.class.getName() },
			EmailReminderModelImpl.EMAILREMINDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILREMINDERID = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailReminderId", new String[] { Long.class.getName() });

	/**
	 * Returns the email reminder where emailReminderId = &#63; or throws a {@link com.ihg.me2.NoSuchEmailReminderException} if it could not be found.
	 *
	 * @param emailReminderId the email reminder ID
	 * @return the matching email reminder
	 * @throws com.ihg.me2.NoSuchEmailReminderException if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder findByEmailReminderId(long emailReminderId)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = fetchByEmailReminderId(emailReminderId);

		if (emailReminder == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailReminderId=");
			msg.append(emailReminderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmailReminderException(msg.toString());
		}

		return emailReminder;
	}

	/**
	 * Returns the email reminder where emailReminderId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailReminderId the email reminder ID
	 * @return the matching email reminder, or <code>null</code> if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchByEmailReminderId(long emailReminderId)
		throws SystemException {
		return fetchByEmailReminderId(emailReminderId, true);
	}

	/**
	 * Returns the email reminder where emailReminderId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailReminderId the email reminder ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching email reminder, or <code>null</code> if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchByEmailReminderId(long emailReminderId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { emailReminderId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
					finderArgs, this);
		}

		if (result instanceof EmailReminder) {
			EmailReminder emailReminder = (EmailReminder)result;

			if ((emailReminderId != emailReminder.getEmailReminderId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMAILREMINDER_WHERE);

			query.append(_FINDER_COLUMN_EMAILREMINDERID_EMAILREMINDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emailReminderId);

				List<EmailReminder> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmailReminderPersistenceImpl.fetchByEmailReminderId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmailReminder emailReminder = list.get(0);

					result = emailReminder;

					cacheResult(emailReminder);

					if ((emailReminder.getEmailReminderId() != emailReminderId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
							finderArgs, emailReminder);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmailReminder)result;
		}
	}

	/**
	 * Removes the email reminder where emailReminderId = &#63; from the database.
	 *
	 * @param emailReminderId the email reminder ID
	 * @return the email reminder that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder removeByEmailReminderId(long emailReminderId)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = findByEmailReminderId(emailReminderId);

		return remove(emailReminder);
	}

	/**
	 * Returns the number of email reminders where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @return the number of matching email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailReminderId(long emailReminderId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILREMINDERID;

		Object[] finderArgs = new Object[] { emailReminderId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILREMINDER_WHERE);

			query.append(_FINDER_COLUMN_EMAILREMINDERID_EMAILREMINDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emailReminderId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAILREMINDERID_EMAILREMINDERID_2 =
		"emailReminder.emailReminderId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDULE = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySchedule",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULE =
		new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySchedule", new String[] { Date.class.getName() },
			EmailReminderModelImpl.SCHEDULETIMESTAMP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCHEDULE = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySchedule",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the email reminders where scheduleTimestamp = &#63;.
	 *
	 * @param scheduleTimestamp the schedule timestamp
	 * @return the matching email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailReminder> findBySchedule(Date scheduleTimestamp)
		throws SystemException {
		return findBySchedule(scheduleTimestamp, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmailReminder> findBySchedule(Date scheduleTimestamp,
		int start, int end) throws SystemException {
		return findBySchedule(scheduleTimestamp, start, end, null);
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
	@Override
	public List<EmailReminder> findBySchedule(Date scheduleTimestamp,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULE;
			finderArgs = new Object[] { scheduleTimestamp };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDULE;
			finderArgs = new Object[] {
					scheduleTimestamp,
					
					start, end, orderByComparator
				};
		}

		List<EmailReminder> list = (List<EmailReminder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmailReminder emailReminder : list) {
				if (!Validator.equals(scheduleTimestamp,
							emailReminder.getScheduleTimestamp())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EMAILREMINDER_WHERE);

			boolean bindScheduleTimestamp = false;

			if (scheduleTimestamp == null) {
				query.append(_FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_1);
			}
			else {
				bindScheduleTimestamp = true;

				query.append(_FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmailReminderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScheduleTimestamp) {
					qPos.add(CalendarUtil.getTimestamp(scheduleTimestamp));
				}

				if (!pagination) {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmailReminder>(list);
				}
				else {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EmailReminder findBySchedule_First(Date scheduleTimestamp,
		OrderByComparator orderByComparator)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = fetchBySchedule_First(scheduleTimestamp,
				orderByComparator);

		if (emailReminder != null) {
			return emailReminder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scheduleTimestamp=");
		msg.append(scheduleTimestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailReminderException(msg.toString());
	}

	/**
	 * Returns the first email reminder in the ordered set where scheduleTimestamp = &#63;.
	 *
	 * @param scheduleTimestamp the schedule timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email reminder, or <code>null</code> if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchBySchedule_First(Date scheduleTimestamp,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmailReminder> list = findBySchedule(scheduleTimestamp, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmailReminder findBySchedule_Last(Date scheduleTimestamp,
		OrderByComparator orderByComparator)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = fetchBySchedule_Last(scheduleTimestamp,
				orderByComparator);

		if (emailReminder != null) {
			return emailReminder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scheduleTimestamp=");
		msg.append(scheduleTimestamp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailReminderException(msg.toString());
	}

	/**
	 * Returns the last email reminder in the ordered set where scheduleTimestamp = &#63;.
	 *
	 * @param scheduleTimestamp the schedule timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email reminder, or <code>null</code> if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchBySchedule_Last(Date scheduleTimestamp,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySchedule(scheduleTimestamp);

		if (count == 0) {
			return null;
		}

		List<EmailReminder> list = findBySchedule(scheduleTimestamp, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmailReminder[] findBySchedule_PrevAndNext(long emailReminderId,
		Date scheduleTimestamp, OrderByComparator orderByComparator)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = findByPrimaryKey(emailReminderId);

		Session session = null;

		try {
			session = openSession();

			EmailReminder[] array = new EmailReminderImpl[3];

			array[0] = getBySchedule_PrevAndNext(session, emailReminder,
					scheduleTimestamp, orderByComparator, true);

			array[1] = emailReminder;

			array[2] = getBySchedule_PrevAndNext(session, emailReminder,
					scheduleTimestamp, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailReminder getBySchedule_PrevAndNext(Session session,
		EmailReminder emailReminder, Date scheduleTimestamp,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAILREMINDER_WHERE);

		boolean bindScheduleTimestamp = false;

		if (scheduleTimestamp == null) {
			query.append(_FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_1);
		}
		else {
			bindScheduleTimestamp = true;

			query.append(_FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EmailReminderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScheduleTimestamp) {
			qPos.add(CalendarUtil.getTimestamp(scheduleTimestamp));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(emailReminder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmailReminder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email reminders where scheduleTimestamp = &#63; from the database.
	 *
	 * @param scheduleTimestamp the schedule timestamp
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySchedule(Date scheduleTimestamp)
		throws SystemException {
		for (EmailReminder emailReminder : findBySchedule(scheduleTimestamp,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(emailReminder);
		}
	}

	/**
	 * Returns the number of email reminders where scheduleTimestamp = &#63;.
	 *
	 * @param scheduleTimestamp the schedule timestamp
	 * @return the number of matching email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySchedule(Date scheduleTimestamp)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCHEDULE;

		Object[] finderArgs = new Object[] { scheduleTimestamp };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILREMINDER_WHERE);

			boolean bindScheduleTimestamp = false;

			if (scheduleTimestamp == null) {
				query.append(_FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_1);
			}
			else {
				bindScheduleTimestamp = true;

				query.append(_FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScheduleTimestamp) {
					qPos.add(CalendarUtil.getTimestamp(scheduleTimestamp));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_1 = "emailReminder.scheduleTimestamp IS NULL";
	private static final String _FINDER_COLUMN_SCHEDULE_SCHEDULETIMESTAMP_2 = "emailReminder.scheduleTimestamp = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED,
			EmailReminderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatus", new String[] { String.class.getName() },
			EmailReminderModelImpl.STATUSCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUS = new FinderPath(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the email reminders where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @return the matching email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailReminder> findByStatus(String statusCode)
		throws SystemException {
		return findByStatus(statusCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<EmailReminder> findByStatus(String statusCode, int start,
		int end) throws SystemException {
		return findByStatus(statusCode, start, end, null);
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
	@Override
	public List<EmailReminder> findByStatus(String statusCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { statusCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { statusCode, start, end, orderByComparator };
		}

		List<EmailReminder> list = (List<EmailReminder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmailReminder emailReminder : list) {
				if (!Validator.equals(statusCode, emailReminder.getStatusCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EMAILREMINDER_WHERE);

			boolean bindStatusCode = false;

			if (statusCode == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUSCODE_1);
			}
			else if (statusCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUSCODE_3);
			}
			else {
				bindStatusCode = true;

				query.append(_FINDER_COLUMN_STATUS_STATUSCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmailReminderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatusCode) {
					qPos.add(statusCode);
				}

				if (!pagination) {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmailReminder>(list);
				}
				else {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EmailReminder findByStatus_First(String statusCode,
		OrderByComparator orderByComparator)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = fetchByStatus_First(statusCode,
				orderByComparator);

		if (emailReminder != null) {
			return emailReminder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusCode=");
		msg.append(statusCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailReminderException(msg.toString());
	}

	/**
	 * Returns the first email reminder in the ordered set where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email reminder, or <code>null</code> if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchByStatus_First(String statusCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmailReminder> list = findByStatus(statusCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmailReminder findByStatus_Last(String statusCode,
		OrderByComparator orderByComparator)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = fetchByStatus_Last(statusCode,
				orderByComparator);

		if (emailReminder != null) {
			return emailReminder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusCode=");
		msg.append(statusCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailReminderException(msg.toString());
	}

	/**
	 * Returns the last email reminder in the ordered set where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email reminder, or <code>null</code> if a matching email reminder could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchByStatus_Last(String statusCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(statusCode);

		if (count == 0) {
			return null;
		}

		List<EmailReminder> list = findByStatus(statusCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmailReminder[] findByStatus_PrevAndNext(long emailReminderId,
		String statusCode, OrderByComparator orderByComparator)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = findByPrimaryKey(emailReminderId);

		Session session = null;

		try {
			session = openSession();

			EmailReminder[] array = new EmailReminderImpl[3];

			array[0] = getByStatus_PrevAndNext(session, emailReminder,
					statusCode, orderByComparator, true);

			array[1] = emailReminder;

			array[2] = getByStatus_PrevAndNext(session, emailReminder,
					statusCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailReminder getByStatus_PrevAndNext(Session session,
		EmailReminder emailReminder, String statusCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAILREMINDER_WHERE);

		boolean bindStatusCode = false;

		if (statusCode == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUSCODE_1);
		}
		else if (statusCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_STATUSCODE_3);
		}
		else {
			bindStatusCode = true;

			query.append(_FINDER_COLUMN_STATUS_STATUSCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EmailReminderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatusCode) {
			qPos.add(statusCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(emailReminder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmailReminder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<EmailReminder> findByStatus(String[] statusCodes)
		throws SystemException {
		return findByStatus(statusCodes, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<EmailReminder> findByStatus(String[] statusCodes, int start,
		int end) throws SystemException {
		return findByStatus(statusCodes, start, end, null);
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
	@Override
	public List<EmailReminder> findByStatus(String[] statusCodes, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((statusCodes != null) && (statusCodes.length == 1)) {
			return findByStatus(statusCodes[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(statusCodes) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(statusCodes),
					
					start, end, orderByComparator
				};
		}

		List<EmailReminder> list = (List<EmailReminder>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmailReminder emailReminder : list) {
				if (!ArrayUtil.contains(statusCodes,
							emailReminder.getStatusCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EMAILREMINDER_WHERE);

			boolean conjunctionable = false;

			if ((statusCodes == null) || (statusCodes.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statusCodes.length; i++) {
					String statusCode = statusCodes[i];

					if (statusCode == null) {
						query.append(_FINDER_COLUMN_STATUS_STATUSCODE_4);
					}
					else if (statusCode.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_STATUS_STATUSCODE_6);
					}
					else {
						query.append(_FINDER_COLUMN_STATUS_STATUSCODE_5);
					}

					if ((i + 1) < statusCodes.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmailReminderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (statusCodes != null) {
					qPos.add(statusCodes);
				}

				if (!pagination) {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmailReminder>(list);
				}
				else {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the email reminders where statusCode = &#63; from the database.
	 *
	 * @param statusCode the status code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(String statusCode) throws SystemException {
		for (EmailReminder emailReminder : findByStatus(statusCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(emailReminder);
		}
	}

	/**
	 * Returns the number of email reminders where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @return the number of matching email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(String statusCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { statusCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILREMINDER_WHERE);

			boolean bindStatusCode = false;

			if (statusCode == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUSCODE_1);
			}
			else if (statusCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUSCODE_3);
			}
			else {
				bindStatusCode = true;

				query.append(_FINDER_COLUMN_STATUS_STATUSCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatusCode) {
					qPos.add(statusCode);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of email reminders where statusCode = any &#63;.
	 *
	 * @param statusCodes the status codes
	 * @return the number of matching email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(String[] statusCodes) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(statusCodes) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EMAILREMINDER_WHERE);

			boolean conjunctionable = false;

			if ((statusCodes == null) || (statusCodes.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < statusCodes.length; i++) {
					String statusCode = statusCodes[i];

					if (statusCode == null) {
						query.append(_FINDER_COLUMN_STATUS_STATUSCODE_4);
					}
					else if (statusCode.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_STATUS_STATUSCODE_6);
					}
					else {
						query.append(_FINDER_COLUMN_STATUS_STATUSCODE_5);
					}

					if ((i + 1) < statusCodes.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (statusCodes != null) {
					qPos.add(statusCodes);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUSCODE_1 = "emailReminder.statusCode IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUSCODE_2 = "emailReminder.statusCode = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUSCODE_3 = "(emailReminder.statusCode IS NULL OR emailReminder.statusCode = '')";
	private static final String _FINDER_COLUMN_STATUS_STATUSCODE_4 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUS_STATUSCODE_1) + ")";
	private static final String _FINDER_COLUMN_STATUS_STATUSCODE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUS_STATUSCODE_2) + ")";
	private static final String _FINDER_COLUMN_STATUS_STATUSCODE_6 = "(" +
		removeConjunction(_FINDER_COLUMN_STATUS_STATUSCODE_3) + ")";

	public EmailReminderPersistenceImpl() {
		setModelClass(EmailReminder.class);
	}

	/**
	 * Caches the email reminder in the entity cache if it is enabled.
	 *
	 * @param emailReminder the email reminder
	 */
	@Override
	public void cacheResult(EmailReminder emailReminder) {
		EntityCacheUtil.putResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderImpl.class, emailReminder.getPrimaryKey(),
			emailReminder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
			new Object[] { emailReminder.getEmailReminderId() }, emailReminder);

		emailReminder.resetOriginalValues();
	}

	/**
	 * Caches the email reminders in the entity cache if it is enabled.
	 *
	 * @param emailReminders the email reminders
	 */
	@Override
	public void cacheResult(List<EmailReminder> emailReminders) {
		for (EmailReminder emailReminder : emailReminders) {
			if (EntityCacheUtil.getResult(
						EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
						EmailReminderImpl.class, emailReminder.getPrimaryKey()) == null) {
				cacheResult(emailReminder);
			}
			else {
				emailReminder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all email reminders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmailReminderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmailReminderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email reminder.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailReminder emailReminder) {
		EntityCacheUtil.removeResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderImpl.class, emailReminder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(emailReminder);
	}

	@Override
	public void clearCache(List<EmailReminder> emailReminders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmailReminder emailReminder : emailReminders) {
			EntityCacheUtil.removeResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
				EmailReminderImpl.class, emailReminder.getPrimaryKey());

			clearUniqueFindersCache(emailReminder);
		}
	}

	protected void cacheUniqueFindersCache(EmailReminder emailReminder) {
		if (emailReminder.isNew()) {
			Object[] args = new Object[] { emailReminder.getEmailReminderId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILREMINDERID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
				args, emailReminder);
		}
		else {
			EmailReminderModelImpl emailReminderModelImpl = (EmailReminderModelImpl)emailReminder;

			if ((emailReminderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILREMINDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { emailReminder.getEmailReminderId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILREMINDERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
					args, emailReminder);
			}
		}
	}

	protected void clearUniqueFindersCache(EmailReminder emailReminder) {
		EmailReminderModelImpl emailReminderModelImpl = (EmailReminderModelImpl)emailReminder;

		Object[] args = new Object[] { emailReminder.getEmailReminderId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILREMINDERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID, args);

		if ((emailReminderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILREMINDERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					emailReminderModelImpl.getOriginalEmailReminderId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILREMINDERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILREMINDERID,
				args);
		}
	}

	/**
	 * Creates a new email reminder with the primary key. Does not add the email reminder to the database.
	 *
	 * @param emailReminderId the primary key for the new email reminder
	 * @return the new email reminder
	 */
	@Override
	public EmailReminder create(long emailReminderId) {
		EmailReminder emailReminder = new EmailReminderImpl();

		emailReminder.setNew(true);
		emailReminder.setPrimaryKey(emailReminderId);

		return emailReminder;
	}

	/**
	 * Removes the email reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emailReminderId the primary key of the email reminder
	 * @return the email reminder that was removed
	 * @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder remove(long emailReminderId)
		throws NoSuchEmailReminderException, SystemException {
		return remove((Serializable)emailReminderId);
	}

	/**
	 * Removes the email reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email reminder
	 * @return the email reminder that was removed
	 * @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder remove(Serializable primaryKey)
		throws NoSuchEmailReminderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmailReminder emailReminder = (EmailReminder)session.get(EmailReminderImpl.class,
					primaryKey);

			if (emailReminder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailReminderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emailReminder);
		}
		catch (NoSuchEmailReminderException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmailReminder removeImpl(EmailReminder emailReminder)
		throws SystemException {
		emailReminder = toUnwrappedModel(emailReminder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailReminder)) {
				emailReminder = (EmailReminder)session.get(EmailReminderImpl.class,
						emailReminder.getPrimaryKeyObj());
			}

			if (emailReminder != null) {
				session.delete(emailReminder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emailReminder != null) {
			clearCache(emailReminder);
		}

		return emailReminder;
	}

	@Override
	public EmailReminder updateImpl(
		com.ihg.me2.model.EmailReminder emailReminder)
		throws SystemException {
		emailReminder = toUnwrappedModel(emailReminder);

		boolean isNew = emailReminder.isNew();

		EmailReminderModelImpl emailReminderModelImpl = (EmailReminderModelImpl)emailReminder;

		Session session = null;

		try {
			session = openSession();

			if (emailReminder.isNew()) {
				session.save(emailReminder);

				emailReminder.setNew(false);
			}
			else {
				session.merge(emailReminder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmailReminderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((emailReminderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailReminderModelImpl.getOriginalScheduleTimestamp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCHEDULE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULE,
					args);

				args = new Object[] {
						emailReminderModelImpl.getScheduleTimestamp()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCHEDULE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULE,
					args);
			}

			if ((emailReminderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailReminderModelImpl.getOriginalStatusCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { emailReminderModelImpl.getStatusCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
			EmailReminderImpl.class, emailReminder.getPrimaryKey(),
			emailReminder);

		clearUniqueFindersCache(emailReminder);
		cacheUniqueFindersCache(emailReminder);

		return emailReminder;
	}

	protected EmailReminder toUnwrappedModel(EmailReminder emailReminder) {
		if (emailReminder instanceof EmailReminderImpl) {
			return emailReminder;
		}

		EmailReminderImpl emailReminderImpl = new EmailReminderImpl();

		emailReminderImpl.setNew(emailReminder.isNew());
		emailReminderImpl.setPrimaryKey(emailReminder.getPrimaryKey());

		emailReminderImpl.setEmailReminderId(emailReminder.getEmailReminderId());
		emailReminderImpl.setSubmitterName(emailReminder.getSubmitterName());
		emailReminderImpl.setSubmitterEmailId(emailReminder.getSubmitterEmailId());
		emailReminderImpl.setReminderNumber(emailReminder.getReminderNumber());
		emailReminderImpl.setScheduleTimestamp(emailReminder.getScheduleTimestamp());
		emailReminderImpl.setEmailSubjectText(emailReminder.getEmailSubjectText());
		emailReminderImpl.setEmailBodyText(emailReminder.getEmailBodyText());
		emailReminderImpl.setStatusCode(emailReminder.getStatusCode());
		emailReminderImpl.setCreateUserId(emailReminder.getCreateUserId());
		emailReminderImpl.setCreateTimestamp(emailReminder.getCreateTimestamp());
		emailReminderImpl.setLastUpdateUserId(emailReminder.getLastUpdateUserId());
		emailReminderImpl.setLastUpdateTimestamp(emailReminder.getLastUpdateTimestamp());

		return emailReminderImpl;
	}

	/**
	 * Returns the email reminder with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email reminder
	 * @return the email reminder
	 * @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailReminderException, SystemException {
		EmailReminder emailReminder = fetchByPrimaryKey(primaryKey);

		if (emailReminder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailReminderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emailReminder;
	}

	/**
	 * Returns the email reminder with the primary key or throws a {@link com.ihg.me2.NoSuchEmailReminderException} if it could not be found.
	 *
	 * @param emailReminderId the primary key of the email reminder
	 * @return the email reminder
	 * @throws com.ihg.me2.NoSuchEmailReminderException if a email reminder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder findByPrimaryKey(long emailReminderId)
		throws NoSuchEmailReminderException, SystemException {
		return findByPrimaryKey((Serializable)emailReminderId);
	}

	/**
	 * Returns the email reminder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email reminder
	 * @return the email reminder, or <code>null</code> if a email reminder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmailReminder emailReminder = (EmailReminder)EntityCacheUtil.getResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
				EmailReminderImpl.class, primaryKey);

		if (emailReminder == _nullEmailReminder) {
			return null;
		}

		if (emailReminder == null) {
			Session session = null;

			try {
				session = openSession();

				emailReminder = (EmailReminder)session.get(EmailReminderImpl.class,
						primaryKey);

				if (emailReminder != null) {
					cacheResult(emailReminder);
				}
				else {
					EntityCacheUtil.putResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
						EmailReminderImpl.class, primaryKey, _nullEmailReminder);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmailReminderModelImpl.ENTITY_CACHE_ENABLED,
					EmailReminderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emailReminder;
	}

	/**
	 * Returns the email reminder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emailReminderId the primary key of the email reminder
	 * @return the email reminder, or <code>null</code> if a email reminder with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailReminder fetchByPrimaryKey(long emailReminderId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)emailReminderId);
	}

	/**
	 * Returns all the email reminders.
	 *
	 * @return the email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailReminder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmailReminder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<EmailReminder> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EmailReminder> list = (List<EmailReminder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMAILREMINDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILREMINDER;

				if (pagination) {
					sql = sql.concat(EmailReminderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmailReminder>(list);
				}
				else {
					list = (List<EmailReminder>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the email reminders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmailReminder emailReminder : findAll()) {
			remove(emailReminder);
		}
	}

	/**
	 * Returns the number of email reminders.
	 *
	 * @return the number of email reminders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAILREMINDER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the email reminder persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.me2.model.EmailReminder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmailReminder>> listenersList = new ArrayList<ModelListener<EmailReminder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmailReminder>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EmailReminderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMAILREMINDER = "SELECT emailReminder FROM EmailReminder emailReminder";
	private static final String _SQL_SELECT_EMAILREMINDER_WHERE = "SELECT emailReminder FROM EmailReminder emailReminder WHERE ";
	private static final String _SQL_COUNT_EMAILREMINDER = "SELECT COUNT(emailReminder) FROM EmailReminder emailReminder";
	private static final String _SQL_COUNT_EMAILREMINDER_WHERE = "SELECT COUNT(emailReminder) FROM EmailReminder emailReminder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emailReminder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmailReminder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmailReminder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmailReminderPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"emailReminderId", "submitterName", "submitterEmailId",
				"reminderNumber", "scheduleTimestamp", "emailSubjectText",
				"emailBodyText", "statusCode", "createUserId", "createTimestamp",
				"lastUpdateUserId", "lastUpdateTimestamp"
			});
	private static EmailReminder _nullEmailReminder = new EmailReminderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmailReminder> toCacheModel() {
				return _nullEmailReminderCacheModel;
			}
		};

	private static CacheModel<EmailReminder> _nullEmailReminderCacheModel = new CacheModel<EmailReminder>() {
			@Override
			public EmailReminder toEntityModel() {
				return _nullEmailReminder;
			}
		};
}