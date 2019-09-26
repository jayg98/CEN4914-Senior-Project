package com.example.demo.config;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClientURI;

public class CustomeMongoDbConfig {

	static public MongoTemplate mongoTemplate() {
		
		//use your own mlab url
		MongoClientURI uri = new MongoClientURI("mongodb://<user>:<password>@ds023303.mlab.com:23303/<db>");
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(uri);
		return new MongoTemplate(mongoDbFactory);
		
	}
	
}
