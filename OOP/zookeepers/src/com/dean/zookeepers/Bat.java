package com.dean.zookeepers;

public class Bat extends Mammal{
	
	
private String name;
	
	//Gorilla constructor
	public Bat() {
		this.name = "ummm...what's its name Bat";
		super.energyLevel= 300;
	}
	public Bat(String name) {
		this.name=name;
		super.energyLevel= 300;
	}
	
	//basic get sets for Gorilla specific stuff
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fly() {
		System.out.println("flip flap, flap flop, floop, shwoop!");
		this.energyLevel-=50;
		System.out.print(name+"'s ");
		super.displayEnergy();
	}
	
	public void eatHumans() {
		System.out.println("nom nom nom nom ..aaahhh brains");
		this.energyLevel+=25;
		System.out.print(name+"'s ");
		super.displayEnergy();
	}
	
	public void attackTown() {
		System.out.println("Roarrrrr...boom bash bank boink ... aaaaaahhhh!");
		this.energyLevel-=100;
		System.out.print(name+"'s ");
		super.displayEnergy();
	}
	
	
	
	
	
	
}
