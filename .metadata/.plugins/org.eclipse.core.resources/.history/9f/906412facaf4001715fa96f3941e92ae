package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class DemoResource {

	@GET
	@Path("annotations")
	public String getAnnotationValues(@MatrixParam("matrixParam") String matrixParam, 
									  @HeaderParam("authID") String authID, 
									  @CookieParam("CookieParamKey") String cookie)  {
		return "matrixParam:"+matrixParam + System.lineSeparator() + "authID:" + authID + System.lineSeparator() + "CookieParamKey:" + cookie; 
	}
	
	
	@GET
	@Path("context")
	
	public String getContextParams (@Context UriInfo uriObj, 
									@Context HttpHeaders httpHeaderObj)  {
		
		String value = "UriInfo:" + uriObj.getAbsolutePath().toString() + System.lineSeparator() + "httpHeaderObj:" + httpHeaderObj.getCookies().toString() ;
		
		return value;
	}
	
	
}
