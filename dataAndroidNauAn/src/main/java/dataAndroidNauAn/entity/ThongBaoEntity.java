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
@Table(name = "thongBao")
public class ThongBaoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "noiDung")
	private String noiDung;
	
	@Column(name = "maMon")
	private Long maMon; 
	
	@Column
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private UserEntity userTB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public UserEntity getUserTB() {
		return userTB;
	}

	public void setUserTB(UserEntity userTB) {
		this.userTB = userTB;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getMaMon() {
		return maMon;
	}

	public void setMaMon(Long maMon) {
		this.maMon = maMon;
	}

	

	
	
	
	
	
}
