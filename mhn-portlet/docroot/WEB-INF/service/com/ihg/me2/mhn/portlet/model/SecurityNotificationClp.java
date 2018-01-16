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

package com.ihg.me2.mhn.portlet.model;

import com.ihg.me2.mhn.portlet.service.ClpSerializer;
import com.ihg.me2.mhn.portlet.service.SecurityNotificationLocalServiceUtil;

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
public class SecurityNotificationClp extends BaseModelImpl<SecurityNotification>
	implements SecurityNotification {
	public SecurityNotificationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SecurityNotification.class;
	}

	@Override
	public String getModelClassName() {
		return SecurityNotification.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("gmScreenname", getGmScreenname());
		attributes.put("gmName", getGmName());
		attributes.put("gmEmail", getGmEmail());
		attributes.put("pcScreenname", getPcScreenname());
		attributes.put("pcName", getPcName());
		attributes.put("pcEmail", getPcEmail());
		attributes.put("secPcScreenname", getSecPcScreenname());
		attributes.put("secPcName", getSecPcName());
		attributes.put("secPcEmail", getSecPcEmail());
		attributes.put("fopsScreenname", getFopsScreenname());
		attributes.put("fopsName", getFopsName());
		attributes.put("fopsEmail", getFopsEmail());
		attributes.put("holidexCode", getHolidexCode());
		attributes.put("hotelName", getHotelName());
		attributes.put("impacted", getImpacted());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		String gmScreenname = (String)attributes.get("gmScreenname");

		if (gmScreenname != null) {
			setGmScreenname(gmScreenname);
		}

		String gmName = (String)attributes.get("gmName");

		if (gmName != null) {
			setGmName(gmName);
		}

		String gmEmail = (String)attributes.get("gmEmail");

		if (gmEmail != null) {
			setGmEmail(gmEmail);
		}

		String pcScreenname = (String)attributes.get("pcScreenname");

		if (pcScreenname != null) {
			setPcScreenname(pcScreenname);
		}

		String pcName = (String)attributes.get("pcName");

		if (pcName != null) {
			setPcName(pcName);
		}

		String pcEmail = (String)attributes.get("pcEmail");

		if (pcEmail != null) {
			setPcEmail(pcEmail);
		}

		String secPcScreenname = (String)attributes.get("secPcScreenname");

		if (secPcScreenname != null) {
			setSecPcScreenname(secPcScreenname);
		}

		String secPcName = (String)attributes.get("secPcName");

		if (secPcName != null) {
			setSecPcName(secPcName);
		}

		String secPcEmail = (String)attributes.get("secPcEmail");

		if (secPcEmail != null) {
			setSecPcEmail(secPcEmail);
		}

		String fopsScreenname = (String)attributes.get("fopsScreenname");

		if (fopsScreenname != null) {
			setFopsScreenname(fopsScreenname);
		}

		String fopsName = (String)attributes.get("fopsName");

		if (fopsName != null) {
			setFopsName(fopsName);
		}

		String fopsEmail = (String)attributes.get("fopsEmail");

		if (fopsEmail != null) {
			setFopsEmail(fopsEmail);
		}

		String holidexCode = (String)attributes.get("holidexCode");

		if (holidexCode != null) {
			setHolidexCode(holidexCode);
		}

		String hotelName = (String)attributes.get("hotelName");

		if (hotelName != null) {
			setHotelName(hotelName);
		}

		String impacted = (String)attributes.get("impacted");

		if (impacted != null) {
			setImpacted(impacted);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public long getNotificationId() {
		return _notificationId;
	}

	@Override
	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationId", long.class);

				method.invoke(_securityNotificationRemoteModel, notificationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGmScreenname() {
		return _gmScreenname;
	}

	@Override
	public void setGmScreenname(String gmScreenname) {
		_gmScreenname = gmScreenname;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setGmScreenname", String.class);

				method.invoke(_securityNotificationRemoteModel, gmScreenname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGmName() {
		return _gmName;
	}

	@Override
	public void setGmName(String gmName) {
		_gmName = gmName;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setGmName", String.class);

				method.invoke(_securityNotificationRemoteModel, gmName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGmEmail() {
		return _gmEmail;
	}

	@Override
	public void setGmEmail(String gmEmail) {
		_gmEmail = gmEmail;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setGmEmail", String.class);

				method.invoke(_securityNotificationRemoteModel, gmEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcScreenname() {
		return _pcScreenname;
	}

	@Override
	public void setPcScreenname(String pcScreenname) {
		_pcScreenname = pcScreenname;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcScreenname", String.class);

				method.invoke(_securityNotificationRemoteModel, pcScreenname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcName() {
		return _pcName;
	}

	@Override
	public void setPcName(String pcName) {
		_pcName = pcName;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcName", String.class);

				method.invoke(_securityNotificationRemoteModel, pcName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcEmail() {
		return _pcEmail;
	}

	@Override
	public void setPcEmail(String pcEmail) {
		_pcEmail = pcEmail;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcEmail", String.class);

				method.invoke(_securityNotificationRemoteModel, pcEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecPcScreenname() {
		return _secPcScreenname;
	}

	@Override
	public void setSecPcScreenname(String secPcScreenname) {
		_secPcScreenname = secPcScreenname;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setSecPcScreenname",
						String.class);

				method.invoke(_securityNotificationRemoteModel, secPcScreenname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecPcName() {
		return _secPcName;
	}

	@Override
	public void setSecPcName(String secPcName) {
		_secPcName = secPcName;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setSecPcName", String.class);

				method.invoke(_securityNotificationRemoteModel, secPcName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecPcEmail() {
		return _secPcEmail;
	}

	@Override
	public void setSecPcEmail(String secPcEmail) {
		_secPcEmail = secPcEmail;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setSecPcEmail", String.class);

				method.invoke(_securityNotificationRemoteModel, secPcEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFopsScreenname() {
		return _fopsScreenname;
	}

	@Override
	public void setFopsScreenname(String fopsScreenname) {
		_fopsScreenname = fopsScreenname;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setFopsScreenname",
						String.class);

				method.invoke(_securityNotificationRemoteModel, fopsScreenname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFopsName() {
		return _fopsName;
	}

	@Override
	public void setFopsName(String fopsName) {
		_fopsName = fopsName;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setFopsName", String.class);

				method.invoke(_securityNotificationRemoteModel, fopsName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFopsEmail() {
		return _fopsEmail;
	}

	@Override
	public void setFopsEmail(String fopsEmail) {
		_fopsEmail = fopsEmail;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setFopsEmail", String.class);

				method.invoke(_securityNotificationRemoteModel, fopsEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHolidexCode() {
		return _holidexCode;
	}

	@Override
	public void setHolidexCode(String holidexCode) {
		_holidexCode = holidexCode;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setHolidexCode", String.class);

				method.invoke(_securityNotificationRemoteModel, holidexCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHotelName() {
		return _hotelName;
	}

	@Override
	public void setHotelName(String hotelName) {
		_hotelName = hotelName;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelName", String.class);

				method.invoke(_securityNotificationRemoteModel, hotelName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImpacted() {
		return _impacted;
	}

	@Override
	public void setImpacted(String impacted) {
		_impacted = impacted;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setImpacted", String.class);

				method.invoke(_securityNotificationRemoteModel, impacted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_securityNotificationRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_securityNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _securityNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_securityNotificationRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSecurityNotificationRemoteModel() {
		return _securityNotificationRemoteModel;
	}

	public void setSecurityNotificationRemoteModel(
		BaseModel<?> securityNotificationRemoteModel) {
		_securityNotificationRemoteModel = securityNotificationRemoteModel;
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

		Class<?> remoteModelClass = _securityNotificationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_securityNotificationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SecurityNotificationLocalServiceUtil.addSecurityNotification(this);
		}
		else {
			SecurityNotificationLocalServiceUtil.updateSecurityNotification(this);
		}
	}

	@Override
	public SecurityNotification toEscapedModel() {
		return (SecurityNotification)ProxyUtil.newProxyInstance(SecurityNotification.class.getClassLoader(),
			new Class[] { SecurityNotification.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SecurityNotificationClp clone = new SecurityNotificationClp();

		clone.setNotificationId(getNotificationId());
		clone.setGmScreenname(getGmScreenname());
		clone.setGmName(getGmName());
		clone.setGmEmail(getGmEmail());
		clone.setPcScreenname(getPcScreenname());
		clone.setPcName(getPcName());
		clone.setPcEmail(getPcEmail());
		clone.setSecPcScreenname(getSecPcScreenname());
		clone.setSecPcName(getSecPcName());
		clone.setSecPcEmail(getSecPcEmail());
		clone.setFopsScreenname(getFopsScreenname());
		clone.setFopsName(getFopsName());
		clone.setFopsEmail(getFopsEmail());
		clone.setHolidexCode(getHolidexCode());
		clone.setHotelName(getHotelName());
		clone.setImpacted(getImpacted());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

		return clone;
	}

	@Override
	public int compareTo(SecurityNotification securityNotification) {
		long primaryKey = securityNotification.getPrimaryKey();

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

		if (!(obj instanceof SecurityNotificationClp)) {
			return false;
		}

		SecurityNotificationClp securityNotification = (SecurityNotificationClp)obj;

		long primaryKey = securityNotification.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{notificationId=");
		sb.append(getNotificationId());
		sb.append(", gmScreenname=");
		sb.append(getGmScreenname());
		sb.append(", gmName=");
		sb.append(getGmName());
		sb.append(", gmEmail=");
		sb.append(getGmEmail());
		sb.append(", pcScreenname=");
		sb.append(getPcScreenname());
		sb.append(", pcName=");
		sb.append(getPcName());
		sb.append(", pcEmail=");
		sb.append(getPcEmail());
		sb.append(", secPcScreenname=");
		sb.append(getSecPcScreenname());
		sb.append(", secPcName=");
		sb.append(getSecPcName());
		sb.append(", secPcEmail=");
		sb.append(getSecPcEmail());
		sb.append(", fopsScreenname=");
		sb.append(getFopsScreenname());
		sb.append(", fopsName=");
		sb.append(getFopsName());
		sb.append(", fopsEmail=");
		sb.append(getFopsEmail());
		sb.append(", holidexCode=");
		sb.append(getHolidexCode());
		sb.append(", hotelName=");
		sb.append(getHotelName());
		sb.append(", impacted=");
		sb.append(getImpacted());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.ihg.me2.mhn.portlet.model.SecurityNotification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificationId</column-name><column-value><![CDATA[");
		sb.append(getNotificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gmScreenname</column-name><column-value><![CDATA[");
		sb.append(getGmScreenname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gmName</column-name><column-value><![CDATA[");
		sb.append(getGmName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gmEmail</column-name><column-value><![CDATA[");
		sb.append(getGmEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcScreenname</column-name><column-value><![CDATA[");
		sb.append(getPcScreenname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcName</column-name><column-value><![CDATA[");
		sb.append(getPcName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcEmail</column-name><column-value><![CDATA[");
		sb.append(getPcEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secPcScreenname</column-name><column-value><![CDATA[");
		sb.append(getSecPcScreenname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secPcName</column-name><column-value><![CDATA[");
		sb.append(getSecPcName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secPcEmail</column-name><column-value><![CDATA[");
		sb.append(getSecPcEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fopsScreenname</column-name><column-value><![CDATA[");
		sb.append(getFopsScreenname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fopsName</column-name><column-value><![CDATA[");
		sb.append(getFopsName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fopsEmail</column-name><column-value><![CDATA[");
		sb.append(getFopsEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holidexCode</column-name><column-value><![CDATA[");
		sb.append(getHolidexCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hotelName</column-name><column-value><![CDATA[");
		sb.append(getHotelName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>impacted</column-name><column-value><![CDATA[");
		sb.append(getImpacted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificationId;
	private String _gmScreenname;
	private String _gmName;
	private String _gmEmail;
	private String _pcScreenname;
	private String _pcName;
	private String _pcEmail;
	private String _secPcScreenname;
	private String _secPcName;
	private String _secPcEmail;
	private String _fopsScreenname;
	private String _fopsName;
	private String _fopsEmail;
	private String _holidexCode;
	private String _hotelName;
	private String _impacted;
	private Date _startDate;
	private Date _endDate;
	private BaseModel<?> _securityNotificationRemoteModel;
}