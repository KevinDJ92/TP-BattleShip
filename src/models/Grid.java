package models;

import java.util.ArrayList;

import views.principals.GameButton;

public class Grid {
	
	ArrayList<GameButton> gridArrayButtons;

	public Grid(ArrayList<GameButton> gridArrayButtons) {
		super();
		this.gridArrayButtons = gridArrayButtons;
	}

	public ArrayList<GameButton> getGridArrayButtons() {
		return gridArrayButtons;
	}

	public void setGridArrayButtons(ArrayList<GameButton> gridArrayButtons) {
		this.gridArrayButtons = gridArrayButtons;
	}

}
