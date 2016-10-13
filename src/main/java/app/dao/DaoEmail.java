package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import app.daoInterface.DaoGenericInterface;
import app.entities.Email;

public class DaoEmail implements DaoGenericInterface<Email> {

	public boolean create(EntityManager eManager, Email object) throws Exception {
		eManager.persist(object);
		
		return true;
	}

	public Email getByID(EntityManager eManager, int ID) throws Exception {
		Email searchObject = eManager.find(Email.class, ID);
		
		if(searchObject == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		return searchObject;
	}

	public boolean delete(EntityManager eManager, int ID) throws Exception {
		Email objectToRemove = eManager.find(Email.class, ID);
		
		if(objectToRemove == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.remove(objectToRemove);
		
		return true;
	}

	public boolean update(EntityManager eManager, int ID) throws Exception {
		Email objectToUpdate = eManager.find(Email.class, ID);
		
		if(objectToUpdate == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.merge(objectToUpdate);
		
		return true;
	}

	public List<Email> getList(EntityManager eManager) {
		TypedQuery<Email> query = 
				eManager.createNamedQuery("Email.findAll", Email.class);
		
		return query.getResultList();
	}

}
