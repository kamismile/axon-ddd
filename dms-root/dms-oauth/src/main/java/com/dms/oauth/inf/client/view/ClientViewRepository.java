package com.dms.oauth.inf.client.view;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClientViewRepository  extends MongoRepository<ClientView,String>{

//	@Query("{'clientName':?0}")
	ClientView findByClientName(String clientName);
	
}
