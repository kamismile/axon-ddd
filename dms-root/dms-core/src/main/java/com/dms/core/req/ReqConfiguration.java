package com.dms.core.req;

import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.GatewayProxyFactory;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dms.core.AppConfiguration;
import com.dms.core.inf.req.svc.IReqApplicationCmdService;
import com.dms.core.req.model.ReqApplication;

@Configuration
@AnnotationDriven
public class ReqConfiguration extends AppConfiguration{
	
	@Bean(name="IReqApplicationService")
    public IReqApplicationCmdService gatewayProxyFactory(){
    	GatewayProxyFactory gatewayProxyFactory = new GatewayProxyFactory(commandBus()); 
    	return gatewayProxyFactory.createGateway(IReqApplicationCmdService.class);
    }
	
	@Bean(name="ReqApplication_aggregateFactory")
    public AggregateFactory aggregateFactory() {
        return new GenericAggregateFactory(ReqApplication.class);
    }
	
	@Bean(name="ReqApplication_eventSourcingRepository")
    public EventSourcingRepository eventSourcingRepository() {
        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(aggregateFactory(), eventStore());
        eventSourcingRepository.setEventBus(eventBus());
        eventSourcingRepository.setSnapshotterTrigger(snapshotterTrigger());
        return eventSourcingRepository;
    }
	
	@Bean(name="ReqApplication_aggregateAonnotationCommandHandler")
    public AggregateAnnotationCommandHandler aggregateAonnotationCommandHandler(){
    	return AggregateAnnotationCommandHandler.subscribe(ReqApplication.class, eventSourcingRepository(),commandBus());
    }

}
