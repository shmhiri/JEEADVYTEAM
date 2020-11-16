package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Catalog;
import Entities.Formation;
import Services.CatalogService;
import Services.FormationService;

@ManagedBean(name= "CatalogBean", eager = true)
@SessionScoped
public class CatalogBean implements Serializable{

private static final long serialVersionUID = 1L;
	

	private int id_cat;
	private String nom_cat;
	private List<Formation> listformations = new ArrayList<Formation>();
	private List<Catalog> Catalogs;
	private static  List<Formation> selectedFormations;
	private static List<Formation> formations;
	private int idselected ;
	
	@EJB
	CatalogService cs;
	@EJB
	FormationService fs;
	
	public  List<Formation> Affiche() {
		 formations = new ArrayList<Formation>();
		formations=  fs.findAllFormations();
		return formations;
	}
	public void AddCatalog() {
		 Catalog c = new Catalog(nom_cat);
		 List<Formation> selectedFormations = new ArrayList<Formation>();
		 c.setListformations(selectedFormations);
		cs.ajouterCatalog(c)	; 
		
		
	
	}
	public void affecterdesformations(int ids) {
	
		cs.affecterFormationAcatalog(ids, id_cat);
	
	}
	public List<Catalog> afficherCatalogs() {
		Catalogs= new ArrayList<Catalog>();
		Catalogs= cs.findAllCatalog();
		return Catalogs;
	}
	public void removeCatalog(int catalogId) {
		cs.removeCatalog(catalogId);

	}
	public String detailsCatalog(int id_cat) {

		return "datailsCat";}
	public List<Formation> getListformations(int id_cat) {
		 detailsCatalog(id_cat);
		listformations = new ArrayList<Formation>();
		cs.getListFormationByCatId(id_cat);
		return listformations;
	}

	public void setListformations(List<Formation> listformations) {
		this.listformations = listformations;
	}

	public List<Catalog> getCatalogs() {
		return Catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		Catalogs = catalogs;
	}

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

	public List<Formation> getlistformations() {
		
		return listformations;
	}

	public void setFormations(List<Formation> listformations) {
		this.listformations = listformations;
	}
	public  List<Formation> getSelectedFormations() {
		return selectedFormations;
	}
	public  void setSelectedFormations(List<Formation> selectedFormations) {
		CatalogBean.selectedFormations=selectedFormations;
	}
	public int getIdselected() {
		return idselected;
	}
	public void setIdselected(int idselected) {
		this.idselected = idselected;
	}
	public CatalogService getCs() {
		return cs;
	}
	public void setCs(CatalogService cs) {
		this.cs = cs;
	}
	public FormationService getFs() {
		return fs;
	}
	public void setFs(FormationService fs) {
		this.fs = fs;
	}
	public List<Formation> getFormations() {
		return formations;
	}
	public String listSelectedFormation(List<Formation> listformations){
		selectedFormations= listformations;
		return "listFormationByCatId?faces-redirect=true&includeViewParams=true";
	}
	
}
