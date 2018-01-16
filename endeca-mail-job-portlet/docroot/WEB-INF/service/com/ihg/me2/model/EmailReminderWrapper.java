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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmailReminder}.
 * </p>
 *
 * @author vishal.rangras
 * @see EmailReminder
 * @generated
 */
public class EmailReminderWrapper implements EmailReminder,
	ModelWrapper<EmailReminder> {
	public EmailReminderWrapper(EmailReminder emailReminder) {
		_emailReminder = emailReminder;
	}

	@Override
	public Class<?> getModelClass() {
		return EmailReminder.class;
	}

	@Override
	public String getModelClassName() {
		return EmailReminder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emailReminderId", getEmailReminderId());
		attributes.put("submitterName", getSubmitterName());
		attributes.put("submitterEmailId", getSubmitterEmailId());
		attributes.put("reminderNumber", getReminderNumber());
		attributes.put("scheduleTimestamp", getScheduleTimestamp());
		attributes.put("emailSubjectText", getEmailSubjectText());
		attributes.put("emailBodyText", getEmailBodyText());
		attributes.put("statusCode", getStatusCode());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createTimestamp", getCreateTimestamp());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("lastUpdateTimestamp", getLastUpdateTimestamp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emailReminderId = (Long)attributes.get("emailReminderId");

		if (emailReminderId != null) {
			setEmailReminderId(emailReminderId);
		}

		String submitterName = (String)attributes.get("submitterName");

		if (submitterName != null) {
			setSubmitterName(submitterName);
		}

		String submitterEmailId = (String)attributes.get("submitterEmailId");

		if (submitterEmailId != null) {
			setSubmitterEmailId(submitterEmailId);
		}

		Integer reminderNumber = (Integer)attributes.get("reminderNumber");

		if (reminderNumber != null) {
			setReminderNumber(reminderNumber);
		}

		Date scheduleTimestamp = (Date)attributes.get("scheduleTimestamp");

		if (scheduleTimestamp != null) {
			setScheduleTimestamp(scheduleTimestamp);
		}

		String emailSubjectText = (String)attributes.get("emailSubjectText");

		if (emailSubjectText != null) {
			setEmailSubjectText(emailSubjectText);
		}

		String emailBodyText = (String)attributes.get("emailBodyText");

		if (emailBodyText != null) {
			setEmailBodyText(emailBodyText);
		}

		String statusCode = (String)attributes.get("statusCode");

		if (statusCode != null) {
			setStatusCode(statusCode);
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
	* Returns the primary key of this email reminder.
	*
	* @return the primary key of this email reminder
	*/
	@Override
	public long getPrimaryKey() {
		return _emailReminder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this email reminder.
	*
	* @param primaryKey the primary key of this email reminder
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emailReminder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the email reminder ID of this email reminder.
	*
	* @return the email reminder ID of this email reminder
	*/
	@Override
	public long getEmailReminderId() {
		return _emailReminder.getEmailReminderId();
	}

	/**
	* Sets the email reminder ID of this email reminder.
	*
	* @param emailReminderId the email reminder ID of this email reminder
	*/
	@Override
	public void setEmailReminderId(long emailReminderId) {
		_emailReminder.setEmailReminderId(emailReminderId);
	}

	/**
	* Returns the submitter name of this email reminder.
	*
	* @return the submitter name of this email reminder
	*/
	@Override
	public java.lang.String getSubmitterName() {
		return _emailReminder.getSubmitterName();
	}

	/**
	* Sets the submitter name of this email reminder.
	*
	* @param submitterName the submitter name of this email reminder
	*/
	@Override
	public void setSubmitterName(java.lang.String submitterName) {
		_emailReminder.setSubmitterName(submitterName);
	}

	/**
	* Returns the submitter email ID of this email reminder.
	*
	* @return the submitter email ID of this email reminder
	*/
	@Override
	public java.lang.String getSubmitterEmailId() {
		return _emailReminder.getSubmitterEmailId();
	}

	/**
	* Sets the submitter email ID of this email reminder.
	*
	* @param submitterEmailId the submitter email ID of this email reminder
	*/
	@Override
	public void setSubmitterEmailId(java.lang.String submitterEmailId) {
		_emailReminder.setSubmitterEmailId(submitterEmailId);
	}

	/**
	* Returns the reminder number of this email reminder.
	*
	* @return the reminder number of this email reminder
	*/
	@Override
	public int getReminderNumber() {
		return _emailReminder.getReminderNumber();
	}

	/**
	* Sets the reminder number of this email reminder.
	*
	* @param reminderNumber the reminder number of this email reminder
	*/
	@Override
	public void setReminderNumber(int reminderNumber) {
		_emailReminder.setReminderNumber(reminderNumber);
	}

	/**
	* Returns the schedule timestamp of this email reminder.
	*
	* @return the schedule timestamp of this email reminder
	*/
	@Override
	public java.util.Date getScheduleTimestamp() {
		return _emailReminder.getScheduleTimestamp();
	}

	/**
	* Sets the schedule timestamp of this email reminder.
	*
	* @param scheduleTimestamp the schedule timestamp of this email reminder
	*/
	@Override
	public void setScheduleTimestamp(java.util.Date scheduleTimestamp) {
		_emailReminder.setScheduleTimestamp(scheduleTimestamp);
	}

	/**
	* Returns the email subject text of this email reminder.
	*
	* @return the email subject text of this email reminder
	*/
	@Override
	public java.lang.String getEmailSubjectText() {
		return _emailReminder.getEmailSubjectText();
	}

	/**
	* Sets the email subject text of this email reminder.
	*
	* @param emailSubjectText the email subject text of this email reminder
	*/
	@Override
	public void setEmailSubjectText(java.lang.String emailSubjectText) {
		_emailReminder.setEmailSubjectText(emailSubjectText);
	}

	/**
	* Returns the email body text of this email reminder.
	*
	* @return the email body text of this email reminder
	*/
	@Override
	public java.lang.String getEmailBodyText() {
		return _emailReminder.getEmailBodyText();
	}

	/**
	* Sets the email body text of this email reminder.
	*
	* @param emailBodyText the email body text of this email reminder
	*/
	@Override
	public void setEmailBodyText(java.lang.String emailBodyText) {
		_emailReminder.setEmailBodyText(emailBodyText);
	}

	/**
	* Returns the status code of this email reminder.
	*
	* @return the status code of this email reminder
	*/
	@Override
	public java.lang.String getStatusCode() {
		return _emailReminder.getStatusCode();
	}

	/**
	* Sets the status code of this email reminder.
	*
	* @param statusCode the status code of this email reminder
	*/
	@Override
	public void setStatusCode(java.lang.String statusCode) {
		_emailReminder.setStatusCode(statusCode);
	}

	/**
	* Returns the create user ID of this email reminder.
	*
	* @return the create user ID of this email reminder
	*/
	@Override
	public java.lang.String getCreateUserId() {
		return _emailReminder.getCreateUserId();
	}

	/**
	* Sets the create user ID of this email reminder.
	*
	* @param createUserId the create user ID of this email reminder
	*/
	@Override
	public void setCreateUserId(java.lang.String createUserId) {
		_emailReminder.setCreateUserId(createUserId);
	}

	/**
	* Returns the create timestamp of this email reminder.
	*
	* @return the create timestamp of this email reminder
	*/
	@Override
	public java.util.Date getCreateTimestamp() {
		return _emailReminder.getCreateTimestamp();
	}

	/**
	* Sets the create timestamp of this email reminder.
	*
	* @param createTimestamp the create timestamp of this email reminder
	*/
	@Override
	public void setCreateTimestamp(java.util.Date createTimestamp) {
		_emailReminder.setCreateTimestamp(createTimestamp);
	}

	/**
	* Returns the last update user ID of this email reminder.
	*
	* @return the last update user ID of this email reminder
	*/
	@Override
	public java.lang.String getLastUpdateUserId() {
		return _emailReminder.getLastUpdateUserId();
	}

	/**
	* Sets the last update user ID of this email reminder.
	*
	* @param lastUpdateUserId the last update user ID of this email reminder
	*/
	@Override
	public void setLastUpdateUserId(java.lang.String lastUpdateUserId) {
		_emailReminder.setLastUpdateUserId(lastUpdateUserId);
	}

	/**
	* Returns the last update timestamp of this email reminder.
	*
	* @return the last update timestamp of this email reminder
	*/
	@Override
	public java.util.Date getLastUpdateTimestamp() {
		return _emailReminder.getLastUpdateTimestamp();
	}

	/**
	* Sets the last update timestamp of this email reminder.
	*
	* @param lastUpdateTimestamp the last update timestamp of this email reminder
	*/
	@Override
	public void setLastUpdateTimestamp(java.util.Date lastUpdateTimestamp) {
		_emailReminder.setLastUpdateTimestamp(lastUpdateTimestamp);
	}

	@Override
	public boolean isNew() {
		return _emailReminder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_emailReminder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _emailReminder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emailReminder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _emailReminder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _emailReminder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_emailReminder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _emailReminder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_emailReminder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_emailReminder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_emailReminder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmailReminderWrapper((EmailReminder)_emailReminder.clone());
	}

	@Override
	public int compareTo(com.ihg.me2.model.EmailReminder emailReminder) {
		return _emailReminder.compareTo(emailReminder);
	}

	@Override
	public int hashCode() {
		return _emailReminder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.me2.model.EmailReminder> toCacheModel() {
		return _emailReminder.toCacheModel();
	}

	@Override
	public com.ihg.me2.model.EmailReminder toEscapedModel() {
		return new EmailReminderWrapper(_emailReminder.toEscapedModel());
	}

	@Override
	public com.ihg.me2.model.EmailReminder toUnescapedModel() {
		return new EmailReminderWrapper(_emailReminder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _emailReminder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _emailReminder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_emailReminder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailReminderWrapper)) {
			return false;
		}

		EmailReminderWrapper emailReminderWrapper = (EmailReminderWrapper)obj;

		if (Validator.equals(_emailReminder, emailReminderWrapper._emailReminder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmailReminder getWrappedEmailReminder() {
		return _emailReminder;
	}

	@Override
	public EmailReminder getWrappedModel() {
		return _emailReminder;
	}

	@Override
	public void resetOriginalValues() {
		_emailReminder.resetOriginalValues();
	}

	private EmailReminder _emailReminder;
}