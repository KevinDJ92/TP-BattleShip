package models;

import java.util.ArrayList;

import enumeration.TypeOfBoat;

public class Boat {
	private final int NB_CASE_AIRCRAFT_CARRIER = 5;
	private final int NB_CASE_BATTLESHIP = 4;
	private final int NB_CASE_DESTROYER = 3;
	private final int NB_CASE_SUBMARINE = 3;
	private final int NB_CASE_PATROL_BOAT = 2;

	private TypeOfBoat typeOfBoat;
	private int nbCaseBoat;
	private ArrayList<Integer> tabIndiceBoat;
	private int vieBoat;
	private boolean mortBoat;
	private boolean isVertical;


	public Boat(TypeOfBoat typeOfBoat) {
		this.typeOfBoat = typeOfBoat;

		switch (typeOfBoat) {

		case AIRCRAFT_CARRIER:
			nbCaseBoat = NB_CASE_AIRCRAFT_CARRIER;
			vieBoat = nbCaseBoat;
			break;
		case BATTLESHIP:
			nbCaseBoat = NB_CASE_BATTLESHIP;
			vieBoat = nbCaseBoat;
			break;
		case DESTROYER:
			nbCaseBoat = NB_CASE_DESTROYER;
			vieBoat = nbCaseBoat;
			break;
		case SUBMARINE:
			nbCaseBoat = NB_CASE_SUBMARINE;
			vieBoat = nbCaseBoat;
			break;
		case PATROL_BOAT:
			nbCaseBoat = NB_CASE_PATROL_BOAT;
			vieBoat = nbCaseBoat;
			break;
		}
		
		mortBoat = false;

		tabIndiceBoat = new ArrayList<Integer>();

		for (int i = 0; i < this.nbCaseBoat; i++) {
			tabIndiceBoat.add(-1);
		}
	}

	// Getters
	
	public TypeOfBoat getTypeOfBoat() {
		return typeOfBoat;
	}

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public int getNbCaseBoat() {
		return nbCaseBoat;
	}

	public void setNbCaseBoat(int nbCaseBoat) {
		this.nbCaseBoat = nbCaseBoat;
	}

	public ArrayList<Integer> getTabIndiceBoat() {
		return tabIndiceBoat;
	}

	public void setTabIndiceBoat(ArrayList<Integer> tabIndiceBoat) {
		this.tabIndiceBoat = tabIndiceBoat;
	}


	public boolean isMortBoat() {
		return mortBoat;
	}

	public void setMortBoat(boolean mortBoat) {
		this.mortBoat = mortBoat;
	}

	public int getVieBoat() {
		return vieBoat;
	}

	public void setVieBoat(int vieBoat) {
		this.vieBoat = vieBoat;
	}
	
	public void perteVieBoat() {
		if (this.vieBoat > 0) {
		this.vieBoat-= 1;
		}
	}
	
	public boolean testMortBoat(){
		if (this.getVieBoat() == 0) {
			return true;
		}
		return false;
	}
	
	
}
