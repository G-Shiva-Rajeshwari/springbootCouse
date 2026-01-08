package com.basic1.spring1.game;

public class MarioGame implements GamingConsole{

	//adding btns to gaming app - step2
	public void up() {
		System.out.println("jump");
	}
	
	public void down() {
		System.out.println("Go into a hole");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("Accelerate");
	}
}
