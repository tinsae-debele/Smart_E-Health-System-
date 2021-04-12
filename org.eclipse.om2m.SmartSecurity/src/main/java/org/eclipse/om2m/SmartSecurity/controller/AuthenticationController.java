package org.eclipse.om2m.SmartSecurity.controller;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.eclipse.om2m.SmartSecurity.model.Authentication;


public class AuthenticationController {
	
	private Authentication auth = new Authentication();

	public boolean checkUser(String username, String userDeatil){
		
		return auth.checkUsername(username , userDeatil);
	}
	public void startup() {}
	public boolean checkPassword(String name,String password , String userDATA) {
		MessageDigest hashAlg;
		try {
			//getting the User details to take out the salt to encrypt and the password to verify.
			Authentication Auth = new Authentication();
			String []originalPass = Auth.getPasswordandSalt(name , userDATA);
			byte [] salt = new byte[64];
			byte [] Password = new byte[32];
			String [] temp = (originalPass[1].substring(1, originalPass[1].length()-1)).split(",");
			String [] temp2 = (originalPass[0].substring(1, originalPass[0].length()-1)).split(",");
			for (int i = 0; i <salt.length;i++) {
				salt[i] =  Byte.parseByte(temp[i].replace(" ", ""));
				if(i % 2 == 0) {Password[i/2] =  Byte.parseByte(temp2[i/2].replace(" ", ""));}
			}
			hashAlg = MessageDigest.getInstance("SHA-256");
			hashAlg.update(salt);
			if(originalPass[0].equals(Arrays.toString(hashAlg.digest(password.getBytes())))) { return true; }

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return false;
	}

    public String setUserNameandRole(String username , String userDetail) {
		return auth.setUserNameandRole(username , userDetail);	
	}
	

}