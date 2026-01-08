package com.gsrr.TaskManagement.user;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.tasks.TaskRepository;
import com.gsrr.TaskManagement.user.dto.UserDetailsDto;
import com.gsrr.TaskManagement.user.dto.UserMapper;
import com.gsrr.TaskManagement.user.dto.UserResponseDto;
import com.gsrr.TaskManagement.user.dto.UserUpdateRequest;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private UserMapper userMapper;
    
    public User createUser(UserDetailsDto dto){
    	
        return userRepository.save(userMapper.toUser(dto));
    }
    
    public void updateUser(Integer id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (request.name() != null) {
            user.setName(request.name());
        }

        if (request.email() != null) {
            user.setEmail(request.email());
        }

        userRepository.save(user);
    }
 
	public void delById(Integer id) {
		 if(!userRepository.existsById(id)){
		        throw new RuntimeException("User not found");
		    }
		userRepository.deleteById(id);
		
	}
	public List<UserResponseDto> displayDetails() {
		
		List<User> users = userRepository.findAll();
		return users.stream().map(u-> {
			List<Task> tasks = taskRepository.findByUserId(u.getId());
			return userMapper.toDto(u,tasks);
//			.map(u -> userMapper.toDto(u, taskRepository.findByUserId(u.getId())))
		}).toList();
	}
	}
