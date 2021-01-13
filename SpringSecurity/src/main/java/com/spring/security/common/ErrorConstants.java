package com.spring.security.common;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import static com.spring.security.common.CommonUtil.isNullOrEmpty;
public class ErrorConstants {

	private static final Map<String, String> errorMap = new HashMap<String, String>();
	public ErrorConstants() {
		
	}

	public static final String REQUIRED_FIELDS_MISSING = "APP-RUL-1001";
	public static final String REQUIRED_FIELDS_MISSING_DESC = "{0} must be populated.";
	
	public static final String DUPLICATE_USER = "APP-RUL-1010";
	public static final String DUPLICATE_USER_DESC = "User {0} already exists.";
	
	public static final String USER_ROLE_MISSING = "APP-RUL-1011";
	public static final String USER_ROLE_MISSING_DESC = "User {0} must have at least one permission group assigned.";
	
	static {
		errorMap.put(DUPLICATE_USER, DUPLICATE_USER_DESC);
		errorMap.put(REQUIRED_FIELDS_MISSING, REQUIRED_FIELDS_MISSING_DESC);
		errorMap.put(USER_ROLE_MISSING, USER_ROLE_MISSING_DESC);
	}
	
	public static String getErrorDescription(String errorCode, Object... dynamicValues)
	{
		String descString = errorMap.get(errorCode);
		StringBuilder formattedDesc = new StringBuilder();
		if(isNullOrEmpty(descString)){
			formattedDesc.append(errorCode);
		}
		else {
			formattedDesc.append(new MessageFormat(descString).format(dynamicValues));
		}
		return formattedDesc.toString();
	}
}
