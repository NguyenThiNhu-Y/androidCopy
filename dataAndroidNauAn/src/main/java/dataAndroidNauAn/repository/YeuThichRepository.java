package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.entity.YeuThichEntity;

public interface YeuThichRepository extends JpaRepository<YeuThichEntity, Long>{
	List<YeuThichEntity> findByUserYT(UserEntity user);

}
