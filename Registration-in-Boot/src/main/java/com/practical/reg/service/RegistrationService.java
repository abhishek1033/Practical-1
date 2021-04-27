package com.practical.reg.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.reg.EntityModel.UserRegistration;
import com.practical.reg.constant.Constant;
import com.practical.reg.model.AllRepository;
import com.practical.reg.utils.CommonUtility;

@Service
public class RegistrationService 
{
	@Autowired
	private AllRepository allRepository;
	
	public Map<String, Object> saveUserData(UserRegistration bo, HttpServletRequest request) 
	{
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		HttpSession session = request.getSession(false);
		try 
		{
			if(CommonUtility.isAlphaNumeric(bo.getPASSWORD()))
			{
				bo.setCrt_date(new Date());
				bo.setCrt_user("ADMIN");
				bo.setStatus(Constant.STATUS);
				bo.setCrt_ip(CommonUtility.getIp(request));
				
				UserRegistration mstData = allRepository.saveUserData(bo);
				if(mstData != null)
				{
					if(null != mstData.getUSER_ID())
					{
						returnMap.put("successMsg", "USER REGISTERED SUCCESSFULLY WITH USER ID : " + mstData.getUSER_ID());
						returnMap.put("returnMsg",Constant.MSG_SUCCESS);
					}
				}	
			}
			else
			{
				returnMap.put("successMsg", "PASSWORD MUST BE ALPHANUMERIC");
				returnMap.put("returnMsg",Constant.MSG_ERROR);
			}
			
			
		}
		catch(Exception e)
		{
			returnMap.put("returnMsg", Constant.MSG_ERROR);
			errorMap = new HashMap<String, String>();
			if (e.getCause() != null) 
			{
				if (e.getCause().getCause() != null) 
				{
					errorMap.put("error_message", e.getCause().getCause().toString());
				}
				else 
				{
					errorMap.put("error_message", e.getCause().toString());
				}
			}
			else 
			{
				errorMap.put("error_message", e.toString());
			}
			returnMap.put("error_message", errorMap);
		}
		return returnMap;
	}

}
