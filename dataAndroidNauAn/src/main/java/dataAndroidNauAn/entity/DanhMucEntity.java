package dataAndroidNauAn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "danhMuc")
public class DanhMucEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tenDM")
	private String tenDM;
	
	@Column(name = "anh")
	private String anh;
	
	@Column(name = "maDM")
	private String maDM;
	
	@OneToMany(mappedBy = "dMuc")
	private List<MonAnEntity> listDMC = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}
	

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public List<MonAnEntity> getListDMC() {
		return listDMC;
	}

	public void setListDMC(List<MonAnEntity> listDMC) {
		this.listDMC = listDMC;
	}
	
	
	
	
	
}
