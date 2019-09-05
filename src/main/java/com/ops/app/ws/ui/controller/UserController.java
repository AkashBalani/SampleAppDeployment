package com.ops.app.ws.ui.controller;

//import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ops.app.ws.service.UserService;
import com.ops.app.ws.shared.dto.UserDto;
import com.ops.app.ws.ui.model.request.UserDetailsRequestModel;
import com.ops.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping()
	public String getUser() { //@PathVariable String id
//		UserRest returnValue = new UserRest();
//		UserDto userDto = userService.getUserByUserId(id);
//		BeanUtils.copyProperties(userDto, returnValue);
//		return returnValue;
		return "Get Mapping for a User";
		}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
		//return null;
	}
	
	@PutMapping
	public String updateUser() {
		return "Update method called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete User";
	}
}
