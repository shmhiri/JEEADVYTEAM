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
public class SelfEvaluation implements Serializable {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int score;

	@Column
	private String qualities;
	
	@Column
	private String improvements;
	public int getId()
	{
		return id;
	}
	
	public String getQualities() {
		return qualities;
	}

	public void setQualities(String qualities) {
		this.qualities = qualities;
	}

	public String getImprovements() {
		return improvements;
	}



	public void setImprovements(String improvements) {
		this.improvements = improvements;
	}



	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int Score)
	{
		this.score=score;
	}
	
	
	@ManyToOne
	private Employee Employee;
	
	public Employee getEmployee() {
		return Employee;
	}

	@Override
	public String toString() {
		return "SeEvaluation360 [Employee=" + Employee + "]";
	}

	public void setEmployee(Employee employee) {
		Employee = employee;
	}

	public SelfEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SelfEvaluation(Employee emp, int score)
	{
		this.Employee=emp;
		this.score=score;
	}

}
