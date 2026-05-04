package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Saskia implements Serializable{
	private static final long serialVersionUID = 1L;
	private double prezioTotala;
	private User user;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Sale> pruduktuak=new ArrayList<Sale>();
	
	public Saskia() {
		super();
	}
	
	public Saskia(double prezioTotala, User user) {
		super();
		this.prezioTotala = prezioTotala;
		this.user = user;
	}
	
	public double getPrezioTotala() {
		return prezioTotala;
	}
	
	public void setPrezioTotala(double prezioTotala) {
		this.prezioTotala = prezioTotala;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}


