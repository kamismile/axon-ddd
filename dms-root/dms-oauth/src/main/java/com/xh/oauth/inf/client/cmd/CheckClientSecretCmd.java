package com.xh.oauth.inf.client.cmd;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CheckClientSecretCmd {

	@TargetAggregateIdentifier
	private String clientId;
    
    private String clientSecret;

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
