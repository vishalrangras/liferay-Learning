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

import com.ihg.me2.model.EmailAttachment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmailAttachment in entity cache.
 *
 * @author vishal.rangras
 * @see EmailAttachment
 * @generated
 */
public class EmailAttachmentCacheModel implements CacheModel<EmailAttachment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{EMAIL_ATTACHMENT_ID=");
		sb.append(EMAIL_ATTACHMENT_ID);
		sb.append(", emailReminderId=");
		sb.append(emailReminderId);
		sb.append(", attachmentFileName=");
		sb.append(attachmentFileName);
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
	public EmailAttachment toEntityModel() {
		EmailAttachmentImpl emailAttachmentImpl = new EmailAttachmentImpl();

		emailAttachmentImpl.setEMAIL_ATTACHMENT_ID(EMAIL_ATTACHMENT_ID);
		emailAttachmentImpl.setEmailReminderId(emailReminderId);

		if (attachmentFileName == null) {
			emailAttachmentImpl.setAttachmentFileName(StringPool.BLANK);
		}
		else {
			emailAttachmentImpl.setAttachmentFileName(attachmentFileName);
		}

		if (createUserId == null) {
			emailAttachmentImpl.setCreateUserId(StringPool.BLANK);
		}
		else {
			emailAttachmentImpl.setCreateUserId(createUserId);
		}

		if (createTimestamp == Long.MIN_VALUE) {
			emailAttachmentImpl.setCreateTimestamp(null);
		}
		else {
			emailAttachmentImpl.setCreateTimestamp(new Date(createTimestamp));
		}

		if (lastUpdateUserId == null) {
			emailAttachmentImpl.setLastUpdateUserId(StringPool.BLANK);
		}
		else {
			emailAttachmentImpl.setLastUpdateUserId(lastUpdateUserId);
		}

		if (lastUpdateTimestamp == Long.MIN_VALUE) {
			emailAttachmentImpl.setLastUpdateTimestamp(null);
		}
		else {
			emailAttachmentImpl.setLastUpdateTimestamp(new Date(
					lastUpdateTimestamp));
		}

		emailAttachmentImpl.resetOriginalValues();

		return emailAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		EMAIL_ATTACHMENT_ID = objectInput.readLong();
		emailReminderId = objectInput.readLong();
		attachmentFileName = objectInput.readUTF();
		createUserId = objectInput.readUTF();
		createTimestamp = objectInput.readLong();
		lastUpdateUserId = objectInput.readUTF();
		lastUpdateTimestamp = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(EMAIL_ATTACHMENT_ID);
		objectOutput.writeLong(emailReminderId);

		if (attachmentFileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachmentFileName);
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

	public long EMAIL_ATTACHMENT_ID;
	public long emailReminderId;
	public String attachmentFileName;
	public String createUserId;
	public long createTimestamp;
	public String lastUpdateUserId;
	public long lastUpdateTimestamp;
}