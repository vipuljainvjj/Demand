package com.vipul.demand.demandutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date formatDate(String date) {
		Date parseDate = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			parseDate = format.parse(date);
		} catch (ParseException e) {
			parseDate = new Date();
		}
		return parseDate;
	}
}
