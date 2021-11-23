package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.AnhCongThucEntity;
import dataAndroidNauAn.entity.CongThucEntity;

public interface AnhCongThucRepository extends JpaRepository<AnhCongThucEntity, Long>{
	List<AnhCongThucEntity> findByCThuc(CongThucEntity cThuc);
}
