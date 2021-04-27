package com.practical.reg.service;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.reg.EntityModel.UserRegistration;
import com.practical.reg.constant.Constant;
import com.practical.reg.model.AllRepository;
import com.practical.reg.utils.CommonUtility;

@Service
public class LoginService 
{
	@Autowired
	private AllRepository allRepository;

	public Map<String, Object> userLogin(UserRegistration bo) 
	{
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		try 
		{
			if(!StringUtils.isBlank(bo.getPASSWORD()) && !StringUtils.isBlank(bo.getUSER_NAME()))
			{
				
				UserRegistration mstData = allRepository.userLogin(bo.getUSER_NAME(),bo.getPASSWORD());
				if(mstData != null)
				{
						returnMap.put("successMsg", "SUCCESS");
						returnMap.put("returnMsg",Constant.MSG_SUCCESS);
						returnMap.put("sessionTableData", mstData);
				}
				else
				{
					returnMap.put("successMsg", "USERNAME AND PASSWORD NOT MATCH");
					returnMap.put("returnMsg",Constant.MSG_ERROR);
				}
			}
			else
			{
				returnMap.put("successMsg", "USERNAME AND PASSWORD NOT BE EMPTY");
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

	public Map<String, Object> userForgetPassword(UserRegistration bo) 
	{
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		try 
		{
			if(!StringUtils.isBlank(bo.getUSER_NAME()))
			{
				UserRegistration mstData = allRepository.getPassword(bo.getUSER_NAME());
				if(mstData != null)
				{
						returnMap.put("successMsg", "YOUR PASSWORD IS : " + mstData.getPASSWORD());
						returnMap.put("returnMsg",Constant.MSG_SUCCESS);
				}	
			}
			else
			{
				returnMap.put("successMsg", "USERNAME MUST BE REQUIRED");
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

	public Map<String, Object> userChangePassword(UserRegistration bo) 
	{

		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		try 
		{
			if(!StringUtils.isBlank(bo.getUSER_NAME()) && !StringUtils.isBlank(bo.getCURRENT_PASSWORD()) && !StringUtils.isBlank(bo.getNEW_PASSWORD()))
			{
				UserRegistration mstData = allRepository.userLogin(bo.getUSER_NAME(),bo.getCURRENT_PASSWORD());
				if(mstData != null)
				{
						mstData.setPASSWORD(bo.getNEW_PASSWORD());
						mstData.setLst_upd_date(new Date());
						mstData.setLst_upd_ip(InetAddress.getLocalHost().getHostAddress());
						mstData.setLst_upd_user("self");
						mstData = allRepository.userChangePassword(mstData);
					
						returnMap.put("successMsg", "PASSWORD IS CHANGED SUCCESSFULLY...");
						returnMap.put("returnMsg",Constant.MSG_SUCCESS);
				}
				else
				{
					returnMap.put("successMsg", "USERNAME AND CURRENT PASSWORD IS NOT MATCHED!!");
					returnMap.put("returnMsg",Constant.MSG_ERROR);
				}
			}
			else
			{
				returnMap.put("successMsg", "USERNAME MUST BE REQUIRED");
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
