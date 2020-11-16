package Bean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Entities.Entrepreneur;
import Services.DiagnosticService;



@ManagedBean(name = "EntrepreneurTestBean")
public class EntrepreneurTest {
	int age;
	String sex;
	float income;
	String childreen, car, married, mortgage;
	
	@EJB
	DiagnosticService ds = new DiagnosticService();
	
	
	public void checkStatu() throws IOException{
		Entrepreneur e = new Entrepreneur();
		e.setAge(age);
		e.setIncome(income);
		if(childreen.equals("YES")){
			e.setChildreen(true);
		}
		else {
			e.setChildreen(false);
		}
		
		if(car.equals("YES")){
			e.setCar(true);
		}
		else {
			e.setCar(false);
		}
		
		if(mortgage.equals("YES")){
			e.setMortgage(true);
		}
		else {
			e.setMortgage(false);
		}
		
		if(married.equals("YES")){
			e.setMarried(true);
		}
		else {
			e.setMarried(false);
		}
		e.setSex(sex);
		String res = ds.diagnostic(e);
		if(res.equals("YES")){
			FacesContext.getCurrentInstance().getExternalContext().redirect("/PiDev-web/Pages/Entrepreneur.jsf");
			//return "/xhtml/Entrepreneur?faces-redirect=true";
		}else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/PiDev-web/Pages/NonEntrepreneur.jsf");
			//return "/xhtml/NonEntrepreneur?faces-redirect=true" ;
		}
		
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public float getIncome() {
		return income;
	}


	public void setIncome(float income) {
		this.income = income;
	}


	public String getChildreen() {
		return childreen;
	}


	public void setChildreen(String childreen) {
		this.childreen = childreen;
	}


	public String getCar() {
		return car;
	}


	public void setCar(String car) {
		this.car = car;
	}


	public String getMarried() {
		return married;
	}


	public void setMarried(String married) {
		this.married = married;
	}


	public String getMortgage() {
		return mortgage;
	}


	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}


	public DiagnosticService getDs() {
		return ds;
	}


	public void setDs(DiagnosticService ds) {
		this.ds = ds;
	}
	
	
	
}
