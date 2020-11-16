package Services;

import java.util.List;

import Entities.Conge;

public interface CongeServiceRemote {

	List<Conge> conges();

	Conge getCongeByNom(String nom);

	int ajoutConge(Conge c);

	void modifConge(Conge c);

	List<Conge> affiAllConge();

	Conge getCongeByIdEmploye(int ide);

}
