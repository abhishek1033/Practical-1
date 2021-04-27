package com.practical.reg.EntityModel;

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
@Table(name="DTL_PRODUCT_IMAGE") 
public class ProductImage extends CommonTableFieldBo
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator= "USER_REG_SEQ")
	@SequenceGenerator(name = "USER_REG_SEQ",sequenceName= "USER_REG_SEQ",allocationSize=1)
	private Integer IMAGE_ID;
	
	@Column(name="IMAGE_PATH")
	private String IMAGE_PATH;
	
	@Column(name="PRODUCT_ID")
	private Integer PRODUCT_ID;
	
	@Transient
	private String PRODUCT_PHOTO,PHOTO_NAME;
	
	

	

	public String getPRODUCT_PHOTO() {
		return PRODUCT_PHOTO;
	}

	public void setPRODUCT_PHOTO(String pRODUCT_PHOTO) {
		PRODUCT_PHOTO = pRODUCT_PHOTO;
	}

	public String getPHOTO_NAME() {
		return PHOTO_NAME;
	}

	public void setPHOTO_NAME(String pHOTO_NAME) {
		PHOTO_NAME = pHOTO_NAME;
	}

	public Integer getIMAGE_ID() {
		return IMAGE_ID;
	}

	public void setIMAGE_ID(Integer iMAGE_ID) {
		IMAGE_ID = iMAGE_ID;
	}

	public String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public void setIMAGE_PATH(String iMAGE_PATH) {
		IMAGE_PATH = iMAGE_PATH;
	}

	public Integer getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(Integer pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	
}
