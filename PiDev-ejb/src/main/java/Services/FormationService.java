package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Catalog;
import Entities.Formation;
import interfaces.IFormationRemote;


@Stateless
@LocalBean
public class FormationService implements IFormationRemote {

	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;
	
	public String ajouterFormation(Formation formation) {
		em.persist(formation);
		
		return "formation"+formation.getId_for()+" crée ";
	}

    public void removeFormation(int formationId) {
		em.remove(em.find(Formation.class,formationId));
		System.out.println("Formation removed! ");
	}

	
	public List<Formation> findAllFormations() {
		List<Formation> Formations=null;
		TypedQuery<Formation> query1= em.createQuery("Select f from Formation f", Formation.class);
		try {
			Formations = query1.getResultList();
		} catch (NoResultException e ) {
			
		}
		return Formations;
		
		
	}

	
	/*public void affecterFormationATheme(int formationId, int CatalogId) {
		Catalog CatalogManagedEntity = em.find(Catalog.class, ThemeId);
		Formation FormationManagedEntity = em.find(Formation.class, formationId);

		if(CatalogManagedEntity.getFormation() == null){
			List<Formation> formations = new ArrayList<>();
			formations.add(FormationManagedEntity);
			CatalogManagedEntity.setFormation(formations);
		}else{
			CatalogManagedEntity.getFormation().add(FormationManagedEntity);
		}
	}
*/
	public Formation getFormationById(int formationId) {
		Formation formation= em.find(Formation.class, formationId);
		System.out.println("Out of findUserById: ");
		return formation;
	}


	
	public String updateFormation(Formation newformation) {
		Formation formation= em.find(Formation.class, newformation.getId_for());
		formation.setNom_for(newformation.getNom_for());
		formation.setPrerequis(newformation.getPrerequis());
		formation.setNiveauobt(newformation.getNiveauobt());
		formation.setDescription(newformation.getDescription());
		formation.setDate_debut(newformation.getDate_debut());
		formation.setDuree(newformation.getDuree());
		formation.setLieu(newformation.getLieu());
		formation.setNom_anim(newformation.getNom_anim());
	

		return "formation updated! ";
	}

	@Override
	public void affecterFormationAcatalog(int formationId, int catId) {
		Catalog CatalogManagedEntity = em.find(Catalog.class, catId);
		Formation FormationManagedEntity = em.find(Formation.class, formationId);
		if(FormationManagedEntity.getCat()==null) {
			FormationManagedEntity.setCat(CatalogManagedEntity);
		}
		else {
			System.out.println("Already affected ! ");
		}
	}

	/*@Override
	public void affecterFormationAcatalog(int formationId, int catId) {
		Catalog CatalogManagedEntity = em.find(Catalog.class, catId);
		Formation FormationManagedEntity = em.find(Formation.class, formationId);

		if(CatalogManagedEntity.getListformations() == null){
			List<Formation> formations = new ArrayList<>();
			formations.add(FormationManagedEntity);
			CatalogManagedEntity.setListformations(formations);
		}else{
			CatalogManagedEntity.getListformations().add(FormationManagedEntity);
		}*/
		
	}








