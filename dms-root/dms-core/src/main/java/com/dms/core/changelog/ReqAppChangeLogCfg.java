package com.dms.core.changelog;

import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dms.core.AppConfiguration;
import com.dms.core.changelog.model.ReqAppChangeLog;

@Configuration
@AnnotationDriven
public class ReqAppChangeLogCfg extends AppConfiguration{
	
/*	@Bean(name="IReqAppChangeLogService")
    public IReqApplicationCmdService gatewayProxyFactory(){
    	GatewayProxyFactory gatewayProxyFactory = new GatewayProxyFactory(commandBus()); 
    	return gatewayProxyFactory.createGateway(IReqApplicationCmdService.class);
    }*/
	
	@Bean(name="ReqAppChangeLog_aggregateFactory")
    public AggregateFactory aggregateFactory() {
        return new GenericAggregateFactory(ReqAppChangeLog.class);
    }
	
	@Bean(name="ReqAppChangeLog_eventSourcingRepository")
    public EventSourcingRepository eventSourcingRepository() {
        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(aggregateFactory(), eventStore());
        eventSourcingRepository.setEventBus(eventBus());
        eventSourcingRepository.setSnapshotterTrigger(snapshotterTrigger());
        return eventSourcingRepository;
    }
	
	@Bean(name="ReqAppChangeLog_aggregateAonnotationCommandHandler")
    public AggregateAnnotationCommandHandler aggregateAonnotationCommandHandler(){
    	return AggregateAnnotationCommandHandler.subscribe(ReqAppChangeLog.class, eventSourcingRepository(),commandBus());
    }
}
