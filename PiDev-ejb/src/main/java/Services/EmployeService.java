package Services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employe;

@Stateless
@LocalBean
public class EmployeService implements EmlpoyeServiceRemote{
	
	@PersistenceContext(unitName= "PiDev-ejb")

	EntityManager em ;
	
	@Override
	public Employe getEmployeByNom( String nom) {
		TypedQuery<Employe> query = em.createQuery("Select e from Employe e "
				+"where "
				+"e.nom=:nom"
				, Employe.class);
		
	
		query.setParameter("nom",nom);
		
		Employe employe = null ; 
		
		try {
			employe = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun employe trouvé avec ce nom :" + nom);
		}
		return employe;
	}
	@Override 
	public Employe getEmployeById(int id) {
		return 
				em.find(Employe.class, id);
	}

	@Override
	public List<Employe> employes (){
		List<Employe> employes=null;
		TypedQuery<Employe> query = em.createQuery("Select e from Employe e "
				, Employe.class);	
		try {
			employes = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return employes;
	}

}
