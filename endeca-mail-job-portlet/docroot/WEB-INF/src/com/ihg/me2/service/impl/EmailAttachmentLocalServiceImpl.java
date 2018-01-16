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

package com.ihg.me2.service.impl;

import com.ihg.me2.NoSuchEmailAttachmentException;
import com.ihg.me2.model.EmailAttachment;
import com.ihg.me2.service.base.EmailAttachmentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the email attachment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.me2.service.EmailAttachmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.base.EmailAttachmentLocalServiceBaseImpl
 * @see com.ihg.me2.service.EmailAttachmentLocalServiceUtil
 */
public class EmailAttachmentLocalServiceImpl
	extends EmailAttachmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.me2.service.EmailAttachmentLocalServiceUtil} to access the email attachment local service.
	 */
	
	public EmailAttachment getEmailAttachmentById(long emailAttachmentId) throws NoSuchEmailAttachmentException, SystemException{
		return emailAttachmentPersistence.findByEmailAttachmentId(emailAttachmentId);
	}
	
	public List<EmailAttachment> getEmailAttachmentByReminderId(long emailReminderId) throws SystemException{
		return emailAttachmentPersistence.findByEmailReminderId(emailReminderId);
	}
	
	public EmailAttachment addEmailAttachment(long emailReminderId, String attachmentFileName, OutputBlob attachmentFileTxt, String createUserId,
			Date createTimestamp, String lastUpdateUserId, Date lastUpdateTimestamp) throws SystemException{
		
		long emailAttachmentId = CounterLocalServiceUtil.increment(EmailAttachment.class.getName());
		EmailAttachment emailAttachment = emailAttachmentPersistence.create(emailAttachmentId);
		emailAttachment.setEmailReminderId(emailReminderId);
		emailAttachment.setAttachmentFileName(attachmentFileName);
		emailAttachment.setAttachmentFileText(attachmentFileTxt);
		emailAttachment.setCreateUserId(createUserId);
		emailAttachment.setCreateTimestamp(createTimestamp);
		emailAttachment.setLastUpdateUserId(lastUpdateUserId);
		emailAttachment.setLastUpdateTimestamp(lastUpdateTimestamp);
		emailAttachment.persist();
		return emailAttachment;
		
	}
	
	public EmailAttachment updateEmailAttachment(long emailAttachmentId, String attachmentFileName, OutputBlob attachmentFileTxt, 
			String lastUpdateUserId, Date lastUpdateTimestamp) throws SystemException, NoSuchEmailAttachmentException {
		
		EmailAttachment emailAttachment = emailAttachmentPersistence.findByEmailAttachmentId(emailAttachmentId);
		emailAttachment.setAttachmentFileName(attachmentFileName);
		emailAttachment.setAttachmentFileText(attachmentFileTxt);
		emailAttachment.setLastUpdateUserId(lastUpdateUserId);
		emailAttachment.setLastUpdateTimestamp(lastUpdateTimestamp);
		emailAttachmentPersistence.update(emailAttachment);
		return emailAttachment;
	}
	
}