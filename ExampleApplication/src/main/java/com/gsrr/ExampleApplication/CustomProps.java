package com.gsrr.ExampleApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class CustomProps {
	private final MyFirstClass myFirstClass;
	
	@Autowired
	public CustomProps(@Qualifier("myBean")MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}
	
	public String tellAStory() {
		return "the dependency is saying : "+myFirstClass.sayHello();
	}
	
	//application.props
	@Value("${my.custom.property}")
	private String customProperty;
	
	//custom.props
	@Value("${my.prop}")
	private String customPropertyFromAnotherFile;
	
	@Value("123")
	private Integer customPropertyInt;

	public String getCustomProperty() {
		return customProperty;
	}


	public String getCustomPropertyFromAnotherFile() {
		return customPropertyFromAnotherFile;
	}

	public Integer getCustomPropertyInt() {
		return customPropertyInt;
	}

	public MyFirstClass getMyFirstClass() {
		return myFirstClass;
	}

}
