package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.*;
import interfaces.*;



@Stateless
@LocalBean
public class ActivityServices implements ActivityServicesInterface{

	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;

	@Override
	public void ajouterActivity(Activity activity) {
    
          em.persist(activity);	
         
	}

	@Override
	public ArrayList<Activity> getAllActivity() {
		ArrayList<Activity> activity = (ArrayList<Activity>) em.createQuery("Select a from Activity a", Activity.class).getResultList(); 
		return activity;
	}

	@Override
	public void deleteActivityById(int ActivitytId) {
		em.remove(em.find(Activity.class, ActivitytId));
		
	}

	@Override
	public void updateAcitivity(Activity Activity) {
		Activity tp = em.find(Activity.class,Activity.getId());
       tp.setDatedebut(Activity.getDatedebut());
       tp.setDatefin(Activity.getDatefin());
		tp.setOtherdetai(Activity.getOtherdetai());		
	}
	 @SuppressWarnings("deprecation")
	   @Override
	   public void validerActivity(int id) {
			Timesheet t=new Timesheet();
			Activity a=new Activity();
			 a=  em.find(Activity.class, id) ;
			int i,j,k;  
		 t=  em.find(Timesheet.class, a.getTimesheetid().getId()) ;
		 
		   if (a.getDatedebut().getMonth()<a.getDatefin().getMonth()) {
			   i=(a.getDatefin().getMonth()-a.getDatedebut().getMonth())*22+(a.getDatefin().getDay()-a.getDatedebut().getDay())*8;
			   j=i*8;
			   k=i;
		   }
		   else   if (a.getDatedebut().getDay()<a.getDatefin().getDay()) {
			   i=a.getDatefin().getDay()-a.getDatedebut().getDay();
			   j=i*8;
			   k=i;
		   }
			   else {
				   
				   i=a.getDatefin().getHours()-a.getDatedebut().getHours();
				   j=i*8;
				   k=1;
			   }
			   
			t.setHeure(t.getHeure()+j);
			t.setJour(t.getJour()+k);
			a.setEtat("valider");
			

	   
	   }

}
