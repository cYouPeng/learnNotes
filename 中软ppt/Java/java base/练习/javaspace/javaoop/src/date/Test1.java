package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();//当前时间
		System.out.println(date);
		System.out.println(date.getTime());//时间戳 1970-1-1 0:0:0.0s到date的毫秒数
		System.out.println(new Date(1536391100000L));
//		DateFormat df1 = DateFormat.getDateInstance();
//		System.out.println(df1.format(date));
//		DateFormat df2 = DateFormat.getTimeInstance();
//		System.out.println(df2.format(date));
//		DateFormat df3 = DateFormat.getDateTimeInstance();
//		System.out.println(df3.format(date));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
		System.out.println(sdf.format(date));
		
		String s = "2018年09月08日 15点47分02秒";
		try {
			Date d = sdf.parse(s);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
