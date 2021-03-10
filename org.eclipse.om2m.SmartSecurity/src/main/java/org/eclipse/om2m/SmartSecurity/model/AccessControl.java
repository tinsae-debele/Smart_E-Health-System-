package org.eclipse.om2m.SmartSecurity.model;

public class AccessControl {
	
    private String username;
    private String role;
	public AccessControl(String username,String role) {
		
		this.role = role;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public String getRole() {
		return role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setRole(String role) {
		this.role = role;
	}
}