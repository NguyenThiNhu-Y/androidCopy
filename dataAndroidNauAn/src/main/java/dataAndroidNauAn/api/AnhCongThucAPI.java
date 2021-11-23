package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.AnhCongThucDTO;
import dataAndroidNauAn.service.impl.AnhCongThucService;

@RestController
public class AnhCongThucAPI {

	@Autowired
	AnhCongThucService service;
	
	@PostMapping(value = "/anh")
	public AnhCongThucDTO save(@RequestBody AnhCongThucDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/anh")
	public List<AnhCongThucDTO> getAnhByMaCT(@RequestParam("maCT") String maCT){
		return service.getAnhByMaCT(maCT);
	}
}
