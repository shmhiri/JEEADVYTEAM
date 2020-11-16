package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Activity  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int id;
	private String code;
	@ManyToOne
	private Project project_id;
	@ManyToOne
	private Timesheet timesheetid;
	@Temporal(TemporalType.DATE)
	private Date datedebut ;
	private Date datefin;
	private Date datesubmited;
	private String etat;
	private String otherdetai;
	@OneToOne
	private User emploey_id;
	
	
	public User getEmploey_id() {
		return emploey_id;
	}
	public void setEmploey_id(User emploey_id) {
		this.emploey_id = emploey_id;
	}
	public Timesheet getTimesheetid() {
		return timesheetid;
	}
	public void setTimesheetid(Timesheet timesheetid) {
		this.timesheetid = timesheetid;
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
	public String getOtherdetai() {
		return otherdetai;
	}
	public void setOtherdetai(String otherdetai) {
		this.otherdetai = otherdetai;
	}
	public Activity(String code, Project project_id, Date datedebut, Date datefin, String otherdetai) {
		super();
		this.code = code;
		this.project_id = project_id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.otherdetai = otherdetai;
	}
	public Activity(Date datedebut, Date datefin, String otherdetai) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.otherdetai = otherdetai;
		this.etat="en cour";
	}
	public Activity() {
		super();
	}
	
	
}
