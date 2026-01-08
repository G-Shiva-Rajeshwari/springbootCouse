package com.gsrr.TaskManagement.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.tasks.TaskRepository;
import com.gsrr.TaskManagement.user.dto.UserDetailsDto;
import com.gsrr.TaskManagement.user.dto.UserResponseDto;
import com.gsrr.TaskManagement.user.dto.UserUpdateRequest;

@RestController
@RequestMapping("/user")
public class UserManagement {
	private UserRepository userRepo;
	private UserService userService;
	private TaskRepository taskRepo;
	
	public UserManagement(UserRepository userRepo, UserService userService) {
		super();
		this.userRepo = userRepo;
		this.userService = userService;
	}

	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody UserDetailsDto user) {
		//User newUser
		return ResponseEntity.ok(userService.createUser(user));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(
	        @PathVariable Integer id,
	        @RequestBody UserUpdateRequest request) {

	    userService.updateUser(id, request);
	    return ResponseEntity.ok("User updated successfully");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		userService.delById(id);
		return ResponseEntity.ok("User deleted successfully");
	}
	
	@GetMapping("/details")
	public ResponseEntity<List<UserResponseDto>> displayDetails(){
		return ResponseEntity.ok(userService.displayDetails());
	}
	
}
