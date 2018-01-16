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

import com.ihg.me2.NoSuchEmailAttachmentException;
import com.ihg.me2.model.EmailAttachment;
import com.ihg.me2.model.impl.EmailAttachmentImpl;
import com.ihg.me2.model.impl.EmailAttachmentModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the email attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see EmailAttachmentPersistence
 * @see EmailAttachmentUtil
 * @generated
 */
public class EmailAttachmentPersistenceImpl extends BasePersistenceImpl<EmailAttachment>
	implements EmailAttachmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmailAttachmentUtil} to access the email attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmailAttachmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmailAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmailAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILATTACHMENTID = new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmailAttachmentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailAttachmentId", new String[] { Long.class.getName() },
			EmailAttachmentModelImpl.EMAIL_ATTACHMENT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILATTACHMENTID = new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailAttachmentId", new String[] { Long.class.getName() });

	/**
	 * Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or throws a {@link com.ihg.me2.NoSuchEmailAttachmentException} if it could not be found.
	 *
	 * @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	 * @return the matching email attachment
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment findByEmailAttachmentId(long EMAIL_ATTACHMENT_ID)
		throws NoSuchEmailAttachmentException, SystemException {
		EmailAttachment emailAttachment = fetchByEmailAttachmentId(EMAIL_ATTACHMENT_ID);

		if (emailAttachment == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EMAIL_ATTACHMENT_ID=");
			msg.append(EMAIL_ATTACHMENT_ID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmailAttachmentException(msg.toString());
		}

		return emailAttachment;
	}

	/**
	 * Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	 * @return the matching email attachment, or <code>null</code> if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment fetchByEmailAttachmentId(long EMAIL_ATTACHMENT_ID)
		throws SystemException {
		return fetchByEmailAttachmentId(EMAIL_ATTACHMENT_ID, true);
	}

	/**
	 * Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching email attachment, or <code>null</code> if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment fetchByEmailAttachmentId(long EMAIL_ATTACHMENT_ID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { EMAIL_ATTACHMENT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
					finderArgs, this);
		}

		if (result instanceof EmailAttachment) {
			EmailAttachment emailAttachment = (EmailAttachment)result;

			if ((EMAIL_ATTACHMENT_ID != emailAttachment.getEMAIL_ATTACHMENT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMAILATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_EMAILATTACHMENTID_EMAIL_ATTACHMENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EMAIL_ATTACHMENT_ID);

				List<EmailAttachment> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmailAttachmentPersistenceImpl.fetchByEmailAttachmentId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmailAttachment emailAttachment = list.get(0);

					result = emailAttachment;

					cacheResult(emailAttachment);

					if ((emailAttachment.getEMAIL_ATTACHMENT_ID() != EMAIL_ATTACHMENT_ID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
							finderArgs, emailAttachment);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
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
			return (EmailAttachment)result;
		}
	}

	/**
	 * Removes the email attachment where EMAIL_ATTACHMENT_ID = &#63; from the database.
	 *
	 * @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	 * @return the email attachment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment removeByEmailAttachmentId(long EMAIL_ATTACHMENT_ID)
		throws NoSuchEmailAttachmentException, SystemException {
		EmailAttachment emailAttachment = findByEmailAttachmentId(EMAIL_ATTACHMENT_ID);

		return remove(emailAttachment);
	}

	/**
	 * Returns the number of email attachments where EMAIL_ATTACHMENT_ID = &#63;.
	 *
	 * @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	 * @return the number of matching email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAttachmentId(long EMAIL_ATTACHMENT_ID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILATTACHMENTID;

		Object[] finderArgs = new Object[] { EMAIL_ATTACHMENT_ID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_EMAILATTACHMENTID_EMAIL_ATTACHMENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(EMAIL_ATTACHMENT_ID);

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

	private static final String _FINDER_COLUMN_EMAILATTACHMENTID_EMAIL_ATTACHMENT_ID_2 =
		"emailAttachment.EMAIL_ATTACHMENT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREMINDERID =
		new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmailAttachmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmailReminderId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREMINDERID =
		new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED,
			EmailAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailReminderId",
			new String[] { Long.class.getName() },
			EmailAttachmentModelImpl.EMAILREMINDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILREMINDERID = new FinderPath(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailReminderId", new String[] { Long.class.getName() });

	/**
	 * Returns all the email attachments where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @return the matching email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailAttachment> findByEmailReminderId(long emailReminderId)
		throws SystemException {
		return findByEmailReminderId(emailReminderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email attachments where emailReminderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailReminderId the email reminder ID
	 * @param start the lower bound of the range of email attachments
	 * @param end the upper bound of the range of email attachments (not inclusive)
	 * @return the range of matching email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailAttachment> findByEmailReminderId(long emailReminderId,
		int start, int end) throws SystemException {
		return findByEmailReminderId(emailReminderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the email attachments where emailReminderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailReminderId the email reminder ID
	 * @param start the lower bound of the range of email attachments
	 * @param end the upper bound of the range of email attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailAttachment> findByEmailReminderId(long emailReminderId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREMINDERID;
			finderArgs = new Object[] { emailReminderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREMINDERID;
			finderArgs = new Object[] {
					emailReminderId,
					
					start, end, orderByComparator
				};
		}

		List<EmailAttachment> list = (List<EmailAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmailAttachment emailAttachment : list) {
				if ((emailReminderId != emailAttachment.getEmailReminderId())) {
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

			query.append(_SQL_SELECT_EMAILATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_EMAILREMINDERID_EMAILREMINDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmailAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emailReminderId);

				if (!pagination) {
					list = (List<EmailAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmailAttachment>(list);
				}
				else {
					list = (List<EmailAttachment>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first email attachment in the ordered set where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email attachment
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment findByEmailReminderId_First(long emailReminderId,
		OrderByComparator orderByComparator)
		throws NoSuchEmailAttachmentException, SystemException {
		EmailAttachment emailAttachment = fetchByEmailReminderId_First(emailReminderId,
				orderByComparator);

		if (emailAttachment != null) {
			return emailAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailReminderId=");
		msg.append(emailReminderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailAttachmentException(msg.toString());
	}

	/**
	 * Returns the first email attachment in the ordered set where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching email attachment, or <code>null</code> if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment fetchByEmailReminderId_First(long emailReminderId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmailAttachment> list = findByEmailReminderId(emailReminderId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last email attachment in the ordered set where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email attachment
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment findByEmailReminderId_Last(long emailReminderId,
		OrderByComparator orderByComparator)
		throws NoSuchEmailAttachmentException, SystemException {
		EmailAttachment emailAttachment = fetchByEmailReminderId_Last(emailReminderId,
				orderByComparator);

		if (emailAttachment != null) {
			return emailAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailReminderId=");
		msg.append(emailReminderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmailAttachmentException(msg.toString());
	}

	/**
	 * Returns the last email attachment in the ordered set where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching email attachment, or <code>null</code> if a matching email attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment fetchByEmailReminderId_Last(long emailReminderId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmailReminderId(emailReminderId);

		if (count == 0) {
			return null;
		}

		List<EmailAttachment> list = findByEmailReminderId(emailReminderId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the email attachments before and after the current email attachment in the ordered set where emailReminderId = &#63;.
	 *
	 * @param EMAIL_ATTACHMENT_ID the primary key of the current email attachment
	 * @param emailReminderId the email reminder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next email attachment
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment[] findByEmailReminderId_PrevAndNext(
		long EMAIL_ATTACHMENT_ID, long emailReminderId,
		OrderByComparator orderByComparator)
		throws NoSuchEmailAttachmentException, SystemException {
		EmailAttachment emailAttachment = findByPrimaryKey(EMAIL_ATTACHMENT_ID);

		Session session = null;

		try {
			session = openSession();

			EmailAttachment[] array = new EmailAttachmentImpl[3];

			array[0] = getByEmailReminderId_PrevAndNext(session,
					emailAttachment, emailReminderId, orderByComparator, true);

			array[1] = emailAttachment;

			array[2] = getByEmailReminderId_PrevAndNext(session,
					emailAttachment, emailReminderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmailAttachment getByEmailReminderId_PrevAndNext(
		Session session, EmailAttachment emailAttachment, long emailReminderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMAILATTACHMENT_WHERE);

		query.append(_FINDER_COLUMN_EMAILREMINDERID_EMAILREMINDERID_2);

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
			query.append(EmailAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(emailReminderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(emailAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmailAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the email attachments where emailReminderId = &#63; from the database.
	 *
	 * @param emailReminderId the email reminder ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmailReminderId(long emailReminderId)
		throws SystemException {
		for (EmailAttachment emailAttachment : findByEmailReminderId(
				emailReminderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(emailAttachment);
		}
	}

	/**
	 * Returns the number of email attachments where emailReminderId = &#63;.
	 *
	 * @param emailReminderId the email reminder ID
	 * @return the number of matching email attachments
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

			query.append(_SQL_COUNT_EMAILATTACHMENT_WHERE);

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
		"emailAttachment.emailReminderId = ?";

	public EmailAttachmentPersistenceImpl() {
		setModelClass(EmailAttachment.class);
	}

	/**
	 * Caches the email attachment in the entity cache if it is enabled.
	 *
	 * @param emailAttachment the email attachment
	 */
	@Override
	public void cacheResult(EmailAttachment emailAttachment) {
		EntityCacheUtil.putResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentImpl.class, emailAttachment.getPrimaryKey(),
			emailAttachment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
			new Object[] { emailAttachment.getEMAIL_ATTACHMENT_ID() },
			emailAttachment);

		emailAttachment.resetOriginalValues();
	}

	/**
	 * Caches the email attachments in the entity cache if it is enabled.
	 *
	 * @param emailAttachments the email attachments
	 */
	@Override
	public void cacheResult(List<EmailAttachment> emailAttachments) {
		for (EmailAttachment emailAttachment : emailAttachments) {
			if (EntityCacheUtil.getResult(
						EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						EmailAttachmentImpl.class,
						emailAttachment.getPrimaryKey()) == null) {
				cacheResult(emailAttachment);
			}
			else {
				emailAttachment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all email attachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmailAttachmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmailAttachmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email attachment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailAttachment emailAttachment) {
		EntityCacheUtil.removeResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentImpl.class, emailAttachment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(emailAttachment);
	}

	@Override
	public void clearCache(List<EmailAttachment> emailAttachments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmailAttachment emailAttachment : emailAttachments) {
			EntityCacheUtil.removeResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				EmailAttachmentImpl.class, emailAttachment.getPrimaryKey());

			clearUniqueFindersCache(emailAttachment);
		}
	}

	protected void cacheUniqueFindersCache(EmailAttachment emailAttachment) {
		if (emailAttachment.isNew()) {
			Object[] args = new Object[] {
					emailAttachment.getEMAIL_ATTACHMENT_ID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILATTACHMENTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
				args, emailAttachment);
		}
		else {
			EmailAttachmentModelImpl emailAttachmentModelImpl = (EmailAttachmentModelImpl)emailAttachment;

			if ((emailAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILATTACHMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailAttachment.getEMAIL_ATTACHMENT_ID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILATTACHMENTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
					args, emailAttachment);
			}
		}
	}

	protected void clearUniqueFindersCache(EmailAttachment emailAttachment) {
		EmailAttachmentModelImpl emailAttachmentModelImpl = (EmailAttachmentModelImpl)emailAttachment;

		Object[] args = new Object[] { emailAttachment.getEMAIL_ATTACHMENT_ID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILATTACHMENTID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
			args);

		if ((emailAttachmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILATTACHMENTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					emailAttachmentModelImpl.getOriginalEMAIL_ATTACHMENT_ID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILATTACHMENTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILATTACHMENTID,
				args);
		}
	}

	/**
	 * Creates a new email attachment with the primary key. Does not add the email attachment to the database.
	 *
	 * @param EMAIL_ATTACHMENT_ID the primary key for the new email attachment
	 * @return the new email attachment
	 */
	@Override
	public EmailAttachment create(long EMAIL_ATTACHMENT_ID) {
		EmailAttachment emailAttachment = new EmailAttachmentImpl();

		emailAttachment.setNew(true);
		emailAttachment.setPrimaryKey(EMAIL_ATTACHMENT_ID);

		return emailAttachment;
	}

	/**
	 * Removes the email attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	 * @return the email attachment that was removed
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment remove(long EMAIL_ATTACHMENT_ID)
		throws NoSuchEmailAttachmentException, SystemException {
		return remove((Serializable)EMAIL_ATTACHMENT_ID);
	}

	/**
	 * Removes the email attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email attachment
	 * @return the email attachment that was removed
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment remove(Serializable primaryKey)
		throws NoSuchEmailAttachmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmailAttachment emailAttachment = (EmailAttachment)session.get(EmailAttachmentImpl.class,
					primaryKey);

			if (emailAttachment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emailAttachment);
		}
		catch (NoSuchEmailAttachmentException nsee) {
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
	protected EmailAttachment removeImpl(EmailAttachment emailAttachment)
		throws SystemException {
		emailAttachment = toUnwrappedModel(emailAttachment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailAttachment)) {
				emailAttachment = (EmailAttachment)session.get(EmailAttachmentImpl.class,
						emailAttachment.getPrimaryKeyObj());
			}

			if (emailAttachment != null) {
				session.delete(emailAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emailAttachment != null) {
			clearCache(emailAttachment);
		}

		return emailAttachment;
	}

	@Override
	public EmailAttachment updateImpl(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws SystemException {
		emailAttachment = toUnwrappedModel(emailAttachment);

		boolean isNew = emailAttachment.isNew();

		EmailAttachmentModelImpl emailAttachmentModelImpl = (EmailAttachmentModelImpl)emailAttachment;

		Session session = null;

		try {
			session = openSession();

			if (emailAttachment.isNew()) {
				session.save(emailAttachment);

				emailAttachment.setNew(false);
			}
			else {
				session.evict(emailAttachment);
				session.saveOrUpdate(emailAttachment);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmailAttachmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((emailAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREMINDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emailAttachmentModelImpl.getOriginalEmailReminderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILREMINDERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREMINDERID,
					args);

				args = new Object[] {
						emailAttachmentModelImpl.getEmailReminderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILREMINDERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREMINDERID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			EmailAttachmentImpl.class, emailAttachment.getPrimaryKey(),
			emailAttachment);

		clearUniqueFindersCache(emailAttachment);
		cacheUniqueFindersCache(emailAttachment);

		emailAttachment.resetOriginalValues();

		return emailAttachment;
	}

	protected EmailAttachment toUnwrappedModel(EmailAttachment emailAttachment) {
		if (emailAttachment instanceof EmailAttachmentImpl) {
			return emailAttachment;
		}

		EmailAttachmentImpl emailAttachmentImpl = new EmailAttachmentImpl();

		emailAttachmentImpl.setNew(emailAttachment.isNew());
		emailAttachmentImpl.setPrimaryKey(emailAttachment.getPrimaryKey());

		emailAttachmentImpl.setEMAIL_ATTACHMENT_ID(emailAttachment.getEMAIL_ATTACHMENT_ID());
		emailAttachmentImpl.setEmailReminderId(emailAttachment.getEmailReminderId());
		emailAttachmentImpl.setAttachmentFileName(emailAttachment.getAttachmentFileName());
		emailAttachmentImpl.setAttachmentFileText(emailAttachment.getAttachmentFileText());
		emailAttachmentImpl.setCreateUserId(emailAttachment.getCreateUserId());
		emailAttachmentImpl.setCreateTimestamp(emailAttachment.getCreateTimestamp());
		emailAttachmentImpl.setLastUpdateUserId(emailAttachment.getLastUpdateUserId());
		emailAttachmentImpl.setLastUpdateTimestamp(emailAttachment.getLastUpdateTimestamp());

		return emailAttachmentImpl;
	}

	/**
	 * Returns the email attachment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email attachment
	 * @return the email attachment
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailAttachmentException, SystemException {
		EmailAttachment emailAttachment = fetchByPrimaryKey(primaryKey);

		if (emailAttachment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emailAttachment;
	}

	/**
	 * Returns the email attachment with the primary key or throws a {@link com.ihg.me2.NoSuchEmailAttachmentException} if it could not be found.
	 *
	 * @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	 * @return the email attachment
	 * @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment findByPrimaryKey(long EMAIL_ATTACHMENT_ID)
		throws NoSuchEmailAttachmentException, SystemException {
		return findByPrimaryKey((Serializable)EMAIL_ATTACHMENT_ID);
	}

	/**
	 * Returns the email attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email attachment
	 * @return the email attachment, or <code>null</code> if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmailAttachment emailAttachment = (EmailAttachment)EntityCacheUtil.getResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				EmailAttachmentImpl.class, primaryKey);

		if (emailAttachment == _nullEmailAttachment) {
			return null;
		}

		if (emailAttachment == null) {
			Session session = null;

			try {
				session = openSession();

				emailAttachment = (EmailAttachment)session.get(EmailAttachmentImpl.class,
						primaryKey);

				if (emailAttachment != null) {
					cacheResult(emailAttachment);
				}
				else {
					EntityCacheUtil.putResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						EmailAttachmentImpl.class, primaryKey,
						_nullEmailAttachment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmailAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					EmailAttachmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emailAttachment;
	}

	/**
	 * Returns the email attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	 * @return the email attachment, or <code>null</code> if a email attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailAttachment fetchByPrimaryKey(long EMAIL_ATTACHMENT_ID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)EMAIL_ATTACHMENT_ID);
	}

	/**
	 * Returns all the email attachments.
	 *
	 * @return the email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailAttachment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email attachments
	 * @param end the upper bound of the range of email attachments (not inclusive)
	 * @return the range of email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailAttachment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the email attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email attachments
	 * @param end the upper bound of the range of email attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmailAttachment> findAll(int start, int end,
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

		List<EmailAttachment> list = (List<EmailAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMAILATTACHMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILATTACHMENT;

				if (pagination) {
					sql = sql.concat(EmailAttachmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmailAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmailAttachment>(list);
				}
				else {
					list = (List<EmailAttachment>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the email attachments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmailAttachment emailAttachment : findAll()) {
			remove(emailAttachment);
		}
	}

	/**
	 * Returns the number of email attachments.
	 *
	 * @return the number of email attachments
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

				Query q = session.createQuery(_SQL_COUNT_EMAILATTACHMENT);

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
	 * Initializes the email attachment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.me2.model.EmailAttachment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmailAttachment>> listenersList = new ArrayList<ModelListener<EmailAttachment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmailAttachment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmailAttachmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMAILATTACHMENT = "SELECT emailAttachment FROM EmailAttachment emailAttachment";
	private static final String _SQL_SELECT_EMAILATTACHMENT_WHERE = "SELECT emailAttachment FROM EmailAttachment emailAttachment WHERE ";
	private static final String _SQL_COUNT_EMAILATTACHMENT = "SELECT COUNT(emailAttachment) FROM EmailAttachment emailAttachment";
	private static final String _SQL_COUNT_EMAILATTACHMENT_WHERE = "SELECT COUNT(emailAttachment) FROM EmailAttachment emailAttachment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emailAttachment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmailAttachment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmailAttachment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmailAttachmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"emailReminderId", "attachmentFileName", "attachmentFileText",
				"createUserId", "createTimestamp", "lastUpdateUserId",
				"lastUpdateTimestamp"
			});
	private static EmailAttachment _nullEmailAttachment = new EmailAttachmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmailAttachment> toCacheModel() {
				return _nullEmailAttachmentCacheModel;
			}
		};

	private static CacheModel<EmailAttachment> _nullEmailAttachmentCacheModel = new CacheModel<EmailAttachment>() {
			@Override
			public EmailAttachment toEntityModel() {
				return _nullEmailAttachment;
			}
		};
}