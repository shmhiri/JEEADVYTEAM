package interfaces;

import javax.ejb.Local;

@Local
public interface MissionExpensesServiceLocal {

	double calculateMissionTotalCost();
	void archiveMission();
	double calculateAverageExpenseNoteCost();
}
