package com.xh.dms.core.req.evd;

import java.util.Date;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xh.dms.core.changelog.cmd.CReqAppChangeLogCmd;
import com.xh.dms.core.req.evt.SubmitReqApplicationEvt;

@Component
public class SubmitReqApplicationEvdCreatChangeLog {
	@Autowired
	private CommandGateway commandGateway;
	
	@EventHandler
	public void createChangeLog(SubmitReqApplicationEvt evt){
		CReqAppChangeLogCmd cmd = new CReqAppChangeLogCmd( "shenqingtiijao", new Date(), evt.identifier());
		commandGateway.send(cmd);
	}
}
