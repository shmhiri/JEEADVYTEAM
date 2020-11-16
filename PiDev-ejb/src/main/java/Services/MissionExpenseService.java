package Services;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfaces.MissionExpensesServiceLocal;
import interfaces.MissionExpensesServiceRemote;


@Stateless
public class MissionExpenseService implements MissionExpensesServiceRemote,MissionExpensesServiceLocal {

	@PersistenceContext(unitName= "PiDev-ejb")

	EntityManager em; 
	@Override
	public double calculateMissionTotalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void archiveMission() {
		// TODO Auto-generated method stub

	}

	@Override
	public double calculateAverageExpenseNoteCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
