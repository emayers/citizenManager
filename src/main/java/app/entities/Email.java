package app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emails database table.
 * 
 */
@Entity
@Table(name="emails")
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String email;

	//bi-directional many-to-one association to Basicinfo
	@ManyToOne
	@JoinColumn(name="ID")
	private Basicinfo basicinfo;

	public Email() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Basicinfo getBasicinfo() {
		return this.basicinfo;
	}

	public void setBasicinfo(Basicinfo basicinfo) {
		this.basicinfo = basicinfo;
	}

}