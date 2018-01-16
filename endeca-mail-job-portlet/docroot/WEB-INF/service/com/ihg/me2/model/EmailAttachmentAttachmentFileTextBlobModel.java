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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the attachmentFileText column in EmailAttachment.
 *
 * @author vishal.rangras
 * @see EmailAttachment
 * @generated
 */
public class EmailAttachmentAttachmentFileTextBlobModel {
	public EmailAttachmentAttachmentFileTextBlobModel() {
	}

	public EmailAttachmentAttachmentFileTextBlobModel(long EMAIL_ATTACHMENT_ID) {
		_EMAIL_ATTACHMENT_ID = EMAIL_ATTACHMENT_ID;
	}

	public EmailAttachmentAttachmentFileTextBlobModel(
		long EMAIL_ATTACHMENT_ID, Blob attachmentFileTextBlob) {
		_EMAIL_ATTACHMENT_ID = EMAIL_ATTACHMENT_ID;
		_attachmentFileTextBlob = attachmentFileTextBlob;
	}

	public long getEMAIL_ATTACHMENT_ID() {
		return _EMAIL_ATTACHMENT_ID;
	}

	public void setEMAIL_ATTACHMENT_ID(long EMAIL_ATTACHMENT_ID) {
		_EMAIL_ATTACHMENT_ID = EMAIL_ATTACHMENT_ID;
	}

	public Blob getAttachmentFileTextBlob() {
		return _attachmentFileTextBlob;
	}

	public void setAttachmentFileTextBlob(Blob attachmentFileTextBlob) {
		_attachmentFileTextBlob = attachmentFileTextBlob;
	}

	private long _EMAIL_ATTACHMENT_ID;
	private Blob _attachmentFileTextBlob;
}