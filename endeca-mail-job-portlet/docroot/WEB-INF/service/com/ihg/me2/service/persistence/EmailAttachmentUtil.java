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

import com.ihg.me2.model.EmailAttachment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the email attachment service. This utility wraps {@link EmailAttachmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see EmailAttachmentPersistence
 * @see EmailAttachmentPersistenceImpl
 * @generated
 */
public class EmailAttachmentUtil {
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
	public static void clearCache(EmailAttachment emailAttachment) {
		getPersistence().clearCache(emailAttachment);
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
	public static List<EmailAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmailAttachment update(EmailAttachment emailAttachment)
		throws SystemException {
		return getPersistence().update(emailAttachment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmailAttachment update(EmailAttachment emailAttachment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(emailAttachment, serviceContext);
	}

	/**
	* Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or throws a {@link com.ihg.me2.NoSuchEmailAttachmentException} if it could not be found.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the matching email attachment
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment findByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailAttachmentId(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment fetchByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailAttachmentId(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment fetchByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAttachmentId(EMAIL_ATTACHMENT_ID,
			retrieveFromCache);
	}

	/**
	* Removes the email attachment where EMAIL_ATTACHMENT_ID = &#63; from the database.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the email attachment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment removeByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByEmailAttachmentId(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the number of email attachments where EMAIL_ATTACHMENT_ID = &#63;.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the number of matching email attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAttachmentId(long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAttachmentId(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns all the email attachments where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @return the matching email attachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailAttachment> findByEmailReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailReminderId(emailReminderId);
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
	public static java.util.List<com.ihg.me2.model.EmailAttachment> findByEmailReminderId(
		long emailReminderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailReminderId(emailReminderId, start, end);
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
	public static java.util.List<com.ihg.me2.model.EmailAttachment> findByEmailReminderId(
		long emailReminderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailReminderId(emailReminderId, start, end,
			orderByComparator);
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
	public static com.ihg.me2.model.EmailAttachment findByEmailReminderId_First(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailReminderId_First(emailReminderId,
			orderByComparator);
	}

	/**
	* Returns the first email attachment in the ordered set where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment fetchByEmailReminderId_First(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailReminderId_First(emailReminderId,
			orderByComparator);
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
	public static com.ihg.me2.model.EmailAttachment findByEmailReminderId_Last(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailReminderId_Last(emailReminderId,
			orderByComparator);
	}

	/**
	* Returns the last email attachment in the ordered set where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment fetchByEmailReminderId_Last(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailReminderId_Last(emailReminderId,
			orderByComparator);
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
	public static com.ihg.me2.model.EmailAttachment[] findByEmailReminderId_PrevAndNext(
		long EMAIL_ATTACHMENT_ID, long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailReminderId_PrevAndNext(EMAIL_ATTACHMENT_ID,
			emailReminderId, orderByComparator);
	}

	/**
	* Removes all the email attachments where emailReminderId = &#63; from the database.
	*
	* @param emailReminderId the email reminder ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailReminderId(long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmailReminderId(emailReminderId);
	}

	/**
	* Returns the number of email attachments where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @return the number of matching email attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailReminderId(long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailReminderId(emailReminderId);
	}

	/**
	* Caches the email attachment in the entity cache if it is enabled.
	*
	* @param emailAttachment the email attachment
	*/
	public static void cacheResult(
		com.ihg.me2.model.EmailAttachment emailAttachment) {
		getPersistence().cacheResult(emailAttachment);
	}

	/**
	* Caches the email attachments in the entity cache if it is enabled.
	*
	* @param emailAttachments the email attachments
	*/
	public static void cacheResult(
		java.util.List<com.ihg.me2.model.EmailAttachment> emailAttachments) {
		getPersistence().cacheResult(emailAttachments);
	}

	/**
	* Creates a new email attachment with the primary key. Does not add the email attachment to the database.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key for the new email attachment
	* @return the new email attachment
	*/
	public static com.ihg.me2.model.EmailAttachment create(
		long EMAIL_ATTACHMENT_ID) {
		return getPersistence().create(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Removes the email attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment that was removed
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment remove(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(EMAIL_ATTACHMENT_ID);
	}

	public static com.ihg.me2.model.EmailAttachment updateImpl(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(emailAttachment);
	}

	/**
	* Returns the email attachment with the primary key or throws a {@link com.ihg.me2.NoSuchEmailAttachmentException} if it could not be found.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment findByPrimaryKey(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the email attachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment, or <code>null</code> if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.me2.model.EmailAttachment fetchByPrimaryKey(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns all the email attachments.
	*
	* @return the email attachments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.me2.model.EmailAttachment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.me2.model.EmailAttachment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.ihg.me2.model.EmailAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the email attachments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of email attachments.
	*
	* @return the number of email attachments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmailAttachmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmailAttachmentPersistence)PortletBeanLocatorUtil.locate(com.ihg.me2.service.ClpSerializer.getServletContextName(),
					EmailAttachmentPersistence.class.getName());

			ReferenceRegistry.registerReference(EmailAttachmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmailAttachmentPersistence persistence) {
	}

	private static EmailAttachmentPersistence _persistence;
}