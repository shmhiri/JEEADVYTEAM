package Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.*;

import Services.*;


@SessionScoped 
@ManagedBean(name="congesbean")
public class CongesBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private int id;
	private User employer_id;
	private Date date ;
    private int nbr;
    private String etat;
    private String comment;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
    
	
///////////////////////
	@EJB
	CongesServices c;
	public void demandeconges() {
		
		c.demande(new Conges( date, nbr, comment));
	}
	////////////////////////////////////
	private List<Conges> coges;
   
	
	public List<Conges> getCoges() {
		coges=c.AllCongés();
		return coges;
	}
	public void setCoges(List<Conges> conges) {
		this.coges = conges;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	///////////////////////////////////
	
	public void accepter(int id) {
		c.validation(id);
		
	}
}
