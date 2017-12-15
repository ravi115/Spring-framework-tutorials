package com.spring.aop.pojo;

public class Consumers {

	private String name;
	private String level;
	
	
	
	public Consumers(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", level=" + level + "]";
	}
	
	
	
}
