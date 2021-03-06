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

package com.ihg.me2.service.base;

import com.ihg.me2.model.EmailReminder;
import com.ihg.me2.service.EmailReminderService;
import com.ihg.me2.service.persistence.EmailAttachmentPersistence;
import com.ihg.me2.service.persistence.EmailReminderPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the email reminder remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ihg.me2.service.impl.EmailReminderServiceImpl}.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.impl.EmailReminderServiceImpl
 * @see com.ihg.me2.service.EmailReminderServiceUtil
 * @generated
 */
public abstract class EmailReminderServiceBaseImpl extends BaseServiceImpl
	implements EmailReminderService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.ihg.me2.service.EmailReminderServiceUtil} to access the email reminder remote service.
	 */

	/**
	 * Returns the email attachment local service.
	 *
	 * @return the email attachment local service
	 */
	public com.ihg.me2.service.EmailAttachmentLocalService getEmailAttachmentLocalService() {
		return emailAttachmentLocalService;
	}

	/**
	 * Sets the email attachment local service.
	 *
	 * @param emailAttachmentLocalService the email attachment local service
	 */
	public void setEmailAttachmentLocalService(
		com.ihg.me2.service.EmailAttachmentLocalService emailAttachmentLocalService) {
		this.emailAttachmentLocalService = emailAttachmentLocalService;
	}

	/**
	 * Returns the email attachment remote service.
	 *
	 * @return the email attachment remote service
	 */
	public com.ihg.me2.service.EmailAttachmentService getEmailAttachmentService() {
		return emailAttachmentService;
	}

	/**
	 * Sets the email attachment remote service.
	 *
	 * @param emailAttachmentService the email attachment remote service
	 */
	public void setEmailAttachmentService(
		com.ihg.me2.service.EmailAttachmentService emailAttachmentService) {
		this.emailAttachmentService = emailAttachmentService;
	}

	/**
	 * Returns the email attachment persistence.
	 *
	 * @return the email attachment persistence
	 */
	public EmailAttachmentPersistence getEmailAttachmentPersistence() {
		return emailAttachmentPersistence;
	}

	/**
	 * Sets the email attachment persistence.
	 *
	 * @param emailAttachmentPersistence the email attachment persistence
	 */
	public void setEmailAttachmentPersistence(
		EmailAttachmentPersistence emailAttachmentPersistence) {
		this.emailAttachmentPersistence = emailAttachmentPersistence;
	}

	/**
	 * Returns the email reminder local service.
	 *
	 * @return the email reminder local service
	 */
	public com.ihg.me2.service.EmailReminderLocalService getEmailReminderLocalService() {
		return emailReminderLocalService;
	}

	/**
	 * Sets the email reminder local service.
	 *
	 * @param emailReminderLocalService the email reminder local service
	 */
	public void setEmailReminderLocalService(
		com.ihg.me2.service.EmailReminderLocalService emailReminderLocalService) {
		this.emailReminderLocalService = emailReminderLocalService;
	}

	/**
	 * Returns the email reminder remote service.
	 *
	 * @return the email reminder remote service
	 */
	public com.ihg.me2.service.EmailReminderService getEmailReminderService() {
		return emailReminderService;
	}

	/**
	 * Sets the email reminder remote service.
	 *
	 * @param emailReminderService the email reminder remote service
	 */
	public void setEmailReminderService(
		com.ihg.me2.service.EmailReminderService emailReminderService) {
		this.emailReminderService = emailReminderService;
	}

	/**
	 * Returns the email reminder persistence.
	 *
	 * @return the email reminder persistence
	 */
	public EmailReminderPersistence getEmailReminderPersistence() {
		return emailReminderPersistence;
	}

	/**
	 * Sets the email reminder persistence.
	 *
	 * @param emailReminderPersistence the email reminder persistence
	 */
	public void setEmailReminderPersistence(
		EmailReminderPersistence emailReminderPersistence) {
		this.emailReminderPersistence = emailReminderPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return EmailReminder.class;
	}

	protected String getModelClassName() {
		return EmailReminder.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = emailReminderPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.ihg.me2.service.EmailAttachmentLocalService.class)
	protected com.ihg.me2.service.EmailAttachmentLocalService emailAttachmentLocalService;
	@BeanReference(type = com.ihg.me2.service.EmailAttachmentService.class)
	protected com.ihg.me2.service.EmailAttachmentService emailAttachmentService;
	@BeanReference(type = EmailAttachmentPersistence.class)
	protected EmailAttachmentPersistence emailAttachmentPersistence;
	@BeanReference(type = com.ihg.me2.service.EmailReminderLocalService.class)
	protected com.ihg.me2.service.EmailReminderLocalService emailReminderLocalService;
	@BeanReference(type = com.ihg.me2.service.EmailReminderService.class)
	protected com.ihg.me2.service.EmailReminderService emailReminderService;
	@BeanReference(type = EmailReminderPersistence.class)
	protected EmailReminderPersistence emailReminderPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private EmailReminderServiceClpInvoker _clpInvoker = new EmailReminderServiceClpInvoker();
}