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
import com.ihg.me2.model.EmailAttachmentAttachmentFileTextBlobModel;
import com.ihg.me2.service.EmailAttachmentLocalServiceUtil;
import com.ihg.me2.service.base.EmailAttachmentServiceBaseImpl;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Base64;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the email attachment remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ihg.me2.service.EmailAttachmentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.me2.service.base.EmailAttachmentServiceBaseImpl
 * @see com.ihg.me2.service.EmailAttachmentServiceUtil
 */
public class EmailAttachmentServiceImpl extends EmailAttachmentServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.ihg.me2.service.EmailAttachmentServiceUtil} to access the email
	 * attachment remote service.
	 */

	public EmailAttachment getEmailAttachmentById(long emailAttachmentId)
			throws NoSuchEmailAttachmentException, SystemException {
		return EmailAttachmentLocalServiceUtil.getEmailAttachmentById(emailAttachmentId);
	}

	public List<EmailAttachment> getEmailAttachmentByReminderId(long emailReminderId) throws SystemException {
		return EmailAttachmentLocalServiceUtil.getEmailAttachmentByReminderId(emailReminderId);
	}

	/*public EmailAttachment addEmailAttachment(long emailReminderId, String attachmentFileName,
			OutputBlob attachmentFileTxt, String createUserId, Date createTimestamp, String lastUpdateUserId,
			Date lastUpdateTimestamp) throws SystemException {
		return EmailAttachmentLocalServiceUtil.addEmailAttachment(emailReminderId, attachmentFileName,
				attachmentFileTxt, createUserId, createTimestamp, lastUpdateUserId, lastUpdateTimestamp);
	}*/

	/*public EmailAttachment updateEmailAttachment(long emailAttachmentId, String attachmentFileName,
			OutputBlob attachmentFileTxt, String lastUpdateUserId, Date lastUpdateTimestamp)
			throws SystemException, NoSuchEmailAttachmentException {
		return EmailAttachmentLocalServiceUtil.updateEmailAttachment(emailAttachmentId, attachmentFileName,
				attachmentFileTxt, lastUpdateUserId, lastUpdateTimestamp);
	}*/
	
	public String getEmailAttachmentFileById(long emailAttachmentId) throws PortalException, SystemException{
		EmailAttachment emailAttachment = EmailAttachmentLocalServiceUtil.getEmailAttachment(emailAttachmentId);
		Blob blob = emailAttachment.getAttachmentFileText();
		String attachmentFileText = null;
		 
		try {
			byte[] blobBytes = blob.getBytes(1, (int) blob.length());
			attachmentFileText = new String(blobBytes);
			
			System.out.println(attachmentFileText);
			for(byte data:blobBytes){
				System.out.print(data+",");
			}
			FileOutputStream outputStream = new FileOutputStream("c:/test/sign.jpg");
	        outputStream.write(blobBytes);
	        outputStream.close();
	        blob.free();
	        
	        return Base64.encode(blobBytes);
	        
	        
	        
	        //return blobBytes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}