package com.basic1.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic1.spring1.game.GameRunner;
import com.basic1.spring1.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();

			context.getBean(GameRunner.class).run();
		}

	}

}
