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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the EmailReminder service. Represents a row in the &quot;email_reminder&quot; database table, with each column mapped to a property of this class.
 *
 * @author vishal.rangras
 * @see EmailReminderModel
 * @see com.ihg.me2.model.impl.EmailReminderImpl
 * @see com.ihg.me2.model.impl.EmailReminderModelImpl
 * @generated
 */
public interface EmailReminder extends EmailReminderModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ihg.me2.model.impl.EmailReminderImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}