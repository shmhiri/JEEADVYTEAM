package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Catalog;
import Entities.FicheCompetence;
import Entities.Formation;
import Enumerates.MaitriseCompetence;
import Services.CatalogService;
import Services.CompetenceService;
import Services.FormationService;

@ManagedBean(name= "FormationBean", eager = true)
@SessionScoped
public class FormationBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id_for;

	private String nom_for;
	private String prerequis;
    private MaitriseCompetence niveauobt;
	private String nom_anim;
	private String description;
	private Date date_debut;
	private int duree;
	private String lieu;
	private int formationIdToBeUpdated;
	private List<Formation> formations;
	private Formation formation ;
	private static Catalog selectedCatalog;
	private int selectedCatalogId;
	private List<Catalog> Catalogs;

	
	@EJB
	FormationService fs;
	@EJB
	CatalogService cs;
	@EJB
	CompetenceService cos;
	/*public List<Catalog> afficheCat(){
		Catalogs= cs.findAllCatalog();
		return Catalogs;
	}*/
	
	public String ajouterFormation() {
		 Formation f =new Formation(nom_for, prerequis, niveauobt, nom_anim, description, date_debut, duree, lieu);
		 Catalog SelectedCatalog=new Catalog();
			System.out.println("2");
			SelectedCatalog.setId_cat(selectedCatalogId);
			System.out.println(selectedCatalogId);
			
			
			if (cs.nombreformationInCatalog(SelectedCatalog)>5){
				System.out.println("ça marche pas");	
				System.out.println(cs.nombreformationInCatalog(SelectedCatalog));	

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"vous ne pouvez plus ajouter de formation", ""));
		}else{
			
			
			
			
			f.setCat(SelectedCatalog);
			fs.ajouterFormation(f);}
		return "Affiche";
	}
	public String  displayFormation(Formation form) {
		this.setFormationIdToBeUpdated(form.getId_for());
		this.setNom_for(form.getNom_for());
		this.setPrerequis(form.getPrerequis());
		this.setNiveauobt(form.getNiveauobt());
		this.setNom_anim(form.getNom_anim());
		this.setDescription(form.getDescription());
		this.setDate_debut(form.getDate_debut());
		this.setDuree(form.getDuree());
		this.setLieu(form.getLieu());
		return "Ajout";
		

	}
	public String modifierformation() {
		Formation f = new Formation();
		f.setId_for(this.getFormationIdToBeUpdated());
		f.setNom_for(this.getNom_for());
		f.setPrerequis(this.getPrerequis());
		f.setNiveauobt(this.getNiveauobt());
		f.setNom_anim(this.getNom_anim());
		f.setDescription(this.getDescription());
		f.setDate_debut(this.getDate_debut());
		f.setDuree(this.getDuree());
		f.setLieu(this.getLieu());
		fs.updateFormation(f);
		return "Affiche";
	}
	
	public List<Formation> afficherFormations() {
		formations= new ArrayList<Formation>();

		formations= fs.findAllFormations();
		return formations;
	}
	public void removeFormation(int formId) {
		fs.removeFormation(formId);

	}
	public Formation getFormationbyid(int forid) {
		return fs.getFormationById(forid);
	}
	public void affecterFormationAcatalog(int formationId, int catId) {
		
		fs.affecterFormationAcatalog(formationId, catId);
	}
	
	public void participer(Formation form,int id ) {
		id=1;
		FicheCompetence f = cos.getFicheByIdUser(id);
		int score_user =( f.getNoteConception()+f.getNoteDevLogiciel()+f.getNoteGestionProjet()
		+f.getNoteMethodesAgile()+f.getNoteReporting())/5;
		
		if(score_user>15 && f.getMaitrise().equals(form.getNiveauobt() )) {
		
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
			"Passer le niveau suivant ", ""));
			
		}
		else if(score_user>15 && form.getNiveauobt().equals("junior") &&( f.getMaitrise().equals("senior")|| f.getMaitrise().equals("specialiste")||f.getMaitrise().equals("expert")) ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ce niveau est inferieur à votre niveau de competence ", ""));
		}
		
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
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public List<Formation> getFormations() {
	formations= fs.findAllFormations();

		return formations;
	}
	
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public int getFormationIdToBeUpdated() {
		return formationIdToBeUpdated;
	}
	public void setFormationIdToBeUpdated(int formationIdToBeUpdated) {
		this.formationIdToBeUpdated = formationIdToBeUpdated;
	}
	
	public FormationService getFs() {
		return fs;
	}
	public void setFs(FormationService fs) {
		this.fs = fs;
	}
	public Catalog getSelectedCatalog() {
		return selectedCatalog;
	}
	public void setSelectedCatalog(Catalog selectedCatalog) {
		FormationBean.selectedCatalog = selectedCatalog;
	}
	public int getSelectedCatalogId() {
		return selectedCatalogId;
	}
	public void setSelectedCatalogId(int selectedCatalogId) {
		this.selectedCatalogId = selectedCatalogId;
	}

	public List<Catalog> getCatalogs() {
		Catalogs=cs.findAllCatalog();
		return Catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		Catalogs = catalogs;
	}
	public void participate(int id_for,int id_user) {}
	
}
