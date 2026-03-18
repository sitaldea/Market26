package domain;

import java.io.Serializable;

public class Mugimenduak implements Serializable{
	private static final long serialVersionUID = 1L;
	private float diruKop;
	private String data;
	private String productName;
	private String mota;
	
	private User user;
	private DiruKontua kontua;
	
	
	public Mugimenduak() {
		super();
	}
	
	
	public Mugimenduak(float diruKop, String data, String productName, String mota) {
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
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public DiruKontua getKontua() {
		return kontua;
	}
	
	public void setKontua(DiruKontua kontua) {
		this.kontua = kontua;
	}
}
