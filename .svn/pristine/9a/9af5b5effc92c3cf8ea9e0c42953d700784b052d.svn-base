package main;

import controller.GameController;
import views.MenuWindow;

public class Start {

	public static void main(String[] args) {

		MenuWindow menu = new MenuWindow();
		
		while(!menu.isStart()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		GameController BattleShip = new GameController(menu.getUsername(), menu.getNiveau(), menu.getTypeDeJeu(), menu.getAdrIP());
	}
}
