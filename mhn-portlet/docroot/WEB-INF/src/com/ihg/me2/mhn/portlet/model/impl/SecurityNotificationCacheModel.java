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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SecurityNotification in entity cache.
 *
 * @author vishal.rangras
 * @see SecurityNotification
 * @generated
 */
public class SecurityNotificationCacheModel implements CacheModel<SecurityNotification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{notificationId=");
		sb.append(notificationId);
		sb.append(", gmScreenname=");
		sb.append(gmScreenname);
		sb.append(", gmName=");
		sb.append(gmName);
		sb.append(", gmEmail=");
		sb.append(gmEmail);
		sb.append(", pcScreenname=");
		sb.append(pcScreenname);
		sb.append(", pcName=");
		sb.append(pcName);
		sb.append(", pcEmail=");
		sb.append(pcEmail);
		sb.append(", secPcScreenname=");
		sb.append(secPcScreenname);
		sb.append(", secPcName=");
		sb.append(secPcName);
		sb.append(", secPcEmail=");
		sb.append(secPcEmail);
		sb.append(", fopsScreenname=");
		sb.append(fopsScreenname);
		sb.append(", fopsName=");
		sb.append(fopsName);
		sb.append(", fopsEmail=");
		sb.append(fopsEmail);
		sb.append(", holidexCode=");
		sb.append(holidexCode);
		sb.append(", hotelName=");
		sb.append(hotelName);
		sb.append(", impacted=");
		sb.append(impacted);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SecurityNotification toEntityModel() {
		SecurityNotificationImpl securityNotificationImpl = new SecurityNotificationImpl();

		securityNotificationImpl.setNotificationId(notificationId);

		if (gmScreenname == null) {
			securityNotificationImpl.setGmScreenname(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setGmScreenname(gmScreenname);
		}

		if (gmName == null) {
			securityNotificationImpl.setGmName(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setGmName(gmName);
		}

		if (gmEmail == null) {
			securityNotificationImpl.setGmEmail(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setGmEmail(gmEmail);
		}

		if (pcScreenname == null) {
			securityNotificationImpl.setPcScreenname(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setPcScreenname(pcScreenname);
		}

		if (pcName == null) {
			securityNotificationImpl.setPcName(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setPcName(pcName);
		}

		if (pcEmail == null) {
			securityNotificationImpl.setPcEmail(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setPcEmail(pcEmail);
		}

		if (secPcScreenname == null) {
			securityNotificationImpl.setSecPcScreenname(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setSecPcScreenname(secPcScreenname);
		}

		if (secPcName == null) {
			securityNotificationImpl.setSecPcName(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setSecPcName(secPcName);
		}

		if (secPcEmail == null) {
			securityNotificationImpl.setSecPcEmail(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setSecPcEmail(secPcEmail);
		}

		if (fopsScreenname == null) {
			securityNotificationImpl.setFopsScreenname(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setFopsScreenname(fopsScreenname);
		}

		if (fopsName == null) {
			securityNotificationImpl.setFopsName(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setFopsName(fopsName);
		}

		if (fopsEmail == null) {
			securityNotificationImpl.setFopsEmail(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setFopsEmail(fopsEmail);
		}

		if (holidexCode == null) {
			securityNotificationImpl.setHolidexCode(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setHolidexCode(holidexCode);
		}

		if (hotelName == null) {
			securityNotificationImpl.setHotelName(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setHotelName(hotelName);
		}

		if (impacted == null) {
			securityNotificationImpl.setImpacted(StringPool.BLANK);
		}
		else {
			securityNotificationImpl.setImpacted(impacted);
		}

		if (startDate == Long.MIN_VALUE) {
			securityNotificationImpl.setStartDate(null);
		}
		else {
			securityNotificationImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			securityNotificationImpl.setEndDate(null);
		}
		else {
			securityNotificationImpl.setEndDate(new Date(endDate));
		}

		securityNotificationImpl.resetOriginalValues();

		return securityNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificationId = objectInput.readLong();
		gmScreenname = objectInput.readUTF();
		gmName = objectInput.readUTF();
		gmEmail = objectInput.readUTF();
		pcScreenname = objectInput.readUTF();
		pcName = objectInput.readUTF();
		pcEmail = objectInput.readUTF();
		secPcScreenname = objectInput.readUTF();
		secPcName = objectInput.readUTF();
		secPcEmail = objectInput.readUTF();
		fopsScreenname = objectInput.readUTF();
		fopsName = objectInput.readUTF();
		fopsEmail = objectInput.readUTF();
		holidexCode = objectInput.readUTF();
		hotelName = objectInput.readUTF();
		impacted = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificationId);

		if (gmScreenname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gmScreenname);
		}

		if (gmName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gmName);
		}

		if (gmEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gmEmail);
		}

		if (pcScreenname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcScreenname);
		}

		if (pcName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcName);
		}

		if (pcEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcEmail);
		}

		if (secPcScreenname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secPcScreenname);
		}

		if (secPcName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secPcName);
		}

		if (secPcEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secPcEmail);
		}

		if (fopsScreenname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fopsScreenname);
		}

		if (fopsName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fopsName);
		}

		if (fopsEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fopsEmail);
		}

		if (holidexCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(holidexCode);
		}

		if (hotelName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hotelName);
		}

		if (impacted == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(impacted);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long notificationId;
	public String gmScreenname;
	public String gmName;
	public String gmEmail;
	public String pcScreenname;
	public String pcName;
	public String pcEmail;
	public String secPcScreenname;
	public String secPcName;
	public String secPcEmail;
	public String fopsScreenname;
	public String fopsName;
	public String fopsEmail;
	public String holidexCode;
	public String hotelName;
	public String impacted;
	public long startDate;
	public long endDate;
}