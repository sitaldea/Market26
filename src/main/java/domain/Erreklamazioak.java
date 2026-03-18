package domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.persistence.OneToOne;

public class Erreklamazioak implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String izenburua;
	private String deskripzioa;
	private String irudia;
	@OneToOne
	private Sale sale;
	private User user;
	private Admin admin;
	
	
	public Erreklamazioak() {
		super();
	}
	
	public Erreklamazioak(String izenburua, String deskripzioa, File file, Sale sale) {
		super();
		this.setIzenburua(izenburua);
		this.deskripzioa = deskripzioa;
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
	
}
