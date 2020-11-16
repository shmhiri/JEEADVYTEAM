package interfaces;

import javax.ejb.Remote;

@Remote

public interface MissionExpensesServiceRemote {

	double calculateMissionTotalCost();
	void archiveMission();
	double calculateAverageExpenseNoteCost();

}
