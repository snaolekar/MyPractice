package com.navpravartancorp.stockapp;

public class StockInfo {
	private String daysLow = ""  ;
	private String daysHigh = "";
	private String monthLow = "";
	private String monthHigh = "";
	private String lastTradePriceOnly = "";
	private String name = ""; 
	private String change= "";
	private String daysRange= "";
	
	public StockInfo(String daysLow, String daysHigh, String yearLow,
			String yearHigh, String lastTradePriceOnly, String name,
			String change, String daysRange) {
		super();
		this.daysLow = daysLow;
		this.daysHigh = daysHigh;
		this.monthLow = yearLow;
		this.monthHigh = yearHigh;
		this.lastTradePriceOnly = lastTradePriceOnly;
		this.name = name;
		this.change = change;
		this.daysRange = daysRange;
	}
	public String getDaysLow() {
		return daysLow;
	}
	public void setDaysLow(String daysLow) {
		this.daysLow = daysLow;
	}
	public String getDaysHigh() {
		return daysHigh;
	}
	public void setDaysHigh(String daysHigh) {
		this.daysHigh = daysHigh;
	}
	public String getMonthLow() {
		return monthLow;
	}
	public void setMonthLow(String monthLow) {
		this.monthLow = monthLow;
	}
	public String getMonthHigh() {
		return monthHigh;
	}
	public void setMonthHigh(String monthHigh) {
		this.monthHigh = monthHigh;
	}
	public String getLastTradePriceOnly() {
		return lastTradePriceOnly;
	}
	public void setLastTradePriceOnly(String lastTradePriceOnly) {
		this.lastTradePriceOnly = lastTradePriceOnly;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getDaysRange() {
		return daysRange;
	}
	public void setDaysRange(String daysRange) {
		this.daysRange = daysRange;
	}

}
