package app.daoInterface;

import java.util.List;

import javax.persistence.EntityManager;

public interface DaoGenericInterface<T> {
	
	public boolean create(EntityManager eManager, T object) throws Exception;
	public T getByID(EntityManager eManager, int ID) throws Exception;
	public boolean delete(EntityManager eManager, int ID) throws Exception;
	public boolean update(EntityManager eManager, int ID) throws Exception;
	public List<T> getList(EntityManager eManager) throws Exception;
}
