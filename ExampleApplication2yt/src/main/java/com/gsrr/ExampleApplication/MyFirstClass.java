package com.gsrr.ExampleApplication;

import org.springframework.stereotype.Component;


public class MyFirstClass {
	
	private String myVar;
	
	
		public MyFirstClass(String myVar) {
			this.myVar = myVar;
	}


		public String sayHello() {
		return "hello hello... var: "+myVar;
	}

}
