package app.citizenManager;

import java.util.*;

import javax.ejb.EJB;
import javax.inject.Named;

import app.ejb.EJBCitizen;
import app.entities.*;

/**
 * @author carola
 *
 */
@Named(value = "citizensController")
public class citizensController {
	
	@EJB
	private EJBCitizen citizen;
	
	public Basicinfo citizenInfo = new Basicinfo();
	public Address address = new Address();
	public Email email = new Email();
	public Phone phone = new Phone();
	
	public List<Basicinfo> getCitizensList(){
		return this.citizen.getCitizensList();
	}
	
	public boolean createCitizen(){
		return citizen.create(citizenInfo, address, email, phone);
	}
	
	public boolean retrieveCitizen(int ID){
		return citizen.getCitizen(ID);
	}
	
	public boolean updateCitizen(int ID){
		return citizen.update(ID);
	}
	
	public boolean deleteCitizen(int ID){
		return citizen.delete(ID);
	}

	
	
}
