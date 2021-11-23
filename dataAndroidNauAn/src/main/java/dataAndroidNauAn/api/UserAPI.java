package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.service.impl.UserService;

@RestController
public class UserAPI {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user/register")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/user/login")
	public UserDTO getUser(@RequestParam("userName") String userName) {
		return service.getUser(userName);
	}
	 
	@PutMapping(value = "/user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return service.save(model);
	}
	@GetMapping(value = "/user/list")
	public List<UserDTO> ListUser() {
		return service.getAllUser();
	}
}
