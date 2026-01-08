package com.gsrr.DemoSpring.laptop;

import com.gsrr.DemoSpring.Computer;

public class Laptop implements Computer {

	public Laptop() {
		System.out.println("laptop constructor");
	}

	@Override
	public void compile() {
		// TODO Auto-generated method stub
			System.out.println("laptop class compiling");

	}

	
}
