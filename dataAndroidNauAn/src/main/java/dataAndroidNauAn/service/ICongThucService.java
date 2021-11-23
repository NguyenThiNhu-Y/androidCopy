package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.CongThucDTO;

public interface ICongThucService {
	CongThucDTO save(CongThucDTO model);
	List<CongThucDTO> getByMaMon(String maMon);
}
