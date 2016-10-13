package app.ejb;

import java.util.List;

import javax.ejb.Stateless;

import app.ejbInterface.EJBGenericInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import app.dao.*;
import app.daoInterface.*;
import app.entities.*;

@Stateless
public class EJBCitizen implements EJBGenericInterface<Basicinfo> {
	@PersistenceContext(unitName="citizenManager")
	private EntityManager eManager;
	private EntityTransaction eTransaction;
	
	DaoGenericInterface<Basicinfo> DaoBasicInfo = new DaoBasicInfo();
	DaoGenericInterface<Address> DaoAddress = new DaoAddress();
	DaoGenericInterface<Email> DaoEmail = new DaoEmail();
	DaoGenericInterface<Phone> DaoPhone = new DaoPhone();

	public boolean create(Basicinfo citizenInfo, Address address, 
			Email email, Phone phone) {
		try {
			eTransaction = eManager.getTransaction();
			
			eTransaction.begin();
			DaoBasicInfo.create(eManager, citizenInfo);
			DaoAddress.create(eManager, address);
			DaoEmail.create(eManager, email);
			DaoPhone.create(eManager, phone);
			eTransaction.commit();
			
			return true;
		} 
		catch (Exception e) {
			if(eTransaction != null)
				eTransaction.rollback();
			
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		finally {
			eManager.close();
		}
	}

	public boolean delete(int ID) {
		try {			
			eTransaction = eManager.getTransaction();
			
			eTransaction.begin();
			DaoBasicInfo.delete(eManager, ID);
			DaoAddress.delete(eManager, ID);
			DaoEmail.delete(eManager, ID);
			DaoPhone.delete(eManager, ID);
			eTransaction.commit();
			
			return true;
		} 
		catch (Exception e) {
			if(eTransaction != null)
				eTransaction.rollback();
			
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		finally {
			eManager.close();
		}
	}

	public boolean update(int ID) {
		try{
			eTransaction.begin();
			DaoBasicInfo.update(eManager, ID);
			DaoAddress.update(eManager, ID);
			DaoEmail.update(eManager, ID);
			DaoPhone.update(eManager, ID);
			eTransaction.commit();
			
			return true;
		}
		catch (Exception e){
			if(eTransaction != null)
				eTransaction.rollback();
			
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		finally {
			eManager.close();
		}
	}

	public List<Basicinfo> getCitizensList() {		
		try{
		return DaoBasicInfo.getList(eManager);
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			
			return null;
		}
		finally {
			eManager.close();
		}
	}

	public boolean getCitizen(int ID) {
		try {
			DaoBasicInfo.getByID(eManager, ID);
			return true;
		} 
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			
			return false;
		}
		finally {
			eManager.close();
		}
	}
}
