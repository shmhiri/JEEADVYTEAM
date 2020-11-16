package interfaces;

import Entities.*;

import java.util.List;


import javax.ejb.Remote;
@Remote
public interface ProjectServicesInterface {
    
	public long ajouterProject(Project project);
	public List<Project> getAllProject();
	public void deleteProjectById(int  ProjectId);
	public void updateProject(Project Project);

}