package com.practical.reg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practical.reg.EntityModel.DtlProduct;
import com.practical.reg.constant.Constant;
import com.practical.reg.model.WebResponseJsonBo;
import com.practical.reg.service.ProductService;

@RestController
@RequestMapping("/pro/api")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	

	@RequestMapping(value = "/saveProductDetails",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebResponseJsonBo> saveProductDetails(@RequestBody String userdata,HttpServletRequest request) throws Exception 
	{
		  TypeToken<DtlProduct> token = new TypeToken<DtlProduct>() {};
		  DtlProduct bo = new Gson().fromJson(userdata, token.getType());
		  WebResponseJsonBo obj = new WebResponseJsonBo();
		   if(null != bo)
		   {
			   Map<String, Object> returnMap = productService.saveProductDetails(bo,request);
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
	
	
	@RequestMapping(value = "/viewProductDetails",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebResponseJsonBo> viewProductDetails(@RequestBody String userdata,HttpServletRequest request) throws Exception 
	{
		  TypeToken<DtlProduct> user = new TypeToken<DtlProduct>() {};
		  DtlProduct bo = new Gson().fromJson(userdata, user.getType());
		  WebResponseJsonBo obj = new WebResponseJsonBo();
		   if(null != bo)
		   {
			   Map<String, Object> returnMap = productService.viewProductDetails(bo);
			   String msg = (String) returnMap.get("returnMsg");
			   String successMsg = (String) returnMap.get("successMsg");
			   if(null != msg && !msg.equals("") && msg.equals("SUCCESS"))
			   {
					if(successMsg !=null)
					{
						obj.setMessage_description(successMsg);
						obj.setDetails((List<Object>) returnMap.get("Details"));
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
	
	
	@RequestMapping(value = "/getProductDetails",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebResponseJsonBo> getProductDetails(@RequestBody String userdata,HttpServletRequest request) throws Exception 
	{
		  TypeToken<DtlProduct> user = new TypeToken<DtlProduct>() {};
		  DtlProduct bo = new Gson().fromJson(userdata, user.getType());
		  WebResponseJsonBo obj = new WebResponseJsonBo();
		   if(null != bo)
		   {
			   Map<String, Object> returnMap = productService.getProductDetails(bo);
			   String msg = (String) returnMap.get("returnMsg");
			   String successMsg = (String) returnMap.get("successMsg");
			   if(null != msg && !msg.equals("") && msg.equals("SUCCESS"))
			   {
					if(successMsg !=null)
					{
						obj.setMessage_description(successMsg);
						obj.setDetails((List<Object>) returnMap.get("Details"));
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
