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

import com.ihg.me2.mhn.portlet.model.SecurityNotification;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the security notification service. This utility wraps {@link SecurityNotificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see SecurityNotificationPersistence
 * @see SecurityNotificationPersistenceImpl
 * @generated
 */
public class SecurityNotificationUtil {
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
	public static void clearCache(SecurityNotification securityNotification) {
		getPersistence().clearCache(securityNotification);
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
	public static List<SecurityNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SecurityNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SecurityNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SecurityNotification update(
		SecurityNotification securityNotification) throws SystemException {
		return getPersistence().update(securityNotification);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SecurityNotification update(
		SecurityNotification securityNotification, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(securityNotification, serviceContext);
	}

	/**
	* Caches the security notification in the entity cache if it is enabled.
	*
	* @param securityNotification the security notification
	*/
	public static void cacheResult(
		com.ihg.me2.mhn.portlet.model.SecurityNotification securityNotification) {
		getPersistence().cacheResult(securityNotification);
	}

	/**
	* Caches the security notifications in the entity cache if it is enabled.
	*
	* @param securityNotifications the security notifications
	*/
	public static void cacheResult(
		java.util.List<com.ihg.me2.mhn.portlet.model.SecurityNotification> securityNotifications) {
		getPersistence().cacheResult(securityNotifications);
	}

	/**
	* Creates a new security notification with the primary key. Does not add the security notification to the database.
	*
	* @param notificationId the primary key for the new security notification
	* @return the new security notification
	*/
	public static com.ihg.me2.mhn.portlet.model.SecurityNotification create(
		long notificationId) {
		return getPersistence().create(notificationId);
	}

	/**
	* Removes the security notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the security notification
	* @return the security notification that was removed
	* @throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException if a security notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.mhn.portlet.model.SecurityNotification remove(
		long notificationId)
		throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(notificationId);
	}

	public static com.ihg.me2.mhn.portlet.model.SecurityNotification updateImpl(
		com.ihg.me2.mhn.portlet.model.SecurityNotification securityNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(securityNotification);
	}

	/**
	* Returns the security notification with the primary key or throws a {@link com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException} if it could not be found.
	*
	* @param notificationId the primary key of the security notification
	* @return the security notification
	* @throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException if a security notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.mhn.portlet.model.SecurityNotification findByPrimaryKey(
		long notificationId)
		throws com.ihg.me2.mhn.portlet.NoSuchSecurityNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(notificationId);
	}

	/**
	* Returns the security notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationId the primary key of the security notification
	* @return the security notification, or <code>null</code> if a security notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.mhn.portlet.model.SecurityNotification fetchByPrimaryKey(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(notificationId);
	}

	/**
	* Returns all the security notifications.
	*
	* @return the security notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.mhn.portlet.model.SecurityNotification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.me2.mhn.portlet.model.SecurityNotification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.ihg.me2.mhn.portlet.model.SecurityNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the security notifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of security notifications.
	*
	* @return the number of security notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SecurityNotificationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SecurityNotificationPersistence)PortletBeanLocatorUtil.locate(com.ihg.me2.mhn.portlet.service.ClpSerializer.getServletContextName(),
					SecurityNotificationPersistence.class.getName());

			ReferenceRegistry.registerReference(SecurityNotificationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SecurityNotificationPersistence persistence) {
	}

	private static SecurityNotificationPersistence _persistence;
}