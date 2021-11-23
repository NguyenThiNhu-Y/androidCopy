package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.YeuThichConverter;
import dataAndroidNauAn.dto.YeuThichDTO;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.entity.YeuThichEntity;
import dataAndroidNauAn.repository.UserRepository;
import dataAndroidNauAn.repository.YeuThichRepository;
import dataAndroidNauAn.service.IYeuThichService;

@Service
public class YeuThichService implements IYeuThichService{

	@Autowired
	YeuThichConverter converter;
	
	@Autowired
	YeuThichRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public YeuThichDTO save(YeuThichDTO model) {
		YeuThichEntity entity = converter.toEntity(model);
		UserEntity userEntity = userRepository.findOneByUserName(model.getUser());
		entity.setUserYT(userEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public List<YeuThichDTO> getYeuThichByUser(String user) {
		UserEntity userEntity = userRepository.findOneByUserName(user);
		List<YeuThichEntity> listEntities = repository.findByUserYT(userEntity);
		List<YeuThichDTO> listDTO = new ArrayList<>();
		for (YeuThichEntity entity : listEntities) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

	@Override
	public List<String> getAllUser() {
		List<YeuThichEntity> listEntities = repository.findAll();
		String tmpUser="";
		List<String> listUser = new ArrayList<>();
		for (YeuThichEntity entity : listEntities) {
			if(!tmpUser.contains(entity.getUserYT().getUserName())) {
				listUser.add(entity.getUserYT().getUserName());
				tmpUser+=" "+entity.getUserYT().getUserName();
			}
		}
		return listUser;
	}

}
