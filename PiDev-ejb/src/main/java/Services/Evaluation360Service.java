package Services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.*;
import interfaces.*;



@Stateless
@LocalBean
public class Evaluation360Service implements Evaluation360Remote {

	@PersistenceContext(unitName= "PiDev-ejb")
	EntityManager em;


	@Override
	public void addEvaluation360(Evaluation360 eval360) {
		em.persist(eval360);
		
	}


	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> EmployeeList=em.createQuery("SELECT e FROM Employee e",Employee.class).getResultList();
		return EmployeeList;
	}


	@Override
	public Employee getEmployee(int EmployeeId) {
		Employee emp=em.find(Employee.class, EmployeeId);
		return emp;
	}


	@Override
	public void addEvaluation360Done(Evaluation360Done eval360Done) {
		em.persist(eval360Done);
		
	}


	@Override
	public List<Evaluation360> getAllEvaluation360() {
		List<Evaluation360> Evaluation360List=em.createQuery("SELECT ev FROM Evaluation360 ev",Evaluation360.class).getResultList();
		return Evaluation360List;
	}
	


	@Override
	public void DeleteEvaluation360(int Evaluation360Id) {
		Evaluation360 tmp=new Evaluation360();
		Query test=em.createQuery("DELETE FROM Evaluation360Done ev WHERE ev.Evaluation360= :Evaluation360Id");
		tmp.setId(Evaluation360Id);
		test.setParameter("Evaluation360Id",tmp);
		test.executeUpdate();
	
		em.remove(em.find(Evaluation360.class, Evaluation360Id));
	}	
	
	@Override
	public Evaluation360Done getEvaluation360Done (int Evaluation360Id)
	{
		Evaluation360 tmp=new Evaluation360();
		Query ev=em.createQuery("SELECT evd FROM Evaluation360Done evd WHERE evd.Evaluation360= :Evaluation360Id");
		tmp.setId(Evaluation360Id);
		ev.setParameter("Evaluation360Id",tmp);
		Evaluation360Done d=new Evaluation360Done();
		d=(Evaluation360Done) ev.getSingleResult();
		return d;
	}


	@Override
	public void updateEvaluation360Done(Evaluation360Done eval) {
		Evaluation360Done evd=em.find(Evaluation360Done.class, eval.getId());
		evd.setImprovements(eval.getImprovements());
		evd.setQualities(eval.getQualities());
		evd.setScore(eval.getScore());
		
	}


	@Override
	public List<Evaluation360Done> getAllEvaluation360Done() {
		List<Evaluation360Done> Evaluation360DoneList=em.createQuery("SELECT ev FROM Evaluation360Done ev",Evaluation360Done.class).getResultList();
		return Evaluation360DoneList;
	}
}
