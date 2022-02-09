package com.dean.zookeepers;

public class Mammal {
	
		
		//member variables 
		protected int energyLevel;
		
		
		//constructors 
			public Mammal() {
				this.energyLevel=100;
			}
			

		// Methods
		public int getEnergyLevel() {			
				return energyLevel;
			}		

		protected void setEnergyLevel(int energyLevel) {
			this.energyLevel = energyLevel;
		}

		public int displayEnergy() {
			System.out.println("Energy Level: "+energyLevel);
			return energyLevel;
		}
		

		
		
		
		
	
}
