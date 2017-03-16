package com.dms.oauth.app.client.evd;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oauth.domain.client.evt.CreateClientEvt;
import com.dms.oauth.domain.client.evt.DeleteClientEvt;
import com.dms.oauth.domain.client.evt.UpdateClientEvt;
import com.dms.oauth.inf.client.view.ClientView;
import com.dms.oauth.inf.client.view.ClientViewRepository;

import net.sf.cglib.beans.BeanCopier;

@Component
public class ClientViewEventHandler {
	
	@Autowired
	private ClientViewRepository clientViewRepository;   

	
	@EventHandler
    public void onCreate(CreateClientEvt evt){
		ClientView clientView = new ClientView();
		BeanCopier beanCopier = BeanCopier.create(CreateClientEvt.class,ClientView.class,false);
		beanCopier.copy(evt, clientView, null);
		clientViewRepository.insert(clientView);
    }
    
	@EventHandler
    public void onUpdate(UpdateClientEvt evt){
		ClientView clientView = new ClientView();
		BeanCopier beanCopier = BeanCopier.create(UpdateClientEvt.class,ClientView.class,false);
		beanCopier.copy(evt, clientView, null);
		clientViewRepository.save(clientView);
    }
    
    @EventHandler
    public void onDelete(DeleteClientEvt evt){
    	clientViewRepository.delete(evt.getClientId());
    }
}
