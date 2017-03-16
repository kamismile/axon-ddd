package com.dms.core.inf.req.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReqApplicationDto{
	
	@Id
	private String reqAppId;	
	
	private String idMember;
	
	private String idDepartment;

	private String appDescription;
	
	private Date createTime;
	
	private boolean state;

	public void setReqAppId(String reqAppId) {
		this.reqAppId = reqAppId;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getReqAppId() {
		return reqAppId;
	}

	public String getIdMember() {
		return idMember;
	}

	public String getIdDepartment() {
		return idDepartment;
	}

	public String getAppDescription() {
		return appDescription;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public boolean isState() {
		return state;
	}
	
	
}
