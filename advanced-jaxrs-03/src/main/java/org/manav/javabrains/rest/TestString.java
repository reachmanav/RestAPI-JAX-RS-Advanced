package org.manav.javabrains.rest;

import java.util.StringTokenizer;

import org.glassfish.jersey.internal.util.Base64;

public class TestString {

	private static final String AUTHORIZATION_BASIC_TOKEN="Basic ";
	
	public static void main(String[] args) {

		
		String inputString = "Basic dXNlcjpwYXNzd29yZA==";

		String authKey = inputString.replaceAll(AUTHORIZATION_BASIC_TOKEN, "");
		System.out.println("authKey="+authKey);
		
	
		String s = Base64.decodeAsString(authKey);
		
		
		System.out.println("decodedAuthKey="+s);
		
		
		StringTokenizer key = new StringTokenizer(s, ":");
		
		String user = key.nextToken();
		String password = key.nextToken();

		System.out.println("user="+user);
		System.out.println("password="+password);
		
	}

}
