package app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the basicinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Basicinfo.findAll", query="SELECT b FROM Basicinfo b")
public class Basicinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String firstName;

	private String lastName;

	private String sex;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="basicinfo")
	private List<Address> addresses;

	//bi-directional many-to-one association to Email
	@OneToMany(mappedBy="basicinfo")
	private List<Email> emails;

	//bi-directional many-to-one association to Phone
	@OneToMany(mappedBy="basicinfo")
	private List<Phone> phones;

	public Basicinfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setBasicinfo(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setBasicinfo(null);

		return address;
	}

	public List<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Email addEmail(Email email) {
		getEmails().add(email);
		email.setBasicinfo(this);

		return email;
	}

	public Email removeEmail(Email email) {
		getEmails().remove(email);
		email.setBasicinfo(null);

		return email;
	}

	public List<Phone> getPhones() {
		return this.phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setBasicinfo(this);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setBasicinfo(null);

		return phone;
	}

}