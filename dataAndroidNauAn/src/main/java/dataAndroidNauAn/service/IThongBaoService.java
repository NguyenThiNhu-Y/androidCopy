package dataAndroidNauAn.service;

import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.entity.MonAnEntity;

public interface IThongBaoService {
	ThongBaoDTO save(String user, MonAnEntity mon);
}
