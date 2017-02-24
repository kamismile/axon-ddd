package com.xh.oauth.inf.client.svc;

import com.xh.oauth.inf.client.cmd.CheckClientSecretCmd;
import com.xh.oauth.inf.client.cmd.CreateClientCmd;
import com.xh.oauth.inf.client.cmd.DeleteClientCmd;
import com.xh.oauth.inf.client.cmd.LoadClientCmd;
import com.xh.oauth.inf.client.cmd.UpdateClientCmd;

public interface ClientService {

	public void createClient(CreateClientCmd cmd);
    public void updateClient(UpdateClientCmd cmd);
    public void deleteClient(DeleteClientCmd cmd);
    public boolean isExist(LoadClientCmd cmd);
	public boolean checkClientSecret(CheckClientSecretCmd cmd);
}
