package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.YeuThichDTO;
import dataAndroidNauAn.entity.YeuThichEntity;

@Component
public class YeuThichConverter {

	public YeuThichEntity toEntity(YeuThichDTO dto) {
		YeuThichEntity entity = new YeuThichEntity();
		entity.setMaMon(dto.getMaMon());
		return entity;
	}
	
	public YeuThichDTO toDTO(YeuThichEntity entity) {
		YeuThichDTO dto = new YeuThichDTO();
		dto.setId(entity.getId());
		dto.setMaMon(entity.getMaMon());
		dto.setUser(entity.getUserYT().getUserName());
		return dto;
	}
}
