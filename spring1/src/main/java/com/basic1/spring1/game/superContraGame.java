package com.basic1.spring1.game;

public class superContraGame implements GamingConsole{
	public void up() {
		System.out.println("fly");
	}
	
	public void down() {
		System.out.println("walk");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("shoot a bullet");
	}
}
