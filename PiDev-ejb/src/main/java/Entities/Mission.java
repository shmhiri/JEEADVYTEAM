package Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import Enumerates.*;
import Entities.User;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "refrence")
@DiscriminatorValue(value="Mission")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public class Mission implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int refrence ;
	@Temporal(TemporalType.DATE) 
	private Date date;
	private String subject;
	private String description;
	private int participantsNumber;
	@Enumerated(EnumType.STRING)
	private State state;
	private String place;
	

	@JsonBackReference(value="userId")
	@ManyToOne
	private User user;

	@JsonManagedReference(value="refrence")
	@OneToMany (mappedBy ="mission", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<MissionExpenses> mission;
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

	private String estimation;
	
	public String getEstimation() {
		return estimation;
	}
	public void setEstimation(String estimation) {
		this.estimation = estimation;
	}

	private Etat etat;
	
private Boolean pressed=false ;


	public Boolean getPressed() {
	return pressed;
}
public void setPressed(Boolean pressed) {
	this.pressed = pressed;
}
private Boolean notpressed=true ;


public Boolean getNotpressed() {
return notpressed;
}
public void setNotpressed(Boolean notpressed) {
this.notpressed = notpressed;
}

	private Boolean isProvidedAccd;
	private Boolean isProvidedTrsp;
	@Temporal(TemporalType.DATE) 
	private Date datedebut;
	@Temporal(TemporalType.DATE) 
	private Date datefin;
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
	
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat =etat;
	}
	

	 
	@Enumerated(EnumType.STRING)
	 private SkillType skillsRequired;
	@Enumerated(EnumType.STRING)
	 private SkillType secondSkill;
	@Enumerated(EnumType.STRING)
	 private SkillType thirdSkill;
	 
	 
	public SkillType getSecondSkill() {
		return secondSkill;
	}
	public void setSecondSkill(SkillType secondSkill) {
		this.secondSkill = secondSkill;
	}
	public SkillType getThirdSkill() {
		return thirdSkill;
	}
	public void setThirdSkill(SkillType thirdSkill) {
		this.thirdSkill = thirdSkill;
	}
	public int getRefrence() {
		return refrence;
	}
	public void setRefrence(int refrence) {
		this.refrence = refrence;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParticipantsNumber() {
		return participantsNumber;
	}
	public void setParticipantsNumber(int participantsNumber) {
		this.participantsNumber = participantsNumber;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Boolean getIsProvidedAccd() {
		return isProvidedAccd;
	}
	public void setIsProvidedAccd(Boolean isProvidedAccd) {
		this.isProvidedAccd = isProvidedAccd;
	}
	public Boolean getIsProvidedTrsp() {
		return isProvidedTrsp;
	}
	public void setIsProvidedTrsp(Boolean isProvidedTrsp) {
		this.isProvidedTrsp = isProvidedTrsp;
	}


	

	public SkillType getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(SkillType skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public Mission(String subject, String description,
			Boolean isProvidedAccd, Boolean isProvidedTrsp,SkillType skillsRequired,SkillType secondSkill,SkillType thirdSkill,Date datedebut, Date datefin,String estimation,String place) {
		super();
		this.date = new Date();
		this.subject = subject;
		this.description = description;
		this.participantsNumber = 0;
		this.state = State.Availbale;
		this.isProvidedAccd = isProvidedAccd;
		this.isProvidedTrsp = isProvidedTrsp;
		this.skillsRequired = skillsRequired;
		this.secondSkill=secondSkill;
		this.thirdSkill=thirdSkill;
		this.datedebut=datedebut;
		this.datefin=datefin;
		this.etat=Etat.Fresh;
		this.estimation=estimation;
		this.place=place;
		this.user.getUserId();
		
		
	}
	
	

	@Override
	public String toString() {
		return "Mission [refrence=" + refrence + ", date=" + date + ", subject=" + subject + ", description="
				+ description + ", participantsNumber=" + participantsNumber + ", state=" + state + ", place=" + place
				+ ", user=" + user+ ", estimation=" + estimation + ", etat=" + etat + ", pressed=" + pressed
				+ ", notpressed=" + notpressed + ", isProvidedAccd=" + isProvidedAccd + ", isProvidedTrsp="
				+ isProvidedTrsp + ", datedebut=" + datedebut + ", datefin=" + datefin + ", skillsRequired="
				+ skillsRequired + ", secondSkill=" + secondSkill + ", thirdSkill=" + thirdSkill + "]";
	}
	public Mission(){}
		
	/*public Mission(int id,Date date, String description,
			Boolean isProvidedAccd, Boolean isProvidedTrsp,int participantsNumber,String skillsRequired,State state,String subject,Employee postedBy,List<Employee> participants) {
		super();
		this.refrence=id;
		this.date = date;
		this.subject = subject;
		this.description = description;
		this.participantsNumber = participantsNumber;
		this.state = state;
		this.isProvidedAccd = isProvidedAccd;
		this.isProvidedTrsp = isProvidedTrsp;
		this.postedBy = postedBy;
		this.participants = participants;
		this.skillsRequired = skillsRequired;
		this.postedBy=postedBy;
	}*/
	 
	  
	 
}
