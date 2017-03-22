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



import org.demo.data.record.AuthorRecord;
import org.demo.persistence.AuthorPersistence;

@Named("AuthorPersistence")
public class AuthorPersistenceImplMongo extends GenericMongoDAO<AuthorRecord> implements AuthorPersistence {

	/**
	 * DAO constructor
	 */
	public AuthorPersistenceImplMongo() {
		super("author");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private AuthorRecord newInstanceWithPrimaryKey(Integer id) {
		AuthorRecord author = new AuthorRecord ();
        author.setId(id); 
		return author;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public AuthorRecord findById(Integer id){
        AuthorRecord  author = newInstanceWithPrimaryKey(id);
		return super.doSelect(author);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<AuthorRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public AuthorRecord load(AuthorRecord author) {
		 return super.doSelect(author);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(AuthorRecord author){
		 super.doInsert(author);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(AuthorRecord author){
		if (super.doExists(author)) {
			super.doUpdate(author);
		} else {
			insert(author);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(AuthorRecord author){
		long result= super.doUpdate(author);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	AuthorRecord   create(AuthorRecord author){
		insert(author);
        return author;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(Integer id) {
		AuthorRecord author = newInstanceWithPrimaryKey(id);
		long r = super.doDelete(author);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(AuthorRecord author) {
		long r = super.doDelete(author);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(Integer id) {
		AuthorRecord author = newInstanceWithPrimaryKey(id);
		return super.doExists(author);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(AuthorRecord author) {
		return super.doExists(author);
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
	protected AuthorRecord docTobean(Document doc) {
		AuthorRecord author = new AuthorRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		author.setId(mongoDoc.getInteger("id"));
		author.setFirstName(mongoDoc.getString("firstName"));
		author.setLastName(mongoDoc.getString("lastName"));
		return author ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(AuthorRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("id", bean.getId());
		doc.append("firstName", bean.getFirstName());
		doc.append("lastName", bean.getLastName());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(AuthorRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(AuthorRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("id", bean.getId());
		return	mongoDoc.getDocument();
	}

}
