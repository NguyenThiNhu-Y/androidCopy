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
@Table(name = "yeuThich")
public class YeuThichEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "maMon")
	private String maMon;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private UserEntity userYT;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public UserEntity getUserYT() {
		return userYT;
	}

	public void setUserYT(UserEntity userYT) {
		this.userYT = userYT;
	}

	
	
}
