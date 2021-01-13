package com.spring.security.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.core.style.ToStringStyler;

public class CommonUtil {

	public CommonUtil() {
		
	}
	
	public static boolean isNullOrEmpty(String value)
	{
		return value == null || value.isBlank();
	}

	public static boolean isNullOrEmpty(String... values)
	{
		boolean isNullValue = true;
		for(int i=0; i<values.length; i++){
			isNullValue = isNullOrEmpty(values[i]);
		}
		return isNullValue;
	}
	
	public static <T> String toJson(T obj)
	{
		return new ReflectionToStringBuilder(obj, ToStringStyle.JSON_STYLE).toString();
	}
}
