package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Erreklamazioak> erreklamazioak=new ArrayList<Erreklamazioak>();
	
	public Admin() {
		super();
	}
	
	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Erreklamazioak> getErreklamazioak() {
		return erreklamazioak;
	}
	
	public void setErreklamazioak(List<Erreklamazioak> erreklamazioak) {
		this.erreklamazioak = erreklamazioak;
	}

}
