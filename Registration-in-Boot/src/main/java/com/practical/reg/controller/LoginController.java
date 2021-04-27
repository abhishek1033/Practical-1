package com.practical.reg.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practical.reg.EntityModel.UserRegistration;
import com.practical.reg.constant.Constant;
import com.practical.reg.model.AuthenticationResponse;
import com.practical.reg.model.WebResponseJsonBo;
import com.practical.reg.service.LoginService;

@RestController
@RequestMapping("/login/api")
public class LoginController 
{
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebResponseJsonBo> saveNotificationData(@RequestBody String userdata,HttpServletRequest request) throws Exception 
	{
		  TypeToken<UserRegistration> user = new TypeToken<UserRegistration>() {};
		  UserRegistration bo = new Gson().fromJson(userdata, user.getType());
		  WebResponseJsonBo obj = new WebResponseJsonBo();
		   if(null != bo)
		   {
			   Map<String, Object> returnMap = loginService.userLogin(bo);
			   String msg = (String) returnMap.get("returnMsg");
			   String successMsg = (String) returnMap.get("successMsg");
			   if(null != msg && !msg.equals("") && msg.equals("SUCCESS"))
			   {
					if(successMsg !=null)
					{
						obj.setMessage_description(successMsg);
						obj.setSessionTableData(returnMap.get("sessionTableData"));
					}
					else
					{
						obj.setReturn_message("success message not found");
					}
					obj.setApplication_id((String)returnMap.get("application_id"));
					obj.setStatus(Constant.SUCCESS_CODE); //1000 status if data insert successfully..
					obj.setValidated(true);
					obj.setServiceStatus(true);
					obj.setP_OUT_MSG("success");
					
				}else
				{
					if(msg !=null && !"".equals(msg))
					{
						if(returnMap.get("successMsg") !=null)
						{
							obj.setMessage_description(successMsg);
						}
						if(returnMap.get("error_message") !=null)
						{
							obj.setError_message((Map<String,Object>)returnMap.get("error_message"));
						}
					}
					else
					{
						obj.setReturn_message("Exception Occure");
					}
					obj.setStatus(Constant.ERROR_CODE);
					obj.setValidated(false);
					obj.setServiceStatus(false);
					obj.setP_OUT_MSG("error");
					
				}
		   }
		   return ResponseEntity.ok(obj);
	  
	  }
	
	
	@RequestMapping(value = "/userForgetPassword",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebResponseJsonBo> userForgetPassword(@RequestBody String userdata,HttpServletRequest request) throws Exception 
	{
		  TypeToken<UserRegistration> user = new TypeToken<UserRegistration>() {};
		  UserRegistration bo = new Gson().fromJson(userdata, user.getType());
		  WebResponseJsonBo obj = new WebResponseJsonBo();
		   if(null != bo)
		   {
			   Map<String, Object> returnMap = loginService.userForgetPassword(bo);
			   String msg = (String) returnMap.get("returnMsg");
			   String successMsg = (String) returnMap.get("successMsg");
			   if(null != msg && !msg.equals("") && msg.equals("SUCCESS"))
			   {
					if(successMsg !=null)
					{
						obj.setMessage_description(successMsg);
					}
					else
					{
						obj.setReturn_message("success message not found");
					}
					obj.setApplication_id((String)returnMap.get("application_id"));
					obj.setStatus(Constant.SUCCESS_CODE); //1000 status if data insert successfully..
					obj.setValidated(true);
					obj.setServiceStatus(true);
					obj.setP_OUT_MSG("success");
					
				}else
				{
					if(msg !=null && !"".equals(msg))
					{
						if(returnMap.get("successMsg") !=null)
						{
							obj.setMessage_description(successMsg);
						}
						if(returnMap.get("error_message") !=null)
						{
							obj.setError_message((Map<String,Object>)returnMap.get("error_message"));
						}
					}
					else
					{
						obj.setReturn_message("Exception Occure");
					}
					obj.setStatus(Constant.ERROR_CODE);
					obj.setValidated(false);
					obj.setServiceStatus(false);
					obj.setP_OUT_MSG("error");
					
				}
		   }
		   return ResponseEntity.ok(obj);
	  
	  }
	
	
	@RequestMapping(value = "/userChangePassword",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebResponseJsonBo> userChangePassword(@RequestBody String userdata,HttpServletRequest request) throws Exception 
	{
		  TypeToken<UserRegistration> user = new TypeToken<UserRegistration>() {};
		  UserRegistration bo = new Gson().fromJson(userdata, user.getType());
		  WebResponseJsonBo obj = new WebResponseJsonBo();
		   if(null != bo)
		   {
			   Map<String, Object> returnMap = loginService.userChangePassword(bo);
			   String msg = (String) returnMap.get("returnMsg");
			   String successMsg = (String) returnMap.get("successMsg");
			   if(null != msg && !msg.equals("") && msg.equals("SUCCESS"))
			   {
					if(successMsg !=null)
					{
						obj.setMessage_description(successMsg);
					}
					else
					{
						obj.setReturn_message("success message not found");
					}
					obj.setApplication_id((String)returnMap.get("application_id"));
					obj.setStatus(Constant.SUCCESS_CODE); //1000 status if data insert successfully..
					obj.setValidated(true);
					obj.setServiceStatus(true);
					obj.setP_OUT_MSG("success");
					
				}else
				{
					if(msg !=null && !"".equals(msg))
					{
						if(returnMap.get("successMsg") !=null)
						{
							obj.setMessage_description(successMsg);
						}
						if(returnMap.get("error_message") !=null)
						{
							obj.setError_message((Map<String,Object>)returnMap.get("error_message"));
						}
					}
					else
					{
						obj.setReturn_message("Exception Occure");
					}
					obj.setStatus(Constant.ERROR_CODE);
					obj.setValidated(false);
					obj.setServiceStatus(false);
					obj.setP_OUT_MSG("error");
					
				}
		   }
		   return ResponseEntity.ok(obj);
	  
	  }
}
