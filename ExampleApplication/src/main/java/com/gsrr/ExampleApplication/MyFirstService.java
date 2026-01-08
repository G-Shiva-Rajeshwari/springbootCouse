package com.gsrr.ExampleApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
	
	//field injection
	//@Autowired
	//@Qualifier("mySecBean")
	//@Qualifier("myBean")
	private MyFirstClass myFirstClass;
	
	private Environment environment;
	
	//constructor injection
//	@Autowired
//	public MyFirstService(@Qualifier("bean1")MyFirstClass myFirstClass) {
//		this.myFirstClass = myFirstClass;
//	}
	
	//setter injection
	@Autowired
	public void setMyFirstService(@Qualifier("myBean")MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}

	public String tellAStory() {
		return "the dependency is saying : "+myFirstClass.sayHello();
	}
	
	public String getJavaVersion() {
		return environment.getProperty("java.version");
	}
	
	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getOsName() {
		return environment.getProperty("os.name");
	}
	
	public String readProp() {
		return environment.getProperty("my.custom.property");
	}

}
