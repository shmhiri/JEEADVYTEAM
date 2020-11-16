package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "Quiz") 
public class Quiz implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Quiz")
	private int id_Quiz ;
	
	@Column(name = "QuizName")
	private String QuizName ;
	
	@Column(name = "Result")
	private int Result ;
	
	@OneToOne
	private Formation formation ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="quiz" , fetch = FetchType.EAGER)
	private List<Question> Questions;
}
