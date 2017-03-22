/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:53 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

/**
 * JUnit test case for bean PublisherRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class PublisherRecordTest 
{
	private static final Logger LOGGER = Logger.getLogger(PublisherRecordTest.class.getName());
	@Test
	public void testSettersAndGetters() {
		
		LOGGER.info("Checking class PublisherRecord getters and setters ..." );
		
		PublisherRecord publisherRecord = new PublisherRecord();


		//--- Test setter/getter for attribute "code"  ( model type : Integer / wrapperType : Integer )
		publisherRecord.setCode( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), publisherRecord.getCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "countryCode"  ( model type : String / wrapperType : String )
		publisherRecord.setCountryCode( "AA" ) ;
		Assert.assertEquals( "AA", publisherRecord.getCountryCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "name"  ( model type : String / wrapperType : String )
		publisherRecord.setName( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", publisherRecord.getName() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "email"  ( model type : String / wrapperType : String )
		publisherRecord.setEmail( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", publisherRecord.getEmail() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "contact"  ( model type : String / wrapperType : String )
		publisherRecord.setContact( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", publisherRecord.getContact() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "city"  ( model type : String / wrapperType : String )
		publisherRecord.setCity( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", publisherRecord.getCity() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "zipCode"  ( model type : Integer / wrapperType : Integer )
		publisherRecord.setZipCode( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), publisherRecord.getZipCode() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "phone"  ( model type : String / wrapperType : String )
		publisherRecord.setPhone( "AAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAA", publisherRecord.getPhone() ) ; // Not primitive type in model


	}

}
