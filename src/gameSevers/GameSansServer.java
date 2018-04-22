package gameSevers;

import controller.GameController;

public class GameSansServer extends Game {

	public GameSansServer(String username, String strategy, GameController controller) {
		super(username, strategy, controller);
	}
}
