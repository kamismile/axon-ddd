package com.dms.oauth.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.oauth.inf.client.cmd.CreateClientCmd;
import com.dms.oauth.inf.client.cmd.DeleteClientCmd;
import com.dms.oauth.inf.client.cmd.UpdateClientCmd;
import com.dms.oauth.inf.client.svc.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/create")
    public Object create(CreateClientCmd cmd) {
    	cmd.setClientId(UUID.randomUUID().toString());
        clientService.createClient(cmd);
        return cmd;
    }

    @RequestMapping(value = "/update/{clientId}")
    public Object update(UpdateClientCmd cmd) {
        clientService.updateClient(cmd);
        return cmd;
    }

    @RequestMapping(value = "/delete/{clientId}")
    public Object delete(DeleteClientCmd cmd) {
        clientService.deleteClient(cmd);
        return cmd;
    }

}
