package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Evaluation360Done implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String score;
	
	@ManyToOne
	private Evaluation360 Evaluation360;
	
	@ManyToOne
	private Employee Coworker;
	
	@Column
	private String qualities;
	
	@Column
	private String improvements;
	
	public Evaluation360Done()
	{
		super();
	}
	
	
	
	
	public Evaluation360 getEvaluation360() {
		return Evaluation360;
	}




	public void setEvaluation360(Evaluation360 evaluation360) {
		Evaluation360 = evaluation360;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	
	
	public String getScore() {
		return score;
	}



	public void setScore(String score) {
		this.score = score;
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



	public Evaluation360Done(Employee coworker, Evaluation360 evaluation3600)
	{
		this.Coworker=coworker;
		this.Evaluation360=evaluation3600;
	}

	public Evaluation360Done(String score, String qualities, String improvements) {
		this.score = score;
		this.qualities = qualities;
		this.improvements = improvements;
	}



	@Override
	public String toString() {
		return "Evaluation360Done [id=" + id + ", Evaluation360=" + Evaluation360 + ", Coworker=" + Coworker + "]";
	}

	
}
