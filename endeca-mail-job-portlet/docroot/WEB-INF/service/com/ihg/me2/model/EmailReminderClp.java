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
import com.ihg.me2.service.EmailReminderLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vishal.rangras
 */
public class EmailReminderClp extends BaseModelImpl<EmailReminder>
	implements EmailReminder {
	public EmailReminderClp() {
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
	public long getPrimaryKey() {
		return _emailReminderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmailReminderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emailReminderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEmailReminderId() {
		return _emailReminderId;
	}

	@Override
	public void setEmailReminderId(long emailReminderId) {
		_emailReminderId = emailReminderId;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailReminderId", long.class);

				method.invoke(_emailReminderRemoteModel, emailReminderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmitterName() {
		return _submitterName;
	}

	@Override
	public void setSubmitterName(String submitterName) {
		_submitterName = submitterName;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitterName", String.class);

				method.invoke(_emailReminderRemoteModel, submitterName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmitterEmailId() {
		return _submitterEmailId;
	}

	@Override
	public void setSubmitterEmailId(String submitterEmailId) {
		_submitterEmailId = submitterEmailId;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitterEmailId",
						String.class);

				method.invoke(_emailReminderRemoteModel, submitterEmailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getReminderNumber() {
		return _reminderNumber;
	}

	@Override
	public void setReminderNumber(int reminderNumber) {
		_reminderNumber = reminderNumber;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setReminderNumber", int.class);

				method.invoke(_emailReminderRemoteModel, reminderNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getScheduleTimestamp() {
		return _scheduleTimestamp;
	}

	@Override
	public void setScheduleTimestamp(Date scheduleTimestamp) {
		_scheduleTimestamp = scheduleTimestamp;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setScheduleTimestamp",
						Date.class);

				method.invoke(_emailReminderRemoteModel, scheduleTimestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailSubjectText() {
		return _emailSubjectText;
	}

	@Override
	public void setEmailSubjectText(String emailSubjectText) {
		_emailSubjectText = emailSubjectText;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailSubjectText",
						String.class);

				method.invoke(_emailReminderRemoteModel, emailSubjectText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailBodyText() {
		return _emailBodyText;
	}

	@Override
	public void setEmailBodyText(String emailBodyText) {
		_emailBodyText = emailBodyText;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailBodyText", String.class);

				method.invoke(_emailReminderRemoteModel, emailBodyText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusCode() {
		return _statusCode;
	}

	@Override
	public void setStatusCode(String statusCode) {
		_statusCode = statusCode;

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusCode", String.class);

				method.invoke(_emailReminderRemoteModel, statusCode);
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

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", String.class);

				method.invoke(_emailReminderRemoteModel, createUserId);
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

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTimestamp", Date.class);

				method.invoke(_emailReminderRemoteModel, createTimestamp);
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

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateUserId",
						String.class);

				method.invoke(_emailReminderRemoteModel, lastUpdateUserId);
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

		if (_emailReminderRemoteModel != null) {
			try {
				Class<?> clazz = _emailReminderRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateTimestamp",
						Date.class);

				method.invoke(_emailReminderRemoteModel, lastUpdateTimestamp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmailReminderRemoteModel() {
		return _emailReminderRemoteModel;
	}

	public void setEmailReminderRemoteModel(
		BaseModel<?> emailReminderRemoteModel) {
		_emailReminderRemoteModel = emailReminderRemoteModel;
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

		Class<?> remoteModelClass = _emailReminderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_emailReminderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmailReminderLocalServiceUtil.addEmailReminder(this);
		}
		else {
			EmailReminderLocalServiceUtil.updateEmailReminder(this);
		}
	}

	@Override
	public EmailReminder toEscapedModel() {
		return (EmailReminder)ProxyUtil.newProxyInstance(EmailReminder.class.getClassLoader(),
			new Class[] { EmailReminder.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmailReminderClp clone = new EmailReminderClp();

		clone.setEmailReminderId(getEmailReminderId());
		clone.setSubmitterName(getSubmitterName());
		clone.setSubmitterEmailId(getSubmitterEmailId());
		clone.setReminderNumber(getReminderNumber());
		clone.setScheduleTimestamp(getScheduleTimestamp());
		clone.setEmailSubjectText(getEmailSubjectText());
		clone.setEmailBodyText(getEmailBodyText());
		clone.setStatusCode(getStatusCode());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreateTimestamp(getCreateTimestamp());
		clone.setLastUpdateUserId(getLastUpdateUserId());
		clone.setLastUpdateTimestamp(getLastUpdateTimestamp());

		return clone;
	}

	@Override
	public int compareTo(EmailReminder emailReminder) {
		long primaryKey = emailReminder.getPrimaryKey();

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

		if (!(obj instanceof EmailReminderClp)) {
			return false;
		}

		EmailReminderClp emailReminder = (EmailReminderClp)obj;

		long primaryKey = emailReminder.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{emailReminderId=");
		sb.append(getEmailReminderId());
		sb.append(", submitterName=");
		sb.append(getSubmitterName());
		sb.append(", submitterEmailId=");
		sb.append(getSubmitterEmailId());
		sb.append(", reminderNumber=");
		sb.append(getReminderNumber());
		sb.append(", scheduleTimestamp=");
		sb.append(getScheduleTimestamp());
		sb.append(", emailSubjectText=");
		sb.append(getEmailSubjectText());
		sb.append(", emailBodyText=");
		sb.append(getEmailBodyText());
		sb.append(", statusCode=");
		sb.append(getStatusCode());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.me2.model.EmailReminder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>emailReminderId</column-name><column-value><![CDATA[");
		sb.append(getEmailReminderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitterName</column-name><column-value><![CDATA[");
		sb.append(getSubmitterName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitterEmailId</column-name><column-value><![CDATA[");
		sb.append(getSubmitterEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reminderNumber</column-name><column-value><![CDATA[");
		sb.append(getReminderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleTimestamp</column-name><column-value><![CDATA[");
		sb.append(getScheduleTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailSubjectText</column-name><column-value><![CDATA[");
		sb.append(getEmailSubjectText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailBodyText</column-name><column-value><![CDATA[");
		sb.append(getEmailBodyText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusCode</column-name><column-value><![CDATA[");
		sb.append(getStatusCode());
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
	private BaseModel<?> _emailReminderRemoteModel;
}