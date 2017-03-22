/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:53 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.WorkgroupRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for WorkgroupPersistence
 * 
 * @author Telosys Tools
 *
 */
public class WorkgroupPersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(WorkgroupPersistenceGenericTest.class.getName());

	public void testPersistenceService(WorkgroupPersistence persistenceService) throws Exception {
    	LOGGER.info("test WorkgroupPersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	WorkgroupRecord workgroup = new WorkgroupRecord();
		//--- Key values
		workgroup.setId(Short.valueOf((short)1)); // "ID" : java.lang.Short
		//--- Other values
		workgroup.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String
		workgroup.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "DESCRIPTION" : java.lang.String
		workgroup.setCreationDate(java.sql.Date.valueOf("2001-06-22")); // "CREATION_DATE" : java.util.Date

    	//--- INSERT
    	LOGGER.info("Insert : " + workgroup);
    	persistenceService.create(workgroup);
    	assertTrue( persistenceService.exists(Short.valueOf((short)1)) );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(workgroup) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	WorkgroupRecord workgroup2 = persistenceService.findById(Short.valueOf((short)1));
    	assertNotNull(workgroup2);
		assertTrue( workgroup2.getId().equals(Short.valueOf((short)1)) ) ;
    	assertTrue( persistenceService.exists(workgroup2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		workgroup2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
		workgroup2.setDescription("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "DESCRIPTION" : java.lang.String
		workgroup2.setCreationDate(java.sql.Date.valueOf("2002-06-22")); // "CREATION_DATE" : java.util.Date
    	LOGGER.info("Update : " + workgroup2 );
    	assertTrue( persistenceService.update(workgroup2) );
    	
    	//--- LOAD
    	WorkgroupRecord workgroup3 = new WorkgroupRecord();
    	workgroup3.setId(Short.valueOf((short)1));
		workgroup3 = persistenceService.load(workgroup3);
    	assertNotNull( persistenceService.load(workgroup3) );
    	LOGGER.info("Loaded : " + workgroup3 );
	assertEquals(workgroup2.getName(), workgroup3.getName() ); 
	assertEquals(workgroup2.getDescription(), workgroup3.getDescription() ); 
		assertEquals(workgroup2.getCreationDate().getTime(), workgroup3.getCreationDate().getTime() ); 


    	workgroup3.setId(Short.valueOf((short)3));
    	assertNull( persistenceService.load(workgroup3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + workgroup2 );
    	assertTrue( persistenceService.delete(workgroup2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(workgroup2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Short.valueOf((short)1)) ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists(Short.valueOf((short)1)) ) ;
    	assertFalse( persistenceService.exists(workgroup2) ) ;
    	workgroup2 = persistenceService.findById(Short.valueOf((short)1));
    	assertNull( workgroup2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}
