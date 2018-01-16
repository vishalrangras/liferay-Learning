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

package com.ihg.me2.model.impl;

import com.ihg.me2.model.EmailReminder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmailReminder in entity cache.
 *
 * @author vishal.rangras
 * @see EmailReminder
 * @generated
 */
public class EmailReminderCacheModel implements CacheModel<EmailReminder>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{emailReminderId=");
		sb.append(emailReminderId);
		sb.append(", submitterName=");
		sb.append(submitterName);
		sb.append(", submitterEmailId=");
		sb.append(submitterEmailId);
		sb.append(", reminderNumber=");
		sb.append(reminderNumber);
		sb.append(", scheduleTimestamp=");
		sb.append(scheduleTimestamp);
		sb.append(", emailSubjectText=");
		sb.append(emailSubjectText);
		sb.append(", emailBodyText=");
		sb.append(emailBodyText);
		sb.append(", statusCode=");
		sb.append(statusCode);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createTimestamp=");
		sb.append(createTimestamp);
		sb.append(", lastUpdateUserId=");
		sb.append(lastUpdateUserId);
		sb.append(", lastUpdateTimestamp=");
		sb.append(lastUpdateTimestamp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmailReminder toEntityModel() {
		EmailReminderImpl emailReminderImpl = new EmailReminderImpl();

		emailReminderImpl.setEmailReminderId(emailReminderId);

		if (submitterName == null) {
			emailReminderImpl.setSubmitterName(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setSubmitterName(submitterName);
		}

		if (submitterEmailId == null) {
			emailReminderImpl.setSubmitterEmailId(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setSubmitterEmailId(submitterEmailId);
		}

		emailReminderImpl.setReminderNumber(reminderNumber);

		if (scheduleTimestamp == Long.MIN_VALUE) {
			emailReminderImpl.setScheduleTimestamp(null);
		}
		else {
			emailReminderImpl.setScheduleTimestamp(new Date(scheduleTimestamp));
		}

		if (emailSubjectText == null) {
			emailReminderImpl.setEmailSubjectText(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setEmailSubjectText(emailSubjectText);
		}

		if (emailBodyText == null) {
			emailReminderImpl.setEmailBodyText(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setEmailBodyText(emailBodyText);
		}

		if (statusCode == null) {
			emailReminderImpl.setStatusCode(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setStatusCode(statusCode);
		}

		if (createUserId == null) {
			emailReminderImpl.setCreateUserId(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setCreateUserId(createUserId);
		}

		if (createTimestamp == Long.MIN_VALUE) {
			emailReminderImpl.setCreateTimestamp(null);
		}
		else {
			emailReminderImpl.setCreateTimestamp(new Date(createTimestamp));
		}

		if (lastUpdateUserId == null) {
			emailReminderImpl.setLastUpdateUserId(StringPool.BLANK);
		}
		else {
			emailReminderImpl.setLastUpdateUserId(lastUpdateUserId);
		}

		if (lastUpdateTimestamp == Long.MIN_VALUE) {
			emailReminderImpl.setLastUpdateTimestamp(null);
		}
		else {
			emailReminderImpl.setLastUpdateTimestamp(new Date(
					lastUpdateTimestamp));
		}

		emailReminderImpl.resetOriginalValues();

		return emailReminderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		emailReminderId = objectInput.readLong();
		submitterName = objectInput.readUTF();
		submitterEmailId = objectInput.readUTF();
		reminderNumber = objectInput.readInt();
		scheduleTimestamp = objectInput.readLong();
		emailSubjectText = objectInput.readUTF();
		emailBodyText = objectInput.readUTF();
		statusCode = objectInput.readUTF();
		createUserId = objectInput.readUTF();
		createTimestamp = objectInput.readLong();
		lastUpdateUserId = objectInput.readUTF();
		lastUpdateTimestamp = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(emailReminderId);

		if (submitterName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submitterName);
		}

		if (submitterEmailId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submitterEmailId);
		}

		objectOutput.writeInt(reminderNumber);
		objectOutput.writeLong(scheduleTimestamp);

		if (emailSubjectText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailSubjectText);
		}

		if (emailBodyText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailBodyText);
		}

		if (statusCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusCode);
		}

		if (createUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createUserId);
		}

		objectOutput.writeLong(createTimestamp);

		if (lastUpdateUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastUpdateUserId);
		}

		objectOutput.writeLong(lastUpdateTimestamp);
	}

	public long emailReminderId;
	public String submitterName;
	public String submitterEmailId;
	public int reminderNumber;
	public long scheduleTimestamp;
	public String emailSubjectText;
	public String emailBodyText;
	public String statusCode;
	public String createUserId;
	public long createTimestamp;
	public String lastUpdateUserId;
	public long lastUpdateTimestamp;
}