package com.dms.oauth;

import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.GatewayProxyFactory;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dms.oauth.domain.client.Client;
import com.dms.oauth.inf.client.svc.ClientService;

@Configuration
@AnnotationDriven
public class ClientConfiguration extends AppConfiguration{
	
	@Bean(name="clientService")
    public ClientService gatewayProxyFactory(){
    	GatewayProxyFactory gatewayProxyFactory = new GatewayProxyFactory(commandBus()); 
    	return gatewayProxyFactory.createGateway(ClientService.class);
    }
	
	@Bean(name="client_aggregateFactory")
    public AggregateFactory<Client> aggregateFactory() {
        return new GenericAggregateFactory<Client>(Client.class);
    }
	
	@Bean(name="client_eventSourcingRepository")
    public EventSourcingRepository<Client> eventSourcingRepository() {
        EventSourcingRepository<Client> eventSourcingRepository = new EventSourcingRepository<Client>(aggregateFactory(), eventStore());
        eventSourcingRepository.setEventBus(eventBus());
        eventSourcingRepository.setSnapshotterTrigger(snapshotterTrigger());
        return eventSourcingRepository;
    }
	
	@Bean(name="client_aggregateAonnotationCommandHandler")
    public AggregateAnnotationCommandHandler<Client> aggregateAonnotationCommandHandler(){
    	return AggregateAnnotationCommandHandler.subscribe(Client.class, eventSourcingRepository(),commandBus());
    }

}
