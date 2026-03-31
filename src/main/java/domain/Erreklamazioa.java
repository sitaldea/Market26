package domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.persistence.*;

import javax.persistence.OneToOne;

@Entity
public class Erreklamazioa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer erreklamazioId;
	
	private String izenburua;
	private String deskripzioa;
	private String irudia;
	private String egoera;
	@OneToOne
	private Sale sale;
	private User user;
	
	
	public Erreklamazioa() {
		super();
	}
	
	public Erreklamazioa(String izenburua, String deskripzioa, File file, Sale sale, String egoera) {
		super();
		this.setIzenburua(izenburua);
		this.deskripzioa = deskripzioa;
		this.egoera = egoera;
		if (file!=null) {
		    this.irudia=file.getName();
			try {
				BufferedImage img1 = ImageIO.read(file);

				String path="src/main/resources/images/";
				File outputfile = new File(path+file.getName());
		    
		    
			   ImageIO.write(img1, "png", outputfile);  // ignore returned boolean

			} catch(IOException ex) {
				//System.out.println("Write error for " + outputfile.getPath()  ": " + ex.getMessage());
		}
		}
		this.sale = sale;
	}

	public Integer getErreklamazioId() {
		return erreklamazioId;
	}

	public void setErreklamazioId(Integer erreklamazioId) {
		this.erreklamazioId = erreklamazioId;
	}

	public String getIzenburua() {
		return izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}
	
	public String getDeskripzioa() {
		return deskripzioa;
	}
	
	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}
	
	public String getIrudia() {
		return irudia;
	}
	
	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}
	
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getEgoera() {
		return egoera;
	}
	
	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}
	
}