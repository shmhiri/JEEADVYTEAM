package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.*;
@Remote
public interface MissionServiceRemote {
	void createMission(Mission m);
	void updateMission(Mission m);
	void removeMission(int id);
	List<Mission> displayMissions();
	List<Mission> filtreMissions();
	public void askForParticipation(Mission m,User e);
	void approveParticipants();
	void updateState();
	double missionFreqPerEmployee();
	
}
