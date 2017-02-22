package com.xh.dms.inf.req;

import java.util.Date;

import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.xh.dms.base.common.ddd.Identifier;

public class MReqApplication implements Identifier<String>{
	
	/**
	 * id
	 */
	@AggregateIdentifier
	private String reqAppId;

	/**
	 * 需求人
	 */
	private String idMember;
	
	/**
	 * 需求人所属部门
	 */
	private String idDepartment;

	/**
	 * 需求描述
	 */
	private String appDescription;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 跟踪状态
	 */
	private boolean state;
	
	@Override
	public String identifier() {
		return reqAppId;
	}

	public String getReqAppId() {
		return reqAppId;
	}

	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	public String getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setReqAppId(String reqAppId) {
		this.reqAppId = reqAppId;
	}

}
