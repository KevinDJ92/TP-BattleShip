package thread;

import java.util.ArrayList;

import gameSevers.Game;
import listeners.IThreadListener;
import views.principals.ChatPanel;

public class ThreadEmission extends Thread {

	ArrayList<IThreadListener> ecouteurs;
	boolean isRunning = true;
	Game joueur;
	ChatPanel cPanel;
	String msg = "";
	
	public ThreadEmission(Game joueur) {
		ecouteurs = new ArrayList<IThreadListener>();
		this.joueur = joueur;
	}
	
	@Override
	public void run() {	
		joueur.getWriter().println(msg);
		joueur.getWriter().flush();
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
