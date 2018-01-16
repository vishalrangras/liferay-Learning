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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ihg.me2.service.http.EmailAttachmentServiceSoap}.
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.http.EmailAttachmentServiceSoap
 * @generated
 */
public class EmailAttachmentSoap implements Serializable {
	public static EmailAttachmentSoap toSoapModel(EmailAttachment model) {
		EmailAttachmentSoap soapModel = new EmailAttachmentSoap();

		soapModel.setEMAIL_ATTACHMENT_ID(model.getEMAIL_ATTACHMENT_ID());
		soapModel.setEmailReminderId(model.getEmailReminderId());
		soapModel.setAttachmentFileName(model.getAttachmentFileName());
		soapModel.setAttachmentFileText(model.getAttachmentFileText());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateTimestamp(model.getCreateTimestamp());
		soapModel.setLastUpdateUserId(model.getLastUpdateUserId());
		soapModel.setLastUpdateTimestamp(model.getLastUpdateTimestamp());

		return soapModel;
	}

	public static EmailAttachmentSoap[] toSoapModels(EmailAttachment[] models) {
		EmailAttachmentSoap[] soapModels = new EmailAttachmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailAttachmentSoap[][] toSoapModels(
		EmailAttachment[][] models) {
		EmailAttachmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailAttachmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailAttachmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailAttachmentSoap[] toSoapModels(
		List<EmailAttachment> models) {
		List<EmailAttachmentSoap> soapModels = new ArrayList<EmailAttachmentSoap>(models.size());

		for (EmailAttachment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailAttachmentSoap[soapModels.size()]);
	}

	public EmailAttachmentSoap() {
	}

	public long getPrimaryKey() {
		return _EMAIL_ATTACHMENT_ID;
	}

	public void setPrimaryKey(long pk) {
		setEMAIL_ATTACHMENT_ID(pk);
	}

	public long getEMAIL_ATTACHMENT_ID() {
		return _EMAIL_ATTACHMENT_ID;
	}

	public void setEMAIL_ATTACHMENT_ID(long EMAIL_ATTACHMENT_ID) {
		_EMAIL_ATTACHMENT_ID = EMAIL_ATTACHMENT_ID;
	}

	public long getEmailReminderId() {
		return _emailReminderId;
	}

	public void setEmailReminderId(long emailReminderId) {
		_emailReminderId = emailReminderId;
	}

	public String getAttachmentFileName() {
		return _attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		_attachmentFileName = attachmentFileName;
	}

	public Blob getAttachmentFileText() {
		return _attachmentFileText;
	}

	public void setAttachmentFileText(Blob attachmentFileText) {
		_attachmentFileText = attachmentFileText;
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

	private long _EMAIL_ATTACHMENT_ID;
	private long _emailReminderId;
	private String _attachmentFileName;
	private Blob _attachmentFileText;
	private String _createUserId;
	private Date _createTimestamp;
	private String _lastUpdateUserId;
	private Date _lastUpdateTimestamp;
}