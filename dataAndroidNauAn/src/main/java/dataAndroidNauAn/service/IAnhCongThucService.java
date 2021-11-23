package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.AnhCongThucDTO;

public interface IAnhCongThucService {
	AnhCongThucDTO save(AnhCongThucDTO model);
	List<AnhCongThucDTO> getAnhByMaCT(String maCT);
}
