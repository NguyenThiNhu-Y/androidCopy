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
@Table(name = "anhCongThuc")
public class AnhCongThucEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String anh;
	
	@ManyToOne
	@JoinColumn(name = "congThuc")
	private CongThucEntity cThuc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public CongThucEntity getcThuc() {
		return cThuc;
	}

	public void setcThuc(CongThucEntity cThuc) {
		this.cThuc = cThuc;
	}
	
	
}
