package dataAndroidNauAn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "monAn")
public class MonAnEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tenMon")
	private String tenMon;
	
	@Column(name = "anh")
	private String anh;
	
	@Column(name = "maMon")
	private String maMon;
	
	@Column(name = "nguoiDang")
	private String nguoiDang;
	
	@Column(name = "luotXem")
	private int luotXem;
	
	@Column(name = "luotThich")
	private int luotThich;
	
	@ManyToOne
	@JoinColumn(name = "maDM")
	private DanhMucEntity dMuc;
	
	@OneToMany(mappedBy = "monNL")
	private List<NguyenLieuEntity> listNguyenLieu = new ArrayList<>();
	
	@OneToMany(mappedBy = "monCT")
	private List<CongThucEntity> listCongThuc = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public DanhMucEntity getdMuc() {
		return dMuc;
	}

	public void setdMuc(DanhMucEntity dMuc) {
		this.dMuc = dMuc;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public List<NguyenLieuEntity> getListNguyenLieu() {
		return listNguyenLieu;
	}

	public void setListNguyenLieu(List<NguyenLieuEntity> listNguyenLieu) {
		this.listNguyenLieu = listNguyenLieu;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public List<CongThucEntity> getListCongThuc() {
		return listCongThuc;
	}

	public void setListCongThuc(List<CongThucEntity> listCongThuc) {
		this.listCongThuc = listCongThuc;
	}

	public String getNguoiDang() {
		return nguoiDang;
	}

	public void setNguoiDang(String nguoiDang) {
		this.nguoiDang = nguoiDang;
	}

	public int getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}

	public int getLuotThich() {
		return luotThich;
	}

	public void setLuotThich(int luotThich) {
		this.luotThich = luotThich;
	}

	
	
	
	
	
	
}
