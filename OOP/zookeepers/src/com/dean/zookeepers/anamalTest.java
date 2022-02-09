package com.dean.zookeepers;

public class anamalTest {

	
	public static void main(String[] args) {

		System.out.println("--------------Zookeeper part 1 Test Requirments ---START");
		Gorilla animal1 = new Gorilla("Bob");
		
		int i = 3;
		while(i>0) {
			i--;
			animal1.throwSomething();
		}
	
		i=2;
		while(i>0) {
			i--;
			animal1.eatBannanas();
		}
	
		animal1.climb();
	
		System.out.println("--------------Zookeeper part 1 Test Requirments ---END");
		System.out.println("--------------Zookeeper part 2 Test Requirments ---START");
		Bat animal2 = new Bat("Bat Fred");
		i = 3;
		while(i>0) {
			i--;
			animal2.attackTown();
		}
	
		i=2;
		while(i>0) {
			i--;
			animal2.eatHumans();
			animal2.fly();
		}
	

		//FYI this assignment did not ask for error check on negative energy values... so we have allowed it. 
		
		
		System.out.println("--------------Zookeeper part 2 Test Requirments ---END");
	
	}
}
