package com.test.sp1.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtill {

	private static final String YYYY_MM_DD = "yyyMMdd";
	private static final String HH_MM_SS = "HHmmss";
	
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
		return sdf.format(date);
	}
	
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(HH_MM_SS);
		return sdf.format(date);
	}
}
