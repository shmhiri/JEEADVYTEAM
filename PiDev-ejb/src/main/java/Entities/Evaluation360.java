package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;





@Entity
public class Evaluation360 implements Serializable {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	
	@Column
	private int score;
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int Score)
	{
		this.score=score;
	}
	
	
	@Column
	private boolean done;
	
	public boolean getDone()
	{
		return done;
	}
	
	public void setDone(boolean done)
	{
		this.done=done;
	}
	
	
	
	@OneToMany(mappedBy = "Evaluation360")
	private List<Evaluation360Done> Evaluation360done;
	
	@ManyToOne
	private Employee Employee;
	
	public Employee getEmployee() {
		return Employee;
	}

	@Override
	public String toString() {
		return "Evaluation360 [Employee=" + Employee + "]";
	}

	public void setEmployee(Employee employee) {
		Employee = employee;
	}

	public Evaluation360() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Evaluation360(Employee emp, int score)
	{
		this.Employee=emp;
		this.score=score;
	}

}
