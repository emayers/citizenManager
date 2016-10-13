package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import app.daoInterface.DaoGenericInterface;
import app.entities.Basicinfo;

public class DaoBasicInfo implements DaoGenericInterface<Basicinfo> {

	public boolean create(EntityManager eManager, Basicinfo object) throws Exception {
		eManager.persist(object);
		
		return true;
	}

	public Basicinfo getByID(EntityManager eManager, int ID) throws Exception {
		Basicinfo searchObject = eManager.find(Basicinfo.class, ID);
		
		if(searchObject == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		return searchObject;
	}

	public boolean delete(EntityManager eManager, int ID) throws Exception {
		Basicinfo objectToRemove = eManager.find(Basicinfo.class, ID);
		
		if(objectToRemove == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.remove(objectToRemove);
		
		return true;
	}

	public boolean update(EntityManager eManager, int ID) throws Exception {
		Basicinfo objectToUpdate = eManager.find(Basicinfo.class, ID);
		
		if(objectToUpdate == null)
			throw new IllegalArgumentException("Citizen Not Found");
		
		eManager.merge(objectToUpdate);
		
		return true;
	}

	public List<Basicinfo> getList(EntityManager eManager) {
		TypedQuery<Basicinfo> query = 
				eManager.createNamedQuery("Basicinfo.findAll", Basicinfo.class);
		
		return query.getResultList();
	}

}
