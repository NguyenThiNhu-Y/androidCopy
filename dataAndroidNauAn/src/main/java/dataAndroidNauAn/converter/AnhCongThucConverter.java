package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.AnhCongThucDTO;
import dataAndroidNauAn.entity.AnhCongThucEntity;

@Component
public class AnhCongThucConverter{
	
	public AnhCongThucEntity toEntity(AnhCongThucDTO dto) {
		AnhCongThucEntity entity = new AnhCongThucEntity();
		entity.setAnh(dto.getAnh());
		return entity;
	}
	
	public AnhCongThucDTO toDTO(AnhCongThucEntity entity) {
		AnhCongThucDTO dto = new AnhCongThucDTO();
		dto.setId(entity.getId());
		dto.setAnh(entity.getAnh());
		dto.setMaCT(entity.getcThuc().getMaCT());
		return dto;
	}
	
}
