/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:52 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

/**
 * JUnit test case for bean BookOrderRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class BookOrderRecordTest 
{
	private static final Logger LOGGER = Logger.getLogger(BookOrderRecordTest.class.getName());
	@Test
	public void testSettersAndGetters() {
		
		LOGGER.info("Checking class BookOrderRecord getters and setters ..." );
		
		BookOrderRecord bookOrderRecord = new BookOrderRecord();


		//--- Test setter/getter for attribute "id"  ( model type : Integer / wrapperType : Integer )
		bookOrderRecord.setId( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), bookOrderRecord.getId() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "shopCode"  ( model type : String / wrapperType : String )
		bookOrderRecord.setShopCode( "AAA" ) ;
		Assert.assertEquals( "AAA", bookOrderRecord.getShopCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "customerCode"  ( model type : String / wrapperType : String )
		bookOrderRecord.setCustomerCode( "AAAAA" ) ;
		Assert.assertEquals( "AAAAA", bookOrderRecord.getCustomerCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "employeeCode"  ( model type : String / wrapperType : String )
		bookOrderRecord.setEmployeeCode( "AAAA" ) ;
		Assert.assertEquals( "AAAA", bookOrderRecord.getEmployeeCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "date"  ( model type : Date / wrapperType : Date )
		bookOrderRecord.setDate( java.sql.Date.valueOf("2001-06-22") ) ;
		Assert.assertEquals( java.sql.Date.valueOf("2001-06-22"), bookOrderRecord.getDate() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "state"  ( model type : Integer / wrapperType : Integer )
		bookOrderRecord.setState( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), bookOrderRecord.getState() ) ; // Not primitive type in model


	}

}
