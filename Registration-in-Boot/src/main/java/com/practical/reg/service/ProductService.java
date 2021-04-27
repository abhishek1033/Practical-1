package com.practical.reg.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.reg.EntityModel.DtlProduct;
import com.practical.reg.EntityModel.ProductDetailsView;
import com.practical.reg.EntityModel.ProductImage;
import com.practical.reg.EntityModel.UserRegistration;
import com.practical.reg.constant.Constant;
import com.practical.reg.model.AllRepository;
import com.practical.reg.utils.CommonUtility;

@Service
public class ProductService 
{
	@Autowired
	private AllRepository allRepository;

	public Map<String, Object> saveProductDetails(DtlProduct bo, HttpServletRequest request) 
	{
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		HttpSession session = request.getSession(false);
		String imagename = "",imagetype = "";
		ResourceBundle resourceBundle = null;
		resourceBundle = ResourceBundle.getBundle("Config.CommonConfig");
		try 
		{
			
				bo.setCrt_date(new Date());
				bo.setCrt_user("ADMIN");
				bo.setStatus(Constant.STATUS);
				bo.setCrt_ip(CommonUtility.getIp(request));
				
				DtlProduct mstData = allRepository.saveProductDetails(bo);
				if(mstData != null)
				{
					if(null != mstData.getPRODUCT_ID())
					{
						List<ProductImage> list=new ArrayList<>();
						if(null != mstData.getImage_list() && mstData.getImage_list().size()>0)
						{
							for(int i=0;i<mstData.getImage_list().size();i++)
							{
								ProductImage img = mstData.getImage_list().get(i);
								img.setPRODUCT_ID(mstData.getPRODUCT_ID());
								img.setCrt_date(new Date());
								img.setCrt_ip(CommonUtility.getIp(request));
								img.setCrt_user("user");
								img.setStatus("Y");
								
								BufferedImage image = null;
								byte[] imageBytes = null;
								
								String ImgPathremote = null;
								ImgPathremote = resourceBundle.getString("userDocuments.windows");
								
								
								if(null != img.getPHOTO_NAME() && !img.getPHOTO_NAME().equals(""))
								{
									try
									{
										int a1 = img.getPHOTO_NAME().lastIndexOf('.');
										imagename = "PRODUCT" +"_"+System.currentTimeMillis() +"_"+img.getPHOTO_NAME();
										imagetype = img.getPHOTO_NAME().substring(a1 + 1);
										ImgPathremote = ImgPathremote + imagename;

										
										if (img.getPRODUCT_PHOTO() != null && !("").equals(img.getPRODUCT_PHOTO())) 
										{

											imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(img.getPRODUCT_PHOTO());
											ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
											image = ImageIO.read(bis);
											bis.close();
											File file = new File(ImgPathremote);
											ImageIO.write(image, imagetype, file);
											img.setIMAGE_PATH(ImgPathremote);
											list.add(img);
										}
									}
									catch(Exception e)
									{
										e.printStackTrace();
										e.getMessage();
									}
								}
							}
							allRepository.saveProductImage(list);
						}
					}
				}
				returnMap.put("successMsg", "PRODUCT INSERTED SUCCESSFULLY...");
				returnMap.put("returnMsg",Constant.MSG_SUCCESS);
				
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

	public Map<String, Object> viewProductDetails(DtlProduct bo) 
	{
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		try 
		{
			if(null != bo.getPRODUCT_ID())
			{
				List<ProductDetailsView> mstData = allRepository.viewProductDetails(bo.getPRODUCT_ID());
				if(mstData != null)
				{
						returnMap.put("successMsg", Constant.MSG_SUCCESS);
						returnMap.put("Details", mstData);
						returnMap.put("returnMsg",Constant.MSG_SUCCESS);
				}	
			}
			else
			{
				returnMap.put("successMsg", "PRODUCT ID MUST BE REQUIRED");
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

	public Map<String, Object> getProductDetails(DtlProduct bo) 
	{
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, String> errorMap=null;
		try 
		{
			if(null != bo.getPRODUCT_ID())
			{
				List<DtlProduct> mstData = allRepository.getProductDetails(bo.getPRODUCT_ID());
				if(mstData != null)
				{
						returnMap.put("successMsg", Constant.MSG_SUCCESS);
						returnMap.put("Details", mstData);
						returnMap.put("returnMsg",Constant.MSG_SUCCESS);
				}	
			}
			else
			{
				returnMap.put("successMsg", "PRODUCT ID MUST BE REQUIRED");
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
