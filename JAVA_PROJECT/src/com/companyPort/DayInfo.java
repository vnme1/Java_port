package com.companyPort;

import java.util.Date;

public class DayInfo {
	private Date firstday;
	private Date lastday;
	private String dayname;
	private String daylist;
	private String date;
	public DayInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DayInfo(Date firstday, Date lastday, String dayname, String daylist, String date) {
		super();
		this.firstday = firstday;
		this.lastday = lastday;
		this.dayname = dayname;
		this.daylist = daylist;
		this.date = date;
	}
	@Override
	public String toString() {
		return "DayInfo [firstday=" + firstday + ", lastday=" + lastday + ", dayname=" + dayname + ", daylist="
				+ daylist + ", date=" + date + "]";
	}
	public Date getFirstday() { return firstday; }
	public void setFirstday(Date firstday) { this.firstday = firstday; }
	public Date getLastday() { return lastday; }
	public void setLastday(Date lastday) { this.lastday = lastday; }
	public String getDayname() { return dayname; }
	public void setDayname(String dayname) { this.dayname = dayname; }
	public String getDaylist() { return daylist; }
	public void setDaylist(String daylist) { this.daylist = daylist; }
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	
	
	
}
