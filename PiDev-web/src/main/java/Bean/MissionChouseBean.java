package Bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Mission;
import Enumerates.SkillType;
import Services.MissionService;

@ManagedBean(name="missionchouseBean")
@SessionScoped
public class MissionChouseBean {
	
	
	private SkillType skill ;
	private SkillType secondSkill;
	 private SkillType thirdSkill;
	public SkillType getSkill() {
		return skill;
	}
	public void setSkill(SkillType skill) {
		this.skill = skill;
	}
	public SkillType getSecondSkill() {
		return secondSkill;
	}
	public void setSecondSkill(SkillType secondSkill) {
		this.secondSkill = secondSkill;
	}
	public SkillType getThirdSkill() {
		return thirdSkill;
	}
	public void setThirdSkill(SkillType thirdSkill) {
		this.thirdSkill = thirdSkill;
	}
	@EJB
	MissionService ms;
	
	private List<Mission> missions;
	
	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public String goToDisplayMissions() { 
		
		
		String navigateTo = "null"; 
		missions=ms.displayselectedMissions(this.skill);
		
			navigateTo = "/Pages/employer/missionList4.jsf?faces-redirect=true"; 
			return navigateTo; 
	} 
}
