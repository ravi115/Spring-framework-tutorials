package com.jersey.spring.jdbc.server.resource;

public class MainApp {


	public static void main(String[] args) {
		
		new UserResources().getAddress(1);
	}
}
