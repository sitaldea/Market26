package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;


@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class DiruKontua implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlID
	@Id 
	private String kontuZenb;
	private double diruKop;
	private User seller;  
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Mugimenduak> mugimenduak=new ArrayList<Mugimenduak>();
	
	public DiruKontua() {
		super();
	}
	
	public DiruKontua(String kontuZenb, double diruKop, User seller) {
		super();
		this.kontuZenb = kontuZenb;
		this.diruKop = diruKop;
		this.seller = seller;
	}
	
	public String getKontuZenb() {
		return kontuZenb;
	}
	
	public void setKontuZenb(String kontuZenb) {
		this.kontuZenb = kontuZenb;
	}
	
	public double getDiruKop() {
		return diruKop;
	}
	
	public void setDiruKop(double diruKop) {
		this.diruKop = diruKop;
	}
	
	public User getSeller() {
		return seller;
	}
	
	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	public List<Mugimenduak> getMugimenduak() {
		return mugimenduak;
	}
	
	public void setMugimenduak(List<Mugimenduak> mugimenduak) {
		this.mugimenduak = mugimenduak;
	}
}


