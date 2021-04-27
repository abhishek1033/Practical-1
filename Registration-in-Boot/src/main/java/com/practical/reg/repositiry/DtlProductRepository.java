package com.practical.reg.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practical.reg.EntityModel.DtlProduct;

@Repository
public interface DtlProductRepository extends JpaRepository<DtlProduct, Integer>
{

	@Query("from DtlProduct where PRODUCT_ID=?1 ")
	List<DtlProduct> getProduct(Integer product_ID);

}
