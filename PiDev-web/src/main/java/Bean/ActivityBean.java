package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.*;

import Services.*;

@SessionScoped 
@ManagedBean(name="activitybean")
public class ActivityBean implements Serializable {
	private static final long serialVersionUID = 1L;
	  private int id;
		private String code;
		private Project project_id;
		private Timesheet timesheetid;
		private Date datedebut ;
		private Date datefin;
		private Date datesubmited;
		private String etat;
		private String otherdetai;
		private User emploey_id;
		

		public User getEmploey_id() {
			return emploey_id;
		}
		public void setEmploey_id(User emploey_id) {
			this.emploey_id = emploey_id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Project getProject_id() {
			return project_id;
		}
		public void setProject_id(Project project_id) {
			this.project_id = project_id;
		}
		public Timesheet getTimesheetid() {
			return timesheetid;
		}
		public void setTimesheetid(Timesheet timesheetid) {
			this.timesheetid = timesheetid;
		}
		public Date getDatedebut() {
			return datedebut;
		}
		public void setDatedebut(Date datedebut) {
			this.datedebut = datedebut;
		}
		public Date getDatefin() {
			return datefin;
		}
		public void setDatefin(Date datefin) {
			this.datefin = datefin;
		}
		public Date getDatesubmited() {
			return datesubmited;
		}
		public void setDatesubmited(Date datesubmited) {
			this.datesubmited = datesubmited;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public String getOtherdetai() {
			return otherdetai;
		}
		public void setOtherdetai(String otherdetai) {
			this.otherdetai = otherdetai;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		/////////////////////// ajout ///////////
		@EJB
		ActivityServices a;
	    public String addActivity() {

	    	String navigateTo = "null";
	    	a.ajouterActivity(new Activity( datedebut, datefin, otherdetai));
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Activity Ajoutée!"));
		navigateTo = "/Pages/admin/ActivityList.xhtml?faces-redirect=true"; 
  
		return navigateTo;

	}
	    ///////////////////////// affiche/////////////////////
	    private ArrayList<Activity> activity;
		public ArrayList<Activity> getActivity() {
			activity=a.getAllActivity();
			return activity;
		}
		public void setActivity(ArrayList<Activity> activity) {
			this.activity = activity;
		}
	    
	    /////////////////////remove///////////////////
		public void removeActivity(int activityId) {
			a.deleteActivityById(activityId); 
			}
		
		//////////// valider tache//////////////
		public void validerAcitivity(int id) {
			a.validerActivity(id);
	    
		}
		
		
	////////////// update activity/////////////////
		
		public String displayDetails(Activity a)
		
		{		String navigateTo = "null"; 
       this.datedebut=a.getDatedebut();
       this.datefin=a.getDatefin();
       this.otherdetai=a.getOtherdetai();
		navigateTo = "/Pages/admin/UpdateActivity.xhtml?faces-redirect=true"; 



		return navigateTo ;}
		
		public void update() {
			
			a.updateAcitivity(new Activity(datedebut, datefin, otherdetai));
		}
}
