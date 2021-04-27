package com.practical.reg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommonTableFieldBo 
{
	@Column(name = "CRT_DATE",updatable = false)
	private Date crt_date;
	
	@Column(name = "CRT_USER",updatable = false)
	private String crt_user;
	
	@Column(name = "CRT_IP",updatable = false)
	private String crt_ip;
	
	@Column(name = "LST_UPD_DATE")
	private Date lst_upd_date;
	
	@Column(name = "LST_UPD_USER")
	private String lst_upd_user;
	
	@Column(name = "LST_UPD_IP")
	private String lst_upd_ip;
	
	@Column(name = "STATUS")
	private String status;

	public Date getCrt_date() {
		return crt_date;
	}

	public void setCrt_date(Date crt_date) {
		this.crt_date = crt_date;
	}

	public String getCrt_user() {
		return crt_user;
	}

	public void setCrt_user(String crt_user) {
		this.crt_user = crt_user;
	}

	public String getCrt_ip() {
		return crt_ip;
	}

	public void setCrt_ip(String crt_ip) {
		this.crt_ip = crt_ip;
	}

	public Date getLst_upd_date() {
		return lst_upd_date;
	}

	public void setLst_upd_date(Date lst_upd_date) {
		this.lst_upd_date = lst_upd_date;
	}

	public String getLst_upd_user() {
		return lst_upd_user;
	}

	public void setLst_upd_user(String lst_upd_user) {
		this.lst_upd_user = lst_upd_user;
	}

	public String getLst_upd_ip() {
		return lst_upd_ip;
	}

	public void setLst_upd_ip(String lst_upd_ip) {
		this.lst_upd_ip = lst_upd_ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
