package com.practical.reg.EntityModel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.practical.reg.model.CommonTableFieldBo;

@Entity
@Table(name="DTL_PRODUCT") 
public class DtlProduct extends CommonTableFieldBo
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator= "USER_REG_SEQ")
	@SequenceGenerator(name = "USER_REG_SEQ",sequenceName= "USER_REG_SEQ",allocationSize=1)
	private Integer PRODUCT_ID;

	@Column(name="PRODUCT_NAME")
	private String PRODUCT_NAME;

	@Column(name="QUANTITY")
	private String QUANTITY;
	
	@Column(name="CATEGORY")
	private String CATEGORY;
	
	@Transient
	private List<ProductImage> image_list;

	public Integer getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(Integer pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(String qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public List<ProductImage> getImage_list() {
		return image_list;
	}

	public void setImage_list(List<ProductImage> image_list) {
		this.image_list = image_list;
	}
	
	
}
