package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.AnhCongThucConverter;
import dataAndroidNauAn.dto.AnhCongThucDTO;
import dataAndroidNauAn.entity.AnhCongThucEntity;
import dataAndroidNauAn.entity.CongThucEntity;
import dataAndroidNauAn.repository.AnhCongThucRepository;
import dataAndroidNauAn.repository.CongThucRepository;
import dataAndroidNauAn.service.IAnhCongThucService;

@Service
public class AnhCongThucService implements IAnhCongThucService{

	@Autowired
	AnhCongThucConverter converter;
	
	@Autowired
	AnhCongThucRepository repository;
	
	@Autowired
	CongThucRepository congThucRepository;
	
	@Override
	public AnhCongThucDTO save(AnhCongThucDTO model) {
		AnhCongThucEntity entity = converter.toEntity(model);
		CongThucEntity congThucEntity = congThucRepository.findOneByMaCT(model.getMaCT());
		entity.setcThuc(congThucEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public List<AnhCongThucDTO> getAnhByMaCT(String maCT) {
		CongThucEntity congThucEntity = congThucRepository.findOneByMaCT(maCT);
		List<AnhCongThucEntity> listEntities = repository.findByCThuc(congThucEntity);
		List<AnhCongThucDTO> listDTO = new ArrayList<>();
		for (AnhCongThucEntity entity : listEntities) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

}
