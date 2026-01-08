package com.basic1.spring1;

import com.basic1.spring1.game.GameRunner;
import com.basic1.spring1.game.MarioGame;
import com.basic1.spring1.game.PacManGame;
import com.basic1.spring1.game.superContraGame;

public class App01GamingBasic {

	public static void main(String[] args) {
		//starting with javagaming application - step1 
		//var game = new MarioGame();
		//var game = new superContraGame();
		var game = new PacManGame();//1: Object Creation
		
		var gameRunner = new GameRunner(game);
		//2: Object Creation + Wiring of Dependencies
		//game is a dependency of gameRunner
		
		gameRunner.run();

	}

}
