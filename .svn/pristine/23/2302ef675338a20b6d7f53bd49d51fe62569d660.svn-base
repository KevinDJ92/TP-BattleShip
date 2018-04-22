package gameSevers;

import java.io.IOException;
import java.net.ServerSocket;

import controller.GameController;
import listeners.EnterKeyListener;

public class GameServer extends Game {

	public GameServer(String titre, String username, GameController controller) {
		super(titre, username, controller);
		try {
			this.server = new ServerSocket(PORT);
			this.sock = server.accept();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		init();
		
		gameWindow.getBoxChat().getMessageBox()
		.addKeyListener(new EnterKeyListener(this, gameWindow.getBoxChat()));
	}
}
