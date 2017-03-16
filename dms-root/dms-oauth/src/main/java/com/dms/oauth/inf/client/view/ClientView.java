package com.dms.oauth.inf.client.view;

import org.springframework.data.annotation.Id;

public class ClientView{

	@Id
	private String clientId;
	
    private String clientName;
    
    private String clientSecret;
    
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


}
