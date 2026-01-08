package com.gsrr.ExampleApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ExampleApplication {

	public static void main(String[] args) {
		try(var context = SpringApplication.run(ExampleApplication.class, args)){
//			MyFirstClass obj = context.getBean(MyFirstClass.class);
//			System.out.println(obj.sayHello());
			
//			MyFirstService service = context.getBean(MyFirstService.class);
//			System.out.println(service.tellAStory());
			
			MyFirstService service = context.getBean(MyFirstService.class);
//			System.out.println(service.getJavaVersion());
//			System.out.println(service.getOsName());
//			System.out.println(service.readProp());
			
			CustomProps cp = context.getBean(CustomProps.class);
			System.out.println(cp.getCustomProperty());
			System.out.println(cp.getCustomPropertyInt());
			System.out.println(cp.getCustomPropertyFromAnotherFile());

		}
	}
	


}
