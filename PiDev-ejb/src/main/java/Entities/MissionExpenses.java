package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MissionExpenses implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refrence;
	@Temporal(TemporalType.DATE) 
	private Date date;
	private double totalCost;
	private double cost;
	private String type;
	private String description;
	private double kilomtrage;
	private double totalRecovered;
	private Boolean isApproved;
	private String image;

	
	@JsonBackReference(value = "userId")
	@ManyToOne
	private User user;

	@JsonBackReference(value = "refrence")
	@ManyToOne
	private Mission mission;
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getKilomtrage() {
		return kilomtrage;
	}

	public void setKilomtrage(double kilomtrage) {
		this.kilomtrage = kilomtrage;
	}

	public int getRefrence() {
		return refrence;
	}

	public void setRefrence(int refrence) {
		this.refrence = refrence;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public double getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(double totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}




}
