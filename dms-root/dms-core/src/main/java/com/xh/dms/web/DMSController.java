package com.xh.dms.web;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.axonframework.eventhandling.replay.ReplayingCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    
@RequestMapping("/dm") 
public class DMSController {
	
	@Autowired
	private ReplayingCluster replayingCluster;
	
	@RequestMapping("/")    
    public String index() {    
        String hello = "hello dms.";
        return hello;    
    } 
	
	@RequestMapping("/replay")    
    public String replay() {    
		ExecutorService executor = Executors.newSingleThreadExecutor();
		replayingCluster.startReplay(executor);
		waitForReplayToHaveStarted(replayingCluster);
		System.out.println(replayingCluster.isInReplayMode());
        return "replay ok.";    
    } 
	
	private void waitForReplayToHaveStarted(ReplayingCluster replayingCluster) {
        while (!replayingCluster.isInReplayMode()) {
            Thread.yield();
        }
    }
}
