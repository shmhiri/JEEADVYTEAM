package interfaces;

import java.util.List;

import Entities.*;

public interface Evaluation360Remote {

	public void addEvaluation360(Evaluation360 eval360);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int EmployeeId);
	public void addEvaluation360Done(Evaluation360Done eval360Done);
	public List<Evaluation360> getAllEvaluation360();
	public List<Evaluation360Done> getAllEvaluation360Done();
	public void DeleteEvaluation360(int Evaluation360Id);
	public Evaluation360Done getEvaluation360Done (int Evaluation360Id);
	public void updateEvaluation360Done (Evaluation360Done eval);
}
