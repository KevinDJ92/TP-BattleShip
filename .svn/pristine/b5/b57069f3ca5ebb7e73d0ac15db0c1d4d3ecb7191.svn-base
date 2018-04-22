package gameSevers;

import java.io.IOException;
import java.net.Socket;

import controller.GameController;
import listeners.EnterKeyListener;

public class GameClient extends Game {

	public GameClient(String username, String strategy, GameController controller, String IP) {
		super(username, strategy, controller);
		
		try {
			this.sock = new Socket(IP, PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		init();
		
		gameWindow.getBoxChat().getMessageBox()
			.addKeyListener(new EnterKeyListener(this, gameWindow.getBoxChat()));
	}
}
