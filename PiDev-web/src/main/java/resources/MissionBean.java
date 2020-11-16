package resources;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.FileNotFoundException;
import java.io.IOException;
import Entities.*;
import Services.*;


@Path("mission")
@RequestScoped
public class MissionBean  {
	
	@Inject
	MissionService ms = new MissionService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("serch/{subject}")
	public Response recherche(@PathParam("subject") String subject)throws Exception  
	   
	
	{
		List<Mission> list=ms.displayMissions(); 
		 List<Mission> list1=ms.displayMissionsubject(subject); 
		 List<Mission> list2=ms.displayMissiondescrip(subject); 
			List<Mission> list3=ms.displayMissionplace(subject); 

		
		 if( list2.isEmpty()&&list1.isEmpty()) {
			 
    		
    		return Response.status(Status.ACCEPTED).entity("liste par place \n "+list3).build();
		
			
		}
		 else if(  list2.isEmpty()&&list3.isEmpty()) {
	    		
	    		return Response.status(Status.ACCEPTED).entity("liste par sujet \n "+list1).build();
			
				
			}
		 else if(  list3.isEmpty()&&list1.isEmpty()) {
	    		
	    		return Response.status(Status.ACCEPTED).entity("liste par description \n "+list2).build();
			
				
			}

			return Response.status(Status.ACCEPTED).entity("all \n "+list).build();


	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{refrence}")
	public Response ShowReclamationDetails(@PathParam("refrence")int refrence)
	
	{
			
	
		boolean exist=ms.getref(refrence);
	
		
		System.out.println("******************************************"+exist);
		
	if (exist == false )
		{
			return Response.status(Status.BAD_REQUEST).entity("Veuillez choisir un refrence différent ").build();
	
		
		}
		
		
	return Response.ok(ms.ShowClaimDetails(refrence)).build();
	}
	
	
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMissions() {
		return Response.ok(ms.displayMissions()).build();
	}
    
    @Secured
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addmission(Mission emp)
	{
		 if (emp.getSubject()==null) {
			return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un Subject ").build();
			
		}
		 else if (emp.getDescription()==null) {
			return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un description ").build();
			
		}
		else if (emp.getEstimation()==null) {
			return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un Estimation ").build();
			
		}
	
		else if (emp.getSkillsRequired()==null) {
			return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un Skill ").build();
			
		}
		ms.createMission(emp);
	
		
			return Response.status(Status.CREATED).entity("Registration Successful").build();
		
		
	}
	@Secured 
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{refrence}")
	public Response DeleteReclamation(@PathParam("refrence")int refrence)
	{
	boolean exist=ms.getref(refrence);
if (exist == false)
	{
		return Response.status(Status.BAD_REQUEST).entity("Veuillez choisir un refrence différent ").build();
	}
	
      ms.removeMission(refrence);

	return Response.status(Status.ACCEPTED).entity("deleted").build();
	}

	@Secured 
	@PUT 
	@Path("{refrence}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateReclamationAdmin(@PathParam("refrence")int refrence ,Mission emp)  {
		boolean exist=ms.getref(refrence);
		if (exist == false)
			{
				return Response.status(Status.BAD_REQUEST).entity("Veuillez choisir un refrence différent ").build();
			}
		else if (emp.getSubject()==null) {
				return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un Subject ").build();
				
			}
			 else if (emp.getDescription()==null) {
				return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un description ").build();
				
			}
			else if (emp.getEstimation()==null) {
				return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un Estimation ").build();
				
			}
		
			else if (emp.getSkillsRequired()==null) {
				return Response.status(Status.BAD_REQUEST).entity("Veuillez entre un Skill ").build();
				
			}
		ms.updateMissionl(emp, refrence);
		return Response.status(Status.ACCEPTED).entity("updated:\n :").build();

	}
/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("code/{code}")
	public Response search (@PathParam(value="code") int n)
	{
		
		System.out.println(getMods().size());
		for (Module va : mods) {
			System.out.println("11111");
			if (va.getCoefficient()==n) {
				System.out.println(va.toString());
				return Response.status(Status.CREATED).entity(va).build();
				
				
			}
 
		}
		return Response.status(Status.BAD_REQUEST).build();

	}*/
}

