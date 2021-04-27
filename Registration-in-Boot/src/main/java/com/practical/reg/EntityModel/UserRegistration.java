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
@Table(name="DTL_USER_REGISTRATION") 
public class UserRegistration  extends CommonTableFieldBo
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator= "USER_REG_SEQ")
	@SequenceGenerator(name = "USER_REG_SEQ",sequenceName= "USER_REG_SEQ",allocationSize=1)
	private Integer USER_ID;
	
	@Column(name="FIRST_NAME")
	private String FIRST_NAME;
	
	@Column(name="LAST_NAME")
	private String LAST_NAME;
	
	@Column(name="EMAIL_ID")
	private String EMAIL_ID;
	
	@Column(name="AGE")
	private Integer AGE;
	
	@Column(name="USER_NAME")
	private String USER_NAME;
	
	@Column(name="PASSWORD")
	private String PASSWORD;


	@Column(name="ROLE_ID")
	private String ROLE_ID;
	
	@Transient
	private String NEW_PASSWORD,CURRENT_PASSWORD;
	
	

	public String getNEW_PASSWORD() {
		return NEW_PASSWORD;
	}

	public void setNEW_PASSWORD(String nEW_PASSWORD) {
		NEW_PASSWORD = nEW_PASSWORD;
	}

	public String getCURRENT_PASSWORD() {
		return CURRENT_PASSWORD;
	}

	public void setCURRENT_PASSWORD(String cURRENT_PASSWORD) {
		CURRENT_PASSWORD = cURRENT_PASSWORD;
	}

	public String getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public Integer getAGE() {
		return AGE;
	}

	public void setAGE(Integer aGE) {
		AGE = aGE;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	
}
