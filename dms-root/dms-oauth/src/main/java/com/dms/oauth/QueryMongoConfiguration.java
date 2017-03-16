package com.dms.oauth;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class QueryMongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "dms-query";
	}

	@Override
	public Mongo mongo() throws UnknownHostException {
		 Mongo mongo = null;
			try {
				mongo = new MongoClient(new MongoClientURI("mongodb://118.89.106.220:27017"));
			} catch (UnknownHostException e) {
				throw e;
			}
		return mongo;
	}

}
