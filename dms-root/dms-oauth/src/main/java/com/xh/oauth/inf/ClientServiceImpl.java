package com.xh.oauth.inf;

import java.util.List;
import java.util.UUID;

import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xh.oauth.inf.client.cmd.CreateClientCmd;
import com.xh.oauth.inf.client.cmd.DeleteClientCmd;
import com.xh.oauth.inf.client.cmd.LoadClientCmd;
import com.xh.oauth.inf.client.cmd.UpdateClientCmd;

//@Service
public class ClientServiceImpl  {/*
    @Autowired
    private Repository<Client> repository;

    @Override
    public Client createClient(Client client) {

        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        return clientDao.createClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientDao.deleteClient(clientId);
    }

    @Override
    public Client findOne(Long clientId) {
        return clientDao.findOne(clientId);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findByClientId(String clientId) {
        return clientDao.findByClientId(clientId);
    }

    @Override
    public Client findByClientSecret(String clientSecret) {
        return clientDao.findByClientSecret(clientSecret);
    }

	@Override
	public Client load(String clientId) {
		return repository.load(clientId);
	}

	@Override
	public Client createClient(CreateClientCmd cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client updateClient(UpdateClientCmd cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(DeleteClientCmd cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client loadClient(LoadClientCmd cmd) {
		// TODO Auto-generated method stub
		return null;
	}
*/}
