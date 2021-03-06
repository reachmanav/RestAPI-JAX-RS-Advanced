package org.manav.javabrains.rest;

import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;

public class MyDateCoverter implements ParamConverter<MyDate> {

	@Override
	public MyDate fromString(String dateString) {
		Calendar cal = Calendar.getInstance();
		
		if ("tomorrow".equalsIgnoreCase(dateString))  {
			cal.add(Calendar.DATE, 1);
		} else if ("yesterday".equalsIgnoreCase(dateString))  {
			cal.add(Calendar.DATE, -1);
		}
		
			
		MyDate mydate = new MyDate();
		mydate.setDate(cal.get(Calendar.DAY_OF_MONTH));
		mydate.setMonth(cal.get(Calendar.MONTH));
		mydate.setYear(cal.get(Calendar.YEAR));
		
		return mydate;
	}

	@Override
	public String toString(MyDate dateString) {
		if (dateString == null)
			return null;
		return dateString.toString();
	}


}
