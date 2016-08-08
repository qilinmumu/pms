/**
 * 
 */
package edu.fjnu.pms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间与字符串转换的小工具
 * @author lzx
 */
public class DateUtils {
	/**
	 * 字符串时间转换为Date类型的时间
	 * @param dateString 字符串时间
	 * @param format 时间格式
	 * @return Date对象
	 * @author lzx
	 */
	public static Date stringToDate(String dateString, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateString);
			return date;
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * 将Date类型的时间转换为指定格式的字符串
	 * @param date 时间对象
	 * @param format 时间格式
	 * @return 字符串时间
	 * @author lzx
	 */
	public static String dateToString(Date date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 得到当前日期下，自定义时分秒的Date对象
	 * @param hour 小时
	 * @param month 分钟
	 * @param day 秒
	 * @return Date对象
	 * @author lzx
	 */
	public static Date getDefinedTime(Integer hour, Integer minute, Integer second){
		Calendar calendar = Calendar.getInstance();
		if (hour != null) {
			calendar.set(Calendar.HOUR_OF_DAY, hour.intValue());
		}
		if (minute != null) {
			calendar.set(Calendar.MINUTE, minute.intValue());
		}
		if (second != null) {
			calendar.set(Calendar.SECOND, second.intValue());
		}
		return calendar.getTime();
	}
	
	/**
	 * 得到年月日的字符串，例如：20151231,20160101
	 * @return 日期字符串
	 * @author lzx
	 */
	public static String getTodayDateStr(){
		Calendar calendar = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append(calendar.get(Calendar.YEAR));
		int month = calendar.get(Calendar.MONTH) + 1;	//一月返回0，所以要加一
		if (month < 10) {
			sb.append("0");
			sb.append(month);	
		} else {
			sb.append(month);
		}
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			sb.append("0");
			sb.append(day);
		} else {
			sb.append(day);
		}
		return sb.toString();
	}
}
