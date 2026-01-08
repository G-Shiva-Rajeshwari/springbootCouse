package com.basic1.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basic1.spring1.game.GameRunner;
import com.basic1.spring1.game.GamingConsole;
import com.basic1.spring1.game.PacManGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacManGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner() {
		var gameRunner = new GameRunner(game());
		return gameRunner;
	}
}
