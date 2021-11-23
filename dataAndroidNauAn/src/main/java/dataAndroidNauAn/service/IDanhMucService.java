package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.DanhMucDTO;

public interface IDanhMucService {

	DanhMucDTO save(DanhMucDTO model);
	List<DanhMucDTO> getAll();
}
