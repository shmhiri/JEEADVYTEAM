package Bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.*;

import Services.Evaluation360Service;
import interfaces.Evaluation360Remote;

@Path("evaluation")
@RequestScoped
public class EvaluationResource {
	@Inject
	Evaluation360Service eval;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getEvaluation()
	{
		return Response.ok(eval.getAllEvaluation360()).build();
	}
	
	@GET
	@Path("done")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getEvaluationDone()
	{
		return Response.ok(eval.getAllEvaluation360Done()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddEvaluation(Evaluation360 evaluation)
	{
		eval.addEvaluation360(evaluation);
		return Response.status(Status.ACCEPTED).entity("Added").build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EditEvaluation360DOne(@PathParam("id")int id,Evaluation360Done evaldone)
	{
		evaldone.setId(id);
		eval.updateEvaluation360Done(evaldone);
		return Response.status(Status.ACCEPTED).entity("Updated").build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response DeleteEvaluation(@PathParam("id")int id)
	{
		eval.DeleteEvaluation360(id);
		return Response.status(Status.ACCEPTED).entity("Deleted").build();
	}
	
}
