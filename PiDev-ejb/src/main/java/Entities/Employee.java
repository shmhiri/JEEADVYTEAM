package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "Employee")
	private List<Evaluation360> Evaluation360;
	
	@OneToMany(mappedBy = "Employee")
	private List<SelfEvaluation> SelfEvaluation;
	
	@OneToMany(mappedBy = "Coworker")
	private List<Evaluation360Done> Evaluation360Done;
	
	public Employee(int id,String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Employee() {}
	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
}
