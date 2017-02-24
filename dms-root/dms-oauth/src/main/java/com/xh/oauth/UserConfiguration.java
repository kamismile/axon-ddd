package com.xh.oauth;

import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.GatewayProxyFactory;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xh.oauth.domain.user.User;
import com.xh.oauth.inf.user.svc.UserService;

@Configuration
@AnnotationDriven
public class UserConfiguration extends AppConfiguration{
	
	@Bean(name="userService")
    public UserService gatewayProxyFactory(){
    	GatewayProxyFactory gatewayProxyFactory = new GatewayProxyFactory(commandBus()); 
    	return gatewayProxyFactory.createGateway(UserService.class);
    }
	
	@Bean(name="user_aggregateFactory")
    public AggregateFactory<User> aggregateFactory() {
        return new GenericAggregateFactory<User>(User.class);
    }
	
	@Bean(name="user_eventSourcingRepository")
    public EventSourcingRepository<User> eventSourcingRepository() {
        EventSourcingRepository<User> eventSourcingRepository = new EventSourcingRepository<User>(aggregateFactory(), eventStore());
        eventSourcingRepository.setEventBus(eventBus());
        eventSourcingRepository.setSnapshotterTrigger(snapshotterTrigger());
        return eventSourcingRepository;
    }
	
	@Bean(name="user_aggregateAonnotationCommandHandler")
    public AggregateAnnotationCommandHandler<User> aggregateAonnotationCommandHandler(){
    	return AggregateAnnotationCommandHandler.subscribe(User.class, eventSourcingRepository(),commandBus());
    }

}
