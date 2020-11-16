package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Catalog;
import Entities.Formation;



import interfaces.ICatalogRemote;

@Stateless
@LocalBean
public class CatalogService implements ICatalogRemote {

	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;

	@Override
	public String ajouterCatalog(Catalog catalog) {
		em.persist(catalog);
		
		return "Catalog"+catalog.getId_cat()+" crée ";
	}
	@Override
	public void updateCatalog(Catalog newcatalog) {

		Catalog catalog= em.find(Catalog.class, newcatalog.getId_cat());
		catalog.setNom_cat(newcatalog.getNom_cat());
		

		System.out.println("catalog updated! ");
		
	}
	@Override
	public void removeCatalog(int catalogId) {
		em.remove(em.find(Catalog.class,catalogId));
		System.out.println("Catalog removed! ");
		
	}
	@Override
	public List<Catalog> findAllCatalog() {
		List<Catalog> Catalog= em.createQuery("Select c from Catalog  c", Catalog.class).getResultList();
		System.out.println("List formations :");
		return Catalog;
	}
	public List<Formation> getListFormationByCatId(int CatId) {
		List<Formation> formationCat = em.createQuery("Select a from Formation a  where a.cat.id_cat =:"+CatId, Formation.class).getResultList();
		//query.setParameter("categoryName", categoryName);
                return formationCat;
	}
	public void affecterFormationAcatalog(int formationId, int catId) {
		Catalog CatalogManagedEntity = em.find(Catalog.class, catId);
		Formation FormationManagedEntity = em.find(Formation.class, formationId);

		if(CatalogManagedEntity.getListformations() == null){
			List<Formation>Listformations = new ArrayList<>();
			Listformations.add(FormationManagedEntity);
			CatalogManagedEntity.setListformations(Listformations);
		}else{
			CatalogManagedEntity.getListformations().add(FormationManagedEntity);
			FormationManagedEntity.setCat(CatalogManagedEntity);
		}
		}
	public Long nombreformationInCatalog(Catalog selectedCatalog) {
		Query query = em.createQuery("SELECT COUNT(a.id_for) FROM Formation a  WHERE a.cat.id_cat ="+selectedCatalog.getId_cat());
        System.out.println(query.toString());       
		return  (Long) query.getSingleResult();
		
	}

	

}
