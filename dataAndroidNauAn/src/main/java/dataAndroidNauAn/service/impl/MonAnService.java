package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.MonAnConverter;
import dataAndroidNauAn.converter.YeuThichConverter;
import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.dto.YeuThichDTO;
import dataAndroidNauAn.entity.DanhMucEntity;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.YeuThichEntity;
import dataAndroidNauAn.repository.DanhMucRepository;
import dataAndroidNauAn.repository.MonAnRepository;
import dataAndroidNauAn.service.IMonAnService;

@Service
public class MonAnService implements IMonAnService{

	@Autowired
	MonAnConverter converter;
	
	@Autowired
	MonAnRepository repository;
	
	@Autowired
	DanhMucRepository dmRepository;
	
	@Autowired
	YeuThichService ytService;
	
	@Autowired
	YeuThichConverter ytConverter;
	
	@Autowired
	MonAnService monService;
	
	@Autowired 
	ThongBaoService tbaoService;
	
	@Autowired
	MonAnConverter monConverter;

	
	
	@Override
	public MonAnDTO save(MonAnDTO dto) {
		MonAnEntity entity = new MonAnEntity();
		entity = converter.toEntity(dto);
		DanhMucEntity danhMucEntity = dmRepository.findOneByMaDM(dto.getMaDM());
		entity.setdMuc(danhMucEntity);
		repository.save(entity);
		
		//tìm xem món mới có trùng tên với mục yêu thích của user nào không?
		
		//tìm tất cả user trong yêu thích
		List<String> listUser = ytService.getAllUser();
		for (String user : listUser) {
			List<YeuThichDTO> listYTDTO = ytService.getYeuThichByUser(user); //lấy các món yêu thích của 1 user
			for (YeuThichDTO yeuThichDTO : listYTDTO) {
				
				YeuThichEntity ytEntity = ytConverter.toEntity(yeuThichDTO);
				
				MonAnDTO monDTO = monService.getByMaMon(ytEntity.getMaMon()); //lấy thông tin món từ mã món
				
				if(entity.getTenMon().equals(monDTO.getTenMon())) { //nếu món mới thêm vào trùng tên với món trong yêu thích thì thêm tbao
					tbaoService.save(user, entity);
				}
			}
			
		}
		
		return converter.toDTO(entity);
	}

	@Override
	public List<MonAnDTO> getByMaDM(String maDM) {
		DanhMucEntity dmEntity = dmRepository.findOneByMaDM(maDM);
		List<MonAnEntity> listEntity = new ArrayList<>();
		List<MonAnDTO> listDTO = new ArrayList<>();
		listEntity = repository.findAll();
		for (MonAnEntity entity : listEntity) {
			if(converter.toDTO(entity).getMaDM()==dmEntity.getMaDM())
				listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

	@Override
	public MonAnDTO getByMaMon(String maMon) {
		MonAnEntity monAnEntity = repository.findOneByMaMon(maMon);
		return converter.toDTO(monAnEntity);
	}

	@Override
	public List<MonAnDTO> getAllMon() {
		List<MonAnEntity> listEntity = new ArrayList<>();
		List<MonAnDTO> listDTO = new ArrayList<>();
		listEntity = repository.findAll();
		for (MonAnEntity entity : listEntity) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

	
	
}
