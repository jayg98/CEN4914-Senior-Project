package com.example.demo.config;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClientURI;

public class CustomeMongoDbConfig {

	static public MongoTemplate mongoTemplate() {
		
		MongoClientURI uri = new MongoClientURI("mongodb://<user>:<password>@ds0XXXXXX.mlab.com:23303/algorithmic");
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(uri);
		return new MongoTemplate(mongoDbFactory);
		
	}
	
}
