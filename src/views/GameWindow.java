package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.GameController;
import gameSevers.Game;
import views.principals.ChatPanel;
import views.principals.GameJMenuItem;

import listeners.resetListener;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel  sec1Pan;
	MainPan mainPan;
	ChatPanel boxChat;
	
	GamePanel gamePanelEnnemi, gamePanelAllie;

	JMenuBar menuBar;
	JMenu menuInGame;
	
	GameJMenuItem reset;
	
	String username;
	Border blackline = BorderFactory.createLineBorder(Color.black);
	Image image;

	public GameWindow(String titre, String username, Game game, GameController gameController) {
		super(titre);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 900);
		setResizable(false);

		setLocationRelativeTo(null);

		mainPan = new MainPan();

		sec1Pan = new JPanel();

		boxChat = new ChatPanel(username);		
		
		// elements du menu
		menuBar = new JMenuBar();
		menuInGame = new JMenu("Menu");
		reset = new GameJMenuItem("Reset");
		reset.addActionListener(new resetListener());

		menuInGame.add(reset);
		menuBar.add(menuInGame);

		sec1Pan.setLayout(new GridLayout(0, 2));

		// creation des gamePanel
		gamePanelEnnemi = new GamePanel(game, gameController);
		gamePanelAllie = new GamePanel(game, gameController);

		//Ajouts aux differents conteneurs
		sec1Pan.add(gamePanelEnnemi);
		sec1Pan.add(gamePanelAllie);

		mainPan.add(sec1Pan);
		mainPan.add(boxChat);

		setJMenuBar(menuBar);
		setContentPane(mainPan);
		setVisible(true);
	}
	

	
	//getter setter**************************************

	public GamePanel getGamePanel() {
		return gamePanelEnnemi;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanelEnnemi = gamePanel;
	}
	
	
	public JPanel getMainPan() {
		return mainPan;
	}

	public void setMainPan(MainPan mainPan) {
		this.mainPan = mainPan;
	}

	public JPanel getSec1Pan() {
		return sec1Pan;
	}

	public void setSec1Pan(JPanel sec1Pan) {
		this.sec1Pan = sec1Pan;
	}

	public ChatPanel getBoxChat() {
		return boxChat;
	}

	public void setBoxChat(ChatPanel boxChat) {
		this.boxChat = boxChat;
	}

	public GamePanel getGamePanelEnnemi() {
		return gamePanelEnnemi;
	}

	public void setGamePanelEnnemi(GamePanel gamePanelEnnemi) {
		this.gamePanelEnnemi = gamePanelEnnemi;
	}

	public GamePanel getGamePanelAllie() {
		return gamePanelAllie;
	}

	public void setGamePanelAllie(GamePanel gamePanelAllie) {
		this.gamePanelAllie = gamePanelAllie;
	}


	public GameJMenuItem getReset() {
		return reset;
	}

	public void setReset(GameJMenuItem reset) {
		this.reset = reset;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Border getBlackline() {
		return blackline;
	}

	public void setBlackline(Border blackline) {
		this.blackline = blackline;
	}

}
