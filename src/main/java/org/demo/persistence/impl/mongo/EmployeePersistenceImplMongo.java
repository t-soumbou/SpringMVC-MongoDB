/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 16:41:52 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.mongo;

import java.util.List;
import javax.inject.Named;
import org.bson.conversions.Bson;
import org.demo.persistence.impl.mongo.commons.GenericMongoDAO;
import org.bson.Document;
import org.demo.persistence.impl.mongo.commons.DocumentWrapper;



import org.demo.data.record.EmployeeRecord;
import org.demo.persistence.EmployeePersistence;

@Named("EmployeePersistence")
public class EmployeePersistenceImplMongo extends GenericMongoDAO<EmployeeRecord> implements EmployeePersistence {

	/**
	 * DAO constructor
	 */
	public EmployeePersistenceImplMongo() {
		super("employee");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private EmployeeRecord newInstanceWithPrimaryKey(String code) {
		EmployeeRecord employee = new EmployeeRecord ();
        employee.setCode(code); 
		return employee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public EmployeeRecord findById(String code){
        EmployeeRecord  employee = newInstanceWithPrimaryKey(code);
		return super.doSelect(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<EmployeeRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public EmployeeRecord load(EmployeeRecord employee) {
		 return super.doSelect(employee);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(EmployeeRecord employee){
		 super.doInsert(employee);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(EmployeeRecord employee){
		if (super.doExists(employee)) {
			super.doUpdate(employee);
		} else {
			insert(employee);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(EmployeeRecord employee){
		long result= super.doUpdate(employee);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	EmployeeRecord   create(EmployeeRecord employee){
		insert(employee);
        return employee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(String code) {
		EmployeeRecord employee = newInstanceWithPrimaryKey(code);
		long r = super.doDelete(employee);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(EmployeeRecord employee) {
		long r = super.doDelete(employee);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(String code) {
		EmployeeRecord employee = newInstanceWithPrimaryKey(code);
		return super.doExists(employee);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(EmployeeRecord employee) {
		return super.doExists(employee);
	}

	/**
	 * Counts all the records present in the database
	 * 
	 * @return
	 */
	public long countAll() {
		return super.doCountAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected EmployeeRecord docTobean(Document doc) {
		EmployeeRecord employee = new EmployeeRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		employee.setCode(mongoDoc.getString("code"));
		employee.setShopCode(mongoDoc.getString("shopCode"));
		employee.setFirstName(mongoDoc.getString("firstName"));
		employee.setLastName(mongoDoc.getString("lastName"));
		employee.setManager(mongoDoc.getShort("manager"));
		employee.setBadgeNumber(mongoDoc.getInteger("badgeNumber"));
		employee.setEmail(mongoDoc.getString("email"));
		return employee ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(EmployeeRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("code", bean.getCode());
		doc.append("shopCode", bean.getShopCode());
		doc.append("firstName", bean.getFirstName());
		doc.append("lastName", bean.getLastName());
		doc.append("manager", bean.getManager());
		doc.append("badgeNumber", bean.getBadgeNumber());
		doc.append("email", bean.getEmail());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(EmployeeRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(EmployeeRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("code", bean.getCode());
		return	mongoDoc.getDocument();
	}

}
