package com.heinsonh.api.ejb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//yyyy-MM-dd, manenar el sigueinte formato de fecha : 2019-09-20
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date StringToDate(String value) {
		try {
			return dateFormat.parse(value);
		} catch (ParseException e) {
			System.out.println("No pudo formatear la fecha");
		}
		return null;
	}

}
