package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Profile;

public class ProfileService {

	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	
	
	public ProfileService() {
			profiles.put("manav", new Profile(1L, "manav","Manav","Shah"));	
			
	}

	public List<Profile> getAllProfiles()  {
		//return new ArrayList<Profile>(profiles.values());
		return new ArrayList<Profile> (profiles.values());
	}
	
	public Profile getProfile(String profileName)  {
		return profiles.get(profileName);
	}
	
	
	public Profile addProfile(Profile newProfile)  {
		newProfile.setId(profiles.size()+1);
		newProfile.setCreated(new Date());
		profiles.put(newProfile.getProfileName(), newProfile);
		return newProfile;
	}
	
	
	public Profile updateProfile(Profile updatedProfile)  {
		
		if (updatedProfile.getProfileName().isEmpty())  {
			System.out.println("No profiles present in the system");
			return null;
		}
		
		profiles.get(updatedProfile.getProfileName()).getId();
		
		profiles.put(updatedProfile.getProfileName(), updatedProfile);
		return updatedProfile;
	}
	
	
	public void removeProfile(String  profileName)  {
		profiles.remove(profileName);
	}
	
	
 	
}
