package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import Enumerates.MaitriseCompetence;
@XmlRootElement
@Entity 
@Table(name = "formation") 
public class Formation  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_for")
	private int id_for;
	
	@XmlElement (name="nom_for")
	@Column(name = "nom_for")
	private String nom_for;
	
	@XmlElement (name="prerequis")
	@Column(name = "prerequis")
	private String prerequis;
	
	@XmlElement (name="niveauobt")
	@Enumerated(EnumType.STRING)
	@Column(name = "niveauobt")
	private MaitriseCompetence niveauobt;
	
	@XmlElement (name="nom_anim")
	@Column(name = "nom_anim")
	private String nom_anim;
	
	@XmlElement (name="description")
	@Column(name = "description")
	private String description;
	
	@XmlElement (name="date_debut")
	@Column(name = "date_debut")
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@XmlElement (name="duree")
	@Column(name = "duree")
	private int duree;
	
	@XmlElement (name="lieu")
	@Column(name = "lieu")
	private String lieu;
	
	@OneToOne
	private Quiz quiz;
	

//	@JsonBackReference(value="cat")
	@ManyToOne
	private Catalog cat;
	

	
	public Catalog getCat() {
		return cat;
	}


	public void setCat(Catalog cat) {
		this.cat = cat;
	}


	public int getId_for() {
		return id_for;
	}


	public void setId_for(int id_for) {
		this.id_for = id_for;
	}


	public String getNom_for() {
		return nom_for;
	}


	public void setNom_for(String nom_for) {
		this.nom_for = nom_for;
	}


	public String getPrerequis() {
		return prerequis;
	}


	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}


	public MaitriseCompetence getNiveauobt() {
		return niveauobt;
	}


	public void setNiveauobt(MaitriseCompetence niveauobt) {
		this.niveauobt = niveauobt;
	}


	public String getNom_anim() {
		return nom_anim;
	}


	public void setNom_anim(String nom_anim) {
		this.nom_anim = nom_anim;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Formation(String nom_for, String prerequis, MaitriseCompetence niveauobt, String nom_anim, String description,
			Date date_debut, int duree, String lieu) {
		super();
		this.nom_for = nom_for;
		this.prerequis = prerequis;
		this.niveauobt = niveauobt;
		this.nom_anim = nom_anim;
		this.description = description;
		this.date_debut = date_debut;
		this.duree = duree;
		this.lieu = lieu;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	/*public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	*/
	
	
}
