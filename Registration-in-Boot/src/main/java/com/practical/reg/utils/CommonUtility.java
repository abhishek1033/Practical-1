package com.practical.reg.utils;

import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class CommonUtility 
{
	public static String getIp(HttpServletRequest request) throws UnknownHostException
	{
		String usrIp = request.getHeader("X-FORWARDED-FOR");
		if(usrIp==null || usrIp == "")
		{
			usrIp = request.getRemoteAddr();
		}
		
		return usrIp;
	}
	
	public static boolean isAlphaNumeric(String str)
    {
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(regex);
        if (str == null) 
        {
            return false;
        }
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
