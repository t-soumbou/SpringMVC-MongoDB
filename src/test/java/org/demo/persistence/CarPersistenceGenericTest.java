/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:15:26 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.CarRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for CarPersistence
 * 
 * @author Telosys Tools
 *
 */
public class CarPersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(CarPersistenceGenericTest.class.getName());

	public void testPersistenceService(CarPersistence persistenceService) throws Exception {
    	LOGGER.info("test CarPersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	CarRecord car = new CarRecord();
		//--- Key values
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		car.setLastname("A"); // "lastname" : java.lang.String
		car.setFirstname("A"); // "firstname" : java.lang.String

    	//--- INSERT
    	LOGGER.info("Insert : " + car);
    	int pkAutoIncr = (int) persistenceService.create(car);
		car.setId( pkAutoIncr );
    	assertTrue( persistenceService.exists(pkAutoIncr) );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(car) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	CarRecord car2 = persistenceService.findById(pkAutoIncr);
    	assertNotNull(car2);
    	assertTrue( persistenceService.exists(car2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		car2.setLastname("B"); // "lastname" : java.lang.String
		car2.setFirstname("B"); // "firstname" : java.lang.String
    	LOGGER.info("Update : " + car2 );
    	assertTrue( persistenceService.update(car2) );
    	
    	//--- LOAD
    	CarRecord car3 = new CarRecord();
    	car3.setId( pkAutoIncr );
		car3 = persistenceService.load(car3);
    	assertNotNull( persistenceService.load(car3) );
    	LOGGER.info("Loaded : " + car3 );
	assertEquals(car2.getLastname(), car3.getLastname() ); 
	assertEquals(car2.getFirstname(), car3.getFirstname() ); 


    	car3.setId(300);
    	assertNull( persistenceService.load(car3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + car2 );
    	assertTrue( persistenceService.delete(car2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(car2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(100) ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists(100) ) ;
    	assertFalse( persistenceService.exists(car2) ) ;
    	car2 = persistenceService.findById(100);
    	assertNull( car2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}
