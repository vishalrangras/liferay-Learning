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

package com.ihg.me2.mhn.portlet.model.impl;

import com.ihg.me2.mhn.portlet.model.SecurityNotification;
import com.ihg.me2.mhn.portlet.model.SecurityNotificationModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SecurityNotification service. Represents a row in the &quot;Security_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.me2.mhn.portlet.model.SecurityNotificationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SecurityNotificationImpl}.
 * </p>
 *
 * @author vishal.rangras
 * @see SecurityNotificationImpl
 * @see com.ihg.me2.mhn.portlet.model.SecurityNotification
 * @see com.ihg.me2.mhn.portlet.model.SecurityNotificationModel
 * @generated
 */
public class SecurityNotificationModelImpl extends BaseModelImpl<SecurityNotification>
	implements SecurityNotificationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a security notification model instance should use the {@link com.ihg.me2.mhn.portlet.model.SecurityNotification} interface instead.
	 */
	public static final String TABLE_NAME = "Security_Notification";
	public static final Object[][] TABLE_COLUMNS = {
			{ "notificationId", Types.BIGINT },
			{ "GM_USR_ID", Types.VARCHAR },
			{ "GM_NM", Types.VARCHAR },
			{ "GM_EMAIL", Types.VARCHAR },
			{ "PC_USR_ID", Types.VARCHAR },
			{ "PC_NM", Types.VARCHAR },
			{ "PC_EMAIL", Types.VARCHAR },
			{ "SEC_PC_USR_ID", Types.VARCHAR },
			{ "SEC_PC_NM", Types.VARCHAR },
			{ "SEC_PC_EMAIL", Types.VARCHAR },
			{ "FOPS_USR_ID", Types.VARCHAR },
			{ "FOPS_NM", Types.VARCHAR },
			{ "FOPS_EMAIL", Types.VARCHAR },
			{ "HLDX_CD", Types.VARCHAR },
			{ "HTL_NM", Types.VARCHAR },
			{ "IMPACTED", Types.VARCHAR },
			{ "START_DT", Types.TIMESTAMP },
			{ "END_DT", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table Security_Notification (notificationId LONG not null primary key,GM_USR_ID VARCHAR(75) null,GM_NM VARCHAR(75) null,GM_EMAIL VARCHAR(75) null,PC_USR_ID VARCHAR(75) null,PC_NM VARCHAR(75) null,PC_EMAIL VARCHAR(75) null,SEC_PC_USR_ID VARCHAR(75) null,SEC_PC_NM VARCHAR(75) null,SEC_PC_EMAIL VARCHAR(75) null,FOPS_USR_ID VARCHAR(75) null,FOPS_NM VARCHAR(75) null,FOPS_EMAIL VARCHAR(75) null,HLDX_CD VARCHAR(75) null,HTL_NM VARCHAR(75) null,IMPACTED VARCHAR(75) null,START_DT DATE null,END_DT DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Security_Notification";
	public static final String ORDER_BY_JPQL = " ORDER BY securityNotification.notificationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Security_Notification.notificationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.me2.mhn.portlet.model.SecurityNotification"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.me2.mhn.portlet.model.SecurityNotification"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.me2.mhn.portlet.model.SecurityNotification"));

	public SecurityNotificationModelImpl() {
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
	public Class<?> getModelClass() {
		return SecurityNotification.class;
	}

	@Override
	public String getModelClassName() {
		return SecurityNotification.class.getName();
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
	}

	@Override
	public String getGmScreenname() {
		if (_gmScreenname == null) {
			return StringPool.BLANK;
		}
		else {
			return _gmScreenname;
		}
	}

	@Override
	public void setGmScreenname(String gmScreenname) {
		_gmScreenname = gmScreenname;
	}

	@Override
	public String getGmName() {
		if (_gmName == null) {
			return StringPool.BLANK;
		}
		else {
			return _gmName;
		}
	}

	@Override
	public void setGmName(String gmName) {
		_gmName = gmName;
	}

	@Override
	public String getGmEmail() {
		if (_gmEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _gmEmail;
		}
	}

	@Override
	public void setGmEmail(String gmEmail) {
		_gmEmail = gmEmail;
	}

	@Override
	public String getPcScreenname() {
		if (_pcScreenname == null) {
			return StringPool.BLANK;
		}
		else {
			return _pcScreenname;
		}
	}

	@Override
	public void setPcScreenname(String pcScreenname) {
		_pcScreenname = pcScreenname;
	}

	@Override
	public String getPcName() {
		if (_pcName == null) {
			return StringPool.BLANK;
		}
		else {
			return _pcName;
		}
	}

	@Override
	public void setPcName(String pcName) {
		_pcName = pcName;
	}

	@Override
	public String getPcEmail() {
		if (_pcEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _pcEmail;
		}
	}

	@Override
	public void setPcEmail(String pcEmail) {
		_pcEmail = pcEmail;
	}

	@Override
	public String getSecPcScreenname() {
		if (_secPcScreenname == null) {
			return StringPool.BLANK;
		}
		else {
			return _secPcScreenname;
		}
	}

	@Override
	public void setSecPcScreenname(String secPcScreenname) {
		_secPcScreenname = secPcScreenname;
	}

	@Override
	public String getSecPcName() {
		if (_secPcName == null) {
			return StringPool.BLANK;
		}
		else {
			return _secPcName;
		}
	}

	@Override
	public void setSecPcName(String secPcName) {
		_secPcName = secPcName;
	}

	@Override
	public String getSecPcEmail() {
		if (_secPcEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _secPcEmail;
		}
	}

	@Override
	public void setSecPcEmail(String secPcEmail) {
		_secPcEmail = secPcEmail;
	}

	@Override
	public String getFopsScreenname() {
		if (_fopsScreenname == null) {
			return StringPool.BLANK;
		}
		else {
			return _fopsScreenname;
		}
	}

	@Override
	public void setFopsScreenname(String fopsScreenname) {
		_fopsScreenname = fopsScreenname;
	}

	@Override
	public String getFopsName() {
		if (_fopsName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fopsName;
		}
	}

	@Override
	public void setFopsName(String fopsName) {
		_fopsName = fopsName;
	}

	@Override
	public String getFopsEmail() {
		if (_fopsEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _fopsEmail;
		}
	}

	@Override
	public void setFopsEmail(String fopsEmail) {
		_fopsEmail = fopsEmail;
	}

	@Override
	public String getHolidexCode() {
		if (_holidexCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _holidexCode;
		}
	}

	@Override
	public void setHolidexCode(String holidexCode) {
		_holidexCode = holidexCode;
	}

	@Override
	public String getHotelName() {
		if (_hotelName == null) {
			return StringPool.BLANK;
		}
		else {
			return _hotelName;
		}
	}

	@Override
	public void setHotelName(String hotelName) {
		_hotelName = hotelName;
	}

	@Override
	public String getImpacted() {
		if (_impacted == null) {
			return StringPool.BLANK;
		}
		else {
			return _impacted;
		}
	}

	@Override
	public void setImpacted(String impacted) {
		_impacted = impacted;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SecurityNotification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SecurityNotification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SecurityNotification)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SecurityNotificationImpl securityNotificationImpl = new SecurityNotificationImpl();

		securityNotificationImpl.setNotificationId(getNotificationId());
		securityNotificationImpl.setGmScreenname(getGmScreenname());
		securityNotificationImpl.setGmName(getGmName());
		securityNotificationImpl.setGmEmail(getGmEmail());
		securityNotificationImpl.setPcScreenname(getPcScreenname());
		securityNotificationImpl.setPcName(getPcName());
		securityNotificationImpl.setPcEmail(getPcEmail());
		securityNotificationImpl.setSecPcScreenname(getSecPcScreenname());
		securityNotificationImpl.setSecPcName(getSecPcName());
		securityNotificationImpl.setSecPcEmail(getSecPcEmail());
		securityNotificationImpl.setFopsScreenname(getFopsScreenname());
		securityNotificationImpl.setFopsName(getFopsName());
		securityNotificationImpl.setFopsEmail(getFopsEmail());
		securityNotificationImpl.setHolidexCode(getHolidexCode());
		securityNotificationImpl.setHotelName(getHotelName());
		securityNotificationImpl.setImpacted(getImpacted());
		securityNotificationImpl.setStartDate(getStartDate());
		securityNotificationImpl.setEndDate(getEndDate());

		securityNotificationImpl.resetOriginalValues();

		return securityNotificationImpl;
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

		if (!(obj instanceof SecurityNotification)) {
			return false;
		}

		SecurityNotification securityNotification = (SecurityNotification)obj;

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<SecurityNotification> toCacheModel() {
		SecurityNotificationCacheModel securityNotificationCacheModel = new SecurityNotificationCacheModel();

		securityNotificationCacheModel.notificationId = getNotificationId();

		securityNotificationCacheModel.gmScreenname = getGmScreenname();

		String gmScreenname = securityNotificationCacheModel.gmScreenname;

		if ((gmScreenname != null) && (gmScreenname.length() == 0)) {
			securityNotificationCacheModel.gmScreenname = null;
		}

		securityNotificationCacheModel.gmName = getGmName();

		String gmName = securityNotificationCacheModel.gmName;

		if ((gmName != null) && (gmName.length() == 0)) {
			securityNotificationCacheModel.gmName = null;
		}

		securityNotificationCacheModel.gmEmail = getGmEmail();

		String gmEmail = securityNotificationCacheModel.gmEmail;

		if ((gmEmail != null) && (gmEmail.length() == 0)) {
			securityNotificationCacheModel.gmEmail = null;
		}

		securityNotificationCacheModel.pcScreenname = getPcScreenname();

		String pcScreenname = securityNotificationCacheModel.pcScreenname;

		if ((pcScreenname != null) && (pcScreenname.length() == 0)) {
			securityNotificationCacheModel.pcScreenname = null;
		}

		securityNotificationCacheModel.pcName = getPcName();

		String pcName = securityNotificationCacheModel.pcName;

		if ((pcName != null) && (pcName.length() == 0)) {
			securityNotificationCacheModel.pcName = null;
		}

		securityNotificationCacheModel.pcEmail = getPcEmail();

		String pcEmail = securityNotificationCacheModel.pcEmail;

		if ((pcEmail != null) && (pcEmail.length() == 0)) {
			securityNotificationCacheModel.pcEmail = null;
		}

		securityNotificationCacheModel.secPcScreenname = getSecPcScreenname();

		String secPcScreenname = securityNotificationCacheModel.secPcScreenname;

		if ((secPcScreenname != null) && (secPcScreenname.length() == 0)) {
			securityNotificationCacheModel.secPcScreenname = null;
		}

		securityNotificationCacheModel.secPcName = getSecPcName();

		String secPcName = securityNotificationCacheModel.secPcName;

		if ((secPcName != null) && (secPcName.length() == 0)) {
			securityNotificationCacheModel.secPcName = null;
		}

		securityNotificationCacheModel.secPcEmail = getSecPcEmail();

		String secPcEmail = securityNotificationCacheModel.secPcEmail;

		if ((secPcEmail != null) && (secPcEmail.length() == 0)) {
			securityNotificationCacheModel.secPcEmail = null;
		}

		securityNotificationCacheModel.fopsScreenname = getFopsScreenname();

		String fopsScreenname = securityNotificationCacheModel.fopsScreenname;

		if ((fopsScreenname != null) && (fopsScreenname.length() == 0)) {
			securityNotificationCacheModel.fopsScreenname = null;
		}

		securityNotificationCacheModel.fopsName = getFopsName();

		String fopsName = securityNotificationCacheModel.fopsName;

		if ((fopsName != null) && (fopsName.length() == 0)) {
			securityNotificationCacheModel.fopsName = null;
		}

		securityNotificationCacheModel.fopsEmail = getFopsEmail();

		String fopsEmail = securityNotificationCacheModel.fopsEmail;

		if ((fopsEmail != null) && (fopsEmail.length() == 0)) {
			securityNotificationCacheModel.fopsEmail = null;
		}

		securityNotificationCacheModel.holidexCode = getHolidexCode();

		String holidexCode = securityNotificationCacheModel.holidexCode;

		if ((holidexCode != null) && (holidexCode.length() == 0)) {
			securityNotificationCacheModel.holidexCode = null;
		}

		securityNotificationCacheModel.hotelName = getHotelName();

		String hotelName = securityNotificationCacheModel.hotelName;

		if ((hotelName != null) && (hotelName.length() == 0)) {
			securityNotificationCacheModel.hotelName = null;
		}

		securityNotificationCacheModel.impacted = getImpacted();

		String impacted = securityNotificationCacheModel.impacted;

		if ((impacted != null) && (impacted.length() == 0)) {
			securityNotificationCacheModel.impacted = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			securityNotificationCacheModel.startDate = startDate.getTime();
		}
		else {
			securityNotificationCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			securityNotificationCacheModel.endDate = endDate.getTime();
		}
		else {
			securityNotificationCacheModel.endDate = Long.MIN_VALUE;
		}

		return securityNotificationCacheModel;
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

	private static ClassLoader _classLoader = SecurityNotification.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SecurityNotification.class
		};
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
	private SecurityNotification _escapedModel;
}