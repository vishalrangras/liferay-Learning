package com.flight.detail.ws.executor.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * Utility class that contains data parsing logic
 * @author ishani
 *
 */
public class FlightUtil {

	/**ishani
	 * Method to parse json and generate the list with required field
	 * @param response
	 * @return
	 */
	public static List<FlightDetail> getFlightDetail(String response){
		List<FlightDetail> flightDetailList = new ArrayList<FlightDetail>();
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response);
			//converted string to json
			//System.out.println("jsonObject-------->"+jsonObject.toJSONString());
			JSONArray flightStatuses = jsonObject.getJSONArray(FlightDetailConstants.FLIGHT_STATUS);
			System.out.println("flightStatuses----->"+flightStatuses.toJSONString());
			if(flightStatuses.length()>0){
				for(int i = 0; i < flightStatuses.length(); i++){
					FlightDetail flightDetail = new FlightDetail();
					JSONObject objects = flightStatuses.getJSONObject(i);
					if(JSONFactoryUtil.createJSONObject(objects.get(FlightDetailConstants.FLIGHT_EQUIPMENT).toString()).getString(FlightDetailConstants.FLIGHT_EQUIPMENT_TAIL_NUMBER)!=null && !JSONFactoryUtil.createJSONObject(objects.get(FlightDetailConstants.FLIGHT_EQUIPMENT).toString()).getString(FlightDetailConstants.FLIGHT_EQUIPMENT_TAIL_NUMBER).equalsIgnoreCase("")){
						flightDetail.setFlightId(JSONFactoryUtil.createJSONObject(objects.get(FlightDetailConstants.FLIGHT_EQUIPMENT).toString()).getString(FlightDetailConstants.FLIGHT_EQUIPMENT_TAIL_NUMBER));
					}else{
						flightDetail.setFlightId(objects.get(FlightDetailConstants.FLIGHT_ID).toString());
					}
					flightDetail.setLiveStatus(FlightUtil.getStatusFromStatusCode(objects.get("status").toString()));
					if(objects.get(FlightDetailConstants.AIRPORT_RESOURCES)!=null){
						if(JSONFactoryUtil.createJSONObject(objects.get(FlightDetailConstants.AIRPORT_RESOURCES).toString()).getString(FlightDetailConstants.ARRIVAL_TERMINAL)!=null){
							String arrivalTerminal = JSONFactoryUtil.createJSONObject(objects.get(FlightDetailConstants.AIRPORT_RESOURCES).toString()).getString(FlightDetailConstants.ARRIVAL_TERMINAL);
							flightDetail.setArrivalTerminal(arrivalTerminal);
						}
					}else{
						flightDetail.setArrivalTerminal(FlightDetailConstants.NA);
					}
					
					String arrivalTime = JSONFactoryUtil.createJSONObject(objects.getString(FlightDetailConstants.ARRIVAL_DATE).toString()).getString(FlightDetailConstants.DATE_LOCAL);
					if(arrivalTime!=null){
						//System.out.println("arrivalTime-->"+arrivalTime);
						java.util.Date date = new java.util.Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
						date = sdf.parse(arrivalTime);
						//System.out.println(date);
						SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
				        String time = localDateFormat.format(date);
				        //System.out.println("time"+time);
						flightDetail.setArrivalTime(time);
					}else{
						flightDetail.setArrivalTime(FlightDetailConstants.NA);
					}
					
					//System.out.println("flightId--->"+objects.get("flightId").toString());
					//System.out.println("status---"+FlightUtil.getStatusFromStatusCode(objects.get("status").toString()));
					//System.out.println("arrivalTerminal---"+arrivalTerminal);
					flightDetailList.add(flightDetail);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightDetailList;
		
	}

	/**ishani
	 * Method to get Whole status from the status code
	 * @param statusCode
	 * @return
	 */
	private static String getStatusFromStatusCode(String statusCode) {
		// TODO Auto-generated method stub
		String status = "";
		if(statusCode.equalsIgnoreCase("L")){
			status=FlightDetailConstants.LANDED;
		}else if(statusCode.equalsIgnoreCase("NO")){
			status=FlightDetailConstants.NOT_OPERATIONAL;
		}
		else if(statusCode.equalsIgnoreCase("R")){
			status=FlightDetailConstants.REDIRECTED;
		}
		else if(statusCode.equalsIgnoreCase("S")){
			status=FlightDetailConstants.SCHEDULED;
		}
		else if(statusCode.equalsIgnoreCase("A")){
			status=FlightDetailConstants.ACTIVE;
		}
		else if(statusCode.equalsIgnoreCase("C")){
			status=FlightDetailConstants.CANCELED;
		}
		else if(statusCode.equalsIgnoreCase("D")){
			status=FlightDetailConstants.DIVERTED;
		}
		else{
			status=FlightDetailConstants.UNKNOWN;
		}
		return status;
	}
	
}
