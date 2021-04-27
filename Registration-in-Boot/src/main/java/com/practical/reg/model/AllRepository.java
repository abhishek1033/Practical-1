package com.practical.reg.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.reg.EntityModel.DtlProduct;
import com.practical.reg.EntityModel.ProductDetailsView;
import com.practical.reg.EntityModel.ProductImage;
import com.practical.reg.EntityModel.UserRegistration;
import com.practical.reg.repositiry.DtlProductRepository;
import com.practical.reg.repositiry.ProductDetailsViewRepository;
import com.practical.reg.repositiry.ProductImageRepository;
import com.practical.reg.repositiry.UserRegistrationRepository;

@Service
@Transactional
public class AllRepository 
{
	@Autowired
	private UserRegistrationRepository registrationRepository;
	
	@Autowired
	private DtlProductRepository productRepository;
	
	@Autowired
	private ProductImageRepository imageRepository;
	
	@Autowired
	private ProductDetailsViewRepository detailsViewRepository;

	public UserRegistration saveUserData(UserRegistration bo) 
	{
		UserRegistration returnBo = new UserRegistration();
		returnBo = registrationRepository.save(bo);
		return returnBo;
	}

	public UserRegistration userLogin(String user_NAME, String password) 
	{
		UserRegistration returnBo = registrationRepository.userLogin(user_NAME,password);
		return returnBo;
	}

	public UserRegistration getPassword(String user_NAME) 
	{
		UserRegistration returnBo = registrationRepository.findByUsername(user_NAME);
		return returnBo;
	}

	public UserRegistration userChangePassword(UserRegistration mstData) 
	{
		UserRegistration returnBo=registrationRepository.save(mstData);
		return returnBo;
	}

	public DtlProduct saveProductDetails(DtlProduct bo) 
	{
		DtlProduct returnBo = productRepository.save(bo);
		return returnBo;
	}

	public void saveProductImage(List<ProductImage> list) 
	{
		imageRepository.saveAll(list);
	}

	public List<ProductDetailsView> viewProductDetails(Integer product_ID) 
	{
		List<ProductDetailsView> list=  detailsViewRepository.getProductDetails(product_ID);
		return list;
	}

	public List<DtlProduct> getProductDetails(Integer product_ID) 
	{
		List<DtlProduct> list=  productRepository.getProduct(product_ID);
		return list;
	}

	

	
	
	
	
}
