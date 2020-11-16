package Services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Conge;
@Stateless
public class CongeService implements CongeServiceRemote {
	@PersistenceContext(unitName= "PiDev-ejb")


	EntityManager em ;
	
	@Override
	public Conge getCongeByNom( String nom) {
		TypedQuery<Conge> query = em.createQuery("Select c from Conge c "
				+"where c.nom=:nom "
				
				, Conge.class);
		
	
		query.setParameter("nom",nom);
		
		Conge conge = null ; 
		
		try {
			conge = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun conge trouvé avec ce nom :" + nom);
		}
		return conge;
	}


	@Override
	public List<Conge> conges (){
		List<Conge> conges=null;
		TypedQuery<Conge> query = em.createQuery("Select c from Conge c "
				, Conge.class);	
		try {
			conges = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return conges;
	}
	@Override
	public int ajoutConge(Conge c) {
		em.persist(c);
		return 
				c.getId_conge();
		
	}
	
	@Override
	public void modifConge(Conge c) {
		em.merge(c);
	}
	@Override
	public List<Conge> affiAllConge()
	{
		List<Conge> conges=null;
	TypedQuery<Conge> q=em.createQuery("select c from Conge c",Conge.class);
	try {
		conges = q.getResultList();
	} catch (NoResultException e ) {
		
	}
	return conges;
	}
@Override
public Conge getCongeByIdEmploye(int ide)
{
TypedQuery<Conge> q=em.createQuery("select c from Conge c where c.employe.id="+ide,Conge.class);
Conge c =null;
try {
	c = q.getSingleResult();
} catch (NoResultException e ) {
	
}
return c;
}

}
