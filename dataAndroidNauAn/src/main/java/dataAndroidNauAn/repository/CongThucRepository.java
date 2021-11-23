package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.CongThucEntity;
import dataAndroidNauAn.entity.MonAnEntity;

public interface CongThucRepository extends JpaRepository<CongThucEntity, Long>{
	List<CongThucEntity> findByMonCT(MonAnEntity monCT);
	public CongThucEntity findOneByMaCT(String maCT);
}
