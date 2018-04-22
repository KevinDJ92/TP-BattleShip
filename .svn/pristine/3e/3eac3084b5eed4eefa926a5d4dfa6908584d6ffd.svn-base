package thread;

import java.io.IOException;
import java.util.ArrayList;


import event.PanelEvent;
import gameSevers.Game;
import listeners.IThreadListener;

// Objet Ecouté
public class ThreadReception extends Thread {
	ArrayList<IThreadListener> ecouteurs;
	boolean isRunning = true;
	Game joueur;
	
	public ThreadReception(Game joueur) {
		ecouteurs = new ArrayList<IThreadListener>();
		this.joueur = joueur;
		
	}
	
	@Override
	public void run() {	
		// on peut commencer à recevoir les messages
		String message = null;
		PanelEvent pEvent = new PanelEvent(message);
		
		try {
			while((message = joueur.getReader().readLine()) != null) {
				System.out.println("message1: " + message);
				
				pEvent.setMsg(message);
				
				notifierLesEcouteurs(pEvent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 	
	public void addThreadListener(IThreadListener iEcoute) {
		ecouteurs.add(iEcoute);
	}
	
	// notifierLesEcouteurs ou FireListener
	// On peut aussi just passer le String msg
	public void notifierLesEcouteurs(PanelEvent e){

		for (IThreadListener ecouteur : ecouteurs) {
			if (e.getMsg().startsWith("bCoord")) {
				System.out.println("bCoord: " + e.getMsg());
				ecouteur.afficherCoord(e);
			}
			else if (e.getMsg().startsWith("msgChat")) {
				System.out.println("msgChat: " + e.getMsg());
				ecouteur.ilYAUnMessage(e);
			}
		}
	}
	
	void actionQuiAgitSurLesObjetQuiEcoute(PanelEvent e){
		notifierLesEcouteurs(e);
	}
}
