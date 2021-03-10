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
	
	public String[] getUserDetails(String Username) {
		String line = "";
		String[] details = new String[5];
		try {
			//Retrieves the users details based of the username
			BufferedReader reader = new BufferedReader(new FileReader("details.txt"));
			line = reader.readLine();
			while(line != null) {
				details = line.split(":");
				if(details[0].equals(Username)) {
					reader.close();
					return details;
				}
				line = reader.readLine();
			}
			reader.close();
		}catch(IOException e) {e.printStackTrace();}
	
		return null;
	}	
	
	public void addInfo(String Username,String password,String role, String contactinfo,String address,String healthCardNumber,String medicaliinfo) {
			
			this.username = Username;
			this.role = role;
			SecureRandom rand = new SecureRandom();
			byte[] salt = new byte[64];
			byte [] Password;
			BufferedWriter br = null;
			FileWriter fr = null;
			String Out;
			try {
				// Making the salt and putting it in the hash alogrithm SHA-256 Salt is 64 bytes
				MessageDigest hashAlg = MessageDigest.getInstance("SHA-256");
				rand.nextBytes(salt);
				hashAlg.update(salt);
				Password = hashAlg.digest(password.getBytes());
				//making a string of the user details to upload to the txt file, format is item:item:item
				Out = Username + ":" + Arrays.toString(Password) + ":" + Arrays.toString(salt) + ":" + role+ ":" + contactinfo+ ":" + address+ ":" + healthCardNumber+ ":" + medicaliinfo;
				//Writing to the passwd.txt file
				fr = new FileWriter("details.txt",true);
				br = new BufferedWriter(fr);
				br.write(Out);
				br.newLine();
				br.close();
				fr.close();
			} 
			catch (Exception e1) {
			}
		}
	
	public boolean checkUsername(String username) {
		
		String line = "";
		String details;
		try {
			//getting the username of each user from the file one by one
			BufferedReader reader = new BufferedReader(new FileReader("details.txt"));
			line = reader.readLine();
			while(line != null) {
				details = line.split(":")[0].replace(" ", "");
				if(details.toLowerCase().equals(username.toLowerCase())) {
					reader.close();
					return false;
				}
				line = reader.readLine();
			}
			reader.close();
		}catch(IOException e) {e.printStackTrace();}
		
		return true;
	}
	
	public String [] getPasswordandSalt(String name) {
		String [] info = this.getUserDetails(name);
		String [] values = new String [2];
		values[0] = info[1];
		values[1] = info[2];
		this.username = info[0];
		this.role = info[3];
		return values;
		}

	
	public String setUserNameandRole(String username) {
		this.username = username;
		String [] details = this.getUserDetails(username);
		this.role = details[3];
		return this.role;
	}
		
}