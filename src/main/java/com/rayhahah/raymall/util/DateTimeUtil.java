package com.rayhahah.raymall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateTimeUtil {
	/**
	 * 默认的日期格式
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 默认的时间格式
	 */
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
	
	/**
	 * @author: Fu Chen
	 * @description:当前日期的字符串格式
	 * @return
	 * @date:2013-2-28
	 */
	public static final String getToday(){
		return dateFormat.format(new Date());
	}
	
	public static final String getTodayDateTime(){
		return dateTimeFormat.format(new Date());
	}
	
	public static final String getFirstDateOfCurrentMonth(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		return dateFormat.format(c.getTime());
	}
	
	public static final String getFirstDateOfMonth(String date){
		Calendar c = Calendar.getInstance();
		c.setTime(DateTimeUtil.formatDate(date));
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		return dateFormat.format(c.getTime());
	}
	
	public static final String getLastDateOfPrevMonth(String date){
		Calendar c = Calendar.getInstance();
		c.setTime(DateTimeUtil.formatDate(date));
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DATE, -1);
		
		return dateFormat.format(c.getTime());
	}
	
	
	
	public static final String getNextYearToday(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, 1);
		
		return dateFormat.format(c.getTime());
	}
	
	public static final String formatDate(Date date){
		return dateFormat.format(date);
	}
	
	public static final String formatDateTime(Date date){
		if(date==null){
			return "";
		}
		
		return dateTimeFormat.format(date);
	}
	
	public static final String formatDateTimeNull(Date date){
		if(date==null){
			return null;
		}
		
		return dateTimeFormat.format(date);
	}
	
	public static final String formatDate(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	public static final Date formatDate(String date){
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
		
	}
	
	public static final Date formatDate(String date,String format){
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return new Date();
		}
		
	}
	
	public static final Date formatDateNull(String date){
		if(date==null){
			return null;
		}
		
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
		
	}
	
	public static final Date formatDateNull(String date,String format){
		if(date==null){
			return null;
		}
		
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	
	/*******************************************/
	
	
    /**
     * 得到yyyy-MM-dd的日期字符串
     * @author Jie Wu
     * @param date
     * @return
     */
    public static String getDateStr(Date date) { 
    	if(date==null)
    		return "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");    
        return format.format(date);    
    }
    
    public static String getDateTimeStr(Date date) { 
    	if(date==null)
    		return "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        return format.format(date);    
    } 
    
    public static String getDateStr(Date date,String formatStr) { 
    	if(date==null)
    		return "";
        SimpleDateFormat format = new SimpleDateFormat(formatStr);    
        return format.format(date);    
    }  
    
    public static String getYearMonthStr(Date date) {    
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");    
        return format.format(date);    
    }  
    
    /**
     * 转化yyyy-MM-dd类型的字符串到Date类型
     * @author Jie Wu
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getDateByStr(String dateStr) throws ParseException{
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
    	return format.parse(dateStr);
    }
    
    /**
     * 返回周一到周日的7个日期的列表。
     * @author Jie Wu
     * @param date 
     * @return - 周一到周日的列表
     */
	public static List<Date> getCurrentWeekDates(Date date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	int nowDayOfWeek = c.get(Calendar.DAY_OF_WEEK); //今天本周的第几天  周日=1； 周一=2；周二=3，周三=4
    	int nowDay = c.get(Calendar.DAY_OF_MONTH);              //当前日     
    	int nowMonth = c.get(Calendar.MONTH);           //当前月
    	int nowYear = c.get(Calendar.YEAR);             //当前年     
    	nowYear += (nowYear < 2000) ? 1900 : 0;
    	List<Date> result = new ArrayList<Date>();
    	if(nowDayOfWeek!=1){//当前非周日
    		Calendar weekDate = Calendar.getInstance();
    		for(int i=0; i<7; i++){ 
    			weekDate.set(nowYear, nowMonth, nowDay - nowDayOfWeek+2+i);
    			result.add(weekDate.getTime());
    		}
    	}else{//当前是星期天，nowDayOfWeek=0。因为我们的周是星期天最后一天，所以要往前推
    		Calendar weekDate = Calendar.getInstance();
    		for(int i=0; i<7; i++){
    			weekDate.set(nowYear, nowMonth, nowDay - 6+i);
    			result.add(weekDate.getTime());
    		}
    	}
    	return result;
    }
	

	/**
	 * 通用日期格式化方法
	 * @param pattern 格式模板
	 * @param date 来源日期
	 * @return 格式化后的字符串
	 */
	public static String formatDate(String pattern, Date date){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		return simpleDateFormat.format(date);
	}
	
	public static final String getNextYearsToday(int years){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, years);
		
		return dateFormat.format(c.getTime());
	}
	
	/**
	 * 转换中文星期名称
	 * @param num 星期数字(calendar.get(Calendar.DAY_OF_WEEK))
	 * @return 中文名称的星期几
	 */
	public static String getWeekChinese(int num){
		String week = null;

		switch (num) {
		case 1:
			week = "星期日";
			break;
		case 2:
			week = "星期一";
			break;
		case 3:
			week = "星期二";
			break;
		case 4:
			week = "星期三";
			break;
		case 5:
			week = "星期四";
			break;
		case 6:
			week = "星期五";
			break;
		case 7:
			week = "星期六";
			break;
		default:
			break;
		}
		
		return week;
	}

	/**
	 * 数字1-7分别代表星期一到星期天
	 * @author Jie Wu
	 * @param num
	 * @return
	 */
	public static String getWeekChinese2(int num){
		String week = null;

		switch (num) {
		case 7:
			week = "周日";
			break;
		case 1:
			week = "周一";
			break;
		case 2:
			week = "周二";
			break;
		case 3:
			week = "周三";
			break;
		case 4:
			week = "周四";
			break;
		case 5:
			week = "周五";
			break;
		case 6:
			week = "周六";
			break;
		default:
			break;
		}
		
		return week;
	}
	/**
	 * 计算两个日期之间相隔多少天;支持跨年
	 * @param dateFrom 起始日期
	 * @param dateEnd 结束日期
	 * @return 相隔天数
	 */
	public static int getDaysBetweenTwoDates(Date dateFrom, Date dateEnd) {
		if(dateFrom == null || dateEnd == null){
			return -1;
		}
		// 实例日历
		Calendar frmCalendar = Calendar.getInstance();
		Calendar toCalendar = Calendar.getInstance();
		// 设置日历为节日开始日期
		frmCalendar.setTime(dateFrom);
		toCalendar.setTime(dateEnd);
		frmCalendar.set(Calendar.HOUR_OF_DAY, 0);
		frmCalendar.set(Calendar.MINUTE, 0);
		frmCalendar.set(Calendar.SECOND, 0);
		frmCalendar.set(Calendar.MILLISECOND, 0);
		toCalendar.set(Calendar.HOUR_OF_DAY, 0);
		toCalendar.set(Calendar.MINUTE, 0);
		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);
		long frmT = frmCalendar.getTimeInMillis();
		long toT = toCalendar.getTimeInMillis();
		int dd = (int) ((toT-frmT)/(1000*60*60*24));
		if(dd<0) dd=-1*dd;
		return dd;
	}
	/**
	 * 计算两个日期相差的年数
	 * 
	 * @author Jie Wu
	 * @param dateFrom
	 * @param dateEnd
	 * @return 相隔天数/365L，四舍五入
	 */
	public static int getYearsBetweenTwoYear(Date dateFrom, Date dateEnd){
		return Math.round(getDaysBetweenTwoDates(dateFrom, dateEnd)/365F);
	}
	
	/**
	 * 获得year-month月的第一天的日期
	 * @author Jie Wu
	 * @param year -年份，如2013年则输入2013
	 * @param month -月份，如1月则输入1，2月输入2; 如果是负数或者0则等于上年的月份，如0等于上年12月，-1等于上年11月；大于12的数为下年的月份，月份=month-12
	 * @return 日期
	 */
	public static Date getFirstDayOfMonth(int year, int month){
		  Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR,year);
		  cal.set(Calendar.MONTH, month-1);
		  cal.set(Calendar.DAY_OF_MONTH, 1);
		  Date firstDate = cal.getTime();
		  return firstDate;
	}
	/**
	 * 获得year-month月的最后一天的日期
	 * @author Jie Wu
	 * @param year -年份，如2013年则输入2013
	 * @param month -月份，如1月则输入1，2月输入2; 如果是负数或者0则等于上年的月份，如0等于上年12月，-1等于上年11月；大于12的数为下年的月份，月份=month-12
	 * @return 日期
	 */
	public static Date getLastDayOfMonth(int year, int month){
		  Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR,year);
		  cal.set(Calendar.MONTH, month);
		  cal.set(Calendar.DAY_OF_MONTH, 1);
		  cal.add(Calendar.DAY_OF_MONTH, -1);
		  Date lastDate = cal.getTime();
		  return lastDate;
	}
	
	/**
	* @author:Fu.Chen
	* @MethodName: getTimeBeforeMinuteStr 
	* @Description: 取得当前时间N分钟前的时间，返回字符串的格式
	* @param date
	* @param minutes
	* @return
	* @date:2016年6月21日
	*/
	public static String getTimeBeforeMinuteStr(Date date,int minutes){
		if(date==null){
			date = new Date();
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date d = new Date(date.getTime()-minutes*60*1000);
		return df.format(d);
	}
	
	/**
	* @author:Fu.Chen
	* @MethodName: getDateBefore 
	* @Description: 取得给定日期之前N天的日期
	* @param date
	* @param before
	* @return
	* @date:2016年7月1日
	*/
	public static Date getDateBefore(Date date,int before){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -before);
		return cal.getTime();
	}
	
	/**
	* @author:Fu.Chen
	* @MethodName: getDateBeforeStr 
	* @Description: 取得给定日期之前N天的日期的字符串
	* @param date
	* @param before
	* @return
	* @date:2016年7月1日
	*/
	public static String getDateBeforeStr(Date date,int before){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(getDateBefore(date, before));
		
	}

	public static Date getDateLater(Date date,int Later){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, Later);
		return cal.getTime();
	}
	public static Date getDateLater2(Date date,int Later){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, Later);
		return cal.getTime();
	}
	
	public static void main(String[] arg){
		int mon =1;
		System.out.println(getDateStr(getFirstDayOfMonth(2013,mon)));
		System.out.println(getDateStr(getLastDayOfMonth(2013,mon)));
	}

	//	将时间转换成Unix时间戳
	public static String date2TimeStamp(String date_str,String format){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return String.valueOf(sdf.parse(date_str).getTime()/1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//joda-time

	//str->Date
	//Date->str
	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";



	public static Date strToDate(String dateTimeStr,String formatStr){
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
		return dateTime.toDate();
	}

	public static String dateToStr(Date date,String formatStr){
		if(date == null){
			return StringUtils.EMPTY;
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(formatStr);
	}

	public static Date strToDate(String dateTimeStr){
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
		return dateTime.toDate();
	}

	public static String dateToStr(Date date){
		if(date == null){
			return StringUtils.EMPTY;
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(STANDARD_FORMAT);
	}

}
