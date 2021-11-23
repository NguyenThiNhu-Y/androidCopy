package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.DanhMucDTO;
import dataAndroidNauAn.service.impl.DanhMucSerivice;

@RestController
public class DanhMucAPI {
	
	@Autowired
	DanhMucSerivice service;
	
	@PostMapping(value = "/danhMuc")
	public DanhMucDTO createDanhMuc(@RequestBody DanhMucDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/danhMuc")
	public List<DanhMucDTO> getAll(){
		return service.getAll();
	}
}
