package com.flight.detail.ws.executor.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
/**
 * 
 * @author ishani
 *
 */
public class RestExecutor {
	
	/**
	 * Method to call api of flightstats and get respones in json format
	 * @return
	 */
	public static String getResponse() {
		
		String appId =  "6e16862b";
        String appKey = "e960c1e860e59dbe60b0ba63224a61bf";
        HttpURLConnection con = null;
        // REST RETURNED VALUES FORMAT
        String restformat = "json"; 
        String domainName = "https://api.flightstats.com/flex";
        String webserviceName ="flightstatus/rest/v2/json/airport/status";
        String airport = "LAX";
        String forArrivalCode = "arr";
        String urlparameters = getUrlParameterForRequestedService(webserviceName);
        String additionalParameters = getAdditionalUrlParameterForRequestedService(webserviceName);
        String serverurl = domainName + "/" +webserviceName +"/" + airport +"/" +forArrivalCode +"/"+urlparameters+"?appId="+appId+"&appKey="+appKey+additionalParameters;
		System.out.println("Serverurl-------------------------------->"+serverurl);
		URL url;
		String output="";
		StringBuffer sBuffer = new StringBuffer();
		try {
			url = new URL( serverurl );
			 HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		        conn.setRequestMethod( "GET" );
		        conn.connect();
		    System.out.println( conn.getResponseCode() );
		  //Get Response
		   BufferedReader br = new BufferedReader(new InputStreamReader(
			        (conn.getInputStream())));
		   
		   System.out.println("Output from Server .... \n");
		   while ((output = br.readLine()) != null) {
			   System.out.println("output before---"+output); 
			   sBuffer.append(output);	
			   System.out.println("output after---"+sBuffer.toString()); 
		   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		 System.out.println("output outside---"+sBuffer.toString()); 
  		return sBuffer.toString();
		
	}

	/**
	 * Method to generate urlparameters needed to be passed in the URL
	 * @param webserviceName
	 * @return
	 */
	private static String getUrlParameterForRequestedService(String webserviceName) {
		String urlParameter = "";
		if(webserviceName.equalsIgnoreCase("flightstatus/rest/v2/json/airport/status")){
			LocalDateTime now = LocalDateTime.now();
			System.out.println("now--->"+now);
			String year = String.valueOf(now.getYear());
			System.out.println("year--->"+year);
			String month = String.valueOf(now.getMonthValue());
			System.out.println("month--->"+month);
			String date = String.valueOf(now.getDayOfMonth()); //for US 
			System.out.println("date--->"+date);
			String hour = String.valueOf(now.getHour());
			System.out.println("hour--->"+hour);
			//String month ="12"; //pass current month here
			urlParameter = year +"/" +month +"/"+date+"/"+hour; 
		}
		System.out.println("getUrlParameterForRequestedService params---"+urlParameter);
		return urlParameter;
	}

	/**
	 * Method to generate additional urlparameters needed to be passed in the URL
	 * @param webserviceName
	 * @return
	 */
	private static String getAdditionalUrlParameterForRequestedService(String webserviceName) {
		String urlParameter = "";
		String numHours = "5";
        String maxFlights= "7";
		if(webserviceName.equalsIgnoreCase("flightstatus/rest/v2/json/airport/status")){
			urlParameter="&utc=false&numHours="+numHours+"&maxFlights="+maxFlights;
		}
		System.out.println("getAdditionalUrlParameterForRequestedService params---"+urlParameter);
		return urlParameter;
	}
}
