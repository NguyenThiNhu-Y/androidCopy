package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.UserDTO;

public interface IUserService {
	UserDTO save(UserDTO model);
	UserDTO getUser(String userName);
	List<UserDTO> getAllUser();
	
}
