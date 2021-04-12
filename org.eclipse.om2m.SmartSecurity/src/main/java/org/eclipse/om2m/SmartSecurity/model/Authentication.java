package org.eclipse.om2m.SmartSecurity.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

public class Authentication {

	private String username;
	private String role;
	
	public Authentication() {
	}
	
	public String getuserName() {
		return username;
	}
	
	public String getRole() {
		return role;
	}
	
	public String[] getUserDetails(String Username, String Files) {
		String line = "";
		String[] details = new String[5];
		//Retrieves the users details based of the username
		//BufferedReader reader = new BufferedReader(new FileReader("details.txt"));
		line = Files;
		
		//System.out.println(Files);
		while(line != null) {
			details = line.split(":");
			return details;
		}
		//reader.close();
		//System.out.println(details);
		return null;
	}	
	
	public String addInfo(String Username,String password,String role, String contactinfo,String address,String healthCardNumber) {
			
			this.username = Username;
			this.role = role;
			SecureRandom rand = new SecureRandom();
			byte[] salt = new byte[64];
			byte [] Password;
			String Out = "";
			try {
				// Making the salt and putting it in the hash alogrithm SHA-256 Salt is 64 bytes
				MessageDigest hashAlg = MessageDigest.getInstance("SHA-256");
				rand.nextBytes(salt);
				hashAlg.update(salt);
				Password = hashAlg.digest(password.getBytes());
				//making a string of the user details to upload to the server password and authintcaiton files, format is item:item:item
				Out = Username + ":" + Arrays.toString(Password) + ":" + Arrays.toString(salt) + ":" + role+ ":" + contactinfo+ ":" + address+ ":" + healthCardNumber;
				//Writing to the passwd.txt file
			} 
			catch (Exception e1) {
			}
			return Out;
		}
	
	public boolean checkUsername(String username ,String datafile) {
		
		String line = "";
		String details;
		while(line != null) {
			details = line.split(":")[0].replace(" ", "");
			if(details.toLowerCase().equals(username.toLowerCase())) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public String [] getPasswordandSalt(String name , String userDetail) {
		String [] info = this.getUserDetails(name , userDetail);
		String [] values = new String [2];
		values[0] = info[1];
		values[1] = info[2];
		this.username = info[0];
		this.role = info[3];
		return values;
		}

	
	public String setUserNameandRole(String username , String userDetail) {
		this.username = username;
		String [] details = this.getUserDetails(username , userDetail);
		this.role = details[3];
		return this.role;
	}
		
}