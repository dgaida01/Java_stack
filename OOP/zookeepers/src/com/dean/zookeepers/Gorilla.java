package com.dean.zookeepers;

public class Gorilla  extends Mammal{
	
	private String name;
	
	//Gorilla constructor
	public Gorilla() {
		this.name = "ummm...what's its name Gorilla";
	}
	public Gorilla(String name) {
		this.name=name;
	}
	
	//basic get sets for Gorilla specific stuff
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//additional methods

	
	public void throwSomething() {
		System.out.println("Tossing one item");
		this.energyLevel-=5;
		System.out.print(name+"'s ");
		super.displayEnergy();
	}
	
	public void eatBannanas() {
		System.out.println("MMM...Bannana good");
		this.energyLevel+=10;
		System.out.print(name+"'s ");
		super.displayEnergy();
		
	}
	
	public void climb() {
		System.out.println("Look at me Ma - i'm on top of this tree!");
		this.energyLevel-=10;
		System.out.print(name+"'s ");
		super.displayEnergy();
		
	}
	
	
	
	
}
