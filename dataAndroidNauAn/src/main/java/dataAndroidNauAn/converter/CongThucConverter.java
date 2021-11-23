package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.CongThucDTO;
import dataAndroidNauAn.entity.CongThucEntity;

@Component
public class CongThucConverter {

	public CongThucEntity toEntity(CongThucDTO dto) {
		CongThucEntity entity = new CongThucEntity();
		entity.setCongThuc(dto.getCongThuc());
		entity.setMaCT(dto.getMaCT());
		return entity;
	}
	
	public CongThucDTO toDTO(CongThucEntity entity) {
		CongThucDTO dto = new CongThucDTO();
		dto.setId(entity.getId());
		dto.setCongThuc(entity.getCongThuc());
		dto.setMonCT(entity.getMon().getMaMon());
		dto.setMaCT(entity.getMaCT());
		return dto;
	}
}
