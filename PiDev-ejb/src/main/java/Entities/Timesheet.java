package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Timesheet  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
	@ManyToOne
	private User employer_id;
	private int heure;
	private int conges;
	private int jour;
	private String poste;
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )    
	private List<Activity> activity=new ArrayList<>();
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
	public Timesheet(User employer_id, int heure, int conges, int jour, String poste, ArrayList<Activity> activity) {
		super();
		this.employer_id = employer_id;
		this.heure = heure;
		this.conges = conges;
		this.jour = jour;
		this.poste = poste;
		this.activity = activity;
	}
	public Timesheet() {
		super();
	}
	
	
	
	
	
}
