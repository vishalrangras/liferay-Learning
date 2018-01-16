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
 * Provides a wrapper for {@link EmailAttachmentLocalService}.
 *
 * @author vishal.rangras
 * @see EmailAttachmentLocalService
 * @generated
 */
public class EmailAttachmentLocalServiceWrapper
	implements EmailAttachmentLocalService,
		ServiceWrapper<EmailAttachmentLocalService> {
	public EmailAttachmentLocalServiceWrapper(
		EmailAttachmentLocalService emailAttachmentLocalService) {
		_emailAttachmentLocalService = emailAttachmentLocalService;
	}

	/**
	* Adds the email attachment to the database. Also notifies the appropriate model listeners.
	*
	* @param emailAttachment the email attachment
	* @return the email attachment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.model.EmailAttachment addEmailAttachment(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.addEmailAttachment(emailAttachment);
	}

	/**
	* Creates a new email attachment with the primary key. Does not add the email attachment to the database.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key for the new email attachment
	* @return the new email attachment
	*/
	@Override
	public com.ihg.me2.model.EmailAttachment createEmailAttachment(
		long EMAIL_ATTACHMENT_ID) {
		return _emailAttachmentLocalService.createEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Deletes the email attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment that was removed
	* @throws PortalException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.model.EmailAttachment deleteEmailAttachment(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.deleteEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Deletes the email attachment from the database. Also notifies the appropriate model listeners.
	*
	* @param emailAttachment the email attachment
	* @return the email attachment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.model.EmailAttachment deleteEmailAttachment(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.deleteEmailAttachment(emailAttachment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailAttachmentLocalService.dynamicQuery();
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
		return _emailAttachmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _emailAttachmentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.me2.model.impl.EmailAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _emailAttachmentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _emailAttachmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _emailAttachmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.me2.model.EmailAttachment fetchEmailAttachment(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.fetchEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the email attachment with the primary key.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment
	* @throws PortalException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.model.EmailAttachment getEmailAttachment(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ihg.me2.model.EmailAttachment> getEmailAttachments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getEmailAttachments(start, end);
	}

	/**
	* Returns the number of email attachments.
	*
	* @return the number of email attachments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmailAttachmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getEmailAttachmentsCount();
	}

	/**
	* Updates the email attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailAttachment the email attachment
	* @return the email attachment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.me2.model.EmailAttachment updateEmailAttachment(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.updateEmailAttachment(emailAttachment);
	}

	@Override
	public com.ihg.me2.model.EmailAttachmentAttachmentFileTextBlobModel getAttachmentFileTextBlobModel(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getAttachmentFileTextBlobModel(primaryKey);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _emailAttachmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_emailAttachmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _emailAttachmentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.me2.model.EmailAttachment getEmailAttachmentById(
		long emailAttachmentId)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getEmailAttachmentById(emailAttachmentId);
	}

	@Override
	public java.util.List<com.ihg.me2.model.EmailAttachment> getEmailAttachmentByReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.getEmailAttachmentByReminderId(emailReminderId);
	}

	@Override
	public com.ihg.me2.model.EmailAttachment addEmailAttachment(
		long emailReminderId, java.lang.String attachmentFileName,
		com.liferay.portal.kernel.dao.jdbc.OutputBlob attachmentFileTxt,
		java.lang.String createUserId, java.util.Date createTimestamp,
		java.lang.String lastUpdateUserId, java.util.Date lastUpdateTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.addEmailAttachment(emailReminderId,
			attachmentFileName, attachmentFileTxt, createUserId,
			createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
	}

	@Override
	public com.ihg.me2.model.EmailAttachment updateEmailAttachment(
		long emailAttachmentId, java.lang.String attachmentFileName,
		com.liferay.portal.kernel.dao.jdbc.OutputBlob attachmentFileTxt,
		java.lang.String lastUpdateUserId, java.util.Date lastUpdateTimestamp)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAttachmentLocalService.updateEmailAttachment(emailAttachmentId,
			attachmentFileName, attachmentFileTxt, lastUpdateUserId,
			lastUpdateTimestamp);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmailAttachmentLocalService getWrappedEmailAttachmentLocalService() {
		return _emailAttachmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmailAttachmentLocalService(
		EmailAttachmentLocalService emailAttachmentLocalService) {
		_emailAttachmentLocalService = emailAttachmentLocalService;
	}

	@Override
	public EmailAttachmentLocalService getWrappedService() {
		return _emailAttachmentLocalService;
	}

	@Override
	public void setWrappedService(
		EmailAttachmentLocalService emailAttachmentLocalService) {
		_emailAttachmentLocalService = emailAttachmentLocalService;
	}

	private EmailAttachmentLocalService _emailAttachmentLocalService;
}