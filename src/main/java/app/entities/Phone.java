package app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phones database table.
 * 
 */
@Entity
@Table(name="phones")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String number;

	private String type;

	//bi-directional many-to-one association to Basicinfo
	@ManyToOne
	@JoinColumn(name="ID")
	private Basicinfo basicinfo;

	public Phone() {
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Basicinfo getBasicinfo() {
		return this.basicinfo;
	}

	public void setBasicinfo(Basicinfo basicinfo) {
		this.basicinfo = basicinfo;
	}

}