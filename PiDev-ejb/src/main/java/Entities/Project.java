package Entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
	@ManyToOne
	private Project Project_code;
	private String Name;
	@ManyToOne
	private User manager_id;
	@Temporal(TemporalType.DATE)
	private Date datedebut ;
	private Date datefin;
	private String otherdetai;
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )    
	private List<Activity> activity=new ArrayList<>();
    
    
	public List<Activity> getActivity() {
		return activity;
	}
	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public Project getProject_code() {
		return Project_code;
	}
	public void setProject_code(Project project_code) {
		Project_code = project_code;
	}
	public User getManager_id() {
		return manager_id;
	}
	public void setManager_id(User manager_id) {
		this.manager_id = manager_id;
	}
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
	public String getOtherdetai() {
		return otherdetai;
	}
	public void setOtherdetai(String otherdetai) {
		this.otherdetai = otherdetai;
	}
	public Project(Project project_code, String name, User manager_id, Date datedebut, Date datefin,
			String otherdetai) {
		super();
		Project_code = project_code;
		Name = name;
		this.manager_id = manager_id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.otherdetai = otherdetai;
	}
	public Project(int id, Project project_code, String name, User manager_id, Date datedebut, Date datefin,
			String otherdetai) {
		super();
		this.id = id;
		Project_code = project_code;
		Name = name;
		this.manager_id = manager_id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.otherdetai = otherdetai;
	}
	
	
}
