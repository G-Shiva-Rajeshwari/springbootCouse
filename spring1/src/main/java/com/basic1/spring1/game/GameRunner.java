package com.basic1.spring1.game;

public class GameRunner {
	GamingConsole game; //loose coupling
	//MarioGame game; //tightly coupled
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: "+game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
