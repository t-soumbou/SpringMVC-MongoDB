/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:52 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.BadgeRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for BadgePersistence
 * 
 * @author Telosys Tools
 *
 */
public class BadgePersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(BadgePersistenceGenericTest.class.getName());

	public void testPersistenceService(BadgePersistence persistenceService) throws Exception {
    	LOGGER.info("test BadgePersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	BadgeRecord badge = new BadgeRecord();
		//--- Key values
		badge.setBadgeNumber(Integer.valueOf(100)); // "BADGE_NUMBER" : java.lang.Integer
		//--- Other values
		badge.setAuthorizationLevel(Short.valueOf((short)1)); // "AUTHORIZATION_LEVEL" : java.lang.Short
		badge.setEndOfValidity(java.sql.Date.valueOf("2001-06-22")); // "END_OF_VALIDITY" : java.util.Date

    	//--- INSERT
    	LOGGER.info("Insert : " + badge);
    	persistenceService.create(badge);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(badge) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	BadgeRecord badge2 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(badge2);
		assertTrue( badge2.getBadgeNumber().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(badge2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		badge2.setAuthorizationLevel(Short.valueOf((short)2)); // "AUTHORIZATION_LEVEL" : java.lang.Short
		badge2.setEndOfValidity(java.sql.Date.valueOf("2002-06-22")); // "END_OF_VALIDITY" : java.util.Date
    	LOGGER.info("Update : " + badge2 );
    	assertTrue( persistenceService.update(badge2) );
    	
    	//--- LOAD
    	BadgeRecord badge3 = new BadgeRecord();
    	badge3.setBadgeNumber(Integer.valueOf(100));
		badge3 = persistenceService.load(badge3);
    	assertNotNull( persistenceService.load(badge3) );
    	LOGGER.info("Loaded : " + badge3 );
	assertEquals(badge2.getAuthorizationLevel(), badge3.getAuthorizationLevel() ); 
		assertEquals(badge2.getEndOfValidity().getTime(), badge3.getEndOfValidity().getTime() ); 


    	badge3.setBadgeNumber(Integer.valueOf(300));
    	assertNull( persistenceService.load(badge3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + badge2 );
    	assertTrue( persistenceService.delete(badge2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(badge2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(badge2) ) ;
    	badge2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( badge2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}