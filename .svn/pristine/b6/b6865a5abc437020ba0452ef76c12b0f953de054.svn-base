package views.principals;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.GameController;
import event.PanelEvent;
import gameSevers.Game;
import listeners.IThreadListener;
import listeners.ListenerGameButton;
import utils.Positionnement;

public class GridPanel extends JPanel implements IThreadListener {

	ArrayList<GameButton> gameButtons;
	Image image;
	private String msgCoord = "bCoord";
	GameController gameController;
	Game game;
	
	public GridPanel(int nbButtons, int xSize, int ySize, Game game, GameController gameController) {
		setLayout(new GridLayout(10,10));
		setPreferredSize(new Dimension(xSize, ySize));
		this.gameController = gameController;
		this.game = game;
		
		gameButtons = new ArrayList<GameButton>();	
		
		try {
			image = ImageIO.read(getClass().getResource("/images/waterbackground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < nbButtons; i++) {
			GameButton gButton = new GameButton();
			gButton.setIndice(i);
			gButton.addActionListener(new ListenerGameButton(game, gameController));	
			
			gameButtons.add(gButton);
		
			add(gButton);
		}
		
		Positionnement.GenerateGrid(gameButtons);
		
	}

	public ArrayList<GameButton> getGameButtons() {
		return gameButtons;
	}

	public void setGameButtons(ArrayList<GameButton> gameButtons) {
		this.gameButtons = gameButtons;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void ilYAUnMessage(PanelEvent e) {
	
	}

	@Override
	public void afficherCoord(PanelEvent e) {
		String msg = e.getMsg();
		
		msg = msg.substring(msgCoord.length());
		
		int coord = Integer.parseInt(msg);
		
		GameButton gameButton1 = game.getGameWindow().getGamePanelAllie().getGridPanel().getGameButtons().get(coord);

		if (gameController.testHitBoatGC(gameController.getJoueur1(), gameButton1)) {

			gameController.getJoueur1().getTabBoat().get(gameController.getWhoIsTouched()).perteVieBoat();
		
			gameController.getJoueur1().perteVieFlotte();

			boolean testHit = true;
			boolean testMortBoat = gameController.getJoueur1().getTabBoat().get(gameController.getWhoIsTouched()).testMortBoat();
			boolean testVictoire = gameController.testMortFlotteGC(gameController.getJoueur1());

			gameController.exploser(gameButton1, "/images/explodeanimation.png");
			if (testVictoire) {
				gameController.setGameOn(false);
			}
			gameController.setTurnOn(true);
			gameController.setWhoIsTouched(-1);
		}

		else {
			gameController.exploser(gameButton1, "/images/sploosh.png");
			gameController.setTurnOn(true);
		}
		System.out.println("isTrue" + gameController.isTurnOn());

	}
}
