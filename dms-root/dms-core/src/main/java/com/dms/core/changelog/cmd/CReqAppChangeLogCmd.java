package com.dms.core.changelog.cmd;

import java.util.Date;

import com.dms.core.changelog.model.ReqAppChgLogState;

public class CReqAppChangeLogCmd {

	private String desc;
	
	private Date changeDate;
	
	private String idReqApp;
	
	private Enum reqAppChgLogState;

	public CReqAppChangeLogCmd(String desc,Date changeDate, String idReqApp) {
		super();
		this.desc = desc;
		this.changeDate = changeDate;
		this.idReqApp = idReqApp;
		this.reqAppChgLogState = ReqAppChgLogState.SUBMIT;
	}

	public String getDesc() {
		return desc;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public String getIdReqApp() {
		return idReqApp;
	}

	public Enum getReqAppChgLogState() {
		return reqAppChgLogState;
	}
	
	
}
