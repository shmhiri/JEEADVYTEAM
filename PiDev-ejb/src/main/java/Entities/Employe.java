package Entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int Id_emp;
	
private String nom ;
private String prenom ;
private String email ;
private int cin ;
private String poste;
private String salaire;
@Embedded
private Adresse adresse ;

public int getId_emp() {
	return Id_emp;
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
public int getCin() {
	return cin;
}
public void setCin(int cin) {
	this.cin = cin;
}
public String getPoste() {
	return poste;
}
public void setPoste(String poste) {
	this.poste = poste;
}
public String getSalaire() {
	return salaire;
}
public void setSalaire(String salaire) {
	this.salaire = salaire;
}
public Adresse getAdresse() {
	return adresse;
}
public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}
public Employe( String nom, String prenom, String email, int cin, String poste, String salaire,
		Adresse adresse) {
	super();
	
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.cin = cin;
	this.poste = poste;
	this.salaire = salaire;
	this.adresse = adresse;
}
public Employe() {
	super();
	// TODO Auto-generated constructor stub
}

}
