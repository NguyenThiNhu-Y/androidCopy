package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.NguyenLieuConverter;
import dataAndroidNauAn.dto.NguyenLieuDTO;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.NguyenLieuEntity;
import dataAndroidNauAn.repository.MonAnRepository;
import dataAndroidNauAn.repository.NguyenLieuRepository;
import dataAndroidNauAn.service.INguyenLieuService;

@Service
public class NguyenLieuService implements INguyenLieuService{

	@Autowired
	NguyenLieuConverter converter;
	
	@Autowired
	NguyenLieuRepository repository;
	
	@Autowired
	MonAnRepository monAnRepository;
	
	@Override
	public NguyenLieuDTO save(NguyenLieuDTO model) {
		NguyenLieuEntity entity = converter.toEntity(model);
		MonAnEntity monAnEntity = monAnRepository.findOneByMaMon(model.getMaMon());
		entity.setMon(monAnEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public List<NguyenLieuDTO> getNguyenLieuByMaMon(String maMon) {
		MonAnEntity monAnEntity = monAnRepository.findOneByMaMon(maMon);
		List<NguyenLieuEntity> listEntities = repository.findByMonNL(monAnEntity);
		List<NguyenLieuDTO> listDTO = new ArrayList<>();
		for (NguyenLieuEntity entity : listEntities) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

}
