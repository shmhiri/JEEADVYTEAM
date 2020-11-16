package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import Entities.*;

import Services.Evaluation360Service;

@ManagedBean(name= "Evaluation360Bean")
@SessionScoped
public class Evaluation360Bean implements Serializable{

private static final long serialVersionUID = 1L;
	

	private int id;
	private int score;
	private List<Evaluation360> evaluation;
	private int empid;
	private String employeename;
	private int coworkerid;
	private String qualities;
	private String improvements;
	private String rating;
	
	
	
	public String getRating() {
		return evalsc.getEvaluation360Done(id).getScore();
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getQualities() {
		return evalsc.getEvaluation360Done(id).getQualities();
	}

	public void setQualities(String qualities) {
		this.qualities = qualities;
	}

	public String getImprovements() {
		return evalsc.getEvaluation360Done(id).getImprovements();
	}

	public void setImprovements(String improvements) {
		this.improvements = improvements;
	}

	public List<Evaluation360> getEvaluation() {
		return evalsc.getAllEvaluation360();
	}

	public void setEvaluation(List<Evaluation360> evaluation) {
		this.evaluation = evalsc.getAllEvaluation360();
	}
	
	public int getCoworkerid() {
		return coworkerid;
	}

	public void setCoworkerid(int coworkerid) {
		this.coworkerid = coworkerid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	@EJB
	Evaluation360Service evalsc;
	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public List<Employee> getEmployee() {
		return evalsc.getAllEmployees();
	}

	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score=score;
	}
	
	public String gotoSubmit()
	{
		employeename=evalsc.getEmployee(empid).toString();
		return "SubmitEvaluation";
	}
	
	public String gotoFill(int idemp, int eval360id)
	{
		id=eval360id;
		employeename=evalsc.getEmployee(idemp).toString();
		return "FillEvaluation";
	}
	
	
	public void AddEvaluation360() {
		Evaluation360 ev=new Evaluation360(evalsc.getEmployee(empid),score);
		Evaluation360Done evaldone=new Evaluation360Done(evalsc.getEmployee(coworkerid), ev);
		System.out.println("==============================");
		System.out.println(evaldone.toString());
		evalsc.addEvaluation360(ev);
		evalsc.addEvaluation360Done(evaldone);
	}
	
	public void ReadEvaluation()
	{
		evaluation=evalsc.getAllEvaluation360();
		for(Evaluation360 e : evaluation)
		{
			employeename=evalsc.getEmployee(e.getEmployee().getId()).toString();
		}
	}
	
	public void removeEvaluation360(int id)
	{
		evalsc.DeleteEvaluation360(id);
	}
	
	public void AddEvaluation360Done()
	{
		Evaluation360Done evaldone=evalsc.getEvaluation360Done(id);
		evaldone.setImprovements(improvements);
		evaldone.setQualities(qualities);
		evaldone.setScore(rating);
		evalsc.updateEvaluation360Done(evaldone);
	}
}

