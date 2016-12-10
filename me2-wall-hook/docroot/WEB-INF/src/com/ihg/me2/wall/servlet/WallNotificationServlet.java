package com.ihg.me2.wall.servlet;

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
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WallNotificationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sendWallNotifications();
	}

	private static List<Long> groupIds;

	public static List<Long> getGroupIds() throws PortalException, SystemException {

		if (groupIds == null) {
			System.out.println("Instantiating the groupList...");
			groupIds = new ArrayList();

			StringTokenizer st = new StringTokenizer(PropsUtil.get("groupList"));

			while (st.hasMoreTokens()) {
				Long companyId = Long.valueOf(PropsUtil.get("companyId"));
				groupIds.add(GroupLocalServiceUtil.getGroup(companyId, st.nextToken(",")).getGroupId());
			}

		}
		return groupIds;
	}

	public boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

	// To retrieve all the messages of last 24 hours
	public List<MBMessage> getMessages(List<Long> groupList) throws SystemException {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date = cal.getTime();
		
		

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class)
				.add(RestrictionsFactoryUtil.ge("modifiedDate", date));
		StringBuffer sql = new StringBuffer();
		

		if (groupList != null && groupList.size() > 0) {

			for (int i = 0; i < groupList.size(); i++) {

				if (i == 0) {
					sql.append(" (groupId = " + groupList.get(i));
				} else {
					sql.append(" or groupId = " + groupList.get(i));
				}

			}
			
			sql.append(")");
			System.out.println("SQL is: " + sql);
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction(sql.toString()));

		}

		List<MBMessage> messageList = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);

		return messageList;

	}

	// To obtain subscriptions based on given companyId, className and classPK
	public List<Subscription> getThreadSubscribers(Long companyId, String className, long classPK)
			throws SystemException {

		List<Subscription> subscriptionList = SubscriptionLocalServiceUtil.getSubscriptions(companyId, className,
				classPK);

		return subscriptionList;
	}

	// Action method which contains entire logic for mail notification to
	// respective subscribers
	public void sendWallNotifications() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		try {

			List<Long> groupList = getGroupIds();

			// Will contain unique threadIds as a thread can contain many messages
			Set<Long> threadIdList = new LinkedHashSet();

			// Will contain unique groupIds as a group (community) can contain many messages
			Set<Long> groupIdList = new LinkedHashSet();

			// Will contain list of subscribers who have subscribed to the threads which are stored in above threadIdList
			Map<Long, List<Subscription>> threadSubscriberList = new LinkedHashMap();

			// Will contain list of subscribers who have subscribed to the communities which are stored in above groupIdList
			Map<Long, List<Subscription>> communitySubscriberList = new LinkedHashMap();

			// Will contain map of threadIds as keys and List of Messages as values
			Map<Long, List<MBMessage>> threadMessageList = new LinkedHashMap();

			// Will contain map of groupIds as keys and list of unique threadIds
			Map<Long, Set<Long>> groupThreadList = new LinkedHashMap();

			// To store all the messages of last 24 hours (or the criteria which we set)
			List<MBMessage> messageList = getMessages(groupList);

			// The following code block executes only if messageList containes messages
			if (messageList != null && messageList.size() > 0) {

				// To store the companyId of messages. It is assumed that all the messages will be coming from only one company
				long companyId = messageList.get(0).getCompanyId();

				System.out.println("Admin email: " + PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));

				// To iterate all the messages of last 24 hours (presently
				// criteria is none so all messages will be returned)
				// And to create list of threadId, groupId and to create a map
				// of groupId as key and list of threadIds as value.
				// The above mentioned lists and maps are created based only on
				// the messages which are iterated and not all messages.
				for (MBMessage message : messageList) {
					if (!isNumeric(message.getBody())) {
						threadIdList.add(message.getThreadId());
						groupIdList.add(message.getCategoryId());
						groupThreadList.put(message.getCategoryId(), new LinkedHashSet<Long>());

					}
				}

				// To store threadIds corresponding to a particular community
				for (MBMessage message : messageList) {
					if (groupThreadList.containsKey(message.getCategoryId())) {
						groupThreadList.get(message.getCategoryId()).add(message.getThreadId());
					}

				}

				// To get the subscribers of MessageBoard Threads
				for (long threadId : threadIdList) {
					threadSubscriberList.put(threadId, getThreadSubscribers(companyId,
							"com.liferay.portlet.messageboards.model.MBThread", threadId));
				}

				// To get the subscribers of MessageBoard Communities
				for (long groupId : groupIdList) {
					communitySubscriberList.put(groupId, getThreadSubscribers(companyId,
							"com.liferay.portlet.messageboards.model.MBCategory", groupId));
				}

				// To combine all the messages of single thread as a single unit
				// and then to store such threads along with their messages in
				// map.
				for (long threadId : threadIdList) {
					List<MBMessage> tempMessageList = new ArrayList();
					for (MBMessage message : messageList) {
						if (message.getThreadId() == threadId) {
							tempMessageList.add(message);
						}
					}
					threadMessageList.put(threadId, tempMessageList);
				}

				// Code for thread subscription
				// The users will be notified about the updates on the thread on
				// which they have subscribed
				// Each mail will contain a single thread and each thread will
				// have messages posted on it in last 24 hours
				for (long threadId : threadIdList) {

					StringBuffer messageBody = new StringBuffer("");
					StringBuffer messageSubject = new StringBuffer(
							threadMessageList.get(threadId).get(0).getSubject().toString());

					// To generate messageBody of mail which will contain all
					// messages belonging to respective thread
					for (MBMessage message : threadMessageList.get(threadId)) {
						messageBody.append("Subject: " + " " + message.getSubject());
						messageBody.append("\n");
						messageBody.append("Msg: " + " " + message.getBody() + "\n");
						messageBody.append("Posted By: " + message.getUserName() + " \n\n");
					}

					System.out.println("\n");
					System.out.println("Thread " + threadId + ": \n" + messageBody.toString());
					System.out.print("This thread will be posted to following mail addresses:");

					// To actually send mails to the thread subscribers
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

				// To clear threadMessageList so that it can be used for
				// community subscription
				threadMessageList.clear();

				// Code for community subscription
				for (long groupId : groupIdList) {

					// Iterating community subscribers based on groupIdList
					for (Subscription subscription : communitySubscriberList.get(groupId)) {

						// Iterating threads in a given community (group)
						// for adding threads which are to be mailed to
						// subscribers to the threadMessageList
						for (long threadId : groupThreadList.get(groupId)) {
							List<MBMessage> tempMessageList = new ArrayList();
							for (MBMessage message : messageList) {
								if (message.getThreadId() == threadId && !isNumeric(message.getBody())) {
									tempMessageList.add(message);
								}
							}
							threadMessageList.put(threadId, tempMessageList);
						}

						// Iterating threads in a given community (group)
						// to send mail notifications to community subscribers
						for (long threadId : groupThreadList.get(groupId)) {

							if (threadMessageList.get(threadId) != null && threadMessageList.get(threadId).size() > 0) {
								StringBuffer messageBody = new StringBuffer("");
								StringBuffer messageSubject = new StringBuffer(
										threadMessageList.get(threadId).get(0).getSubject().toString());

								for (MBMessage message : threadMessageList.get(threadId)) {
									messageBody.append("Subject: " + " " + message.getSubject());
									messageBody.append("\n");
									messageBody.append("Msg: " + " " + message.getBody() + "\n\n");
									messageBody.append("Posted By: " + message.getUserName() + " \n\n");
								}

								System.out.println("\n");
								System.out.println("Thread " + threadId + ": \n" + messageBody.toString());
								System.out.print(
										"This community notification will be posted to following mail addresses:");

								InternetAddress fromAddress = new InternetAddress(
										PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));

								InternetAddress toAddress = new InternetAddress(
										UserLocalServiceUtil.getUser(subscription.getUserId()).getEmailAddress());
								MailMessage mailMessage = new MailMessage();
								mailMessage.setTo(toAddress);
								mailMessage.setFrom(fromAddress);
								mailMessage.setSubject("Community Subscription: " + messageSubject.toString());
								mailMessage.setBody(messageBody.toString());
								MailServiceUtil.sendEmail(mailMessage);

								System.out.print(
										UserLocalServiceUtil.getUser(subscription.getUserId()).getEmailAddress() + " ");
							}

						}
					}
				}

				threadMessageList.clear();

				Date date = new Date();
				System.out.println("Triggered..." + date.toString());
			}

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

}
