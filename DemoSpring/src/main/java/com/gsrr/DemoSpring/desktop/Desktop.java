package com.gsrr.DemoSpring.desktop;

import com.gsrr.DemoSpring.Computer;

public class Desktop implements Computer {

	public Desktop() {
		System.out.println("desktop constructor");
	}
	@Override
	public void compile() {
		System.out.println("deskto[p class ok");
	}

}
