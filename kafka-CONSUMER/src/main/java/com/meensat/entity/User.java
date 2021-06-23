package com.meensat.entity;

import lombok.Data;

@Data
public class User {
	
	private int id;
	private String name;
	private String[] address;
	
	public User(int id, String name, String[] address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public User() {
		
	}
	
	
}
