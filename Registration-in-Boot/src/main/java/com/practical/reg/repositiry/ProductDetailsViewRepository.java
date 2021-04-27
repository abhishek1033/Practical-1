package com.practical.reg.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practical.reg.EntityModel.ProductDetailsView;

@Repository
public interface ProductDetailsViewRepository extends JpaRepository<ProductDetailsView, Integer> 
{
	@Query("from ProductDetailsView where PRODUCT_ID=?1 ")
	List<ProductDetailsView> getProductDetails(Integer product_ID);

}
