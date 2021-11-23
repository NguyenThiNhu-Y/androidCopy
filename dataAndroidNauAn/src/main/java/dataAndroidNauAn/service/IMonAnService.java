package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.MonAnDTO;

public interface IMonAnService {
	MonAnDTO save(MonAnDTO model);
	List<MonAnDTO> getByMaDM(String maDM);
	MonAnDTO getByMaMon(String maMon);
	List<MonAnDTO> getAllMon();
}
