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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ihg.me2.service.http.EmailReminderServiceSoap}.
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.http.EmailReminderServiceSoap
 * @generated
 */
public class EmailReminderSoap implements Serializable {
	public static EmailReminderSoap toSoapModel(EmailReminder model) {
		EmailReminderSoap soapModel = new EmailReminderSoap();

		soapModel.setEmailReminderId(model.getEmailReminderId());
		soapModel.setSubmitterName(model.getSubmitterName());
		soapModel.setSubmitterEmailId(model.getSubmitterEmailId());
		soapModel.setReminderNumber(model.getReminderNumber());
		soapModel.setScheduleTimestamp(model.getScheduleTimestamp());
		soapModel.setEmailSubjectText(model.getEmailSubjectText());
		soapModel.setEmailBodyText(model.getEmailBodyText());
		soapModel.setStatusCode(model.getStatusCode());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateTimestamp(model.getCreateTimestamp());
		soapModel.setLastUpdateUserId(model.getLastUpdateUserId());
		soapModel.setLastUpdateTimestamp(model.getLastUpdateTimestamp());

		return soapModel;
	}

	public static EmailReminderSoap[] toSoapModels(EmailReminder[] models) {
		EmailReminderSoap[] soapModels = new EmailReminderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailReminderSoap[][] toSoapModels(EmailReminder[][] models) {
		EmailReminderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailReminderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailReminderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailReminderSoap[] toSoapModels(List<EmailReminder> models) {
		List<EmailReminderSoap> soapModels = new ArrayList<EmailReminderSoap>(models.size());

		for (EmailReminder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailReminderSoap[soapModels.size()]);
	}

	public EmailReminderSoap() {
	}

	public long getPrimaryKey() {
		return _emailReminderId;
	}

	public void setPrimaryKey(long pk) {
		setEmailReminderId(pk);
	}

	public long getEmailReminderId() {
		return _emailReminderId;
	}

	public void setEmailReminderId(long emailReminderId) {
		_emailReminderId = emailReminderId;
	}

	public String getSubmitterName() {
		return _submitterName;
	}

	public void setSubmitterName(String submitterName) {
		_submitterName = submitterName;
	}

	public String getSubmitterEmailId() {
		return _submitterEmailId;
	}

	public void setSubmitterEmailId(String submitterEmailId) {
		_submitterEmailId = submitterEmailId;
	}

	public int getReminderNumber() {
		return _reminderNumber;
	}

	public void setReminderNumber(int reminderNumber) {
		_reminderNumber = reminderNumber;
	}

	public Date getScheduleTimestamp() {
		return _scheduleTimestamp;
	}

	public void setScheduleTimestamp(Date scheduleTimestamp) {
		_scheduleTimestamp = scheduleTimestamp;
	}

	public String getEmailSubjectText() {
		return _emailSubjectText;
	}

	public void setEmailSubjectText(String emailSubjectText) {
		_emailSubjectText = emailSubjectText;
	}

	public String getEmailBodyText() {
		return _emailBodyText;
	}

	public void setEmailBodyText(String emailBodyText) {
		_emailBodyText = emailBodyText;
	}

	public String getStatusCode() {
		return _statusCode;
	}

	public void setStatusCode(String statusCode) {
		_statusCode = statusCode;
	}

	public String getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;
	}

	public Date getCreateTimestamp() {
		return _createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		_createTimestamp = createTimestamp;
	}

	public String getLastUpdateUserId() {
		return _lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;
	}

	public Date getLastUpdateTimestamp() {
		return _lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		_lastUpdateTimestamp = lastUpdateTimestamp;
	}

	private long _emailReminderId;
	private String _submitterName;
	private String _submitterEmailId;
	private int _reminderNumber;
	private Date _scheduleTimestamp;
	private String _emailSubjectText;
	private String _emailBodyText;
	private String _statusCode;
	private String _createUserId;
	private Date _createTimestamp;
	private String _lastUpdateUserId;
	private Date _lastUpdateTimestamp;
}