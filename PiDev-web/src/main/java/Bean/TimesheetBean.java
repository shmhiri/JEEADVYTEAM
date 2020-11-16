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
import javax.persistence.ManyToOne;


import Entities.*;

import Services.*;





@SessionScoped 
@ManagedBean(name="timesheetbean")
public class TimesheetBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	    private int id;
		private User employer_id;
		private int heure;
		private int conges;
		private int jour;
		private String poste;
		private List<Activity> activity;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public User getEmployer_id() {
			return employer_id;
		}
		public void setEmployer_id(User employer_id) {
			this.employer_id = employer_id;
		}
		public int getHeure() {
			return heure;
		}
		public void setHeure(int heure) {
			this.heure = heure;
		}
		public int getConges() {
			return conges;
		}
		public void setConges(int conges) {
			this.conges = conges;
		}
		public int getJour() {
			return jour;
		}
		public void setJour(int jour) {
			this.jour = jour;
		}
		public String getPoste() {
			return poste;
		}
		public void setPoste(String poste) {
			this.poste = poste;
		}
		public List<Activity> getActivity() {
			return activity;
		}
		public void setActivity(List<Activity> activity) {
			this.activity = activity;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		////////////// affiche timesheet/////////////
		@EJB
		TimesheetServices tm;

		private ArrayList<Timesheet> timesheets;
		public ArrayList<Timesheet> getTimesheets() {
			timesheets=tm.AllTimesheet();
			return timesheets;
		}
		public void setTimesheets(ArrayList<Timesheet> timesheets) {
			this.timesheets = timesheets;
		}
		


		

}
