package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import enumeration.AIStrategy;
import enumeration.TypeDeJeu;
import gameSevers.Game;
import gameSevers.GameClient;
import gameSevers.GameSansServer;
import gameSevers.GameServer;
import listeners.resetListener;
import models.Joueur;
import utils.AI;
import views.GameWindow;
import views.principals.GameButton;

public class GameController {

	private Joueur joueur1;
	private AI joueurAI;
	private AIStrategy strategy;
	private TypeDeJeu typeDeJeu;
	private int attaque;
	private boolean turnOn;
	private boolean gameOn;
	private int whoIsTouched;
	private String username;
	private String adrIP;
	private Game game;
	private boolean isServerActive = false;
	private boolean isServer = false;
	
	public GameController() {
		initGame();
	}

	public GameController(String username, AIStrategy strategy, TypeDeJeu typeDeJeu, String adrIP) {
		this.adrIP = adrIP;
		this.username = username;
		this.strategy = strategy;
		this.typeDeJeu = typeDeJeu;
		
		initGame();
	}

	public void StartGame() {
		
		joueurAI.leVraiGenerererBateauAleatoire();
		joueur1.leVraiGenerererBateauAleatoire();
		joueur1.afficherFlotte(game.getGameWindow().getGamePanelAllie());

		while (gameOn && !game.getGameWindow().getReset().isBntIsPressed()) {

			while (turnOn && gameOn && !game.getGameWindow().getReset().isBntIsPressed()) {

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				for (int i = 0; i < 100; i++) {

					if (game.getGameWindow().getGamePanel().getGridPanel().getGameButtons().get(i).isBntIsPressed() == true) {

						GameButton gameButton = game.getGameWindow().getGamePanel().getGridPanel().getGameButtons().get(i);
						game.getGameWindow().getGamePanel().getGridPanel().getGameButtons().get(i).setBntIsPressed(false);

						if (this.testHitBoatGC(joueurAI, gameButton)) {

							joueurAI.getTabBoat().get(whoIsTouched).perteVieBoat();
							System.out.println(joueurAI.getTabBoat().get(whoIsTouched).getVieBoat());
							joueurAI.perteVieFlotte();

							boolean testHit = true;
							boolean testMortBoat = joueurAI.getTabBoat().get(whoIsTouched).testMortBoat();
							boolean testVictoire = this.testMortFlotteGC(joueurAI);

							this.setMessageTouched(joueurAI, joueur1, gameButton, testHit, testMortBoat, testVictoire);

							exploser(gameButton, "/images/explodeanimation.png");
							if (testVictoire) {
								gameOn = false;
								afficherVictoire(joueur1);
							}
							turnOn = false;
							this.whoIsTouched = -1;
						}

						else {

							this.setMessageMiss(joueurAI, joueur1, gameButton);
							exploser(gameButton, "/images/sploosh.png");
							turnOn = false;
						}
					}
				}
			}
			if (typeDeJeu == typeDeJeu.JoueurAI) {
				while (!turnOn && gameOn && !game.getGameWindow().getReset().isBntIsPressed()) {

					if (strategy == AIStrategy.RANDUMB) {
						attaque = joueurAI.tirAleatoire();
					}
					else if (strategy == AIStrategy.HIT_SEARCH) {
					attaque = joueurAI.tirMeshSearch();
					}
					else if (strategy == AIStrategy.HIT_SEARCH2) {
						attaque = joueurAI.tirAggroMesh();
					}

					GameButton gameButton1 = game.getGameWindow().getGamePanelAllie().getGridPanel().getGameButtons().get(attaque);

					if (this.testHitBoatGC(joueur1, gameButton1)) {

						joueur1.getTabBoat().get(whoIsTouched).perteVieBoat();
						System.out.println(joueurAI.getTabBoat().get(whoIsTouched).getVieBoat());
						joueur1.perteVieFlotte();

						boolean testHit = true;
						boolean testMortBoat = joueur1.getTabBoat().get(whoIsTouched).testMortBoat();
						boolean testVictoire = this.testMortFlotteGC(joueur1);

						this.setMessageTouched(joueur1, joueurAI, gameButton1, testHit, testMortBoat, testVictoire);

						exploser(gameButton1, "/images/explodeanimation.png");
						if (testVictoire) {
							gameOn = false;
							afficherVictoire(joueurAI);
						}
						turnOn = true;
						this.whoIsTouched = -1;

						joueurAI.recupererResultat(true, attaque);
					}

					else {

						this.setMessageMiss(joueur1, joueurAI, gameButton1);
						exploser(gameButton1, "/images/sploosh.png");
						turnOn = true;

						joueurAI.recupererResultat(false, attaque);
					}

					break;
				}
			}
		}

		if (game.getGameWindow().getReset().isBntIsPressed()) {
			initGame();
		}

	}

	public boolean testHitBoatGC(Joueur joueurVise, GameButton gameButton) {

		for (int i = 0; i < joueurVise.getTabBoat().size(); i++) {
			for (int j = 0; j < joueurVise.getTabBoat().get(i).getTabIndiceBoat().size(); j++) {
				if (gameButton.getIndice() == joueurVise.getTabBoat().get(i).getTabIndiceBoat().get(j)) {

					whoIsTouched = i;
					return true;
				}
			}
		}
		return false;
	}

	public void exploser(GameButton btn, String filepath) {

		int x = 376;
		int y = 94;
		int w = 47;
		int h = 47;

		try {

			BufferedImage bufferedimg = ImageIO.read(getClass().getResource(filepath));
			BufferedImage[] img = new BufferedImage[9];

			for (int i1 = 0; i1 < 2; i1++) {
				for (int j = 0; j < 9; j++) {

					img[j] = bufferedimg.getSubimage(x, y, w, h);

					btn.setIcon(new ImageIcon(img[j]));

					x -= w;

					if (x == 0) {
						x = 376;
						y -= h;
					}

					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean testMortFlotteGC(Joueur joueurVise) {
		if (joueurVise.getVie() == 0) {
			return true;
		}
		return false;
	}

	public void setMessageTouched(Joueur joueurVise, Joueur joueurEnJeu, GameButton gameButton, boolean testHit,
			boolean testMortBoat, boolean testVictoire) {

		if (testHit) {

			if (testMortBoat) {
				game.getGameWindow().getBoxChat().getAffichageChat().append(joueurEnJeu.getName() + " : Nous avons coule "
						+ joueurVise.getTabBoat().get(whoIsTouched).getTypeOfBoat() + " \n");
				if (joueurEnJeu == joueurAI) {
					game.getGameWindow().getBoxChat().getAffichageChat()
					.append(joueurEnJeu.getName() + " : Stupide humain! Tu ne peux pas gagner! AHAHAHAHAHAH!!!" + "\n");
				}

			}

			else {
				game.getGameWindow().getBoxChat().getAffichageChat()
						.append(joueurEnJeu.getName() + " : Nous avons touche l'ennemi!" + "\n");

			}
		}

		if (testVictoire) {
			game.getGameWindow().getBoxChat().getAffichageChat().append(joueurEnJeu.getName() + " : Nous avons GAGNE!" + "\n");
			
		}

	}

	public void setMessageMiss(Joueur joueurVise, Joueur joueurEnJeu, GameButton gameButton) {

		game.getGameWindow().getBoxChat().getAffichageChat()
				.append(joueurEnJeu.getName() + " : Nous avons rater notre cible!" + "\n");


	}

	public void initGame() {		
		if (typeDeJeu == typeDeJeu.JoueurAI) {
			this.game = new GameSansServer("BATTLESHIP", username, this);
		}
		else {
			if (typeDeJeu == typeDeJeu.Serveur) {
				this.game = new GameServer("BATTLESHIP", username, this);
			}
			else if (typeDeJeu == typeDeJeu.Client)  {
				this.game = new GameClient("BATTLESHIP", username, this, adrIP);
			}
		}
		
		this.joueurAI = new AI("AI");
		this.joueur1 = new Joueur(username);
		this.strategy = strategy;
		this.turnOn = true;
		this.gameOn = true;
		this.whoIsTouched = -1;
		this.resetAffichage();
		game.getGameWindow().getReset().setBntIsPressed(false);
		this.StartGame();
	}

	public void resetAffichage() {
		for (int i = 0; i < game.getGameWindow().getGamePanelAllie().getNbbuttons(); i++) {
			Color trans = new Color(255, 255, 255, 99);
			
			game.getGameWindow().getGamePanelAllie().getGridPanel().getGameButtons().get(i).setIcon(null);
			game.getGameWindow().getGamePanelEnnemi().getGridPanel().getGameButtons().get(i).setIcon(null);

		}
		game.getGameWindow().getBoxChat().getAffichageChat().setText("");

	}

	public void afficherVictoire(Joueur joueur) {

		if (joueur == joueur1) {

			int option = JOptionPane.showConfirmDialog(null, "Voulez-vous recommencer une partie?", "VICTOIRE!!!",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.NO_OPTION) {
				System.exit(0);
			} else if (option == JOptionPane.YES_OPTION) {
				initGame();
			}
		}

		else if (joueur == joueurAI) {

			int option = JOptionPane.showConfirmDialog(null, "Voulez-vous recommencer une partie?", "DEFAITE!!!",
					JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.NO_OPTION) {
				System.exit(0);
			} else if (option == JOptionPane.YES_OPTION) {
				initGame();
			}
		}
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public boolean isTurnOn() {
		return turnOn;
	}

	public void setTurnOn(boolean turnOn) {
		this.turnOn = turnOn;
	}

	public boolean isGameOn() {
		return gameOn;
	}

	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}

	public int getWhoIsTouched() {
		return whoIsTouched;
	}

	public void setWhoIsTouched(int whoIsTouched) {
		this.whoIsTouched = whoIsTouched;
	}

	public GameWindow getMainFenetre() {
		return game.getGameWindow();
	}

	public void setMainFenetre(GameWindow mainFenetre) {
		this.game.setGameWindow(mainFenetre);
	}

	public boolean isServerActive() {
		return isServerActive;
	}

	public void setServerActive(boolean isServerActive) {
		this.isServerActive = isServerActive;
	}

	public boolean isServer() {
		return isServer;
	}

	public void setServer(boolean isServer) {
		this.isServer = isServer;
	}

}
