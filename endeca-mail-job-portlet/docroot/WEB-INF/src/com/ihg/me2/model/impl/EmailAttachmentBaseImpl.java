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
import com.ihg.me2.service.EmailAttachmentLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the EmailAttachment service. Represents a row in the &quot;email_attachment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmailAttachmentImpl}.
 * </p>
 *
 * @author vishal.rangras
 * @see EmailAttachmentImpl
 * @see com.ihg.me2.model.EmailAttachment
 * @generated
 */
public abstract class EmailAttachmentBaseImpl extends EmailAttachmentModelImpl
	implements EmailAttachment {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a email attachment model instance should use the {@link EmailAttachment} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmailAttachmentLocalServiceUtil.addEmailAttachment(this);
		}
		else {
			EmailAttachmentLocalServiceUtil.updateEmailAttachment(this);
		}
	}
}