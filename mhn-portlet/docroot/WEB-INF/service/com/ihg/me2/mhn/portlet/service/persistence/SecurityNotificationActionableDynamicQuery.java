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

package com.ihg.me2.mhn.portlet.service.persistence;

import com.ihg.me2.mhn.portlet.model.SecurityNotification;
import com.ihg.me2.mhn.portlet.service.SecurityNotificationLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author vishal.rangras
 * @generated
 */
public abstract class SecurityNotificationActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public SecurityNotificationActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(SecurityNotificationLocalServiceUtil.getService());
		setClass(SecurityNotification.class);

		setClassLoader(com.ihg.me2.mhn.portlet.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("notificationId");
	}
}