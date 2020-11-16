package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity 
@Table(name = "Catalog") 
public class Catalog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cat")
	private int id_cat;
	
	@Column(name = "nom_cat")
	private String nom_cat;
	//@OneToMany(targetEntity = Formation.class, mappedBy = "forms", fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cat" , fetch = FetchType.EAGER)
	private List<Formation> listformations;
	
	

	public int getId_cat() {
		return id_cat;
	}

	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public String getNom_cat() {
		return nom_cat;
	}

	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}

	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public Catalog(String nom_cat) {
		super();
		this.nom_cat = nom_cat;
	}

	public Catalog(String nom_cat, List<Formation> listformations) {
		
		this.nom_cat = nom_cat;
		this.listformations = listformations;
	}

	public List<Formation> getListformations() {
		return listformations;
	}

	public void setListformations(List<Formation> listformations) {
		this.listformations = listformations;
	}

	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

