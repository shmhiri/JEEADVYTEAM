package Bean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Enumerates.MaitriseCompetence;

@ManagedBean(name= "MaitriseBean")
@ApplicationScoped
public class MaitriseBean implements Serializable {
	private static final long serialVersionUID= 1L;
	public MaitriseCompetence[] getMaitrises() {
		return MaitriseCompetence.values();
	}
	
}
