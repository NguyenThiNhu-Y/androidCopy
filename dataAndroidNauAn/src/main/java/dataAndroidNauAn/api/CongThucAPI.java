package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.CongThucDTO;
import dataAndroidNauAn.service.impl.CongThucService;

@RestController
public class CongThucAPI {

	@Autowired
	CongThucService service;
	
	@PostMapping(value = "/congThuc")
	public CongThucDTO createCongThuc(@RequestBody CongThucDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/congThuc")
	public List<CongThucDTO> getByMaMon(@RequestParam("maMon") String maMon){
		return service.getByMaMon(maMon);
	}
}
