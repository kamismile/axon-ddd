package com.dms.oauth.inf.client.cmd;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateClientCmd {

    private String clientName;
    
    @TargetAggregateIdentifier
    private String clientId;
    
    private String clientSecret;
    
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
    
    
}
