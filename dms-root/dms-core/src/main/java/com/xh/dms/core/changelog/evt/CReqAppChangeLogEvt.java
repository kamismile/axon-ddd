package com.xh.dms.core.changelog.evt;

import java.util.Date;
import java.util.UUID;

import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.xh.dms.core.changelog.cmd.CReqAppChangeLogCmd;

public class CReqAppChangeLogEvt {

	@AggregateIdentifier
	private String idChangeLog;
	
	private String desc;
	
	private Date changeDate;
	
	private String idReqApp;
	
	private Enum reqAppChgLogState;
	
	public CReqAppChangeLogEvt(CReqAppChangeLogCmd cmd) {
		this.idChangeLog = UUID.randomUUID().toString();
		this.desc = cmd.getDesc();
		this.changeDate = cmd.getChangeDate();
		this.idReqApp = cmd.getIdReqApp();
		this.reqAppChgLogState = cmd.getReqAppChgLogState();
	}

	public String getIdChangeLog() {
		return idChangeLog;
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
