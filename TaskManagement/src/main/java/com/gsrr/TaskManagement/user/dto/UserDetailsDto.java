package com.gsrr.TaskManagement.user.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsDto{
	@NotBlank
	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	private String email; 
	
}
