package com.dms.oauth.inf.client.svc;

import com.dms.oauth.domain.client.Client;
import com.dms.oauth.inf.client.cmd.CheckClientIdCmd;
import com.dms.oauth.inf.client.cmd.CheckClientSecretCmd;
import com.dms.oauth.inf.client.cmd.CreateClientCmd;
import com.dms.oauth.inf.client.cmd.DeleteClientCmd;
import com.dms.oauth.inf.client.cmd.LoadClientCmd;
import com.dms.oauth.inf.client.cmd.UpdateClientCmd;

public interface ClientService {

	public void createClient(CreateClientCmd cmd);
    public void updateClient(UpdateClientCmd cmd);
    public void deleteClient(DeleteClientCmd cmd);
    public boolean isExist(LoadClientCmd cmd);
	public boolean checkClientSecret(CheckClientSecretCmd cmd);
	public boolean checkClientId(CheckClientIdCmd cmd);
	public Client load(LoadClientCmd loadClientCmd);
}
