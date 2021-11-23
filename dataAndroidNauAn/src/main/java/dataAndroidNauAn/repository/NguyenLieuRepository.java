package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.NguyenLieuEntity;

public interface NguyenLieuRepository extends JpaRepository<NguyenLieuEntity, Long>{
	List<NguyenLieuEntity> findByMonNL(MonAnEntity monNL);
}
