package gameSevers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import controller.GameController;
import thread.ThreadReception;
//import thread.ThreadReception;
import views.GameWindow;
import views.principals.GameButton;

public class Game {

	final protected int PORT = 56946;
	final protected static String titreClient = "Client";
	
	protected String IP;

	// pour le serveur
	protected ServerSocket server;
	
	// pour le serveur et le client
	protected Socket sock;
	protected BufferedReader reader;
	protected PrintWriter writer;
	protected GameWindow gameWindow;
	protected ThreadReception threadReception;
	GameController controller;
	
	public Game(String titre, String username, GameController controller) {
		this.gameWindow = new GameWindow(titre, username, this, controller);
		this.controller = controller;
	}
	
	protected void init(){
		try {
			// initalise le bufferedreader
			this.reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			// initialise le printwriter
			this.writer = new PrintWriter(sock.getOutputStream(), true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		threadReception = new ThreadReception(this);
		threadReception.addThreadListener(gameWindow.getBoxChat());
		threadReception.addThreadListener(gameWindow.getGamePanelEnnemi().getGridPanel());
		threadReception.start();
		
		System.out.println("************************************************88");
	}
	
	public GameWindow getGameWindow() {
		return gameWindow;
	}

	public void setGameWindow(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	public Socket getSock() {
		return sock;
	}

	public void setSock(Socket sock) {
		this.sock = sock;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	
}
