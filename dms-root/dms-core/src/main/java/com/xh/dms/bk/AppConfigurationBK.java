package com.xh.dms.bk;

import java.net.UnknownHostException;

import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.GatewayProxyFactory;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.mongo.DefaultMongoTemplate;
import org.axonframework.eventstore.mongo.DocumentPerCommitStorageStrategy;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.axonframework.eventstore.mongo.MongoTemplate;
import org.springframework.context.annotation.Bean;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.xh.dms.core.req.model.ReqApplication;
import com.xh.dms.inf.req.svc.IReqApplicationCmdService;

public class AppConfigurationBK {

    public SimpleCommandBus commandBus() {
        SimpleCommandBus simpleCommandBus = new SimpleCommandBus();
        return simpleCommandBus;
    }

    /**
     * The simple command bus, an implementation of an EventBus
     * mostly appropriate in a single JVM, single threaded use case.
     * @return the {@link SimpleEventBus}
     */
    public SimpleEventBus eventBus() {
        return new SimpleEventBus();
    }

/*    @Bean
    public DefaultCommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }*/
    
    public IReqApplicationCmdService gatewayProxyFactory(){
    	GatewayProxyFactory gatewayProxyFactory = new GatewayProxyFactory(commandBus()); 
    	return gatewayProxyFactory.createGateway(IReqApplicationCmdService.class);
    }

    /**
     * An event sourcing implementation needs a place to store events. i.e. The event Store.
     * In our use case we will be storing our events in a file system, so we configure
     * the FileSystemEventStore as our EventStore implementation
     *
     * It should be noted that Axon allows storing the events
     * in other persistent mechanism...jdbc, jpa etc
     *
     * @return the {@link EventStore}
     */
/*    public EventStore eventStore() {
        EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("d:/events/reqApplication")));
        return eventStore;
    }*/
    
    public EventStore mongoEventStore(){
        Mongo mongo = null;
		try {
			mongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MongoTemplate mongoTemplate = new DefaultMongoTemplate(mongo);
		EventStore eventStore = new MongoEventStore(mongoTemplate,new DocumentPerCommitStorageStrategy());
        return eventStore;
    }

    /**
     * Our aggregate root is now created from stream of events and not from a representation in a persistent mechanism,
     * thus we need a repository that can handle the retrieving of our aggregate root from the stream of events.
     *
     * We configure the EventSourcingRepository which does exactly this. We supply it with the event store
     * @return {@link EventSourcingRepository}
     */
    public EventSourcingRepository eventSourcingRepository() {
        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(ReqApplication.class, mongoEventStore());
        eventSourcingRepository.setEventBus(eventBus());
        return eventSourcingRepository;
    }
    
    public AggregateAnnotationCommandHandler aggregateAonnotationCommandHandler(){
    	AggregateAnnotationCommandHandler aggregateAnnotationCommandHandler = new AggregateAnnotationCommandHandler(ReqApplication.class, eventSourcingRepository(),commandBus());
    	return aggregateAnnotationCommandHandler;
    }
}
