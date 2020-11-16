package Services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.*;
import interfaces.*;



@Stateless
@LocalBean

public class CongesServices implements CongesServicesInterface{
	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;
	@Override
	public void demande(Conges conges) {

		em.persist(conges);
	}

	@Override
	public void validation(int id) {
       Conges c = new Conges();
       Timesheet t=new Timesheet();
       c=em.find(Conges.class,id);
       t=em.find(Timesheet.class,c.getTimesheet().getId());
       c.setEtat("accepter");
       t.setConges(t.getConges()+c.getNbr());
	}

	@Override
	public List<Conges> AllCongés() {
		List<Conges> conges = em.createQuery("Select e from Conges e", Conges.class).getResultList();
		System.out.println(conges);
		System.out.println("vide");
		return conges;
	}

}
