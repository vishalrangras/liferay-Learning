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
 * Provides the remote service utility for EmailAttachment. This utility wraps
 * {@link com.ihg.me2.service.impl.EmailAttachmentServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author vishal.rangras
 * @see EmailAttachmentService
 * @see com.ihg.me2.service.base.EmailAttachmentServiceBaseImpl
 * @see com.ihg.me2.service.impl.EmailAttachmentServiceImpl
 * @generated
 */
public class EmailAttachmentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.me2.service.impl.EmailAttachmentServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.ihg.me2.model.EmailAttachment getEmailAttachmentById(
		long emailAttachmentId)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAttachmentById(emailAttachmentId);
	}

	public static java.util.List<com.ihg.me2.model.EmailAttachment> getEmailAttachmentByReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAttachmentByReminderId(emailReminderId);
	}

	public static java.lang.String getEmailAttachmentFileById(
		long emailAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAttachmentFileById(emailAttachmentId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmailAttachmentService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmailAttachmentService.class.getName());

			if (invokableService instanceof EmailAttachmentService) {
				_service = (EmailAttachmentService)invokableService;
			}
			else {
				_service = new EmailAttachmentServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EmailAttachmentServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmailAttachmentService service) {
	}

	private static EmailAttachmentService _service;
}