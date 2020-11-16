package Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import Enumerates.Role;
@ManagedBean(name="data")
public class data implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public Role[] getRoles() {
	return Role.values();}
}
