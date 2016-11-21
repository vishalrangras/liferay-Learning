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

package com.encephalsparks.guestbook.service.persistence;

import com.encephalsparks.guestbook.model.Guestbook;
import com.encephalsparks.guestbook.service.GuestbookLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author vishal.rangras
 * @generated
 */
public abstract class GuestbookActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public GuestbookActionableDynamicQuery() throws SystemException {
		setBaseLocalService(GuestbookLocalServiceUtil.getService());
		setClass(Guestbook.class);

		setClassLoader(com.encephalsparks.guestbook.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("guestbookId");
	}
}