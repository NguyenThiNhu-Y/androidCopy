package dataAndroidNauAn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "passWord")
	private String passWord;
	
	@Column(name = "anh")
	private String anh;
	
	@Column(name = "hoTen")
	private String hoTen;
	
	@Column(name = "ngaySinh")
	private Date ngaySinh;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gioiTinh")
	private String gioiTinh;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column
	private int status;
	
	@OneToMany(mappedBy = "userYT")
	private List<YeuThichEntity> listYeuThich = new ArrayList<>();
	
	@OneToMany(mappedBy = "userTB")
	private List<ThongBaoEntity> listThongBao = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<YeuThichEntity> getListYeuThich() {
		return listYeuThich;
	}

	public void setListYeuThich(List<YeuThichEntity> listYeuThich) {
		this.listYeuThich = listYeuThich;
	}

	public List<ThongBaoEntity> getListThongBao() {
		return listThongBao;
	}

	public void setListThongBao(List<ThongBaoEntity> listThongBao) {
		this.listThongBao = listThongBao;
	}
	
	
	
	
}
