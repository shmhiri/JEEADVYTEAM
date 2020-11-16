package Bean;

import java.io.Serializable;


import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Embedded;

import Entities.User;
import Enumerates.Role;
import Services.UserService;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Session Bean implementation class UserBean
 */
@SessionScoped
@ManagedBean
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UserService us;
	
	/**
	 * 
	 */
	
	private String nom ;
	private String prenom ;
	private String email ;
	private String password ; 
	private String image ;
	private int userId;
	 public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	private Boolean loggedIn; 

public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


private  Role role ;
@Embedded

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	User u ;
	
	public Cookie getCookie() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;
		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("user")) {
					cookie = userCookies[i];
					return cookie;
				}
			}
		}
		return null;
	}
	
	
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public String DoLogin() {
		if (email.contentEquals("")) {
				FacesContext.getCurrentInstance().addMessage("form:esmlboutton", new FacesMessage("email obligatoire"));

		}
		else {
			if (password.equals("")) {
			FacesContext.getCurrentInstance().addMessage("form:esmlboutton", new FacesMessage("password obligatoire"));

			}
		}
		u  = us.getUserByEmailAndPassword(email, password);
		if  (u==null) 
		 {
			FacesContext.getCurrentInstance().addMessage("form:esmlboutton", new FacesMessage("email ou password incorrect"));
		 }
		
		
		if(u.getRole().equals(role.Manager))
		{
			loggedIn = true;
			Cookie loginCookie = new Cookie("user",u.getUserId()+"");
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		    response.addCookie(loginCookie);
			loginCookie.setMaxAge(30*60);
			return "/tmp/layoutadmin1?faces-redirect=true";
			
		}
	
		else {
			Cookie loginCookie = new Cookie("user",u.getUserId()+"");
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		    response.addCookie(loginCookie);
			loginCookie.setMaxAge(30*60);
			return "/tmp/welcome?faces-redirect=true";
		}
	
	}
	public String ajoutUser()
	{ System.out.println("aaaaaaaaaaaaaaaaaaa");
	 System.out.println(nom + prenom+email+  password+   email+ role);

System.out.println(u);
	us.ajoutUser( new User( nom,  prenom,  email,  password,  image,  role));
return "/Pages/login?faces-redirect=true" ;
		
	}
	public String DoLogout() {
		u =null;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;
		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("user")) {
					cookie = userCookies[i];
					cookie.setMaxAge(0);
				}
			}
		}
		return "/Pages/login?faces-redirect=true" ;
	}
}

