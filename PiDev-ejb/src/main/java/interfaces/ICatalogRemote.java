package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Catalog;
import Entities.Formation;

@Remote
public interface ICatalogRemote {
	public String ajouterCatalog(Catalog catalog);
	public void updateCatalog(Catalog catalog);
	public void removeCatalog(int catalogId);

	public List <Catalog> findAllCatalog();
	public List<Formation> getListFormationByCatId(int CatId);
	public void affecterFormationAcatalog(int formationId, int catId);
	public Long nombreformationInCatalog(Catalog selectedCatalog);
}
