package Services;

import java.util.List;

import javax.ejb.Remote;

import Entities.Employe;

@Remote
public interface EmlpoyeServiceRemote {


	List<Employe> employes();

	Employe getEmployeByNom(String nom);

	Employe getEmployeById(int id);

}
