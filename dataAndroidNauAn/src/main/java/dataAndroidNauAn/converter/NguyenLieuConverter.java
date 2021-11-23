package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.NguyenLieuDTO;
import dataAndroidNauAn.entity.NguyenLieuEntity;

@Component
public class NguyenLieuConverter {
	
	public NguyenLieuEntity toEntity(NguyenLieuDTO dto) {
		NguyenLieuEntity entity = new NguyenLieuEntity();
		entity.setTen(dto.getTen());
		entity.setDinhLuong(dto.getDinhLuong());
		return entity;
	}
	
	public NguyenLieuDTO toDTO(NguyenLieuEntity entity) {
		NguyenLieuDTO dto = new NguyenLieuDTO();
		dto.setId(entity.getId());
		dto.setTen(entity.getTen());
		dto.setDinhLuong(entity.getDinhLuong());
		dto.setMaMon(entity.getMon().getMaMon());
		return dto;
	}

}
