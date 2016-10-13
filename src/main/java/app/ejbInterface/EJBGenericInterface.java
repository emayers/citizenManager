package app.ejbInterface;

import java.util.List;

import javax.ejb.Remote;

import app.entities.Address;
import app.entities.Basicinfo;
import app.entities.Email;
import app.entities.Phone;

@Remote
public interface EJBGenericInterface<T> {
	
	public boolean create(Basicinfo citizenInfo, Address address, 
			Email email, Phone phone);
	public boolean delete(int ID);
	public boolean update(int ID);
	public boolean getCitizen(int ID);
	public List<T> getCitizensList();
}
