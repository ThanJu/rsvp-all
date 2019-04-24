package com.highteam.router.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间类型的数据转换工具类
 * @author wz
 * 2016-5-5
 */
public class DateUtils {

	// log日志
    private static Log log = LogFactory.getLog(DateUtils.class);
    private static String defaultDatePattern = null;  
    private static String timePattern = "HH:mm";  
    public static final String TS_FORMAT = DateUtils.getDatePattern() + " HH:mm:ss.S";  
    private static Calendar cale = Calendar.getInstance();  
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");  
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    
	/**
	 * 格式化字符串 获取：年-月-日 yyyy-MM-dd
	 *2016-5-31
	 */
	public static final String date_sampleFormat = "yyyy-MM-dd";
	
	/**
	 * 格式化字符串 获取：年-月-日 yyyy-MM-dd
	 		读取excel时在使用这个常量 
	 * @author wz
	 */
	public static final String dateYMD = "yyyy-MM-dd";
	
	/**
	 * 格式化字符串 获取：年-月-日  时分秒	 yyyy-MM-dd HH:mm:ss
	 		读取excel时在使用这个常量 
	 * @author wz
	 */
	public static final String dateYMDHMS = "yyyy-MM-dd HH:mm:ss";
	
   // 构造函数
    public DateUtils(){  
    }  

    /**  
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回  
     */  
    public static String getDateTime(){  
        try{  
            return sdf2.format(cale.getTime());  
        } catch(Exception e){  
            log.debug("DateUtils.getDateTime():" + e.getMessage());  
            return "";  
        }  
    }

    /**  
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回  
     */  
    public static String getDate(){  
        try{  
            return sdf.format(cale.getTime());  
        } catch(Exception e){  
            log.debug("DateUtil.getDate():" + e.getMessage());  
            return "";  
        }  
    }  

    /**  
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回  
     */  
    public static String getTime(){  
        String temp = "";  
        try{  
            temp += sdf1.format(cale.getTime());  
            return temp;  
        } catch(Exception e){  
            log.debug("DateUtil.getTime():" + e.getMessage());  
            return "";  
        }  
    }  

    /**  
     * 统计时开始日期的默认值,  
     * 今年的开始时间  
     */  
    public static String getStartDate(){  
        try{  
            return getYear() + "-01-01";  
        } catch(Exception e){  
            log.debug("DateUtil.getStartDate():" + e.getMessage());  
            return "";  
        }  
    }  

    /**  
     * 统计时结束日期的默认值  
     */  
    public static String getEndDate(){  
        try{  
            return getDate();  
        } catch(Exception e){  
            log.debug("DateUtil.getEndDate():" + e.getMessage());  
            return "";  
        }  
    }  

    /**  
     * 获得服务器当前日期的年份  
     */  
    public static String getYear(){  
        try{  
            //返回的int型，需要字符串转换  
            return String.valueOf(cale.get(Calendar.YEAR));  
        } catch(Exception e){  
            log.debug("DateUtil.getYear():" + e.getMessage());  
            return "";  
        }  
    }  

    /**  
     * 获得服务器当前日期的月份  
     */  
    public static String getMonth(){  
        try{  
            //一个数字格式，非常好  
            java.text.DecimalFormat df = new java.text.DecimalFormat();  
            df.applyPattern("00");  
            return df.format((cale.get(Calendar.MONTH) + 1));  
            //return String.valueOf(cale.get(Calendar.MONTH) + 1);  
        } catch(Exception e){  
            log.debug("DateUtil.getMonth():" + e.getMessage());  
            return "";  
        }  
    }  

    /**  
     * 获得服务器在当前月中天数  
     */  
    public static String getDay(){  
        try{  
            return String.valueOf(cale.get(Calendar.DAY_OF_MONTH));  
        } catch(Exception e){  
            log.debug("DateUtil.getDay():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /**  
     * 比较两个日期相差的天数,  
     * 第一个日期要比第二个日期要晚  
     */  
    public static int getMargin(String date1,String date2){  
        int margin;  
        try{  
            ParsePosition pos = new ParsePosition(0);  
            ParsePosition pos1 = new ParsePosition(0);  
            Date dt1 = sdf.parse(date1,pos);  
            Date dt2 = sdf.parse(date2,pos1);  
            long l = dt1.getTime() - dt2.getTime();  
            margin = (int)(l / (24 * 60 * 60 * 1000));  
            return margin;  
        } catch(Exception e){  
            log.debug("DateUtil.getMargin():" + e.toString());  
            return 0;  
        }  
    }  
  
  
    /**  
     * 比较两个日期相差的天数，格式不一样  
     * 第一个日期要比第二个日期要晚  
     */  
    public static double getDoubleMargin(String date1,String date2){  
        double margin;  
        try{  
            ParsePosition pos = new ParsePosition(0);  
            ParsePosition pos1 = new ParsePosition(0);  
            Date dt1 = sdf2.parse(date1,pos);  
            Date dt2 = sdf2.parse(date2,pos1);  
            long l = dt1.getTime() - dt2.getTime();  
            margin = (l / (24 * 60 * 60 * 1000.00));  
            return margin;  
        } catch(Exception e){  
            log.debug("DateUtil.getMargin():" + e.toString());  
            return 0;  
        }  
    }  
  
  
    /**  
     * 比较两个日期相差的月数  
     */  
    public static int getMonthMargin(String date1,String date2){  
        int margin;  
        try{  
            margin  = (Integer.parseInt(date2.substring(0,4)) - Integer.parseInt(date1.substring(0,4)))* 12;  
            margin += (Integer.parseInt(date2.substring(4,7).replaceAll("-0","-")) - Integer.parseInt(date1.substring(4,7).replaceAll("-0","-")));  
            return margin;  
        } catch(Exception e){  
            log.debug("DateUtil.getMargin():" + e.toString());  
            return 0;  
        }  
    }  
  
    /**  
     * 返回日期加X天后的日期  
     */  
    public static String addDay(String date,int i){  
        try{  
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(5,7))-1,Integer.parseInt(date.substring(8,10)));  
            gCal.add(GregorianCalendar.DATE,i);  
            return sdf.format(gCal.getTime());
        } catch(Exception e){  
            log.debug("DateUtil.addDay():" + e.toString());  
            return getDate();  
        }  
    }

    /**
     * 返回日期加X天后的日期
     */
    public static Date addDay(Date date,int i){
        cale.setTime(date);
        cale.add(Calendar.DATE,i);
        return cale.getTime();
    }

    /**  
     * 返回日期加X月后的日期  
     */  
    public static String addMonth(String date,int i){  
        try{  
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(5,7))-1,Integer.parseInt(date.substring(8,10)));  
            gCal.add(GregorianCalendar.MONTH,i);  
            return sdf.format(gCal.getTime());  
        } catch(Exception e){  
            log.debug("DateUtil.addMonth():" + e.toString());  
            return getDate();  
        }  
    }  
  
    /**  
     * 返回日期加X年后的日期  
     */  
    public static String addYear(String date,int i){  
        try{  
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(5,7))-1,Integer.parseInt(date.substring(8,10)));  
            gCal.add(GregorianCalendar.YEAR,i);  
            return sdf.format(gCal.getTime());  
        } catch(Exception e){  
            log.debug("DateUtil.addYear():" + e.toString());  
            return "";  
        }  
    }  
  
  
    /**  
     * 返回某年某月中的最大天  
     */  
    public static int getMaxDay(String year,String month){  
        int day = 0;  
        try{  
            int iyear = Integer.parseInt(year);  
            int imonth = Integer.parseInt(month);  
            if(imonth == 1 || imonth == 3 || imonth == 5 || imonth == 7 || imonth == 8 || imonth == 10 || imonth == 12){  
                day = 31;  
            } else if(imonth == 4 || imonth == 6 || imonth == 9 || imonth == 11){  
                day = 30;  
            } else if((0 == (iyear % 4)) && (0 != (iyear % 100)) || (0 == (iyear % 400))){  
                day = 29;  
            } else{  
                day = 28;  
            }  
            return day;  
        } catch(Exception e){  
            log.debug("DateUtil.getMonthDay():" + e.toString());  
            return 1;  
        }  
    }  
      
  
  
    /**  
     * 格式化日期  
     */  
    @SuppressWarnings("static-access")  
    public String rollDate(String orgDate,int Type,int Span){  
        try{  
            String temp = "";  
            int iyear,imonth,iday;  
            int iPos = 0;  
            char seperater = '-';  
            if(orgDate == null || orgDate.length() < 6){  
                return "";  
            }  
  
            iPos = orgDate.indexOf(seperater);  
            if(iPos > 0){  
                iyear = Integer.parseInt(orgDate.substring(0,iPos));  
                temp = orgDate.substring(iPos + 1);  
            } else{  
                iyear = Integer.parseInt(orgDate.substring(0,4));  
                temp = orgDate.substring(4);  
            }  
  
            iPos = temp.indexOf(seperater);  
            if(iPos > 0){  
                imonth = Integer.parseInt(temp.substring(0,iPos));  
                temp = temp.substring(iPos + 1);  
            } else{  
                imonth = Integer.parseInt(temp.substring(0,2));  
                temp = temp.substring(2);  
            }  
  
            imonth--;  
            if(imonth < 0 || imonth > 11){  
                imonth = 0;  
            }  
  
            iday = Integer.parseInt(temp);  
            if(iday < 1 || iday > 31)  
                iday = 1;  
  
            Calendar orgcale = Calendar.getInstance();  
            orgcale.set(iyear,imonth,iday);  
            temp = this.rollDate(orgcale,Type,Span);  
            return temp;  
        }catch(Exception e){  
            return "";  
        }  
    }  
  
    public static String rollDate(Calendar cal,int Type,int Span){  
        try{  
            String temp = "";  
            Calendar rolcale;  
            rolcale = cal;  
            rolcale.add(Type,Span);  
            temp = sdf.format(rolcale.getTime());  
            return temp;  
        }catch(Exception e){  
            return "";  
        }  
    }  
  
    /**  
     *   
     * 返回默认的日期格式  
     *   
     */  
    public static synchronized String getDatePattern() {  
        defaultDatePattern = "yyyy-MM-dd";  
        return defaultDatePattern;  
    }  
  
    /**  
     * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd  
     */  
    public static final String getDate(Date aDate) {  
        SimpleDateFormat df = null;  
        String returnValue = "";  
  
        if (aDate != null) {  
            df = new SimpleDateFormat(getDatePattern());  
            returnValue = df.format(aDate);  
        }  
  
        return (returnValue);  
    }  
  
  
  
    /**  
     * 取得给定日期的时间字符串，格式为当前默认时间格式  
     */  
    public static String getTimeNow(Date theTime) {  
        return getDateTime(timePattern, theTime);  
    }  
  
    /**  
     * 取得当前时间的Calendar日历对象  
     */  
    public Calendar getToday() throws ParseException {  
        Date today = new Date();  
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());  
        String todayAsString = df.format(today);  
        Calendar cal = new GregorianCalendar();  
        cal.setTime(convertStringToDate(todayAsString));  
        return cal;  
    }  
  
    /**  
     * 将日期类转换成指定格式的字符串形式  
     */  
    public static final String getDateTime(String aMask, Date aDate) {  
        SimpleDateFormat df = null;  
        String returnValue = "";  
  
        if (aDate == null) {  
            log.error("aDate is null!");  
        } else {  
            df = new SimpleDateFormat(aMask);  
            returnValue = df.format(aDate);  
        }  
        return (returnValue);  
    }  
      
    /**  
     * 将指定的日期转换成默认格式的字符串形式  
     */  
    public static final String convertDateToString(Date aDate) {  
        return getDateTime(getDatePattern(), aDate);  
    }  
  
      
    /**  
     * 将日期字符串按指定格式转换成日期类型  
     * @param aMask 指定的日期格式，如:yyyy-MM-dd   
     * @param strDate 待转换的日期字符串  
     */  
      
    public static final Date convertStringToDate(String aMask, String strDate)  
      throws ParseException {  
        SimpleDateFormat df = null;  
        Date date = null;  
        df = new SimpleDateFormat(aMask);  
  
        if (log.isDebugEnabled()) {  
            log.debug("converting '" + strDate + "' to date with mask '"+ aMask + "'");  
        }  
        try {  
            date = df.parse(strDate);  
        } catch (ParseException pe) {  
            log.error("ParseException: " + pe);  
            throw pe;  
        }  
        return (date);  
    }  
      
    /**  
     * 将日期字符串按默认格式转换成日期类型  
     */  
    public static Date convertStringToDate(String strDate)  
      throws ParseException {  
        Date aDate = null;  
  
        try {  
            if (log.isDebugEnabled()) {  
                log.debug("converting date with pattern: " + getDatePattern());  
            }  
            aDate = convertStringToDate(getDatePattern(), strDate);  
        } catch (ParseException pe) {  
            log.error("Could not convert '" + strDate  
                      + "' to a date, throwing exception");  
            throw new ParseException(pe.getMessage(),  
                                     pe.getErrorOffset());  
                      
        }  
  
        return aDate;  
    }  
      
    /**  
     * 返回一个JAVA简单类型的日期字符串  
     */  
    public static String getSimpleDateFormat(){  
        SimpleDateFormat formatter=new SimpleDateFormat();  
        String NDateTime=formatter.format(new Date());  
        return NDateTime;  
    }  
      
    /**  
     * 将两个字符串格式的日期进行比较  
     * @param last 要比较的第一个日期字符串  
     * @param now   要比较的第二个日期格式字符串  
     * @return true(last 在now 日期之前),false(last 在now 日期之后)  
     */  
    public static boolean compareTo(String last, String now) {  
        try {  
            SimpleDateFormat formatter = new SimpleDateFormat(  
                    "yyyy-MM-dd HH:mm:ss");  
            Date temp1 = formatter.parse(last);  
            Date temp2 = formatter.parse(now);  
            if (temp1.after(temp2))  
                return false;  
            else if (temp1.before(temp2))  
                return true;  
        } catch (ParseException e) {  
            log.debug(e.getMessage());  
        }  
        return false;  
    }

    /**  
     * 返回指定年份中指定月份的天数  
     * @param 年份year  
     * @param 月份month  
     * @return 指定月的总天数  
     */  
    public static String getMonthLastDay(int year,int month)  
    {  
        int[][] day={{0,30,28,31,30,31,30,31,31,30,31,30,31},  
                        {0,31,29,31,30,31,30,31,31,30,31,30,31}};  
        if(year%4==0 && year%100!=0 || year%400==0)   
        {  
            return day[1][month]+"";  
        }  
        else  
        {  
            return day[0][month]+"";  
        }  
    }  
      
    /**  
     * 取得当前时间的日戳  
     * @return  
     */  
    @SuppressWarnings("deprecation")  
    public static String getTimestamp(){  
        Date date=new Date();  
        String timestamp=""+(date.getYear()+1900)+date.getMonth()+date.getDate()+date.getMinutes()+date.getSeconds()+date.getTime();  
        return timestamp;  
    }  
    /**  
     * 取得指定时间的日戳  
     * @return  
     */  
    @SuppressWarnings("deprecation")  
    public static String getTimestamp(Date date){  
        String timestamp=""+(date.getYear()+1900)+date.getMonth()+date.getDate()+date.getMinutes()+date.getSeconds()+date.getTime();  
        return timestamp;  
    }
    
    /**
     * 获取格式化时间
     * @param date 时间参数
     * @return
     */
    public static String getDateByFormat2(Date date){
    	try{  
            return sdf2.format(date);  
        } catch(Exception e){
            log.debug("DateUtils.getDateTime():" + e.getMessage());  
            return "";  
        }  
    }
    public static void main(String[] args){  
        System.out.println(DateUtils.getDate());//获取日期格式为2010-08-12  
        System.out.println(DateUtils.getDateTime());//获取日期格式为2010-08-12 18:08:21  
        System.out.println(DateUtils.getTime());//获取日期格式为18:08:21  
        System.out.println(DateUtils.getYear());//获取当前时间年份2010  
        System.out.println(DateUtils.getMonth());//获取当年时间月份08  
        System.out.println(DateUtils.getStartDate());//获取2010-01-01  
        System.out.println(DateUtils.getEndDate());//2010-08-12  
        System.out.println(DateUtils.getDay());//获得服务器在当前月中已经过了的天数12  
        System.out.println(DateUtils.getMargin("2010-05-02", "2010-04-01"));//比较两个日期相差的天数  
        System.out.println(DateUtils.getDoubleMargin("2010-05-07 23:22:11", "2010-04-01 01:33:33"));  
    }
    
	/**
	 * 格式化时间公共方法
	 * 
	 * @param Date
	 *            date 日期
	 * @param String
	 *            format 格式化字符串 例如:yyyy-MM-dd
	 * @return String
	 */
	public static String format(Date date, String format) {
		if (date != null && !date.equals(null) && !isBlank(format)) {
			format = date_sampleFormat;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null && !date.equals(null)) {
			return sdf.format(date);
		} else {
			return null;
		}

	}
	
	/**
	 * 校验空串,只校验null,""两中情况
	 * 
	 * @param String
	 * @return boolean
	 */
	public static boolean isBlank(String v) {
		if (v != null && !v.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// 获得本周一0点时间 返回类型 Date
	public static Date getTimesWeekmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	// 获得本周一0点时间 返回类型 String
	public static String getTimesWeekmorningString() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf2.format(cal.getTime());
	}

	// 获得本周日24点时间
	public static String getTimesWeeknight() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, 7);
		return sdf2.format(cal.getTime());
	}

	// 获得本月第一天0点时间
	public static String getTimesMonthmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return sdf2.format(cal.getTime());
	}

	// 获得本月最后一天24点时间
	public static String getTimesMonthnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		return sdf2.format(cal.getTime());
	}
}
