package Bean;

import java.io.IOException;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import Entities.*;
import Enumerates.*;
import Services.*;



@ManagedBean(name="missionBean")
@SessionScoped
public class MissionManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String subject;
	private String description;
	private Boolean isProvidedAccd;
	private Boolean isProvidedTrsp;
	private SkillType skill ;
	private int parti;
	private User user;
	
	@EJB
	UserService uservice = new UserService();
	
	private Boolean pressed;
	
	public Boolean getPressed() {
		return pressed;
	}

	public void setPressed(Boolean pressed) {
		this.pressed = pressed;
	}

	private Boolean notpressed;


	public Boolean getNotpressed() {
	return notpressed;
	}
	public void setNotpressed(Boolean notpressed) {
	this.notpressed = notpressed;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String estimation ;
	private String place ;
	
	
	 public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEstimation() {
		return estimation;
	}

	public void setEstimation(String estimation) {
		this.estimation = estimation;
	}

	public int getParti() {
		return parti;
	}

	public void setParti(int parti) {
		this.parti = parti;
	}

	private SkillType secondSkill;
	 private SkillType thirdSkill;
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

/*	
	private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat("yyyy/MM/dd");
	    }
	};
	
	public static int compareDates(Date date1, Date date2) {
	    DateFormat dateFormat = dateFormatThreadLocal.get();
	    return dateFormat.format(date1).compareTo(dateFormat.format(date2));
	}
	
*/

	private Date datedebut;
	private Date datefin;
	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}


	private List<User> participants;
	
	private Set<Mission> missions_parti;


	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	public Set<Mission> getMissions_parti() {
		return missions_parti;
	}

	public void setMissions_parti(Set<Mission> missions_parti) {
		this.missions_parti = missions_parti;
	}

	private int ref;
	private  Etat etat;
	
          
	

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public SkillType getSkill() {
		return skill;
	}

	public void setSkill(SkillType skill) {
		this.skill = skill;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsProvidedAccd() {
		return isProvidedAccd;
	}

	public void setIsProvidedAccd(Boolean isProvidedAccd) {
		this.isProvidedAccd = isProvidedAccd;
	}

	public Boolean getIsProvidedTrsp() {
		return isProvidedTrsp;
	}

	public void setIsProvidedTrsp(Boolean isProvidedTrsp) {
		this.isProvidedTrsp = isProvidedTrsp;
	}

	Date currentDate = new Date();
	
	LocalDateTime today =  LocalDateTime.now();    
	LocalDateTime week = today.plusMinutes(5);      //today.plusDays
	LocalDateTime weeks = today.plusMinutes(15); 

	
	
	
/*	@Schedule(hour = "*", minute = "* /1", persistent = false)
	   public Etat statout(Mission m){
	       
		m.setRefrence(ref);
		
		   if(today.isAfter(week)) 
	        {  ms.updateetat(m);
	          
	          return Etat.Dated;
	         
	        }
			else if(today.isAfter(weeks)) 
	        {ms.updateetat(m);
				return Etat.Old;
				
	        }
	        else 
	        {ms.updateetat(m);
	        	return Etat.Fresh;
	        	
	        }
	    }
	*/
 Mission misssssion ;

	

	
	
	public Mission getMisssssion() {
		return misssssion;
	}

	public void setMisssssion(Mission misssssion) {
		this.misssssion = misssssion;
	}

	@EJB
	MissionService ms = new MissionService();
	
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

	public User findEmp() {
		try {
			Cookie cook = getCookie();
			User emp = uservice.affUser(Integer.parseInt(cook.getValue()));

			return emp;
		} catch (NullPointerException ex) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/Pages/login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public String goToTest() { 
		String navigateTo = "null"; 
	
			navigateTo = "/Pages/TestEntrepreneur.jsf?faces-redirect=true"; 
			return navigateTo; 
		
	} 

	
	public String goToAddMission() { 
		String navigateTo = "/Pages/login.jsf?faces-redirect=true"; 
	if (findEmp().getUserId()==1) {

		navigateTo = "/Pages/admin/addMission.jsf?faces-redirect=true"; 
		return navigateTo; 
	
		
	}
	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("you are not a manager"));
			return navigateTo; 
		
	} 
	/////////////////
	
	//Employee manager = new  Employee(1,"Saddem", Role.Manager);
	//Employee employee = new  Employee(2,"Achraf", Role.Employe);
	public String addMission() { 
		String navigateTo = "null"; 
		
		if (	this.secondSkill.equals(null) && this.thirdSkill.equals(null) ) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad*********************** Credentials"));
			navigateTo = "/Pages/admin/Done.jsf?faces-redirect=true";  
			return navigateTo;
		} 
		
		else if (currentDate.after(datedebut) || 
				datefin.before(datedebut) ||
				this.skill.equals(this.secondSkill) || 
				this.skill.equals(this.thirdSkill) || 
				this.secondSkill.equals(this.thirdSkill) ) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad*********************** Credentials"));
			navigateTo = "/Pages/admin/NotDonne.jsf?faces-redirect=true"; 
			return navigateTo;
		} 
		else {
			Mission m = new Mission(subject, description, isProvidedAccd, isProvidedTrsp, skill,secondSkill,thirdSkill,datedebut,datefin,tryToEsteam(),place) ;
			
			ms.createMission(m);
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Mission Ajoutée!"));
			navigateTo = "/Pages/admin/missionList2.jsf?faces-redirect=true"; 
			return navigateTo;
				
		}
			
		
		
	}
	////////////////////////
	 List<Mission> missions;
	 
	 @PostConstruct
	 public void init() {
		 missions = ms.displayMissions();
	 }
	
	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public String goToDisplayMissions() { 
		
		String navigateTo = "null"; 
		missions=ms.displayMissions();
		
			navigateTo = "/Pages/admin/missionList2.jsf?faces-redirect=true"; 
			return navigateTo; 
	} 
	///////////////////////
	public String deleteMission(int id)
	{
	
		String navigateTo = "null"; 
		ms.removeMission(id);
		missions=ms.displayMissions();
		navigateTo = "/Pages/admin/missionList2.jsf?faces-redirect=true"; 
		return navigateTo; 
	}
	
	public String displayDetails(Mission m)
	{
	
		
		String navigateTo = "null"; 
		
		this.subject= m.getSubject();
		this.description=m.getDescription();
		this.isProvidedAccd=m.getIsProvidedAccd();
		this.isProvidedTrsp=m.getIsProvidedTrsp();
		this.skill = m.getSkillsRequired();
		this.secondSkill=m.getSecondSkill();
		this.thirdSkill=m.getThirdSkill();
		this.ref=m.getRefrence();
		this.datedebut=m.getDatedebut();
		this.datefin=m.getDatefin();
		this.estimation=m.getEstimation();
		this.place=m.getPlace();
		navigateTo = "/Pages/admin/updateMission.xhtml?faces-redirect=true"; 
		return navigateTo; 
	}
	public String updateThisMission() { 
		String navigateTo = "null"; 
		
		if (currentDate.after(datedebut) || datefin.before(datedebut) || skill.equals(secondSkill) || skill.equals(thirdSkill) || secondSkill.equals(thirdSkill)) {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
			navigateTo = "/Pages/admin/Done.jsf?faces-redirect=true";  
			return navigateTo;
		} 
		else {
			Mission m = new Mission(subject, description, isProvidedAccd, isProvidedTrsp, skill,secondSkill,thirdSkill,datedebut,datefin,estimation,place);
			m.setRefrence(ref);
			ms.updateMission(m);
			navigateTo = "/Pages/admin/missionList2.jsf?faces-redirect=true"; 
			return navigateTo; 
			
		}
	
	
	}
	public String consultMissions() { 
	
		String navigateTo = "null"; 
		missions=ms.displayMissions();
		
		navigateTo = "/Pages/employer/missionList2.jsf?faces-redirect=true"; 
		return navigateTo; 
	}
	

	private UserSkills us ;
	
	
	public UserSkills getUS() {
		return us;
	}

	public void setUS(UserSkills us) {
		this.us = us;
	}
	
	
	
	public String changedmymindelama(Mission m) { 
		
		String	navigateTo=null ;
	//if(m.getSkillsRequired().equals(us.getSkillsRequired())||m.getSkillsRequired().equals(us.getSecondSkill())) {
		

	this.subject= m.getSubject();
	this.description=m.getDescription();
	this.isProvidedAccd=m.getIsProvidedAccd();
	this.isProvidedTrsp=m.getIsProvidedTrsp();
	this.skill = m.getSkillsRequired();
	this.secondSkill=m.getSecondSkill();
	this.thirdSkill=m.getThirdSkill();
	this.ref=m.getRefrence();
	this.datedebut=m.getDatedebut();
	this.datefin=m.getDatefin();
	this.parti=m.getParticipantsNumber();
    this.place=m.getPlace();
	this.estimation=m.getEstimation();
	//m.addTag(user);
	m.setRefrence(ref);
	showDo=true;
	showUndo=false;
	this.pressed=m.getPressed();
	this.notpressed=m.getNotpressed();
	ms.minesParticipation(m);
	
		navigateTo = "/Pages/employer/missionList4.xhtml?faces-redirect=true"; 
		return navigateTo; 
	/*}
	
	navigateTo = "/Pages/employer/welcomeEmployee.xhtml?faces-redirect=true"; 
	return navigateTo; */
	}
	
	
	
	
	public String changedmyminde(Mission m) { 
		
		String	navigateTo=null ;
	//if(m.getSkillsRequired().equals(us.getSkillsRequired())||m.getSkillsRequired().equals(us.getSecondSkill())) {
		

	this.subject= m.getSubject();
	this.description=m.getDescription();
	this.isProvidedAccd=m.getIsProvidedAccd();
	this.isProvidedTrsp=m.getIsProvidedTrsp();
	this.skill = m.getSkillsRequired();
	this.secondSkill=m.getSecondSkill();
	this.thirdSkill=m.getThirdSkill();
	this.ref=m.getRefrence();
	this.datedebut=m.getDatedebut();
	this.datefin=m.getDatefin();
	this.parti=m.getParticipantsNumber();
    this.place=m.getPlace();
	this.estimation=m.getEstimation();
	//m.addTag(user);
	m.setRefrence(ref);
	showDo=true;
	showUndo=false;
	this.pressed=m.getPressed();
	this.notpressed=m.getNotpressed();
	ms.minesParticipation(m);
	
		navigateTo = "/Pages/employer/missionList2.xhtml?faces-redirect=true"; 
		return navigateTo; 
	/*}
	
	navigateTo = "/Pages/employer/welcomeEmployee.xhtml?faces-redirect=true"; 
	return navigateTo; */
	}
	
	private boolean showDo=true;
	public boolean isShowDo() {
		return showDo;
	}

	public void setShowDo(boolean showDo) {
		this.showDo = showDo;
	}

	public boolean isShowUndo() {
		return showUndo;
	}

	public void setShowUndo(boolean showUndo) {
		this.showUndo = showUndo;
	}

	private boolean showUndo=false;

	public String askForMissionlama(Mission m) { 
		
		String	navigateTo=null ;
	//if(m.getSkillsRequired().equals(us.getSkillsRequired())||m.getSkillsRequired().equals(us.getSecondSkill())) {
		

	this.subject= m.getSubject();
	this.description=m.getDescription();
	this.isProvidedAccd=m.getIsProvidedAccd();
	this.isProvidedTrsp=m.getIsProvidedTrsp();
	this.skill = m.getSkillsRequired();
	this.secondSkill=m.getSecondSkill();
	this.thirdSkill=m.getThirdSkill();
	this.ref=m.getRefrence();
	this.datedebut=m.getDatedebut();
	this.datefin=m.getDatefin();
	this.parti=m.getParticipantsNumber();
    this.place=m.getPlace();
	this.estimation=m.getEstimation();
	//m.addTag(user);
	m.setRefrence(ref);
	this.pressed=m.getPressed();
	this.notpressed=m.getNotpressed();
	ms.addParticipation(m);
	showDo=false;
	showUndo=true;
		navigateTo = "/Pages/employer/missionList4.xhtml?faces-redirect=true"; 
		return navigateTo; 
	/*}
	
	navigateTo = "/Pages/employer/welcomeEmployee.xhtml?faces-redirect=true"; 
	return navigateTo; */
	}
	
	
	
	
	

	public String askForMission(Mission m) { 
		
		String	navigateTo=null ;
	//if(m.getSkillsRequired().equals(us.getSkillsRequired())||m.getSkillsRequired().equals(us.getSecondSkill())) {
		

	this.subject= m.getSubject();
	this.description=m.getDescription();
	this.isProvidedAccd=m.getIsProvidedAccd();
	this.isProvidedTrsp=m.getIsProvidedTrsp();
	this.skill = m.getSkillsRequired();
	this.secondSkill=m.getSecondSkill();
	this.thirdSkill=m.getThirdSkill();
	this.ref=m.getRefrence();
	this.datedebut=m.getDatedebut();
	this.datefin=m.getDatefin();
	this.parti=m.getParticipantsNumber();
    this.place=m.getPlace();
	this.estimation=m.getEstimation();
	//m.addTag(user);
	m.setRefrence(ref);
	this.pressed=m.getPressed();
	this.notpressed=m.getNotpressed();
	ms.addParticipation(m);
	
	showDo=false;
	showUndo=true;
	
		navigateTo = "/Pages/employer/missionList2.xhtml?faces-redirect=true"; 
		return navigateTo; 
	/*}
	
	navigateTo = "/Pages/employer/welcomeEmployee.xhtml?faces-redirect=true"; 
	return navigateTo; */
	}
	
	public String goBack() { 
		String navigateTo = "null"; 
	
			navigateTo = "/Pages/admin/welcomeManager.jsf?faces-redirect=true"; 
			return navigateTo; 
		
	} 
	
	
	
	public String tryToEsteam() {
		
		if(this.estimation != null) {
			String m;
			m=this.estimation;
			return m;
		}
		
		else	if(this.place.equals("Paris")||this.place.equals("paris")) {
			
			return "2000";
			
		}
		else if(this.place.equals("London")||this.place.equals("london")) {
		
		return "4000";
			
		}
		else	if(this.place.equals("Madrid")||this.place.equals("madrid")) {
		
		return "1750";
		
	}
		else if(this.place.equals("Roma")||this.place.equals("roma")) {
		
		return "2000";
		
	}
		else if(this.place.equals("Stockholm") || this.place.equals("stockholm")) {
		
		return "2500";
		
	}
		else	if(this.place.equals("Lyon") || this.place.equals("lyon") ) {
	
		return "1500";
		
	}
		else	if(this.place.equals("New York")||this.place.equals("new york") ) {
		
	
		return "15000";
		
	}
		else	if(this.place.equals("Montreal")||this.place.equals("montreal")) {
		
		return "10000";
		
	}
		else	if(this.place.equals("Toronto")||this.place.equals("toronto")) {
	
		return "11000";
		
	}
	
		else	if(this.place.equals("Amsterdam") ||this.place.equals("amsterdam") ) {
			
			return "3000";
			
		}
		
	else	if(this.place.equals("Tunis") ||this.place.equals("tunis") ) {
			
			return "3000";
			
		}
		
	else	if(this.place.equals("Sousse") ||this.place.equals("sousse") ) {
		
		return "3000";
		
	}
	else {
		
		return "0000";
	}
		
	}
	
	
}


