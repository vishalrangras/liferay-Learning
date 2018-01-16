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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author vishal.rangras
 * @generated
 */
public class SecurityNotificationSoap implements Serializable {
	public static SecurityNotificationSoap toSoapModel(
		SecurityNotification model) {
		SecurityNotificationSoap soapModel = new SecurityNotificationSoap();

		soapModel.setNotificationId(model.getNotificationId());
		soapModel.setGmScreenname(model.getGmScreenname());
		soapModel.setGmName(model.getGmName());
		soapModel.setGmEmail(model.getGmEmail());
		soapModel.setPcScreenname(model.getPcScreenname());
		soapModel.setPcName(model.getPcName());
		soapModel.setPcEmail(model.getPcEmail());
		soapModel.setSecPcScreenname(model.getSecPcScreenname());
		soapModel.setSecPcName(model.getSecPcName());
		soapModel.setSecPcEmail(model.getSecPcEmail());
		soapModel.setFopsScreenname(model.getFopsScreenname());
		soapModel.setFopsName(model.getFopsName());
		soapModel.setFopsEmail(model.getFopsEmail());
		soapModel.setHolidexCode(model.getHolidexCode());
		soapModel.setHotelName(model.getHotelName());
		soapModel.setImpacted(model.getImpacted());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static SecurityNotificationSoap[] toSoapModels(
		SecurityNotification[] models) {
		SecurityNotificationSoap[] soapModels = new SecurityNotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SecurityNotificationSoap[][] toSoapModels(
		SecurityNotification[][] models) {
		SecurityNotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SecurityNotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SecurityNotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SecurityNotificationSoap[] toSoapModels(
		List<SecurityNotification> models) {
		List<SecurityNotificationSoap> soapModels = new ArrayList<SecurityNotificationSoap>(models.size());

		for (SecurityNotification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SecurityNotificationSoap[soapModels.size()]);
	}

	public SecurityNotificationSoap() {
	}

	public long getPrimaryKey() {
		return _notificationId;
	}

	public void setPrimaryKey(long pk) {
		setNotificationId(pk);
	}

	public long getNotificationId() {
		return _notificationId;
	}

	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;
	}

	public String getGmScreenname() {
		return _gmScreenname;
	}

	public void setGmScreenname(String gmScreenname) {
		_gmScreenname = gmScreenname;
	}

	public String getGmName() {
		return _gmName;
	}

	public void setGmName(String gmName) {
		_gmName = gmName;
	}

	public String getGmEmail() {
		return _gmEmail;
	}

	public void setGmEmail(String gmEmail) {
		_gmEmail = gmEmail;
	}

	public String getPcScreenname() {
		return _pcScreenname;
	}

	public void setPcScreenname(String pcScreenname) {
		_pcScreenname = pcScreenname;
	}

	public String getPcName() {
		return _pcName;
	}

	public void setPcName(String pcName) {
		_pcName = pcName;
	}

	public String getPcEmail() {
		return _pcEmail;
	}

	public void setPcEmail(String pcEmail) {
		_pcEmail = pcEmail;
	}

	public String getSecPcScreenname() {
		return _secPcScreenname;
	}

	public void setSecPcScreenname(String secPcScreenname) {
		_secPcScreenname = secPcScreenname;
	}

	public String getSecPcName() {
		return _secPcName;
	}

	public void setSecPcName(String secPcName) {
		_secPcName = secPcName;
	}

	public String getSecPcEmail() {
		return _secPcEmail;
	}

	public void setSecPcEmail(String secPcEmail) {
		_secPcEmail = secPcEmail;
	}

	public String getFopsScreenname() {
		return _fopsScreenname;
	}

	public void setFopsScreenname(String fopsScreenname) {
		_fopsScreenname = fopsScreenname;
	}

	public String getFopsName() {
		return _fopsName;
	}

	public void setFopsName(String fopsName) {
		_fopsName = fopsName;
	}

	public String getFopsEmail() {
		return _fopsEmail;
	}

	public void setFopsEmail(String fopsEmail) {
		_fopsEmail = fopsEmail;
	}

	public String getHolidexCode() {
		return _holidexCode;
	}

	public void setHolidexCode(String holidexCode) {
		_holidexCode = holidexCode;
	}

	public String getHotelName() {
		return _hotelName;
	}

	public void setHotelName(String hotelName) {
		_hotelName = hotelName;
	}

	public String getImpacted() {
		return _impacted;
	}

	public void setImpacted(String impacted) {
		_impacted = impacted;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
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
}