package com.dms.oauth.app.client.chd;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.inf.exception.AppBizException;
import com.dms.oauth.domain.client.Client;
import com.dms.oauth.inf.client.cmd.CheckClientIdCmd;
import com.dms.oauth.inf.client.cmd.CreateClientCmd;
import com.dms.oauth.inf.client.cmd.LoadClientCmd;
import com.dms.oauth.inf.client.view.ClientView;
import com.dms.oauth.inf.client.view.ClientViewRepository;

@Component
public class ClientCommandHandler {
	
	@Autowired
	private ClientViewRepository clientViewRepository;
	
	@Autowired
	private Repository<Client> repository;
	
	@CommandHandler
	public void createClient(CreateClientCmd cmd) throws AppBizException{
		ClientView clientView = clientViewRepository.findByClientName(cmd.getClientName());
		if(clientView != null){
			throw new AppBizException("", new UnsupportedOperationException(), "unsupported operation", cmd.getClientName());
		}
		repository.add(new Client(cmd));
	}
	
	@CommandHandler
	public boolean checkClientId(CheckClientIdCmd cmd){
		Client load = repository.load(cmd.getIdClient());
		return load != null;
	}
	
	@CommandHandler
	public Client load(LoadClientCmd cmd){
		return repository.load(cmd.getClientId());
	}

}
