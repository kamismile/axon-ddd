package com.xh.oauth.app.client.chd;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xh.dms.base.exception.AppBizException;
import com.xh.oauth.domain.client.Client;
import com.xh.oauth.inf.client.cmd.CreateClientCmd;
import com.xh.oauth.inf.client.view.ClientView;
import com.xh.oauth.inf.client.view.ClientViewRepository;

@Component
public class ClientCommandHandler {
	
	@Autowired
	private ClientViewRepository userViewRepository;
	
	@Autowired
	private Repository<Client> repository;
	
	@CommandHandler
	public void createClient(CreateClientCmd cmd) throws AppBizException{
		ClientView clientView = userViewRepository.findByClientName(cmd.getClientName());
		if(clientView != null){
			throw new AppBizException("", new UnsupportedOperationException(), "unsupported operation", cmd.getClientName());
		}
		repository.add(new Client(cmd));
	}

}
