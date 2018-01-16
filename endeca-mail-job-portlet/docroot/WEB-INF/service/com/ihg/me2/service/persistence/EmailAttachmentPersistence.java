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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the email attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see EmailAttachmentPersistenceImpl
 * @see EmailAttachmentUtil
 * @generated
 */
public interface EmailAttachmentPersistence extends BasePersistence<EmailAttachment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailAttachmentUtil} to access the email attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or throws a {@link com.ihg.me2.NoSuchEmailAttachmentException} if it could not be found.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the matching email attachment
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment findByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment fetchByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email attachment where EMAIL_ATTACHMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment fetchByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the email attachment where EMAIL_ATTACHMENT_ID = &#63; from the database.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the email attachment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment removeByEmailAttachmentId(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email attachments where EMAIL_ATTACHMENT_ID = &#63;.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d
	* @return the number of matching email attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAttachmentId(long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the email attachments where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @return the matching email attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.me2.model.EmailAttachment> findByEmailReminderId(
		long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailAttachment> findByEmailReminderId(
		long emailReminderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailAttachment> findByEmailReminderId(
		long emailReminderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first email attachment in the ordered set where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email attachment
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment findByEmailReminderId_First(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first email attachment in the ordered set where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment fetchByEmailReminderId_First(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last email attachment in the ordered set where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email attachment
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment findByEmailReminderId_Last(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last email attachment in the ordered set where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email attachment, or <code>null</code> if a matching email attachment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment fetchByEmailReminderId_Last(
		long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.me2.model.EmailAttachment[] findByEmailReminderId_PrevAndNext(
		long EMAIL_ATTACHMENT_ID, long emailReminderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the email attachments where emailReminderId = &#63; from the database.
	*
	* @param emailReminderId the email reminder ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailReminderId(long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email attachments where emailReminderId = &#63;.
	*
	* @param emailReminderId the email reminder ID
	* @return the number of matching email attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailReminderId(long emailReminderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the email attachment in the entity cache if it is enabled.
	*
	* @param emailAttachment the email attachment
	*/
	public void cacheResult(com.ihg.me2.model.EmailAttachment emailAttachment);

	/**
	* Caches the email attachments in the entity cache if it is enabled.
	*
	* @param emailAttachments the email attachments
	*/
	public void cacheResult(
		java.util.List<com.ihg.me2.model.EmailAttachment> emailAttachments);

	/**
	* Creates a new email attachment with the primary key. Does not add the email attachment to the database.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key for the new email attachment
	* @return the new email attachment
	*/
	public com.ihg.me2.model.EmailAttachment create(long EMAIL_ATTACHMENT_ID);

	/**
	* Removes the email attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment that was removed
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment remove(long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.me2.model.EmailAttachment updateImpl(
		com.ihg.me2.model.EmailAttachment emailAttachment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email attachment with the primary key or throws a {@link com.ihg.me2.NoSuchEmailAttachmentException} if it could not be found.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment
	* @throws com.ihg.me2.NoSuchEmailAttachmentException if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment findByPrimaryKey(
		long EMAIL_ATTACHMENT_ID)
		throws com.ihg.me2.NoSuchEmailAttachmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email attachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param EMAIL_ATTACHMENT_ID the primary key of the email attachment
	* @return the email attachment, or <code>null</code> if a email attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.me2.model.EmailAttachment fetchByPrimaryKey(
		long EMAIL_ATTACHMENT_ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the email attachments.
	*
	* @return the email attachments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.me2.model.EmailAttachment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailAttachment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.me2.model.EmailAttachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the email attachments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email attachments.
	*
	* @return the number of email attachments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}