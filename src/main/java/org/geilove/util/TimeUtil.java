package org.geilove.util;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;
import java.util.Random;  
  
public class TimeUtil {  
  
	private   Calendar now=Calendar.getInstance(); 
	
	public Integer getYear(){
		return now.get(Calendar.YEAR);
	}
	
	public  Integer getMonth(){
		return now.get(Calendar.MONTH) + 1;
	}
	public  Integer getDay(){
		return now.get(Calendar.DAY_OF_MONTH);
		//String s=String.valueOf(now.get(Calendar.DAY_OF_MONTH));
	}
	public  Long getMil(){
		//Random rd=new Random();
		Long data=now.getTimeInMillis();
		return data;
	}
	
	public  String getNyDay(){
		Integer d= now.get(Calendar.DAY_OF_MONTH);
		String dstr=d.toString();
		
		Integer m= now.get(Calendar.MONTH)+1;
		String mstr=m.toString();
		
		Integer n= now.get(Calendar.YEAR);
		String nstr=n.toString();
		return '/'+nstr+mstr+dstr;
		//String s=String.valueOf(now.get(Calendar.DAY_OF_MONTH));
	}
	
    public static void main(String[] args) throws ParseException {  
//        Calendar now = Calendar.getInstance();  
//        System.out.println("年: " + now.get(Calendar.YEAR));       
//        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");  
//        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));  
//        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));  
//        System.out.println("分: " + now.get(Calendar.MINUTE));  
//        System.out.println("秒: " + now.get(Calendar.SECOND));  
        //System.out.println("当前时间毫秒数：" + now.getTimeInMillis());  
//        System.out.println(now.getTime());  
       // Integer y=getYear();
        //System.out.println(y.toString());
        Date d = new Date();  
        System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d);          System.out.println("格式化后的日期：" + dateNowStr);  
//          
//        String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样  
//        Date today = sdf.parse(str);  
//        System.out.println("字符串转成日期：" + today);  
    }  
}  