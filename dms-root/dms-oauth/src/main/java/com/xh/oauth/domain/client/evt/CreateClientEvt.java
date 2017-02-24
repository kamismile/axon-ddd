package com.xh.oauth.domain.client.evt;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateClientEvt {

    private String clientName;
    
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
