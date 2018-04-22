package views;

import javax.swing.JPanel;

import controller.GameController;
import gameSevers.Game;
import views.principals.GridPanel;

public class GamePanel extends JPanel {
	
	final static int nbButtons = 100;
	private GridPanel gridPanel;
	
	public GamePanel(Game game, GameController gameController) {
		gridPanel = new GridPanel(nbButtons, 470, 470, game, gameController);
		add(gridPanel);
	}

	public static int getNbbuttons() {
		return nbButtons;
	}

	public GridPanel getGridPanel() {
		return gridPanel;
	}

	public void setGridPanel(GridPanel gridPanel) {
		this.gridPanel = gridPanel;
	}
	
	
}
