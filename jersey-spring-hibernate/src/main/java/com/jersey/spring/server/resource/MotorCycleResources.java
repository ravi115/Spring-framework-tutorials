package com.jersey.spring.server.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.spring.server.model.Motor;
import com.jersey.spring.server.repository.UserRepository;

@Path("/rest")
public class MotorCycleResources {

	@Autowired
	UserRepository userRepository;
	
	@GET
	@Path("/v1/motorbikes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMotorCycle() {
		System.out.println("...............called................");
		
		List<Motor> motorBkies = userRepository.getAllMotorBikes();
		System.out.println(motorBkies);
		return Response.ok().status(200).entity(motorBkies).build();
	}
	
	@GET
	@Path("/v1/motorbikes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMotorCycle(@PathParam("id") int id) {
		System.out.println("...............called................");
		
		Motor motorBkies = userRepository.getMotorCycle(id);
		System.out.println(motorBkies);
		return Response.ok().status(200).entity(motorBkies).build();
	}
	
	
	@POST
	@Path("/v1/motorbikes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Motor motorBikes, @Context UriInfo uriInfo) {
		
		userRepository.save(motorBikes);
		Long id = (long) motorBikes.getId();
		URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.ok().status(200).entity(createdUri).build();	
	}
	
	
	
}
