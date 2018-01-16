package com.ihg.me2.mhn.portlet.bean;

public class SecurityNotificationInfo {
	
	private String holidexCode;
	private String hotelName;
	private String impacted;
	private String startDate;
	private String endDate;
	

	public String getHolidexCode() {
		return holidexCode;
	}
	public void setHolidexCode(String holidexCode) {
		this.holidexCode = holidexCode;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getImpacted() {
		return impacted;
	}
	public void setImpacted(String impacted) {
		this.impacted = impacted;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "SecurityNotificationInfo [holidexCode=" + holidexCode + ", hotelName=" + hotelName + ", impacted="
				+ impacted + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
