package com.ihg.wallportlet.notification;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class WallNotificationPortletb extends MVCPortlet {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

	public static List<MBMessage> getMessages() throws SystemException {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -48);
		Date date = cal.getTime();

		// DynamicQuery dynamicQuery =
		// DynamicQueryFactoryUtil.forClass(MBMessage.class).add(RestrictionsFactoryUtil.ge("modifiedDate",
		// date));
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class);
		
		/*DynamicQuery dynamicQuery2 = 
				DynamicQueryFactoryUtil.forClass(MBMessage.class).add(RestrictionsFactoryUtil.ge("modifiedDate", date)).
				add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("groupId", groupList.get(0)), 
						RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("groupId", groupList.get(1)), 
								RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("groupId", groupList.get(2)),
										RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("groupId", groupList.get(3)),
												RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("groupId", groupList.get(4)),
														RestrictionsFactoryUtil.eq("groupId", groupList.get(5))))))));*/
		
		List<MBMessage> messageList = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);

		return messageList;

	}

	public void sendWallNotifications(ActionRequest actionRequest, ActionResponse actionResponse) {
		// TODO Auto-generated method stub

		try {

			// List<Subscription> threadSubscriberList;

			Set<Long> threadIdList = new LinkedHashSet();
			Set<Long> groupIdList = new LinkedHashSet();
			Map<Long, List<Subscription>> threadSubscriberList = new LinkedHashMap();
			Map<Long, List<Subscription>> categorySubscriberList = new LinkedHashMap();
			Map<Long, List<MBMessage>> threadMessageList = new LinkedHashMap();
			Map<Long, Set<Long>> groupThreadList = new LinkedHashMap();

			List<MBMessage> messageList = getMessages();
			long companyId = messageList.get(0).getCompanyId();

			System.out.println("Admin email: " + PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));

			for (MBMessage message : messageList) {
				if (!isNumeric(message.getBody())) {
					threadIdList.add(message.getThreadId());
					groupIdList.add(message.getGroupId());
					groupThreadList.put(message.getGroupId(), new LinkedHashSet<Long>());
					// groupThreadList.put(message.getThreadId(),
					// message.getGroupId());
				}

				// threadSubscriberList =
				// getThreadSubscribers(message.getCompanyId(),
				// "com.liferay.portlet.messageboards.model.MBThread",
				// message.getThreadId());
			}

			for (MBMessage message : messageList) {
				if(groupThreadList.containsKey(message.getGroupId()) ){
					groupThreadList.get(message.getGroupId()).add(message.getThreadId());
				}
				
			}

			for (long threadId : threadIdList) {
				threadSubscriberList.put(threadId,
						getThreadSubscribers(companyId, "com.liferay.portlet.messageboards.model.MBThread", threadId));
			}

			for (long groupId : groupIdList) {
				categorySubscriberList.put(groupId,
						getThreadSubscribers(companyId, "com.liferay.portlet.messageboards.model.MBCategory", groupId));
			}

			for (long threadId : threadIdList) {
				List<MBMessage> tempMessageList = new ArrayList();
				for (MBMessage message : messageList) {
					if (message.getThreadId() == threadId) {
						tempMessageList.add(message);
					}
				}
				threadMessageList.put(threadId, tempMessageList);
			}

			for (long threadId : threadIdList) {
				StringBuffer messageBody = new StringBuffer("");
				StringBuffer messageSubject = new StringBuffer(
						threadMessageList.get(threadId).get(0).getSubject().toString());
				for (MBMessage message : threadMessageList.get(threadId)) {
					messageBody.append("Subject: " + " " + message.getSubject());
					messageBody.append("\n");
					messageBody.append("Msg: " + " " + message.getBody() + "\n\n");
				}
				System.out.println("\n");
				System.out.println("Thread " + threadId + ": \n" + messageBody.toString());
				System.out.print("This thread will be posted to following mail addresses:");
				for (Subscription threadSubscription : threadSubscriberList.get(threadId)) {

					InternetAddress fromAddress = new InternetAddress(
							PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));
					InternetAddress toAddress = new InternetAddress(
							UserLocalServiceUtil.getUser(threadSubscription.getUserId()).getEmailAddress());
					MailMessage mailMessage = new MailMessage();
					mailMessage.setTo(toAddress);
					mailMessage.setFrom(fromAddress);
					mailMessage.setSubject("Thread Subscription: " + messageSubject.toString());
					mailMessage.setBody(messageBody.toString());
					MailServiceUtil.sendEmail(mailMessage);

					System.out.print(
							UserLocalServiceUtil.getUser(threadSubscription.getUserId()).getEmailAddress() + " ");

				}

				System.out.println();
			}

			for (long groupId : groupIdList) {
				for (Subscription subscription : categorySubscriberList.get(groupId)) {

					// This will be refactored as a method
					for (long threadId : groupThreadList.get(groupId)) {
						StringBuffer messageBody = new StringBuffer("");
						StringBuffer messageSubject = new StringBuffer(
								threadMessageList.get(threadId).get(0).getSubject().toString());
						
						for (MBMessage message : threadMessageList.get(threadId)) {
							messageBody.append("Subject: " + " " + message.getSubject());
							messageBody.append("\n");
							messageBody.append("Msg: " + " " + message.getBody() + "\n\n");
						}
						
						System.out.println("\n");
						System.out.println("Thread " + threadId + ": \n" + messageBody.toString());
						System.out.print("This community notification will be posted to following mail addresses:");

						InternetAddress fromAddress = new InternetAddress(PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));
						
						InternetAddress toAddress = new InternetAddress(
								UserLocalServiceUtil.getUser(subscription.getUserId()).getEmailAddress());
						MailMessage mailMessage = new MailMessage();
						mailMessage.setTo(toAddress);
						mailMessage.setFrom(fromAddress);
						mailMessage.setSubject("Community Subscription: " + messageSubject.toString());
						mailMessage.setBody(messageBody.toString());
						MailServiceUtil.sendEmail(mailMessage);

						System.out
								.print(UserLocalServiceUtil.getUser(subscription.getUserId()).getEmailAddress() + " ");

					}
				}
			}

			Date date = new Date();
			System.out.println("Triggered..." + date.toString());

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Subscription> getThreadSubscribers(Long companyId, String className, long classPK)
			throws SystemException {

		List<Subscription> subscriptionList = SubscriptionLocalServiceUtil.getSubscriptions(companyId, className,
				classPK);

		return subscriptionList;
	}

}
