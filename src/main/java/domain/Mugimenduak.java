package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Mugimenduak implements Serializable{
	private static final long serialVersionUID = 1L;
	private float diruKop;
	private Date data;
	private String productName;
	private String mota;
	
	private DiruKontua kontua;
	
	
	public Mugimenduak() {
		super();
	}
	
	
	public Mugimenduak(float diruKop, Date data, String productName, String mota) {
		super();
		this.diruKop = diruKop;
		this.data = data;
		this.productName = productName;
		this.mota = mota;
	}
	
	public float getDiruKop() {
		return diruKop;
	}
	
	public void setDiruKop(float diruKop) {
		this.diruKop = diruKop;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getMota() {
		return mota;
	}
	
	public void setMota(String mota) {
		this.mota = mota;
	}
	
	
	public DiruKontua getKontua() {
		return kontua;
	}
	
	public void setKontua(DiruKontua kontua) {
		this.kontua = kontua;
	}
}
