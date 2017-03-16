package com.dms.core.changelog.model;

import java.util.Date;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import com.dms.core.changelog.cmd.CReqAppChangeLogCmd;
import com.dms.core.changelog.evt.CReqAppChangeLogEvt;

public class ReqAppChangeLog extends AbstractAnnotatedAggregateRoot{
	
	@AggregateIdentifier
	private String idChangeLog;
	
	private String desc;
	
	private Date changeDate;
	
	private String idReqApp;
	
	private Enum reqAppChgLogState;

	public ReqAppChangeLog() {
		super();
	}

	/**
	 * @param cmd
	 * @see com.dms.core.changelog.model.ReqAppChangeLog#onCReqAppChangeLogEvt(CReqAppChangeLogEvt)
	 */
	@CommandHandler
	public ReqAppChangeLog(CReqAppChangeLogCmd cmd) {
		System.out.println("c create log.");
		apply(new CReqAppChangeLogEvt(cmd));
	}
	
	@EventSourcingHandler
	public void onCReqAppChangeLogEvt(CReqAppChangeLogEvt evt){
		this.idChangeLog = evt.getIdChangeLog();
		this.idReqApp = evt.getIdReqApp();
		this.changeDate = evt.getChangeDate();
		this.desc = evt.getDesc();
		this.reqAppChgLogState = evt.getReqAppChgLogState();
		System.out.println("change log created.");
	}
}
