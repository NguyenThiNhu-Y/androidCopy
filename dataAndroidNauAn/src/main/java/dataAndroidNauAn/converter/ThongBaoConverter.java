package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.entity.ThongBaoEntity;

@Component
public class ThongBaoConverter {

	public ThongBaoEntity toEntity(ThongBaoDTO dto) {
		ThongBaoEntity entity = new ThongBaoEntity();
		entity.setNoiDung(dto.getNoiDung());
		entity.setStatus(dto.getStatus());
		entity.setMaMon(dto.getMaMon());;
		return entity;
	}
	
	public ThongBaoDTO toDTO(ThongBaoEntity entity) {
		ThongBaoDTO dto = new ThongBaoDTO();
		dto.setId(entity.getId());
		dto.setNoiDung(entity.getNoiDung());
		dto.setStatus(entity.getStatus());
		dto.setMaMon(entity.getId());
		dto.setUser(entity.getUserTB().getUserName());
		return dto;
	}
}
