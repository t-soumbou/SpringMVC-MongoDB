/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:53 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

/**
 * JUnit test case for bean ShopRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class ShopRecordTest 
{
	private static final Logger LOGGER = Logger.getLogger(ShopRecordTest.class.getName());
	@Test
	public void testSettersAndGetters() {
		
		LOGGER.info("Checking class ShopRecord getters and setters ..." );
		
		ShopRecord shopRecord = new ShopRecord();


		//--- Test setter/getter for attribute "code"  ( model type : String / wrapperType : String )
		shopRecord.setCode( "AAA" ) ;
		Assert.assertEquals( "AAA", shopRecord.getCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "name"  ( model type : String / wrapperType : String )
		shopRecord.setName( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", shopRecord.getName() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "address1"  ( model type : String / wrapperType : String )
		shopRecord.setAddress1( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", shopRecord.getAddress1() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "address2"  ( model type : String / wrapperType : String )
		shopRecord.setAddress2( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", shopRecord.getAddress2() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "zipCode"  ( model type : Integer / wrapperType : Integer )
		shopRecord.setZipCode( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), shopRecord.getZipCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "city"  ( model type : String / wrapperType : String )
		shopRecord.setCity( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", shopRecord.getCity() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "countryCode"  ( model type : String / wrapperType : String )
		shopRecord.setCountryCode( "AA" ) ;
		Assert.assertEquals( "AA", shopRecord.getCountryCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "phone"  ( model type : String / wrapperType : String )
		shopRecord.setPhone( "AAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAA", shopRecord.getPhone() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "email"  ( model type : String / wrapperType : String )
		shopRecord.setEmail( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", shopRecord.getEmail() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "executive"  ( model type : String / wrapperType : String )
		shopRecord.setExecutive( "AAAA" ) ;
		Assert.assertEquals( "AAAA", shopRecord.getExecutive() ) ; // Not primitive type in model


	}

}