package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import Enumerates.Role; 


@Entity
public class User  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
private String nom ;
private String prenom ;
private String email ;
private String password ; 
private String image ;

@Enumerated(EnumType.STRING)
private  Role role ;

@JsonManagedReference(value="userId")
@OneToMany (mappedBy ="user", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
private Set<Mission> mission;

@JsonManagedReference(value="userId")
@OneToMany (mappedBy ="user", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
private Set<MissionExpenses> missionExpenses;

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

public User() {
	super();
}
public User(String nom, String prenom, String email, String password, String image, Role role) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.image = image;
	this.role = role;
}


}


