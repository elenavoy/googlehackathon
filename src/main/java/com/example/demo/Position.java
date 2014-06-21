package com.example.demo;

public class Position{
	public final String name;
	public String description;
	public boolean taken = false;

	public Position(String name, String description){
		this.name = name;
		this.description = description;
	}

	public void taken(){
		setTaken(true);
	}

	public void setTaken(boolean taken){
		this.taken = taken;
	}

	public boolean isTaken(){
		return taken;
	}

	public boolean isAvailable(){
		return !taken;
	}
}