package Entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Enumerates.SkillType;


@Entity
public class UserSkills extends User{
	
	@Enumerated(EnumType.STRING)
	 private SkillType skillsRequired;
	@Enumerated(EnumType.STRING)
	 private SkillType secondSkill;
	@Enumerated(EnumType.STRING)
	 private SkillType thirdSkill;
	public SkillType getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(SkillType skillsRequired) {
		this.skillsRequired = skillsRequired;
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
	public UserSkills(SkillType skillsRequired, SkillType secondSkill, SkillType thirdSkill) {
		super();
		this.skillsRequired = skillsRequired;
		this.secondSkill = secondSkill;
		this.thirdSkill = thirdSkill;
	}


}
