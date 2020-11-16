package Bean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Enumerates.SkillType;


@ManagedBean(name = "skilll") 
@ApplicationScoped
public class Skill implements Serializable{
	private static final long serialVersionUID = 1L;
	public SkillType[] getSkillTypes() { return SkillType.values(); }
	
	
	

}
