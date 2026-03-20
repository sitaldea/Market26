package domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User extends Erabiltzailea implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String telefonoa;
	@XmlIDREF
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Sale> sales=new ArrayList<Sale>();
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Sale> erositakoak=new ArrayList<Sale>();
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<DiruKontua> kontuak=new ArrayList<DiruKontua>();
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Erreklamazioak> errklamazioak=new ArrayList<Erreklamazioak>();
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Mugimenduak> mugimenduak=new ArrayList<Mugimenduak>();

	public User() {
		super();
	}

	public User(String email, String name, String password, String telefonoa) {
		super(email, password);
		this.name = name;
		this.telefonoa = telefonoa;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String toString(){
		return getEmail()+";"+name+sales;
	}
	
	/**
	 * This method creates/adds a sale to a seller
	 * 
	 * @param title of the sale
	 * @param description of the sale
	 * @param status 
	 * @param selling price
	 * @param publicationDate
	 * @return Sale
	 */
	
	


	public Sale addSale(String title, String description, int status, float price,  Date pubDate, File file, String egoera)  {
		
		Sale sale=new Sale(title, description, status, price,  pubDate, file, this, egoera);
        sales.add(sale);
        return sale;
	}
	
	public void addErositakoa(Sale sale) {
		erositakoak.add(sale);
	}
	
	public void addDiruKontua(String kontuZenb, double diruKop) {
		DiruKontua kontu=new DiruKontua(kontuZenb, diruKop, this);
		kontuak.add(kontu);
	}
	
	
	/**
	 * This method checks if the ride already exists for that driver
	 * 
	 * @param from the origin location 
	 * @param to the destination location 
	 * @param date the date of the ride 
	 * @return true if the ride exists and false in other case
	 */
	public boolean doesSaleExist(String title)  {	
		for (Sale s:sales)
			if ( s.getTitle().compareTo(title)==0 )
			 return true;
		return false;
	}
		
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    User other = (User) obj;
	    return getEmail() != null && getEmail().equals(other.getEmail());
	}

	@Override
	public int hashCode() {
	    return getEmail() != null ? getEmail().hashCode() : 0;
	}


	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public List<Sale> getSales() {
		return sales;
	}
	
	public List<Sale> getErositakoak() {
		return erositakoak;
	}
	
	public List<DiruKontua> getKontuak() {
		return kontuak;
	}

	public void updateDiruKop(String zenb, double diruKop) {
		for (DiruKontua k:kontuak) {
			if (k.getKontuZenb().compareTo(zenb)==0) {
				k.setDiruKop(diruKop);
				return;
			}
		}
	}
	
	public List<Erreklamazioak> getErrklamazioak() {
		return errklamazioak;
	}
}
