package com.practical.reg.EntityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_DETAILS_VIEW")
public class ProductDetailsView 
{
	@Id
	@Column(name="PRODUCT_ID")
	private Integer PRODUCT_ID;
	
	@Column(name="PRODUCT_NAME")
	private String PRODUCT_NAME;
	
	@Column(name="QUANTITY")
	private String QUANTITY;
	
	@Column(name="CATEGORY")
	private String CATEGORY;
	
	@Column(name="STATUS")
	private String STATUS;
	
	@Column(name="IMAGE_PATH")
	private String IMAGE_PATH;
	
	

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

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	
}
