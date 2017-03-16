package com.dms.core.bk;

import java.util.concurrent.ExecutorService;

import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventhandling.AnnotationClusterSelector;
import org.axonframework.eventhandling.SimpleCluster;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.BackloggingIncomingMessageHandler;
import org.axonframework.eventhandling.replay.ReplayingCluster;
import org.axonframework.unitofwork.NoTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import com.dms.core.AppConfiguration;

//@Configuration
//@AnnotationDriven 
public class ReplayingClusterCfg extends AppConfiguration{/*
	
//	@Bean
	public ReplayingCluster replayingCluster(){
		ReplayingCluster replayingCluster = new ReplayingCluster(new SimpleCluster("simple"), eventStore(),
				new NoTransactionManager(), 2,new BackloggingIncomingMessageHandler());
		return replayingCluster;
	}
	
	
	public AnnotationClusterSelector annotationClusterSelector(){
		AnnotationClusterSelector annotationClusterSelector = new AnnotationClusterSelector(EventHandler.class, replayingCluster());
		return annotationClusterSelector;
	}
*/}
