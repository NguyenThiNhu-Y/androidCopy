package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.service.impl.MonAnService;

@RestController
public class MonAnAPI {

	@Autowired
	MonAnService service;
	
	@PostMapping(value = "/monAn") //thêm món
	public MonAnDTO save(@RequestBody MonAnDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/monAn") //lấy 1 list 1 ăn theo danh mục
	public List<MonAnDTO> getDanhMucCon(@RequestParam("maDM") String maDM){
		return service.getByMaDM(maDM);
	}
	
	@GetMapping(value = "/motMonAn") //lấy 1 món theo mã món
	public MonAnDTO getByMaMon(@RequestParam("maMon") String maMon) {
		return service.getByMaMon(maMon);
	}
	
	@GetMapping(value = "/getAllMon")
	public List<MonAnDTO> getAllMon(){
		return service.getAllMon();
	}
	
}
