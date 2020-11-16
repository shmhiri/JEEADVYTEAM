package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Conge implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int Id_conge;
	@OneToOne
	private Employe employe;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	
	
	
	public etat_demande getEtat_demande() {
		return etat_demande;
	}
	public void setEtat_demande(etat_demande etat_demande) {
		this.etat_demande = etat_demande;
	}
	public int getId_conge() {
		return Id_conge;
	}
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	private Date date_debut;
	private Date date_fin;
	private String raison;
	@Enumerated(EnumType.STRING)
	private etat_demande etat_demande;
	private enum etat_demande{Acceptée,Refusée,En_cours_de_traitement};

	

	
	

}
