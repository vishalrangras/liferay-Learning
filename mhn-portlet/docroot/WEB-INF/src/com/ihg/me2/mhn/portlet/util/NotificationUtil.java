package com.ihg.me2.mhn.portlet.util;

import com.ihg.me2.mhn.portlet.bean.SecurityNotificationInfo;
import com.ihg.me2.mhn.portlet.model.SecurityNotification;
import com.ihg.me2.mhn.portlet.service.SecurityNotificationLocalServiceUtil;
import com.ihg.me2.utils.session.MerlinCache;
import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NotificationUtil {
	
	private static Log log = LogFactoryUtil.getLog(NotificationUtil.class);
	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static final String HTL = "HTL";
	private static final String OFC = "OFC";
	private static final String SECURITY_VALUES = "SECURITY_VALUES";
	private static final String HLDX_CD = "HLDX_CD";
	private static final String HOTELNM = "HOTELNM";
	private static final String LOC_NM  = "LOC_NM";
	private static final String LOCATIONS = "LOCATIONS";
	
	public static Map<String, SecurityNotificationInfo> getHotelNotification(ThemeDisplay themeDisplay) throws SystemException{
		
		User user = themeDisplay.getUser();
		String screenname = user.getScreenName();
		log.debug("Screenname is: "+screenname);
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SecurityNotification.class);
		
		Criterion criterion = RestrictionsFactoryUtil.ilike("gmScreenname", screenname);
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("pcScreenname", screenname));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("secPcScreenname", screenname));
		criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("fopsScreenname", screenname));
		
		dynamicQuery.add(criterion);
		
		List<SecurityNotification> securityNotificationList = SecurityNotificationLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		Map<String, SecurityNotificationInfo> securityNotificationInfoList = new LinkedHashMap<String, SecurityNotificationInfo>();
		
		if (securityNotificationList!=null && securityNotificationList.size()>0){	
			
			for(SecurityNotification securityNotification:securityNotificationList){
				SecurityNotificationInfo securityNotificationInfo = new SecurityNotificationInfo();
				securityNotificationInfo.setHolidexCode(securityNotification.getHolidexCode());
				if(securityNotification.getHotelName()!=null && !securityNotification.getHotelName().equals("")){
					securityNotificationInfo.setHotelName(securityNotification.getHotelName());
				}else{
					securityNotificationInfo.setHotelName(getHotelName(screenname, securityNotification.getHolidexCode()));
				}
				
				securityNotificationInfo.setImpacted(securityNotification.getImpacted());
				if(securityNotification.getImpacted().equalsIgnoreCase("Affected")){
					securityNotificationInfo.setStartDate(dateFormat.format(securityNotification.getStartDate()));
					securityNotificationInfo.setEndDate(dateFormat.format(securityNotification.getEndDate()));
				}
				securityNotificationInfoList.put(securityNotification.getHolidexCode(), securityNotificationInfo);
			}		
		}
		
		
		return securityNotificationInfoList;
	}
	
	//Logic to get Hotel Name from Merlin Session
	public static String getHotelName(String screenname, String userHolidexCode) throws NullPointerException{
		
		Map<String, Map<String, String>> htlMap = (Map<String, Map<String, String>>)MerlinCache.getCacheMap(HTL).get(SECURITY_VALUES);
		Map<String, Map<String, String>> ofcMap = (Map<String, Map<String, String>>)MerlinCache.getCacheMap(OFC).get(SECURITY_VALUES);
		String locations = MerlinSession.get(screenname, LOCATIONS);
		List<String> locCodes = new ArrayList<String>(Arrays.asList(locations.split(";")));
		
		Map<String, String> holidexLocationMap = new LinkedHashMap();
		String holidexCode = null;
		boolean hotelFound = true;
		
		for(String locId : locCodes){
			Map<String, String>   location = (Map<String, String>) htlMap.get(locId);
		    try{
		    	holidexCode = (String) location.get(HLDX_CD);
		    	holidexLocationMap.put(holidexCode, locId);
		    }catch(NullPointerException e){
		    	
		    }    
		}
		
		String hotelName = StringPool.BLANK;
		
		try{
			Map<String, String>   location = (Map<String, String>) htlMap.get(holidexLocationMap.get(userHolidexCode));
			hotelName =(String) location.get(HOTELNM);
			if(hotelName.indexOf("[")!=-1){	
				hotelName = hotelName.substring(0, hotelName.indexOf("["));
			}
		}catch(NullPointerException e){
			hotelFound = false;
		}
		
		if(!hotelFound){
			Map<String, String> holidexOfcLocationMap = new LinkedHashMap();
			for(String locId : locCodes){
				Map<String, String>   location = (Map<String, String>) ofcMap.get(locId);
			    try{
			    	holidexCode = (String) location.get(HLDX_CD);
			    	holidexOfcLocationMap.put(holidexCode, locId);
			    }catch(NullPointerException e){
			    	
			    }    
			}
			
			try{
				Map<String, String>   location = (Map<String, String>) ofcMap.get(holidexOfcLocationMap.get(userHolidexCode));
				
				hotelName = (String) location.get(LOC_NM);
				if(hotelName.indexOf("[")!=-1){	
					hotelName = hotelName.substring(0, hotelName.indexOf("["));
				}
			}catch(NullPointerException e){
				
			}
		}
		return hotelName;
	};
	
}