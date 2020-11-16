package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Conges implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
	@OneToOne
	private Timesheet timesheet;
	@OneToOne
	private User employer_id;
	private Date date;
	private int nbr;
	private String comment;
	private String etat;
	
	public Timesheet getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Conges( Date date, int nbr, String comment, String etat) {
		super();
		this.date = date;
		this.nbr = nbr;
		this.comment = comment;
		this.etat = etat;
	}
	public Conges() {
		super();
	}
	public Conges(Date date, int nbr, String comment) {
		super();
		this.date = date;
		this.nbr = nbr;
		this.comment = comment;
	}
	
	

}
