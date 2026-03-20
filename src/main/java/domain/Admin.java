package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Admin extends Erabiltzailea implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Admin() {
		super();
	}
	
	public Admin(String email, String password) {
		super(email, password);
	}
}
