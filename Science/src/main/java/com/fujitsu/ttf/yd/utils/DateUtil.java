package com.fujitsu.ttf.yd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @Description 时间工具类
 * @author 鲜攀
 * @date: 2019年10月14日 下午3:57:54
 */
public class DateUtil {

	/**
	 * @Description string 解析为时间
	 * @param dateStr 时间的字符串
	 * @param format  解析的时间格式
	 * @return 时间
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			return new SimpleDateFormat(format).parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @Description 将 obj 解析成 时间类型
	 * @param obj 任意对象
	 * @return 时间
	 */
	public static Date parseDate(Object obj) {
		if (null == obj) {
			return null;
		}
		if (obj instanceof Date) {
			return (Date) obj;
		}
		if (obj instanceof java.sql.Date) {
			return (Date) obj;
		}
		// 为字符串时
		if (obj instanceof String) {
			String dateStr = (String) obj;
			StringBuilder builder = new StringBuilder("yyyy");
			if (dateStr.charAt(4) == '-') {
				builder.append("-MM-dd");
			} else if (dateStr.charAt(4) == '/') {
				builder.append("/MM/dd");
			} else if (dateStr.charAt(4) == '_') {
				builder.append("_MM_dd");
			} else {
				builder.append("MMdd");
			}
			if (dateStr.length() < builder.length()) {
				return null;
			} else if (dateStr.length() == builder.length()) {
				return parseDate(dateStr, builder.toString());
			}
			if (dateStr.charAt(builder.length()) == ' ') {
				builder.append(' ');
			}
			if (dateStr.charAt(builder.length() + 2) == ':') {
				builder.append("HH:mm:ss");
			} else if (dateStr.charAt(builder.length() + 2) == '/') {
				builder.append("HH/mm/ss");
			} else {
				builder.append("HHmmss");
			}
			if (dateStr.length() < builder.length()) {
				return null;
			}
			if (dateStr.length() == builder.length()) {
				return parseDate(dateStr, builder.toString());
			}
			if (dateStr.charAt(builder.length()) == '.' && dateStr.length() == (builder.length() + 4)) {
				builder.append(".SSS");
			} else if (dateStr.length() == (builder.length() + 3)) {
				builder.append("SSS");
			} else {
				dateStr = dateStr.substring(0, builder.length());
			}
			return parseDate(dateStr, builder.toString());
		}
		// 为长整型时
		if (obj instanceof Long) {
			long l = (long) obj;
			if (l < 10000000000l) {
				return new Date(l * 1000);
			}
			return new Date(l);
		}
		// 为短整型时
		if (obj instanceof Integer) {
			long l = (int) obj * 1000;
			return new Date(l);
		}
		return null;
	}
}
