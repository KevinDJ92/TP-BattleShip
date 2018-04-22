package enumeration;


//Met la valeur afficher de l'enumeration
//public enum TypeOfBoat {
//	PATROL_BOAT, DESTROYER, SUBMARINE, BATTLESHIP
//}

// Pour Choisir la valeur afficher de l'enumeration
public enum TypeOfBoat {
	PATROL_BOAT("Patrol Boat"), DESTROYER("Destroyer"), SUBMARINE("Submarine"), BATTLESHIP("Battleship"), AIRCRAFT_CARRIER("Aircraft Carrier");
	
	private String boatName; 
	
	private TypeOfBoat(String boatName) { 
	    this.boatName = boatName; 
	} 

	@Override 
	public String toString(){ 
	    return boatName; 
	} 
}




