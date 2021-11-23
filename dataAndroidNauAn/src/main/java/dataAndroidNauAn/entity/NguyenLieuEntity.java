package dataAndroidNauAn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nguyenLieu")
public class NguyenLieuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String ten;
	
	@Column(name = "dinhLuong")
	private String dinhLuong;
	
	@ManyToOne
	@JoinColumn(name = "mon")
	private MonAnEntity monNL;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDinhLuong() {
		return dinhLuong;
	}

	public void setDinhLuong(String dinhLuong) {
		this.dinhLuong = dinhLuong;
	}

	public MonAnEntity getMon() {
		return monNL;
	}

	public void setMon(MonAnEntity mon) {
		this.monNL = mon;
	}
	
	
	
}
