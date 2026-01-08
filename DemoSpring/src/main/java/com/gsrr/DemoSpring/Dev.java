package com.gsrr.DemoSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsrr.DemoSpring.laptop.Laptop;


public class Dev {

	
	private Computer comp;
	
	int age;
	
	public Dev() {
		System.out.println("dev constructor");
	}
		
	public Dev(Computer comp) {
//		super();
		this.comp = comp;
	}

	public Computer getComp() {
		return comp;
	}
	
	public void setComp(Computer comp) {
		this.comp = comp;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		System.out.println("done");
	}
	
		public void build() {
			System.out.println("working on project");
			comp.compile();
		}
		
}
