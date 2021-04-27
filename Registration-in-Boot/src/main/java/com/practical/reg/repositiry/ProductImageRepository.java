package com.practical.reg.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practical.reg.EntityModel.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> 
{

}
