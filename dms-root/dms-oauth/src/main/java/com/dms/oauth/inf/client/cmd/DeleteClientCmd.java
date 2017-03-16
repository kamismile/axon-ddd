package com.dms.oauth.inf.client.cmd;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class DeleteClientCmd {

	@TargetAggregateIdentifier
	private String clientId;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	
}
