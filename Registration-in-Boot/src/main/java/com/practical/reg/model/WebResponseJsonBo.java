package com.practical.reg.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.practical.reg.EntityModel.ProductDetailsView;

public class WebResponseJsonBo 
{
	@JsonInclude(Include.NON_NULL)
	private String application_id;
	
	@JsonInclude(Include.NON_NULL)
	private String return_message;
	
	@JsonInclude(Include.NON_NULL)
	private int status;
	
	@JsonInclude(Include.NON_NULL)
	private Map<String,Object> error_message;
	
	@JsonInclude(Include.NON_NULL)
	private String message_description;
	
	@JsonInclude(Include.NON_NULL)
	private boolean isValidated;
	
	@JsonInclude(Include.NON_NULL)
	private boolean serviceStatus;
	
	@JsonInclude(Include.NON_NULL)
	private String P_OUT_MSG;
	
	@JsonInclude(Include.NON_NULL)
	private String thumbnailFileName;
	
	@JsonInclude(Include.NON_NULL)
	private Object sessionTableData;
	
	@JsonInclude(Include.NON_NULL)
	private String responseData;
	
	@Transient
	private String role_name;
	
	@JsonInclude(Include.NON_NULL)
	private List<Object> Details;
	
	

	

	public List<Object> getDetails() {
		return Details;
	}

	public void setDetails(List<Object> details) {
		Details = details;
	}

	public String getApplication_id() {
		return application_id;
	}

	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}

	public String getReturn_message() {
		return return_message;
	}

	public void setReturn_message(String return_message) {
		this.return_message = return_message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, Object> getError_message() {
		return error_message;
	}

	public void setError_message(Map<String, Object> error_message) {
		this.error_message = error_message;
	}

	public String getMessage_description() {
		return message_description;
	}

	public void setMessage_description(String message_description) {
		this.message_description = message_description;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public boolean isServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(boolean serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getP_OUT_MSG() {
		return P_OUT_MSG;
	}

	public void setP_OUT_MSG(String p_OUT_MSG) {
		P_OUT_MSG = p_OUT_MSG;
	}

	public String getThumbnailFileName() {
		return thumbnailFileName;
	}

	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}

	public Object getSessionTableData() {
		return sessionTableData;
	}

	public void setSessionTableData(Object sessionTableData) {
		this.sessionTableData = sessionTableData;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
	
}
