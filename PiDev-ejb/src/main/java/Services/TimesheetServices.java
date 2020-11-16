package Services;

import java.util.ArrayList;
import java.util.List;

import Entities.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import interfaces.*;

@Stateless
@LocalBean


public class TimesheetServices implements TimesheetServicesInterface{
	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;

	@Override
	public void ajouterTimesheet(Timesheet timesheet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Timesheet> AllTimesheet() {
		ArrayList<Timesheet> timesheet = (ArrayList<Timesheet>) em.createQuery("Select e from Timesheet e", Timesheet.class).getResultList(); 
		return timesheet ;
	}

	@Override
	public void deleteTimesheetById(int tmesheetid) {
		em.remove(em.find(Timesheet.class, tmesheetid));
		
	}

	@Override
	public void updateTimesheet(Timesheet timesheet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Timesheet> FindTimesheet(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
   
}
