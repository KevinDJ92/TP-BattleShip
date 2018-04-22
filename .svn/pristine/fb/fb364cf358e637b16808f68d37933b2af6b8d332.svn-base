package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.GameController;
import gameSevers.Game;
import thread.ThreadEmission;
import views.principals.GameButton;

public class ListenerGameButton implements ActionListener {

	private Game game;
	private final String msgCoord = "bCoord";
	private GameController gameController;
	
	public ListenerGameButton(Game game, GameController gameController) {
		this.game = game;
		this.gameController = gameController;

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		GameButton gameButton = (GameButton) event.getSource();
		Integer indice = gameButton.getIndice();
			
		System.out.println(" indice "  + indice);

		ThreadEmission threadEmission = new ThreadEmission(game);
		threadEmission.setMsg(msgCoord + gameButton.getIndice());
		threadEmission.start();
			
		gameButton.setBntIsPressed(true);
		
	}
}
