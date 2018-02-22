package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Profile;
import org.koushik.javabrains.messenger.service.ProfileService;

@Path ("/profiles")
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles()  {
		return profileService.getAllProfiles();
	}
	
	
	@Path ("/{profileName}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	
	public Profile getProfile(@PathParam("profileName") String profileName)  {
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile newProfile)  {
		return profileService.addProfile(newProfile);
	}
	
	@Path ("/{profileName}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)	
	public Profile update(@PathParam("profileName") String profileName, Profile updatedProfile)  {
		updatedProfile.setProfileName(profileName);
		updatedProfile.setId((profileService.getProfile(profileName).getId()));		
		System.out.println("ID IS: <" +updatedProfile.getId() + ">");
		updatedProfile.setId(updatedProfile.getId());
		return profileService.updateProfile(updatedProfile);
	}
	
	@Path("/{profileName}")
	@DELETE
	@Produces (MediaType.APPLICATION_JSON)
	public void removeProfile(@PathParam("profileName") String profileName)  {
		profileService.removeProfile(profileName);
	}
	

	
	
}
