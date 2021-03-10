package org.eclipse.om2m.SmartSecurity.controller;

public class LinkedList {
	Node head; // head 
	String listname;
	String [] Actions = {"seek","get","modify"};
	// the node class I will need for the solution
	static class Node { 

		String name;
		int number; 
		Node next;

		Node(String n,int d) 
		{ 
			name = n;
			number = d; 
			next = null; 
		} 
	}
	
	// Initializes the LinkedList into the sets I need exactly
	public LinkedList(String list,String [] name,String codes) {
		this.listname = list;
		for(int i = 0; i < name.length; i++) {
			int a = Character.getNumericValue(codes.charAt(i));
			if(a != 4) {
				this.insert(name[i], a);
			}
		}
	}
	
	// inserts a new node into the list
	public void insert(String name, int number) { 
		Node new_node = new Node(name,number); 
		new_node.next = null; 

		if (head == null) { 
			head = new_node; 
		} 
		else { 
			Node last = head; 
			while (last.next != null) { 
				last = last.next; 
			} 
			last.next = new_node; 
		} 

	} 
	
	//grants access to the user if the request is with the limit of the access of said title
	public boolean GrantAccess (String name, String access){
		System.out.println("Checking Access to "+ listname +" for a " + name + " wanting to " + access );
		for(int i = 0; i < Actions.length;i++){
			if(Actions[i].toLowerCase().contentEquals(access.toLowerCase())) {
				int a = this.GetAccess(name); 
				if(a >= i ) {
					return true;
				}
			}
		}
			return false;
	}
	
	//gets the access level of the given title
	private int GetAccess(String name){
		Node currNode = this.head; 
		while (currNode != null) { 
			if(currNode.name.equals(name)){
				return currNode.number;}
			currNode = currNode.next; 
		}  
		return -1;
	}


	public String getAccessName (String name) {
		int temp = this.GetAccess(name);
		if(temp != -1) {
		return Actions[temp];}
		else return null;
		
	}
}

