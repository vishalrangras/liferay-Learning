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

package com.ihg.me2.service.persistence;

import com.ihg.me2.model.EmailAttachment;
import com.ihg.me2.service.EmailAttachmentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author vishal.rangras
 * @generated
 */
public abstract class EmailAttachmentActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public EmailAttachmentActionableDynamicQuery() throws SystemException {
		setBaseLocalService(EmailAttachmentLocalServiceUtil.getService());
		setClass(EmailAttachment.class);

		setClassLoader(com.ihg.me2.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("EMAIL_ATTACHMENT_ID");
	}
}