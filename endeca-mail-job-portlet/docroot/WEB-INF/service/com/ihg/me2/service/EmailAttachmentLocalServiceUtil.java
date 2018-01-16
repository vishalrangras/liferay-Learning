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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EmailAttachment. This utility wraps
 * {@link com.ihg.me2.service.impl.EmailAttachmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author vishal.rangras
 * @see EmailAttachmentLocalService
 * @see com.ihg.me2.service.base.EmailAttachmentLocalServiceBaseImpl
 * @see com.ihg.me2.service.impl.EmailAttachmentLocalServiceImpl
 * @generated
 */
public class EmailAttachmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.me2.service.impl.EmailAttachmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the email attachment to the database. Also notifies the appropriate model listeners.
	*
	* @param emailAttachment the email attachment
	* @return the email attachment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment addEmailAttachment(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmailAttachment(emailAttachment);
	}

	/**
	* Creates a new email attachment with the primary key. Does not add the email attachment to the database.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key for the new email attachment
	* @return the new email attachment
	*/
	public static com.ihg.me2.model.EmailAttachment createEmailAttachment(
		long EMAIL_ATTACHMENT_ID) {
		return getService().createEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Deletes the email attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment that was removed
	* @throws PortalException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment deleteEmailAttachment(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Deletes the email attachment from the database. Also notifies the appropriate model listeners.
	*
	* @param emailAttachment the email attachment
	* @return the email attachment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment deleteEmailAttachment(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmailAttachment(emailAttachment);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.me2.model.EmailAttachment fetchEmailAttachment(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the email attachment with the primary key.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment
	* @throws PortalException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment getEmailAttachment(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAttachment(EMAIL_ATTACHMENT_ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.me2.model.EmailAttachment> getEmailAttachments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAttachments(start, end);
	}

	/**
	* Returns the number of email attachments.
	*
	* @return the number of email attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmailAttachmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAttachmentsCount();
	}

	/**
	* Updates the email attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailAttachment the email attachment
	* @return the email attachment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment updateEmailAttachment(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmailAttachment(emailAttachment);
	}

	public static com.ihg.me2.model.EmailAttachmentAttachmentFileTextBlobModel getAttachmentFileTextBlobModel(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentFileTextBlobModel(primaryKey);
	}

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

	public static com.ihg.me2.model.EmailAttachment addEmailAttachment(
		long emailReminderId, java.lang.String attachmentFileName,
		com.liferay.portal.kernel.dao.jdbc.OutputBlob attachmentFileTxt,
		java.lang.String createUserId, java.util.Date createTimestamp,
		java.lang.String lastUpdateUserId, java.util.Date lastUpdateTimestamp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmailAttachment(emailReminderId, attachmentFileName,
			attachmentFileTxt, createUserId, createTimestamp, lastUpdateUserId,
			lastUpdateTimestamp);
	}

	public static com.ihg.me2.model.EmailAttachment updateEmailAttachment(
		long emailAttachmentId, java.lang.String attachmentFileName,
		com.liferay.portal.kernel.dao.jdbc.OutputBlob attachmentFileTxt,
		java.lang.String lastUpdateUserId, java.util.Date lastUpdateTimestamp)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmailAttachment(emailAttachmentId,
			attachmentFileName, attachmentFileTxt, lastUpdateUserId,
			lastUpdateTimestamp);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmailAttachmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmailAttachmentLocalService.class.getName());

			if (invokableLocalService instanceof EmailAttachmentLocalService) {
				_service = (EmailAttachmentLocalService)invokableLocalService;
			}
			else {
				_service = new EmailAttachmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmailAttachmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmailAttachmentLocalService service) {
	}

	private static EmailAttachmentLocalService _service;
}