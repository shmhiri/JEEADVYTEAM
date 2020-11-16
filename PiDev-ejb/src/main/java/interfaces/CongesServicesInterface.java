package interfaces;

import Entities.*;
import java.util.List;

import javax.ejb.Remote;



@Remote
public interface CongesServicesInterface {
	
	public void demande(Conges conges);
	public void validation(int id);
	public List<Conges> AllCongés();

	
	

}
