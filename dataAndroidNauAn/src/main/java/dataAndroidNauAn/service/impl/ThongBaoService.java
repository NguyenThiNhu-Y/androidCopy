package dataAndroidNauAn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.ThongBaoConverter;
import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.ThongBaoEntity;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.repository.ThongBaoRepository;
import dataAndroidNauAn.repository.UserRepository;
import dataAndroidNauAn.service.IThongBaoService;

@Service
public class ThongBaoService implements IThongBaoService{

	
	@Autowired
	ThongBaoRepository repository;
	
	@Autowired
	ThongBaoConverter converter;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public ThongBaoDTO save(String user, MonAnEntity mon) {
		ThongBaoEntity entity = new ThongBaoEntity();
		UserEntity userEntity = userRepository.findOneByUserName(user);
		entity.setNoiDung("Món "+mon.getTenMon()+" bạn thích có 1 công thức mới");
		entity.setStatus(0);
		entity.setMaMon(mon.getId());
		entity.setUserTB(userEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

}
