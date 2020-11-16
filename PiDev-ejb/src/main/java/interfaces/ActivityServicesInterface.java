package interfaces;

import Entities.*;

import java.util.ArrayList;

import javax.ejb.Remote;
@Remote
public interface ActivityServicesInterface {

	
	public void ajouterActivity(Activity activity);
	public ArrayList<Activity> getAllActivity();
	public void deleteActivityById(int  ActivitytId);
	public void updateAcitivity(Activity Activity);
	public void validerActivity(int id);
}
