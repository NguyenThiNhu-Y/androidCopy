package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.NguyenLieuDTO;

public interface INguyenLieuService {

	NguyenLieuDTO save(NguyenLieuDTO model);
	List<NguyenLieuDTO> getNguyenLieuByMaMon(String maMon);
}
