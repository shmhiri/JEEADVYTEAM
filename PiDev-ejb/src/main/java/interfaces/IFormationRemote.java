package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Formation;


@Remote
public interface IFormationRemote {
	public String ajouterFormation(Formation formation);
	public String updateFormation(Formation newformation);
	public void removeFormation(int formationId);

	public List <Formation> findAllFormations();
	public void affecterFormationAcatalog(int formationId, int catId);}
