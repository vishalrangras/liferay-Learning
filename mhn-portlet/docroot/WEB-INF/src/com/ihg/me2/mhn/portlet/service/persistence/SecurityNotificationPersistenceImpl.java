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

package com.ihg.me2.mhn.portlet.service.persistence;

import com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException;
import com.ihg.me2.mhn.portlet.model.SecurityNotification;
import com.ihg.me2.mhn.portlet.model.impl.SecurityNotificationImpl;
import com.ihg.me2.mhn.portlet.model.impl.SecurityNotificationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the security notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see SecurityNotificationPersistence
 * @see SecurityNotificationUtil
 * @generated
 */
public class SecurityNotificationPersistenceImpl extends BasePersistenceImpl<SecurityNotification>
	implements SecurityNotificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SecurityNotificationUtil} to access the security notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SecurityNotificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
			SecurityNotificationModelImpl.FINDER_CACHE_ENABLED,
			SecurityNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
			SecurityNotificationModelImpl.FINDER_CACHE_ENABLED,
			SecurityNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
			SecurityNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SecurityNotificationPersistenceImpl() {
		setModelClass(SecurityNotification.class);
	}

	/**
	 * Caches the security notification in the entity cache if it is enabled.
	 *
	 * @param securityNotification the security notification
	 */
	@Override
	public void cacheResult(SecurityNotification securityNotification) {
		EntityCacheUtil.putResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
			SecurityNotificationImpl.class,
			securityNotification.getPrimaryKey(), securityNotification);

		securityNotification.resetOriginalValues();
	}

	/**
	 * Caches the security notifications in the entity cache if it is enabled.
	 *
	 * @param securityNotifications the security notifications
	 */
	@Override
	public void cacheResult(List<SecurityNotification> securityNotifications) {
		for (SecurityNotification securityNotification : securityNotifications) {
			if (EntityCacheUtil.getResult(
						SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
						SecurityNotificationImpl.class,
						securityNotification.getPrimaryKey()) == null) {
				cacheResult(securityNotification);
			}
			else {
				securityNotification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all security notifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SecurityNotificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SecurityNotificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the security notification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SecurityNotification securityNotification) {
		EntityCacheUtil.removeResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
			SecurityNotificationImpl.class, securityNotification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SecurityNotification> securityNotifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SecurityNotification securityNotification : securityNotifications) {
			EntityCacheUtil.removeResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
				SecurityNotificationImpl.class,
				securityNotification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new security notification with the primary key. Does not add the security notification to the database.
	 *
	 * @param notificationId the primary key for the new security notification
	 * @return the new security notification
	 */
	@Override
	public SecurityNotification create(long notificationId) {
		SecurityNotification securityNotification = new SecurityNotificationImpl();

		securityNotification.setNew(true);
		securityNotification.setPrimaryKey(notificationId);

		return securityNotification;
	}

	/**
	 * Removes the security notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationId the primary key of the security notification
	 * @return the security notification that was removed
	 * @throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException if a security notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecurityNotification remove(long notificationId)
		throws NoSuchSecurityNotificationException, SystemException {
		return remove((Serializable)notificationId);
	}

	/**
	 * Removes the security notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the security notification
	 * @return the security notification that was removed
	 * @throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException if a security notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecurityNotification remove(Serializable primaryKey)
		throws NoSuchSecurityNotificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SecurityNotification securityNotification = (SecurityNotification)session.get(SecurityNotificationImpl.class,
					primaryKey);

			if (securityNotification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSecurityNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(securityNotification);
		}
		catch (NoSuchSecurityNotificationException nsee) {
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
	protected SecurityNotification removeImpl(
		SecurityNotification securityNotification) throws SystemException {
		securityNotification = toUnwrappedModel(securityNotification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(securityNotification)) {
				securityNotification = (SecurityNotification)session.get(SecurityNotificationImpl.class,
						securityNotification.getPrimaryKeyObj());
			}

			if (securityNotification != null) {
				session.delete(securityNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (securityNotification != null) {
			clearCache(securityNotification);
		}

		return securityNotification;
	}

	@Override
	public SecurityNotification updateImpl(
		com.ihg.me2.mhn.portlet.model.SecurityNotification securityNotification)
		throws SystemException {
		securityNotification = toUnwrappedModel(securityNotification);

		boolean isNew = securityNotification.isNew();

		Session session = null;

		try {
			session = openSession();

			if (securityNotification.isNew()) {
				session.save(securityNotification);

				securityNotification.setNew(false);
			}
			else {
				session.merge(securityNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
			SecurityNotificationImpl.class,
			securityNotification.getPrimaryKey(), securityNotification);

		return securityNotification;
	}

	protected SecurityNotification toUnwrappedModel(
		SecurityNotification securityNotification) {
		if (securityNotification instanceof SecurityNotificationImpl) {
			return securityNotification;
		}

		SecurityNotificationImpl securityNotificationImpl = new SecurityNotificationImpl();

		securityNotificationImpl.setNew(securityNotification.isNew());
		securityNotificationImpl.setPrimaryKey(securityNotification.getPrimaryKey());

		securityNotificationImpl.setNotificationId(securityNotification.getNotificationId());
		securityNotificationImpl.setGmScreenname(securityNotification.getGmScreenname());
		securityNotificationImpl.setGmName(securityNotification.getGmName());
		securityNotificationImpl.setGmEmail(securityNotification.getGmEmail());
		securityNotificationImpl.setPcScreenname(securityNotification.getPcScreenname());
		securityNotificationImpl.setPcName(securityNotification.getPcName());
		securityNotificationImpl.setPcEmail(securityNotification.getPcEmail());
		securityNotificationImpl.setSecPcScreenname(securityNotification.getSecPcScreenname());
		securityNotificationImpl.setSecPcName(securityNotification.getSecPcName());
		securityNotificationImpl.setSecPcEmail(securityNotification.getSecPcEmail());
		securityNotificationImpl.setFopsScreenname(securityNotification.getFopsScreenname());
		securityNotificationImpl.setFopsName(securityNotification.getFopsName());
		securityNotificationImpl.setFopsEmail(securityNotification.getFopsEmail());
		securityNotificationImpl.setHolidexCode(securityNotification.getHolidexCode());
		securityNotificationImpl.setHotelName(securityNotification.getHotelName());
		securityNotificationImpl.setImpacted(securityNotification.getImpacted());
		securityNotificationImpl.setStartDate(securityNotification.getStartDate());
		securityNotificationImpl.setEndDate(securityNotification.getEndDate());

		return securityNotificationImpl;
	}

	/**
	 * Returns the security notification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the security notification
	 * @return the security notification
	 * @throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException if a security notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecurityNotification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSecurityNotificationException, SystemException {
		SecurityNotification securityNotification = fetchByPrimaryKey(primaryKey);

		if (securityNotification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSecurityNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return securityNotification;
	}

	/**
	 * Returns the security notification with the primary key or throws a {@link com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException} if it could not be found.
	 *
	 * @param notificationId the primary key of the security notification
	 * @return the security notification
	 * @throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException if a security notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecurityNotification findByPrimaryKey(long notificationId)
		throws NoSuchSecurityNotificationException, SystemException {
		return findByPrimaryKey((Serializable)notificationId);
	}

	/**
	 * Returns the security notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the security notification
	 * @return the security notification, or <code>null</code> if a security notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecurityNotification fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SecurityNotification securityNotification = (SecurityNotification)EntityCacheUtil.getResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
				SecurityNotificationImpl.class, primaryKey);

		if (securityNotification == _nullSecurityNotification) {
			return null;
		}

		if (securityNotification == null) {
			Session session = null;

			try {
				session = openSession();

				securityNotification = (SecurityNotification)session.get(SecurityNotificationImpl.class,
						primaryKey);

				if (securityNotification != null) {
					cacheResult(securityNotification);
				}
				else {
					EntityCacheUtil.putResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
						SecurityNotificationImpl.class, primaryKey,
						_nullSecurityNotification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SecurityNotificationModelImpl.ENTITY_CACHE_ENABLED,
					SecurityNotificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return securityNotification;
	}

	/**
	 * Returns the security notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the security notification
	 * @return the security notification, or <code>null</code> if a security notification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecurityNotification fetchByPrimaryKey(long notificationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificationId);
	}

	/**
	 * Returns all the security notifications.
	 *
	 * @return the security notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecurityNotification> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the security notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.mhn.portlet.model.impl.SecurityNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of security notifications
	 * @param end the upper bound of the range of security notifications (not inclusive)
	 * @return the range of security notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecurityNotification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the security notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.mhn.portlet.model.impl.SecurityNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of security notifications
	 * @param end the upper bound of the range of security notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of security notifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecurityNotification> findAll(int start, int end,
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

		List<SecurityNotification> list = (List<SecurityNotification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SECURITYNOTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SECURITYNOTIFICATION;

				if (pagination) {
					sql = sql.concat(SecurityNotificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SecurityNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SecurityNotification>(list);
				}
				else {
					list = (List<SecurityNotification>)QueryUtil.list(q,
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
	 * Removes all the security notifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SecurityNotification securityNotification : findAll()) {
			remove(securityNotification);
		}
	}

	/**
	 * Returns the number of security notifications.
	 *
	 * @return the number of security notifications
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

				Query q = session.createQuery(_SQL_COUNT_SECURITYNOTIFICATION);

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
	 * Initializes the security notification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.me2.mhn.portlet.model.SecurityNotification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SecurityNotification>> listenersList = new ArrayList<ModelListener<SecurityNotification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SecurityNotification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SecurityNotificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SECURITYNOTIFICATION = "SELECT securityNotification FROM SecurityNotification securityNotification";
	private static final String _SQL_COUNT_SECURITYNOTIFICATION = "SELECT COUNT(securityNotification) FROM SecurityNotification securityNotification";
	private static final String _ORDER_BY_ENTITY_ALIAS = "securityNotification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SecurityNotification exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SecurityNotificationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"gmScreenname", "gmName", "gmEmail", "pcScreenname", "pcName",
				"pcEmail", "secPcScreenname", "secPcName", "secPcEmail",
				"fopsScreenname", "fopsName", "fopsEmail", "holidexCode",
				"hotelName", "impacted", "startDate", "endDate"
			});
	private static SecurityNotification _nullSecurityNotification = new SecurityNotificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SecurityNotification> toCacheModel() {
				return _nullSecurityNotificationCacheModel;
			}
		};

	private static CacheModel<SecurityNotification> _nullSecurityNotificationCacheModel =
		new CacheModel<SecurityNotification>() {
			@Override
			public SecurityNotification toEntityModel() {
				return _nullSecurityNotification;
			}
		};
}