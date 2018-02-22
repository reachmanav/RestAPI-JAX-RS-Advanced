package org.manav.javabrains.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test2")
public class MyResource2 {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date testMessage()  {
		return new Date() ;
	}
}
