package com.dms.oauth;

import java.net.UnknownHostException;

import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.ClusteringEventBus;
import org.axonframework.eventhandling.DefaultClusterSelector;
import org.axonframework.eventhandling.SimpleCluster;
import org.axonframework.eventhandling.amqp.spring.ListenerContainerLifecycleManager;
import org.axonframework.eventhandling.amqp.spring.SpringAMQPTerminal;
import org.axonframework.eventhandling.replay.BackloggingIncomingMessageHandler;
import org.axonframework.eventhandling.replay.ReplayingCluster;
import org.axonframework.eventsourcing.EventCountSnapshotterTrigger;
import org.axonframework.eventsourcing.SpringAggregateSnapshotter;
import org.axonframework.eventstore.mongo.DefaultMongoTemplate;
import org.axonframework.eventstore.mongo.DocumentPerCommitStorageStrategy;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.axonframework.eventstore.mongo.MongoTemplate;
import org.axonframework.serializer.Serializer;
import org.axonframework.serializer.json.JacksonSerializer;
import org.axonframework.unitofwork.NoTransactionManager;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


public class AppConfiguration {
	
	@Bean(name = "snapshotterTaskExecutor")
    public ThreadPoolTaskExecutor snapshotterTaskExecutor(){
    	ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    	taskExecutor.setCorePoolSize(2);
    	taskExecutor.setMaxPoolSize(5);
    	taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
    	return taskExecutor;
    }
    
    @Bean
    public SpringAggregateSnapshotter springAggregateSnapshotter(){
    	SpringAggregateSnapshotter springAggregateSnapshotter = new SpringAggregateSnapshotter();  
    	springAggregateSnapshotter.setEventStore(eventStore());
    	springAggregateSnapshotter.setExecutor(snapshotterTaskExecutor());
    	return springAggregateSnapshotter;
    }
    
    @Bean
    public EventCountSnapshotterTrigger snapshotterTrigger(){
    	EventCountSnapshotterTrigger snapshotterTrigger = new EventCountSnapshotterTrigger();  
    	snapshotterTrigger.setTrigger(5);
    	snapshotterTrigger.setSnapshotter(springAggregateSnapshotter());
    	return snapshotterTrigger;
    }
    
    @Bean
    public SimpleCommandBus commandBus() {
        SimpleCommandBus simpleCommandBus = new SimpleCommandBus();
        return simpleCommandBus;
    }

    @Bean
    public CommandGateway commandGateway(){
    	CommandGateway commandGateway = new DefaultCommandGateway(commandBus());
    	return commandGateway;
    }

    @Bean
    public SimpleCluster simpleCluster(){
    	return new SimpleCluster("axon-simple-cluster");
    }
    
    @Bean
    public ConnectionFactory connectionFactory(){
    	CachingConnectionFactory factory = new CachingConnectionFactory();
    	factory.setHost("118.89.106.220");
    	return factory;
    }
    
    @Bean
    public Serializer serializer(){
    	Serializer serializer = new JacksonSerializer();
    	return serializer;
    }
    
    @Bean
    public ListenerContainerLifecycleManager listenerContainerLifecycleManager(){
    	ListenerContainerLifecycleManager listenerContainerLifecycleManager = new ListenerContainerLifecycleManager();
    	return listenerContainerLifecycleManager;
    }
    
    @Bean
    public SpringAMQPTerminal eventBusTerminal(){
    	SpringAMQPTerminal amqpTerminal = new SpringAMQPTerminal(); 
    	return amqpTerminal;
    }
    
    @Bean
    public ClusteringEventBus eventBus() {
    	ClusteringEventBus clusteringEventBus = new ClusteringEventBus(new DefaultClusterSelector(simpleCluster()),eventBusTerminal());
        return clusteringEventBus;
    }
    
    /*@Bean
    public ClusteringEventBus eventBus() {
    	ClusteringEventBus clusteringEventBus = new ClusteringEventBus(new DefaultClusterSelector(simpleCluster()));
    	return clusteringEventBus;
    }*/
    
    @Bean
    public MongoEventStore eventStore(){
        Mongo mongo = null;
		try {
			mongo = new MongoClient(new MongoClientURI("mongodb://118.89.106.220:27017"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		MongoTemplate mongoTemplate = new DefaultMongoTemplate(mongo);
        return new MongoEventStore(mongoTemplate,new DocumentPerCommitStorageStrategy());
    }
    
    @Bean
	public ReplayingCluster replayingCluster(){
		ReplayingCluster replayingCluster = new ReplayingCluster(simpleCluster(), eventStore(),
				new NoTransactionManager(), 2,new BackloggingIncomingMessageHandler());
		return replayingCluster;
	}
}
