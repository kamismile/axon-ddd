package com.dms.oauth.inf.client.cmd;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CheckClientIdCmd {
	
	@TargetAggregateIdentifier
	private String idClient;

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	

}
