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

import com.ihg.me2.service.ClpSerializer;
import com.ihg.me2.service.EmailAttachmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vishal.rangras
 */
public class EmailAttachmentClp extends BaseModelImpl<EmailAttachment>
	implements EmailAttachment {
	public EmailAttachmentClp() {
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
	public long getPrimaryKey() {
		return _EMAIL_ATTACHMENT_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEMAIL_ATTACHMENT_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _EMAIL_ATTACHMENT_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEMAIL_ATTACHMENT_ID() {
		return _EMAIL_ATTACHMENT_ID;
	}

	@Override
	public void setEMAIL_ATTACHMENT_ID(long EMAIL_ATTACHMENT_ID) {
		_EMAIL_ATTACHMENT_ID = EMAIL_ATTACHMENT_ID;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEMAIL_ATTACHMENT_ID",
						long.class);

				method.invoke(_emailAttachmentRemoteModel, EMAIL_ATTACHMENT_ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmailReminderId() {
		return _emailReminderId;
	}

	@Override
	public void setEmailReminderId(long emailReminderId) {
		_emailReminderId = emailReminderId;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailReminderId", long.class);

				method.invoke(_emailAttachmentRemoteModel, emailReminderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttachmentFileName() {
		return _attachmentFileName;
	}

	@Override
	public void setAttachmentFileName(String attachmentFileName) {
		_attachmentFileName = attachmentFileName;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentFileName",
						String.class);

				method.invoke(_emailAttachmentRemoteModel, attachmentFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getAttachmentFileText() {
		return _attachmentFileText;
	}

	@Override
	public void setAttachmentFileText(Blob attachmentFileText) {
		_attachmentFileText = attachmentFileText;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentFileText",
						Blob.class);

				method.invoke(_emailAttachmentRemoteModel, attachmentFileText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", String.class);

				method.invoke(_emailAttachmentRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateTimestamp() {
		return _createTimestamp;
	}

	@Override
	public void setCreateTimestamp(Date createTimestamp) {
		_createTimestamp = createTimestamp;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTimestamp", Date.class);

				method.invoke(_emailAttachmentRemoteModel, createTimestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastUpdateUserId() {
		return _lastUpdateUserId;
	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateUserId",
						String.class);

				method.invoke(_emailAttachmentRemoteModel, lastUpdateUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastUpdateTimestamp() {
		return _lastUpdateTimestamp;
	}

	@Override
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		_lastUpdateTimestamp = lastUpdateTimestamp;

		if (_emailAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _emailAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateTimestamp",
						Date.class);

				method.invoke(_emailAttachmentRemoteModel, lastUpdateTimestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmailAttachmentRemoteModel() {
		return _emailAttachmentRemoteModel;
	}

	public void setEmailAttachmentRemoteModel(
		BaseModel<?> emailAttachmentRemoteModel) {
		_emailAttachmentRemoteModel = emailAttachmentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _emailAttachmentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_emailAttachmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmailAttachmentLocalServiceUtil.addEmailAttachment(this);
		}
		else {
			EmailAttachmentLocalServiceUtil.updateEmailAttachment(this);
		}
	}

	@Override
	public EmailAttachment toEscapedModel() {
		return (EmailAttachment)ProxyUtil.newProxyInstance(EmailAttachment.class.getClassLoader(),
			new Class[] { EmailAttachment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmailAttachmentClp clone = new EmailAttachmentClp();

		clone.setEMAIL_ATTACHMENT_ID(getEMAIL_ATTACHMENT_ID());
		clone.setEmailReminderId(getEmailReminderId());
		clone.setAttachmentFileName(getAttachmentFileName());
		clone.setAttachmentFileText(getAttachmentFileText());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreateTimestamp(getCreateTimestamp());
		clone.setLastUpdateUserId(getLastUpdateUserId());
		clone.setLastUpdateTimestamp(getLastUpdateTimestamp());

		return clone;
	}

	@Override
	public int compareTo(EmailAttachment emailAttachment) {
		long primaryKey = emailAttachment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailAttachmentClp)) {
			return false;
		}

		EmailAttachmentClp emailAttachment = (EmailAttachmentClp)obj;

		long primaryKey = emailAttachment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{EMAIL_ATTACHMENT_ID=");
		sb.append(getEMAIL_ATTACHMENT_ID());
		sb.append(", emailReminderId=");
		sb.append(getEmailReminderId());
		sb.append(", attachmentFileName=");
		sb.append(getAttachmentFileName());
		sb.append(", attachmentFileText=");
		sb.append(getAttachmentFileText());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createTimestamp=");
		sb.append(getCreateTimestamp());
		sb.append(", lastUpdateUserId=");
		sb.append(getLastUpdateUserId());
		sb.append(", lastUpdateTimestamp=");
		sb.append(getLastUpdateTimestamp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.me2.model.EmailAttachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>EMAIL_ATTACHMENT_ID</column-name><column-value><![CDATA[");
		sb.append(getEMAIL_ATTACHMENT_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailReminderId</column-name><column-value><![CDATA[");
		sb.append(getEmailReminderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentFileName</column-name><column-value><![CDATA[");
		sb.append(getAttachmentFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentFileText</column-name><column-value><![CDATA[");
		sb.append(getAttachmentFileText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTimestamp</column-name><column-value><![CDATA[");
		sb.append(getCreateTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastUpdateUserId</column-name><column-value><![CDATA[");
		sb.append(getLastUpdateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastUpdateTimestamp</column-name><column-value><![CDATA[");
		sb.append(getLastUpdateTimestamp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _EMAIL_ATTACHMENT_ID;
	private long _emailReminderId;
	private String _attachmentFileName;
	private Blob _attachmentFileText;
	private String _createUserId;
	private Date _createTimestamp;
	private String _lastUpdateUserId;
	private Date _lastUpdateTimestamp;
	private BaseModel<?> _emailAttachmentRemoteModel;
}