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

package com.ihg.me2.mhn.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SecurityNotificationLocalService}.
 *
 * @author vishal.rangras
 * @see SecurityNotificationLocalService
 * @generated
 */
public class SecurityNotificationLocalServiceWrapper
	implements SecurityNotificationLocalService,
		ServiceWrapper<SecurityNotificationLocalService> {
	public SecurityNotificationLocalServiceWrapper(
		SecurityNotificationLocalService securityNotificationLocalService) {
		_securityNotificationLocalService = securityNotificationLocalService;
	}

	/**
	* Adds the security notification to the database. Also notifies the appropriate model listeners.
	*
	* @param securityNotification the security notification
	* @return the security notification that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification addSecurityNotification(
		com.ihg.me2.mhn.portlet.model.SecurityNotification securityNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.addSecurityNotification(securityNotification);
	}

	/**
	* Creates a new security notification with the primary key. Does not add the security notification to the database.
	*
	* @param notificationId the primary key for the new security notification
	* @return the new security notification
	*/
	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification createSecurityNotification(
		long notificationId) {
		return _securityNotificationLocalService.createSecurityNotification(notificationId);
	}

	/**
	* Deletes the security notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the security notification
	* @return the security notification that was removed
	* @throws PortalException if a security notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification deleteSecurityNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.deleteSecurityNotification(notificationId);
	}

	/**
	* Deletes the security notification from the database. Also notifies the appropriate model listeners.
	*
	* @param securityNotification the security notification
	* @return the security notification that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification deleteSecurityNotification(
		com.ihg.me2.mhn.portlet.model.SecurityNotification securityNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.deleteSecurityNotification(securityNotification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _securityNotificationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.mhn.portlet.model.impl.SecurityNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.mhn.portlet.model.impl.SecurityNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification fetchSecurityNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.fetchSecurityNotification(notificationId);
	}

	/**
	* Returns the security notification with the primary key.
	*
	* @param notificationId the primary key of the security notification
	* @return the security notification
	* @throws PortalException if a security notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification getSecurityNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.getSecurityNotification(notificationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ihg.me2.mhn.portlet.model.SecurityNotification> getSecurityNotifications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.getSecurityNotifications(start,
			end);
	}

	/**
	* Returns the number of security notifications.
	*
	* @return the number of security notifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSecurityNotificationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.getSecurityNotificationsCount();
	}

	/**
	* Updates the security notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param securityNotification the security notification
	* @return the security notification that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.mhn.portlet.model.SecurityNotification updateSecurityNotification(
		com.ihg.me2.mhn.portlet.model.SecurityNotification securityNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _securityNotificationLocalService.updateSecurityNotification(securityNotification);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _securityNotificationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_securityNotificationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _securityNotificationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SecurityNotificationLocalService getWrappedSecurityNotificationLocalService() {
		return _securityNotificationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSecurityNotificationLocalService(
		SecurityNotificationLocalService securityNotificationLocalService) {
		_securityNotificationLocalService = securityNotificationLocalService;
	}

	@Override
	public SecurityNotificationLocalService getWrappedService() {
		return _securityNotificationLocalService;
	}

	@Override
	public void setWrappedService(
		SecurityNotificationLocalService securityNotificationLocalService) {
		_securityNotificationLocalService = securityNotificationLocalService;
	}

	private SecurityNotificationLocalService _securityNotificationLocalService;
}