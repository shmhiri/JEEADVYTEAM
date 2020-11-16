package interfaces;

import javax.ejb.Remote;

import Entities.FicheCompetence;

@Remote
public interface ICompetenceRemote {
	public String ajouterFiche(FicheCompetence fiche);
	public String updateFiche(FicheCompetence fiche);
	public FicheCompetence getFicheByIdUser(int id);
	public void removeFiche(int id);
}
