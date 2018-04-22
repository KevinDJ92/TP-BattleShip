package listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import event.PanelEvent;
import gameSevers.Game;
import thread.ThreadEmission;
import views.principals.ChatPanel;

public class EnterKeyListener extends KeyAdapter {

	private final String msgChat = "msgChat";
	private ChatPanel cPanel;
	private Game joueur;
	
	public EnterKeyListener(Game joueur, ChatPanel cPanel) {
		this.cPanel = cPanel;
		this.joueur = joueur;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			// envoi le message
			ThreadEmission threadEmission = new ThreadEmission(joueur);
			threadEmission.setMsg(msgChat + cPanel.getMessageBox().getText());
			threadEmission.start();
			
			// récupère le message a envoyer
			String message = "msgChat: " + 					
			((JTextField)e.getSource()).getText();
			
			// ajoute le message envoyé dans le textarea
			PanelEvent pEvent = new PanelEvent(message);
			
			cPanel.ilYAUnMessage(pEvent);			
			
			// vider le textfield
			((JTextField)e.getSource()).setText(null);
		}
	}
}

