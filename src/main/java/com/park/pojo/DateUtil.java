package com.park.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getDate(Date date) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result=simpleDateFormat.format(date);
		return result;
	}
	public static Date toDate(String dateString) throws ParseException {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=simpleDateFormat.parse(dateString);
		return date;
	}
	

}
