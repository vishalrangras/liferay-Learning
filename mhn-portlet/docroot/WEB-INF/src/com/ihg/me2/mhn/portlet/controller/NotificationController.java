package com.ihg.me2.mhn.portlet.controller;

import com.ihg.me2.mhn.portlet.bean.SecurityNotificationInfo;
import com.ihg.me2.mhn.portlet.util.NotificationUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Vishal Rangras
 * 
 * Portlet implementation class NotificationController
 */
public class NotificationController extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(NotificationController.class);
	private static final String TOP_CONTENT_ID="prefTopContentId";
	private static final String NO_ACCESS_TO_CONTENT_ID="prefNoAccessToContentId";
	private static final String BOTTOM_CONTENT_ID="prefBottomContentId";
	private static final String DEFAULT_PREFS_MESSAGE="No Value found";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
			
		try {
						
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences prefs = renderRequest.getPreferences();
			Map<String, SecurityNotificationInfo> securityNotificationInfoList =  NotificationUtil.getHotelNotification(themeDisplay);
			 long groupId= themeDisplay.getScopeGroupId();
			renderRequest.setAttribute("notificationList", securityNotificationInfoList);
			renderRequest.setAttribute("topContentId",prefs.getValue(TOP_CONTENT_ID, DEFAULT_PREFS_MESSAGE));
			renderRequest.setAttribute("noAccessContentId",prefs.getValue(NO_ACCESS_TO_CONTENT_ID, DEFAULT_PREFS_MESSAGE));
			renderRequest.setAttribute("bottomContentId",prefs.getValue(BOTTOM_CONTENT_ID, DEFAULT_PREFS_MESSAGE));
			renderRequest.setAttribute("groupId",groupId);
			renderRequest.setAttribute(WebKeys.PORTLET_DECORATE, Boolean.FALSE);
		
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.doView(renderRequest, renderResponse);
	}
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		try
		{
			PortletPreferences prefs = renderRequest.getPreferences();
			if (Validator.isNotNull(prefs))
			{
				
				String  prefTopContentId= prefs.getValue(TOP_CONTENT_ID, DEFAULT_PREFS_MESSAGE);
				String  prefNoAccessToContentId= prefs.getValue(NO_ACCESS_TO_CONTENT_ID, DEFAULT_PREFS_MESSAGE);
				String  prefBottomContentId= prefs.getValue(BOTTOM_CONTENT_ID, DEFAULT_PREFS_MESSAGE);
				
				renderRequest.setAttribute(TOP_CONTENT_ID, prefTopContentId);
				renderRequest.setAttribute(NO_ACCESS_TO_CONTENT_ID, prefNoAccessToContentId);
				renderRequest.setAttribute(BOTTOM_CONTENT_ID, prefBottomContentId);
				
			}
			super.doEdit(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
		}
	}
	
	
	public void setMhnPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			String  prefTopContentId= ParamUtil.getString(actionRequest,TOP_CONTENT_ID,  DEFAULT_PREFS_MESSAGE);
			String  prefNoAccessToContentId= ParamUtil.getString(actionRequest,NO_ACCESS_TO_CONTENT_ID,  DEFAULT_PREFS_MESSAGE);
			String  prefBottomContentId= ParamUtil.getString(actionRequest,BOTTOM_CONTENT_ID,  DEFAULT_PREFS_MESSAGE);

			portletPreferences.setValue(TOP_CONTENT_ID, prefTopContentId);
			portletPreferences.setValue(NO_ACCESS_TO_CONTENT_ID, prefNoAccessToContentId);
			portletPreferences.setValue(BOTTOM_CONTENT_ID, prefBottomContentId);
			portletPreferences.store();

		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
		}
	}
}