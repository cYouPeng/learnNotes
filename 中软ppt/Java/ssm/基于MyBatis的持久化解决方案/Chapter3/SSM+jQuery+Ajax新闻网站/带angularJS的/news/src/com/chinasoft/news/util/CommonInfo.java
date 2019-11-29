package com.chinasoft.news.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CommonInfo {

	public static String getDate(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(new Date());
	}
}
