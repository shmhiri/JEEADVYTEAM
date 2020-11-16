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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Question") 
public class Question implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Question")
	private int id_Question ;
	
	@Column(name = "question_name")
	private String question_name ; 
	
	@Column(name = "userchoice")
	private Boolean userchoice ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="question" , fetch = FetchType.EAGER)
	private List<Answer> Answers ;
	
	@ManyToOne
	private Quiz quiz;
	
}
