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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailAttachmentService}.
 *
 * @author vishal.rangras
 * @see EmailAttachmentService
 * @generated
 */
public class EmailAttachmentServiceWrapper implements EmailAttachmentService,
	ServiceWrapper<EmailAttachmentService> {
	public EmailAttachmentServiceWrapper(
		EmailAttachmentService emailAttachmentService) {
		_emailAttachmentService = emailAttachmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _emailAttachmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_emailAttachmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _emailAttachmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.me2.model.EmailAttachment getEmailAttachmentById(
		long emailAttachmentId)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentService.getEmailAttachmentById(emailAttachmentId);
	}

	@Override
	public java.util.List<com.ihg.me2.model.EmailAttachment> getEmailAttachmentByReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentService.getEmailAttachmentByReminderId(emailReminderId);
	}

	@Override
	public java.lang.String getEmailAttachmentFileById(long emailAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentService.getEmailAttachmentFileById(emailAttachmentId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmailAttachmentService getWrappedEmailAttachmentService() {
		return _emailAttachmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmailAttachmentService(
		EmailAttachmentService emailAttachmentService) {
		_emailAttachmentService = emailAttachmentService;
	}

	@Override
	public EmailAttachmentService getWrappedService() {
		return _emailAttachmentService;
	}

	@Override
	public void setWrappedService(EmailAttachmentService emailAttachmentService) {
		_emailAttachmentService = emailAttachmentService;
	}

	private EmailAttachmentService _emailAttachmentService;
}