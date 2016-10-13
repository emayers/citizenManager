package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import app.daoInterface.DaoGenericInterface;
import app.entities.Address;

public class DaoAddress implements DaoGenericInterface<Address> {

	public boolean create(EntityManager eManager, Address object) throws Exception {
		eManager.persist(object);
		
		return true;
	}

	public Address getByID(EntityManager eManager, int ID) throws Exception {
		Address searchObject = eManager.find(Address.class, ID);
		
		if(searchObject == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		return searchObject;
	}

	public boolean delete(EntityManager eManager, int ID) throws Exception {
		Address objectToRemove = eManager.find(Address.class, ID);
		
		if(objectToRemove == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.remove(objectToRemove);
		
		return true;
	}

	public boolean update(EntityManager eManager, int ID) throws Exception {
		Address objectToUpdate = eManager.find(Address.class, ID);
		
		if(objectToUpdate == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.merge(objectToUpdate);
		
		return true;
	}

	public List<Address> getList(EntityManager eManager) throws Exception {
		TypedQuery<Address> query = 
				eManager.createNamedQuery("Address.findAll", Address.class);
		
		return query.getResultList();
	}


}
