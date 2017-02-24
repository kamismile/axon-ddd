package com.xh.oauth.domain.client;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import com.xh.oauth.domain.client.evt.CreateClientEvt;
import com.xh.oauth.domain.client.evt.DeleteClientEvt;
import com.xh.oauth.domain.client.evt.UpdateClientEvt;
import com.xh.oauth.inf.client.cmd.CreateClientCmd;
import com.xh.oauth.inf.client.cmd.DeleteClientCmd;
import com.xh.oauth.inf.client.cmd.UpdateClientCmd;

public class Client extends AbstractAnnotatedAggregateRoot<String> {

	@AggregateIdentifier
	private String clientId;
    private String clientName;
    private String clientSecret;

    public Client() {
		super();
	}
    
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
    
    
    public Client(CreateClientCmd cmd) {
    	CreateClientEvt evt = new CreateClientEvt();
    	evt.setClientId(cmd.getClientId());
    	evt.setClientName(cmd.getClientName());
    	evt.setClientSecret(cmd.getClientSecret());
		apply(evt);
	}
    
    @EventSourcingHandler
    public void onCreate(CreateClientEvt evt){
    	this.clientId = evt.getClientId();
    	this.clientName = evt.getClientName();
    	this.clientSecret = evt.getClientSecret();
    }
    
    @CommandHandler
    public void updateClient(UpdateClientCmd cmd){
    	UpdateClientEvt evt = new UpdateClientEvt();
    	evt.setClientId(cmd.getClientId());
    	evt.setClientName(cmd.getClientName());
    	evt.setClientSecret(cmd.getClientSecret());
    	apply(evt);
    }
    
    @EventSourcingHandler
    public void onUpdate(UpdateClientEvt evt){
    	this.clientId = evt.getClientId();
    	this.clientName = evt.getClientName();
    	this.clientSecret = evt.getClientSecret();
    }
    
    @CommandHandler
    public void deleteClient(DeleteClientCmd cmd){
    	DeleteClientEvt evt = new DeleteClientEvt();
    	evt.setClientId(cmd.getClientId());
    	markDeleted();
    	apply(evt);
    }
    
    @EventSourcingHandler
    public void onDelete(DeleteClientEvt evt){
    	markDeleted();
    }

}
