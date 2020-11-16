package Services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import Entities.*;
import interfaces.ICompetenceRemote;

@Stateless
@LocalBean
public class CompetenceService implements ICompetenceRemote {

	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;
	
	@Override
	public String ajouterFiche(FicheCompetence fiche) {
	em.persist(fiche);
		
		return "fiche crée ";
	}

	@Override
	public String updateFiche(FicheCompetence fiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FicheCompetence getFicheByIdUser(int id) {
		FicheCompetence fiche= em.createQuery("select e from FicheCompetence where e.user.id=:id", FicheCompetence.class).getSingleResult();
	return fiche;
	}

	@Override
	public void removeFiche(int id) {
		em.remove(em.find(FicheCompetence.class,id));
		System.out.println("FicheCompetence removed! ");
		
	}

}
