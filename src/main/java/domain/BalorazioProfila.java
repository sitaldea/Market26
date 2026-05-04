package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class BalorazioProfila implements Serializable{
	private static final long serialVersionUID = 1L;
	private String balorazioa;
	private int puntuazioa;
	private User user;
	
	public BalorazioProfila() {
		super();
	}
	
	public BalorazioProfila(String balorazioa, int puntuazioa, User user) {
		super();
		this.balorazioa = balorazioa;
		this.puntuazioa = puntuazioa;
		this.user = user;
	}
	
	public String getBalorazioa() {
		return balorazioa;
	}
	
	public void setBalorazioa(String balorazioa) {
		this.balorazioa = balorazioa;
	}
	
	public int getPuntuazioa() {
		return puntuazioa;
	}
	
	public void setPuntuazioa(int puntuazioa) {
		this.puntuazioa = puntuazioa;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
