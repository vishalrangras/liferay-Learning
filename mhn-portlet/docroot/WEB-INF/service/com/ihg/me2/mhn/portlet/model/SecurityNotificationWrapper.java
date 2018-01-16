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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SecurityNotification}.
 * </p>
 *
 * @author vishal.rangras
 * @see SecurityNotification
 * @generated
 */
public class SecurityNotificationWrapper implements SecurityNotification,
	ModelWrapper<SecurityNotification> {
	public SecurityNotificationWrapper(
		SecurityNotification securityNotification) {
		_securityNotification = securityNotification;
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

	/**
	* Returns the primary key of this security notification.
	*
	* @return the primary key of this security notification
	*/
	@Override
	public long getPrimaryKey() {
		return _securityNotification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this security notification.
	*
	* @param primaryKey the primary key of this security notification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_securityNotification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notification ID of this security notification.
	*
	* @return the notification ID of this security notification
	*/
	@Override
	public long getNotificationId() {
		return _securityNotification.getNotificationId();
	}

	/**
	* Sets the notification ID of this security notification.
	*
	* @param notificationId the notification ID of this security notification
	*/
	@Override
	public void setNotificationId(long notificationId) {
		_securityNotification.setNotificationId(notificationId);
	}

	/**
	* Returns the gm screenname of this security notification.
	*
	* @return the gm screenname of this security notification
	*/
	@Override
	public java.lang.String getGmScreenname() {
		return _securityNotification.getGmScreenname();
	}

	/**
	* Sets the gm screenname of this security notification.
	*
	* @param gmScreenname the gm screenname of this security notification
	*/
	@Override
	public void setGmScreenname(java.lang.String gmScreenname) {
		_securityNotification.setGmScreenname(gmScreenname);
	}

	/**
	* Returns the gm name of this security notification.
	*
	* @return the gm name of this security notification
	*/
	@Override
	public java.lang.String getGmName() {
		return _securityNotification.getGmName();
	}

	/**
	* Sets the gm name of this security notification.
	*
	* @param gmName the gm name of this security notification
	*/
	@Override
	public void setGmName(java.lang.String gmName) {
		_securityNotification.setGmName(gmName);
	}

	/**
	* Returns the gm email of this security notification.
	*
	* @return the gm email of this security notification
	*/
	@Override
	public java.lang.String getGmEmail() {
		return _securityNotification.getGmEmail();
	}

	/**
	* Sets the gm email of this security notification.
	*
	* @param gmEmail the gm email of this security notification
	*/
	@Override
	public void setGmEmail(java.lang.String gmEmail) {
		_securityNotification.setGmEmail(gmEmail);
	}

	/**
	* Returns the pc screenname of this security notification.
	*
	* @return the pc screenname of this security notification
	*/
	@Override
	public java.lang.String getPcScreenname() {
		return _securityNotification.getPcScreenname();
	}

	/**
	* Sets the pc screenname of this security notification.
	*
	* @param pcScreenname the pc screenname of this security notification
	*/
	@Override
	public void setPcScreenname(java.lang.String pcScreenname) {
		_securityNotification.setPcScreenname(pcScreenname);
	}

	/**
	* Returns the pc name of this security notification.
	*
	* @return the pc name of this security notification
	*/
	@Override
	public java.lang.String getPcName() {
		return _securityNotification.getPcName();
	}

	/**
	* Sets the pc name of this security notification.
	*
	* @param pcName the pc name of this security notification
	*/
	@Override
	public void setPcName(java.lang.String pcName) {
		_securityNotification.setPcName(pcName);
	}

	/**
	* Returns the pc email of this security notification.
	*
	* @return the pc email of this security notification
	*/
	@Override
	public java.lang.String getPcEmail() {
		return _securityNotification.getPcEmail();
	}

	/**
	* Sets the pc email of this security notification.
	*
	* @param pcEmail the pc email of this security notification
	*/
	@Override
	public void setPcEmail(java.lang.String pcEmail) {
		_securityNotification.setPcEmail(pcEmail);
	}

	/**
	* Returns the sec pc screenname of this security notification.
	*
	* @return the sec pc screenname of this security notification
	*/
	@Override
	public java.lang.String getSecPcScreenname() {
		return _securityNotification.getSecPcScreenname();
	}

	/**
	* Sets the sec pc screenname of this security notification.
	*
	* @param secPcScreenname the sec pc screenname of this security notification
	*/
	@Override
	public void setSecPcScreenname(java.lang.String secPcScreenname) {
		_securityNotification.setSecPcScreenname(secPcScreenname);
	}

	/**
	* Returns the sec pc name of this security notification.
	*
	* @return the sec pc name of this security notification
	*/
	@Override
	public java.lang.String getSecPcName() {
		return _securityNotification.getSecPcName();
	}

	/**
	* Sets the sec pc name of this security notification.
	*
	* @param secPcName the sec pc name of this security notification
	*/
	@Override
	public void setSecPcName(java.lang.String secPcName) {
		_securityNotification.setSecPcName(secPcName);
	}

	/**
	* Returns the sec pc email of this security notification.
	*
	* @return the sec pc email of this security notification
	*/
	@Override
	public java.lang.String getSecPcEmail() {
		return _securityNotification.getSecPcEmail();
	}

	/**
	* Sets the sec pc email of this security notification.
	*
	* @param secPcEmail the sec pc email of this security notification
	*/
	@Override
	public void setSecPcEmail(java.lang.String secPcEmail) {
		_securityNotification.setSecPcEmail(secPcEmail);
	}

	/**
	* Returns the fops screenname of this security notification.
	*
	* @return the fops screenname of this security notification
	*/
	@Override
	public java.lang.String getFopsScreenname() {
		return _securityNotification.getFopsScreenname();
	}

	/**
	* Sets the fops screenname of this security notification.
	*
	* @param fopsScreenname the fops screenname of this security notification
	*/
	@Override
	public void setFopsScreenname(java.lang.String fopsScreenname) {
		_securityNotification.setFopsScreenname(fopsScreenname);
	}

	/**
	* Returns the fops name of this security notification.
	*
	* @return the fops name of this security notification
	*/
	@Override
	public java.lang.String getFopsName() {
		return _securityNotification.getFopsName();
	}

	/**
	* Sets the fops name of this security notification.
	*
	* @param fopsName the fops name of this security notification
	*/
	@Override
	public void setFopsName(java.lang.String fopsName) {
		_securityNotification.setFopsName(fopsName);
	}

	/**
	* Returns the fops email of this security notification.
	*
	* @return the fops email of this security notification
	*/
	@Override
	public java.lang.String getFopsEmail() {
		return _securityNotification.getFopsEmail();
	}

	/**
	* Sets the fops email of this security notification.
	*
	* @param fopsEmail the fops email of this security notification
	*/
	@Override
	public void setFopsEmail(java.lang.String fopsEmail) {
		_securityNotification.setFopsEmail(fopsEmail);
	}

	/**
	* Returns the holidex code of this security notification.
	*
	* @return the holidex code of this security notification
	*/
	@Override
	public java.lang.String getHolidexCode() {
		return _securityNotification.getHolidexCode();
	}

	/**
	* Sets the holidex code of this security notification.
	*
	* @param holidexCode the holidex code of this security notification
	*/
	@Override
	public void setHolidexCode(java.lang.String holidexCode) {
		_securityNotification.setHolidexCode(holidexCode);
	}

	/**
	* Returns the hotel name of this security notification.
	*
	* @return the hotel name of this security notification
	*/
	@Override
	public java.lang.String getHotelName() {
		return _securityNotification.getHotelName();
	}

	/**
	* Sets the hotel name of this security notification.
	*
	* @param hotelName the hotel name of this security notification
	*/
	@Override
	public void setHotelName(java.lang.String hotelName) {
		_securityNotification.setHotelName(hotelName);
	}

	/**
	* Returns the impacted of this security notification.
	*
	* @return the impacted of this security notification
	*/
	@Override
	public java.lang.String getImpacted() {
		return _securityNotification.getImpacted();
	}

	/**
	* Sets the impacted of this security notification.
	*
	* @param impacted the impacted of this security notification
	*/
	@Override
	public void setImpacted(java.lang.String impacted) {
		_securityNotification.setImpacted(impacted);
	}

	/**
	* Returns the start date of this security notification.
	*
	* @return the start date of this security notification
	*/
	@Override
	public java.util.Date getStartDate() {
		return _securityNotification.getStartDate();
	}

	/**
	* Sets the start date of this security notification.
	*
	* @param startDate the start date of this security notification
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_securityNotification.setStartDate(startDate);
	}

	/**
	* Returns the end date of this security notification.
	*
	* @return the end date of this security notification
	*/
	@Override
	public java.util.Date getEndDate() {
		return _securityNotification.getEndDate();
	}

	/**
	* Sets the end date of this security notification.
	*
	* @param endDate the end date of this security notification
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_securityNotification.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _securityNotification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_securityNotification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _securityNotification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_securityNotification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _securityNotification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _securityNotification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_securityNotification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _securityNotification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_securityNotification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_securityNotification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_securityNotification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SecurityNotificationWrapper((SecurityNotification)_securityNotification.clone());
	}

	@Override
	public int compareTo(SecurityNotification securityNotification) {
		return _securityNotification.compareTo(securityNotification);
	}

	@Override
	public int hashCode() {
		return _securityNotification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<SecurityNotification> toCacheModel() {
		return _securityNotification.toCacheModel();
	}

	@Override
	public SecurityNotification toEscapedModel() {
		return new SecurityNotificationWrapper(_securityNotification.toEscapedModel());
	}

	@Override
	public SecurityNotification toUnescapedModel() {
		return new SecurityNotificationWrapper(_securityNotification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _securityNotification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _securityNotification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_securityNotification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SecurityNotificationWrapper)) {
			return false;
		}

		SecurityNotificationWrapper securityNotificationWrapper = (SecurityNotificationWrapper)obj;

		if (Validator.equals(_securityNotification,
					securityNotificationWrapper._securityNotification)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SecurityNotification getWrappedSecurityNotification() {
		return _securityNotification;
	}

	@Override
	public SecurityNotification getWrappedModel() {
		return _securityNotification;
	}

	@Override
	public void resetOriginalValues() {
		_securityNotification.resetOriginalValues();
	}

	private SecurityNotification _securityNotification;
}