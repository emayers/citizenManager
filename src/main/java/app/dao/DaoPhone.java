package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import app.daoInterface.DaoGenericInterface;
import app.entities.Phone;

public class DaoPhone implements DaoGenericInterface<Phone> {

	public boolean create(EntityManager eManager, Phone object) throws Exception {
		eManager.persist(object);
		
		return true;
	}

	public Phone getByID(EntityManager eManager, int ID) throws Exception {
		Phone searchObject = eManager.find(Phone.class, ID);
		
		if(searchObject == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		return searchObject;
	}

	public boolean delete(EntityManager eManager, int ID) throws Exception {
		Phone objectToRemove = eManager.find(Phone.class, ID);
		
		if(objectToRemove == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.remove(objectToRemove);
		
		return true;
	}

	public boolean update(EntityManager eManager, int ID) throws Exception {
		Phone objectToUpdate = eManager.find(Phone.class, ID);
		
		if(objectToUpdate == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.merge(objectToUpdate);
		
		return true;
	}

	public List<Phone> getList(EntityManager eManager) {
		TypedQuery<Phone> query = 
				eManager.createNamedQuery("Phone.findAll", Phone.class);
		
		return query.getResultList();
	}
	
}
