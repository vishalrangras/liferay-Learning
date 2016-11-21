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

package com.encephalsparks.guestbook.service.impl;

import com.encephalsparks.guestbook.EntryEmailException;
import com.encephalsparks.guestbook.EntryMessageException;
import com.encephalsparks.guestbook.EntryNameException;
import com.encephalsparks.guestbook.model.Entry;
import com.encephalsparks.guestbook.service.base.EntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.encephalsparks.guestbook.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author vishal.rangras
 * @see com.encephalsparks.guestbook.service.base.EntryLocalServiceBaseImpl
 * @see com.encephalsparks.guestbook.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.encephalsparks.guestbook.service.EntryLocalServiceUtil} to access the
	 * entry local service.
	 */

	public List<Entry> getEntries(long groupId, long guestbookId)
			throws SystemException {

		return entryPersistence.findByG_G(groupId, guestbookId);
	}

	public List<Entry> getEntries(long groupId, long guestbookId, int start,
			int end) throws SystemException {

		return entryPersistence.findByG_G(groupId, guestbookId, start, end);
	}

	protected void validate(String name, String email, String entry)
			throws PortalException {
		if (Validator.isNull(name)) {
			throw new EntryNameException();
		}

		if (!Validator.isEmailAddress(email)) {
			throw new EntryEmailException();
		}

		if (Validator.isNull(entry)) {
			throw new EntryMessageException();
		}
	}

	public Entry addEntry(long userId, long guestbookId, String name,
			String email, String message, ServiceContext serviceContext)
			throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name, email, message);

		long entryId = counterLocalService.increment();

		Entry entry = entryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setGuestbookId(guestbookId);
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);

		entryPersistence.update(entry);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				Entry.class.getName(), entryId, false, true, true);

		return entry;

	}

	public Entry deleteEntry(long entryId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Entry entry = getEntry(entryId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				Entry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				entryId);

		entry = deleteEntry(entryId);

		return entry;
	}

	public Entry updateEntry(long userId, long guestbookId, long entryId, String name, String email,
			String message, ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();

		validate(name, email, message);

		Entry entry = getEntry(entryId);
		
		entry.setUserId(userId);
	    entry.setUserName(user.getFullName());
	    entry.setName(name);
	    entry.setEmail(email);
	    entry.setMessage(message);
	    entry.setModifiedDate(serviceContext.getModifiedDate(now));
	    entry.setExpandoBridgeAttributes(serviceContext);
		
		entryPersistence.update(entry);
		
		resourceLocalService.updateResources(
		        user.getCompanyId(), groupId, Entry.class.getName(), entryId,
		        serviceContext.getGroupPermissions(),
		        serviceContext.getGuestPermissions());

		return entry;
	}

}