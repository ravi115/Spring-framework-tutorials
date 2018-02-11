package com.jersey.spring.jdbc.server.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.spring.jdbc.server.model.User;
import com.jersey.spring.jdbc.server.repository.UserDAO;

@Path("/feeds")
public class UserResources {

	@Autowired
	UserDAO userDAO;
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAddress() {
	
		System.out.println("get invoked for all student....");
		List<User> list = userDAO.listUsers();
		return Response.ok().status(200).entity(list).build();
	}
	
	
	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddress(@PathParam("id") int id) {
		
		System.out.println("get invoked for student...." + id);
		User user = userDAO.getUsers(id);
		return Response.ok().status(200).entity(user).build();
	}
	
	
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add( User user, @Context UriInfo uriInfo) {
		
		System.out.println("post invoked to add a student....");
		
		userDAO.create(user);
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		
		return Response.ok().status(200).entity(uri).build();
	}
	

	@PUT
	@Path("/users/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, User user, @Context UriInfo uriInfo) {
		
		System.out.println("update invoked to update a student....");
		userDAO.update(id, user);
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		
		return Response.ok().status(200).entity(uri).build();
	}
	
	@DELETE
	@Path("/users/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		
		System.out.println("delete invoked for a student....");
		userDAO.delete(id);
		
		return Response.ok().status(200).entity("{\"status\":\"deleted\"}").build();
	}
	
	
}
