
package org.demo.persistence.impl.mongo;

import org.demo.persistence.BookOrderPersistence ;
import org.demo.persistence.BookOrderPersistenceGenericTest;
import org.junit.Test;
import org.demo.persistence.impl.mongo.commons.MongoUtil;
import com.mongodb.client.MongoDatabase;
import org.demo.persistence.impl.mongo.commons.ClientProvider;
import org.junit.After;
import org.junit.BeforeClass;
import java.util.logging.*;

/**
 * JUnit tests for Car persistence service
 * 
 * @author Telosys Tools
 *
 */
public class BookOrderPersistenceMongoTest extends BookOrderPersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(BookOrderPersistenceMongoTest.class.getName());

	@BeforeClass
	public static void startMongoServer() {
		try {
			MongoUtil.init();
		} catch (Exception e) {
			LOGGER.info("error start server");
		}
	}

	@Test
	public void testPersistenceService() throws Exception {
    	BookOrderPersistence persistenceService = new BookOrderPersistenceImplMongo();
    	testPersistenceService(persistenceService);
	}

	@After
	public void after() throws Exception{
		System.out.println("Fin du test. Suppression de la base " + "mongoPersistence");
		MongoDatabase db = ClientProvider.getMongoInstance().getDatabase("mongoPersistence");
		db.drop();
		LOGGER.info("Base " + "mongoPersistence" + " supprime avec succes");
	}

}

