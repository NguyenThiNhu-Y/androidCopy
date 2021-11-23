package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.NguyenLieuDTO;
import dataAndroidNauAn.service.impl.NguyenLieuService;

@RestController
public class NguyenLieuAPI {

	@Autowired
	NguyenLieuService service;
	
	@PostMapping(value = "/nguyenLieu")
	public NguyenLieuDTO save(@RequestBody NguyenLieuDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "nguyenLieu")
	public List<NguyenLieuDTO> getNguyenLieuByMaMon(@RequestParam("maMon") String maMon){
		return service.getNguyenLieuByMaMon(maMon);
	}
}
