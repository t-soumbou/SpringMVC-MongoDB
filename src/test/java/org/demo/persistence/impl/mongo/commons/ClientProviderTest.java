/*
 * Created on 2017-03-22 ( Time 16:41:53 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.persistence.impl.mongo.commons;

import java.util.Properties;

import org.demo.persistence.impl.mongo.commons.ClientProvider;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

import com.mongodb.MongoClient;



/**
 * JUnit tests for ClientProvider
 * 
 * @author Telosys 
 *
 */
public class ClientProviderTest {
	private static final Logger LOGGER = Logger.getLogger(ClientProviderTest.class.getName());
	private void printProperty(Properties properties, String name) {
		String value = properties.getProperty(name);
		LOGGER.info(" . " + name + " = " + value );
		Assert.assertNotNull( value );
		Assert.assertFalse( "".equals(value.trim()));
	}

	@Test
	public void test1MongoProperties() {
		LOGGER.info("--- test MONGO properties");
    	
		LOGGER.info("MONGO properties file name = '" + ClientProvider.getMongoPrpertiesFileName() + "'");
		LOGGER.info(" properties file searched via classpath in : " );
		LOGGER.info(" 1 - 'src/test/resources' " );
		LOGGER.info(" 2 - 'src/main/resources' " );
		
		Properties properties = ClientProvider.loadJdbcPropertiesFromClassPath();

		LOGGER.info("MONGO properties values : " );
		printProperty(properties, "mongo.hostname" );
		printProperty(properties, "mongo.port" );		
		printProperty(properties, "mongo.dbname" );
		printProperty(properties, "mongo.username" );
		printProperty(properties, "mongo.password" );	
	}
	
	@Test
	public void test2MongoClient() {
    	LOGGER.info("--- test ClientProvider ");	
    	MongoClient client = ClientProvider.getMongoInstance();
    	LOGGER.info("client ready. ");   	
    	Assert.assertNotNull( client );
	}
}