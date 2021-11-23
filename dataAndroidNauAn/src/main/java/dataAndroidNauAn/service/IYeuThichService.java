package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.YeuThichDTO;

public interface IYeuThichService {
	YeuThichDTO save(YeuThichDTO model);
	List<YeuThichDTO> getYeuThichByUser(String user);
	List<String> getAllUser();
}
