package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.DanhMucDTO;
import dataAndroidNauAn.entity.DanhMucEntity;

@Component
public class DanhMucConverter {
	
	public DanhMucEntity toEntity(DanhMucDTO dto) {
		DanhMucEntity entity = new DanhMucEntity();
		entity.setTenDM(dto.getTenDM());
		entity.setAnh(dto.getAnh());
		entity.setMaDM(dto.getMaDM());
		return entity;
	}
	
	public DanhMucDTO toDTO(DanhMucEntity entity) {
		DanhMucDTO dto = new DanhMucDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTenDM(entity.getTenDM());
		dto.setAnh(entity.getAnh());
		dto.setMaDM(entity.getMaDM());
		return dto;
	}
	
}
