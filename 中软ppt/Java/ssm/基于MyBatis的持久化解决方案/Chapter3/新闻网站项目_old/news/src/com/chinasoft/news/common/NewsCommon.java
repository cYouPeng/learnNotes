package com.chinasoft.news.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsCommon {

	public static String getDate(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(new Date());
	}
	
	public static String getMD5String(String str){  
        byte[] buf=str.getBytes();  
        MessageDigest md5;  
        StringBuilder sb=new StringBuilder();  
        try {  
            md5 = MessageDigest.getInstance("MD5");  
            md5.update(buf);  
            byte[] tmp=md5.digest();  
            for (byte b:tmp) {  
                sb.append(Integer.toHexString(b&0xff));  
            }  
        } catch (NoSuchAlgorithmException e) {   
            e.printStackTrace();  
        }  
        return sb.toString();  
    }  
}
