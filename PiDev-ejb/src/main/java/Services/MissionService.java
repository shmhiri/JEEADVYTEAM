package Services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.rowset.spi.TransactionalWriter;

import Entities.*;
import Enumerates.SkillType;

import interfaces.MissionServiceLocal;
import interfaces.MissionServiceRemote;

@LocalBean
@Stateless
public class MissionService implements MissionServiceRemote,MissionServiceLocal {


	@PersistenceContext(unitName= "PiDev-ejb")


	EntityManager em; 
	@Override
	public void createMission(Mission m) {
		// TODO Auto-generated method stub
		em.persist(m);

	}
	
	public boolean getref(int refrence) {
		Mission mission = em.find(Mission.class, refrence); 
		//mission.setRefrence(refrence);
		if (mission != null) {
			return true;
			
		}
		
		return false;
		
		    }

	public void updateetat(Mission m) {
	
		Mission mission = em.find(Mission.class, m.getRefrence()); 
		mission.setEtat(m.getEtat());  
		    }
		
	public void minesParticipation(Mission m) {
		
		
		
		
		//if(mission.getPressed().equals(false)) {
		

		Mission mission = em.find(Mission.class, m.getRefrence()); 
		mission.setPressed(false);
		mission.setNotpressed(true);
		mission.setParticipantsNumber(m.getParticipantsNumber()-1);
			
			//mission.setPressed(true);
		//}
		//mission= em.createQuery("SELECT a FROM mission a JOIN FETCH a.users WHERE a.id = 1", Mission.class).getSingleResult();
	//	mission.setParticipantsNumber(m.getParticipantsNumber());

		    }
		
		
	public void addParticipation(Mission m) {
		
		
		
		
		//if(mission.getPressed().equals(false)) {
		

		Mission mission = em.find(Mission.class, m.getRefrence()); 
		mission.setPressed(true);
		mission.setNotpressed(false);
		mission.setParticipantsNumber(m.getParticipantsNumber()+1);
			
			//mission.setPressed(true);
		//}
		//mission= em.createQuery("SELECT a FROM mission a JOIN FETCH a.users WHERE a.id = 1", Mission.class).getSingleResult();
	//	mission.setParticipantsNumber(m.getParticipantsNumber());

		    }
		
		
	public void updateMissionl(Mission m,int id) {
		// TODO Auto-generated method stub
		Mission mission = em.find(Mission.class, id); 
		mission.setSubject(m.getSubject()); 
		mission.setDescription(m.getDescription());
		mission.setIsProvidedAccd(m.getIsProvidedAccd());
		mission.setIsProvidedTrsp(m.getIsProvidedTrsp());
		mission.setSkillsRequired(m.getSkillsRequired());
		mission.setSecondSkill(m.getSecondSkill());
		mission.setThirdSkill(m.getThirdSkill());
		mission.setDatedebut(m.getDatedebut());
		mission.setDatefin(m.getDatefin());
		mission.setEstimation(m.getEstimation());
		mission.setPlace(m.getPlace());
		
	}
	
	
	
	@Override
	public void updateMission(Mission m) {
		// TODO Auto-generated method stub
		Mission mission = em.find(Mission.class, m.getRefrence()); 
		mission.setSubject(m.getSubject()); 
		mission.setDescription(m.getDescription());
		mission.setIsProvidedAccd(m.getIsProvidedAccd());
		mission.setIsProvidedTrsp(m.getIsProvidedTrsp());
		mission.setSkillsRequired(m.getSkillsRequired());
		mission.setSecondSkill(m.getSecondSkill());
		mission.setThirdSkill(m.getThirdSkill());
		mission.setDatedebut(m.getDatedebut());
		mission.setDatefin(m.getDatefin());
		mission.setEstimation(m.getEstimation());
		mission.setPlace(m.getPlace());
		
	}

	@Override
	public void removeMission(int id) {
		// TODO Auto-generated method stub
		Mission ms = em.find(Mission.class, id);
		em.remove(ms); 

	}
	
	
	

	
	public Mission ShowClaimDetails (int id) {
			// TODO Auto-generated method stub
			 Mission m = em.find(Mission.class, id);
			 return m;
		
			}

	public List<Mission> displayMissionplace(String place) {
		 
		TypedQuery<Mission> query =
				em.createQuery("select m FROM Mission m WHERE m.place=:place",
						Mission.class);
				query.setParameter("place",place);
				List<Mission> missions = null;
				try { missions = query.getResultList(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return missions;

	}
	public List<Mission> displayMissiondescrip(String description) {
		 
		TypedQuery<Mission> query =
				em.createQuery("select m FROM Mission m WHERE m.description=:description",
						Mission.class);
				query.setParameter("description",description);
				List<Mission> missions = null;
				try { missions = query.getResultList(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return missions;

	}
	public List<Mission> displayMissionsubject(String subject) {
		 
		TypedQuery<Mission> query =
				em.createQuery("select m FROM Mission m WHERE m.subject=:subject",
						Mission.class);
				query.setParameter("subject",subject);
				List<Mission> missions = null;
				try { missions = query.getResultList(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return missions;

	}
	
	public List<Mission> displayselectedMissions(SkillType skillsRequired) {
		 
		TypedQuery<Mission> query =
				em.createQuery("select m FROM Mission m WHERE m.skillsRequired=:skillsRequired",
						Mission.class);
				query.setParameter("skillsRequired",skillsRequired);
				List<Mission> missions = null;
				try { missions = query.getResultList(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return missions;

	}
	
	@Override
	public List<Mission> displayMissions() {
		List<Mission> missions = em.createQuery("select m from Mission m", Mission.class).getResultList();
		return missions; 
	}

	@Override
	public List<Mission> filtreMissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void askForParticipation(Mission m,User e) {
		// TODO Auto-generated method stub
		
		

	}

	@Override
	public void approveParticipants() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateState() {
		// TODO Auto-generated method stub

	}

	@Override
	public double missionFreqPerEmployee() {
		// TODO Auto-generated method stub
		return 0;
	}

}
