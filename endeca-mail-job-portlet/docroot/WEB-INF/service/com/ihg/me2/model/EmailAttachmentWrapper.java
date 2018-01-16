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

package com.ihg.me2.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmailAttachment}.
 * </p>
 *
 * @author vishal.rangras
 * @see EmailAttachment
 * @generated
 */
public class EmailAttachmentWrapper implements EmailAttachment,
	ModelWrapper<EmailAttachment> {
	public EmailAttachmentWrapper(EmailAttachment emailAttachment) {
		_emailAttachment = emailAttachment;
	}

	@Override
	public Class<?> getModelClass() {
		return EmailAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return EmailAttachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("EMAIL_ATTACHMENT_ID", getEMAIL_ATTACHMENT_ID());
		attributes.put("emailReminderId", getEmailReminderId());
		attributes.put("attachmentFileName", getAttachmentFileName());
		attributes.put("attachmentFileText", getAttachmentFileText());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createTimestamp", getCreateTimestamp());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("lastUpdateTimestamp", getLastUpdateTimestamp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long EMAIL_ATTACHMENT_ID = (Long)attributes.get("EMAIL_ATTACHMENT_ID");

		if (EMAIL_ATTACHMENT_ID != null) {
			setEMAIL_ATTACHMENT_ID(EMAIL_ATTACHMENT_ID);
		}

		Long emailReminderId = (Long)attributes.get("emailReminderId");

		if (emailReminderId != null) {
			setEmailReminderId(emailReminderId);
		}

		String attachmentFileName = (String)attributes.get("attachmentFileName");

		if (attachmentFileName != null) {
			setAttachmentFileName(attachmentFileName);
		}

		Blob attachmentFileText = (Blob)attributes.get("attachmentFileText");

		if (attachmentFileText != null) {
			setAttachmentFileText(attachmentFileText);
		}

		String createUserId = (String)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date createTimestamp = (Date)attributes.get("createTimestamp");

		if (createTimestamp != null) {
			setCreateTimestamp(createTimestamp);
		}

		String lastUpdateUserId = (String)attributes.get("lastUpdateUserId");

		if (lastUpdateUserId != null) {
			setLastUpdateUserId(lastUpdateUserId);
		}

		Date lastUpdateTimestamp = (Date)attributes.get("lastUpdateTimestamp");

		if (lastUpdateTimestamp != null) {
			setLastUpdateTimestamp(lastUpdateTimestamp);
		}
	}

	/**
	* Returns the primary key of this email attachment.
	*
	* @return the primary key of this email attachment
	*/
	@Override
	public long getPrimaryKey() {
		return _emailAttachment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this email attachment.
	*
	* @param primaryKey the primary key of this email attachment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emailAttachment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the e m a i l_ a t t a c h m e n t_ i d of this email attachment.
	*
	* @return the e m a i l_ a t t a c h m e n t_ i d of this email attachment
	*/
	@Override
	public long getEMAIL_ATTACHMENT_ID() {
		return _emailAttachment.getEMAIL_ATTACHMENT_ID();
	}

	/**
	* Sets the e m a i l_ a t t a c h m e n t_ i d of this email attachment.
	*
	* @param EMAIL_ATTACHMENT_ID the e m a i l_ a t t a c h m e n t_ i d of this email attachment
	*/
	@Override
	public void setEMAIL_ATTACHMENT_ID(long EMAIL_ATTACHMENT_ID) {
		_emailAttachment.setEMAIL_ATTACHMENT_ID(EMAIL_ATTACHMENT_ID);
	}

	/**
	* Returns the email reminder ID of this email attachment.
	*
	* @return the email reminder ID of this email attachment
	*/
	@Override
	public long getEmailReminderId() {
		return _emailAttachment.getEmailReminderId();
	}

	/**
	* Sets the email reminder ID of this email attachment.
	*
	* @param emailReminderId the email reminder ID of this email attachment
	*/
	@Override
	public void setEmailReminderId(long emailReminderId) {
		_emailAttachment.setEmailReminderId(emailReminderId);
	}

	/**
	* Returns the attachment file name of this email attachment.
	*
	* @return the attachment file name of this email attachment
	*/
	@Override
	public java.lang.String getAttachmentFileName() {
		return _emailAttachment.getAttachmentFileName();
	}

	/**
	* Sets the attachment file name of this email attachment.
	*
	* @param attachmentFileName the attachment file name of this email attachment
	*/
	@Override
	public void setAttachmentFileName(java.lang.String attachmentFileName) {
		_emailAttachment.setAttachmentFileName(attachmentFileName);
	}

	/**
	* Returns the attachment file text of this email attachment.
	*
	* @return the attachment file text of this email attachment
	*/
	@Override
	public java.sql.Blob getAttachmentFileText() {
		return _emailAttachment.getAttachmentFileText();
	}

	/**
	* Sets the attachment file text of this email attachment.
	*
	* @param attachmentFileText the attachment file text of this email attachment
	*/
	@Override
	public void setAttachmentFileText(java.sql.Blob attachmentFileText) {
		_emailAttachment.setAttachmentFileText(attachmentFileText);
	}

	/**
	* Returns the create user ID of this email attachment.
	*
	* @return the create user ID of this email attachment
	*/
	@Override
	public java.lang.String getCreateUserId() {
		return _emailAttachment.getCreateUserId();
	}

	/**
	* Sets the create user ID of this email attachment.
	*
	* @param createUserId the create user ID of this email attachment
	*/
	@Override
	public void setCreateUserId(java.lang.String createUserId) {
		_emailAttachment.setCreateUserId(createUserId);
	}

	/**
	* Returns the create timestamp of this email attachment.
	*
	* @return the create timestamp of this email attachment
	*/
	@Override
	public java.util.Date getCreateTimestamp() {
		return _emailAttachment.getCreateTimestamp();
	}

	/**
	* Sets the create timestamp of this email attachment.
	*
	* @param createTimestamp the create timestamp of this email attachment
	*/
	@Override
	public void setCreateTimestamp(java.util.Date createTimestamp) {
		_emailAttachment.setCreateTimestamp(createTimestamp);
	}

	/**
	* Returns the last update user ID of this email attachment.
	*
	* @return the last update user ID of this email attachment
	*/
	@Override
	public java.lang.String getLastUpdateUserId() {
		return _emailAttachment.getLastUpdateUserId();
	}

	/**
	* Sets the last update user ID of this email attachment.
	*
	* @param lastUpdateUserId the last update user ID of this email attachment
	*/
	@Override
	public void setLastUpdateUserId(java.lang.String lastUpdateUserId) {
		_emailAttachment.setLastUpdateUserId(lastUpdateUserId);
	}

	/**
	* Returns the last update timestamp of this email attachment.
	*
	* @return the last update timestamp of this email attachment
	*/
	@Override
	public java.util.Date getLastUpdateTimestamp() {
		return _emailAttachment.getLastUpdateTimestamp();
	}

	/**
	* Sets the last update timestamp of this email attachment.
	*
	* @param lastUpdateTimestamp the last update timestamp of this email attachment
	*/
	@Override
	public void setLastUpdateTimestamp(java.util.Date lastUpdateTimestamp) {
		_emailAttachment.setLastUpdateTimestamp(lastUpdateTimestamp);
	}

	@Override
	public boolean isNew() {
		return _emailAttachment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_emailAttachment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _emailAttachment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emailAttachment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _emailAttachment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _emailAttachment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_emailAttachment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _emailAttachment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_emailAttachment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_emailAttachment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_emailAttachment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmailAttachmentWrapper((EmailAttachment)_emailAttachment.clone());
	}

	@Override
	public int compareTo(com.ihg.me2.model.EmailAttachment emailAttachment) {
		return _emailAttachment.compareTo(emailAttachment);
	}

	@Override
	public int hashCode() {
		return _emailAttachment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.me2.model.EmailAttachment> toCacheModel() {
		return _emailAttachment.toCacheModel();
	}

	@Override
	public com.ihg.me2.model.EmailAttachment toEscapedModel() {
		return new EmailAttachmentWrapper(_emailAttachment.toEscapedModel());
	}

	@Override
	public com.ihg.me2.model.EmailAttachment toUnescapedModel() {
		return new EmailAttachmentWrapper(_emailAttachment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _emailAttachment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _emailAttachment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_emailAttachment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailAttachmentWrapper)) {
			return false;
		}

		EmailAttachmentWrapper emailAttachmentWrapper = (EmailAttachmentWrapper)obj;

		if (Validator.equals(_emailAttachment,
					emailAttachmentWrapper._emailAttachment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmailAttachment getWrappedEmailAttachment() {
		return _emailAttachment;
	}

	@Override
	public EmailAttachment getWrappedModel() {
		return _emailAttachment;
	}

	@Override
	public void resetOriginalValues() {
		_emailAttachment.resetOriginalValues();
	}

	private EmailAttachment _emailAttachment;
}