package org.manav.javabrains.rest;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER="Authorization";
	private static final String AUTHORIZATION_BASIC_TOKEN="Basic ";
	private static final String URL_PREFIX_SECURED="secured";
	
	
	@Override
	public void filter(ContainerRequestContext requestcontext) throws IOException {
		
		List<String> authKeyList = requestcontext.getHeaders().get(AUTHORIZATION_HEADER);
		
		
		if (requestcontext.getUriInfo().getAbsolutePath().getPath().contains(URL_PREFIX_SECURED))
		{
		if (authKeyList.size() > 0 )  {			
				String authKey = authKeyList.get(0);
				authKey = authKey.replaceAll(AUTHORIZATION_BASIC_TOKEN, "");		
				byte[] decodedAuthKeyByteArray = Base64.getDecoder().decode(authKey);
				String decodedAuthKey = new String(decodedAuthKeyByteArray);		
				StringTokenizer key = new StringTokenizer(decodedAuthKey, ":");		
				String user = key.nextToken();
				String password = key.nextToken();		
				if ("user".equals(user) && "password".equals(password))  {
					return;
				}		
		}
				
		Response response = Response.status(Status.UNAUTHORIZED)
									.entity("Unauthorized access")
									.build();
		
		
		requestcontext.abortWith(response);
	
		}
	
	}

}
