package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="Action")
public class Action {
	
	
	private boolean disabled=true;
	public boolean isDisabled(){ return disabled;}
	public void setDisabled(boolean disabled) { this.disabled = disabled;}
	
	public void able() {
		
		this.disabled=false;
		
	}

	

}
