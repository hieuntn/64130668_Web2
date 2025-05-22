package hieuntn.edu.vn.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="congtrinh")
public class CongTrinh {
	@Id
	@Column(name="CONGTRINH_ID")
	private String congTrinhID;
	
	@Column(name="TENCONGTRINH")
	private String tenCongTrinh;
	
	@Column(name ="HINHTHUC")
	private String hinhThuc;
	
	@Column(name="QUYMO")
	private String quyMo;
	
	@Column(name="NOIAPDUNG")
	private String noiApDung;
	
	@Column(name="NAMBATDAU")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date namBatDau;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="NAMKETTHUC")
	private Date  namKetThuc;
	
	@ManyToMany(mappedBy = "nkh_thamgiacongtrinh")
    @JsonBackReference
    private List<NKH> thamGia = new ArrayList<>();
	
	public CongTrinh() {};
	
	public String getCongTrinhID() {
	    return congTrinhID;
	}

	public void setCongTrinhID(String congTrinhID) {
	    this.congTrinhID = congTrinhID;
	}

	public String getTenCongTrinh() {
	    return tenCongTrinh;
	}

	public void setTenCongTrinh(String tenCongTrinh) {
	    this.tenCongTrinh = tenCongTrinh;
	}

	public String getHinhThuc() {
	    return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
	    this.hinhThuc = hinhThuc;
	}

	public String getQuyMo() {
	    return quyMo;
	}

	public void setQuyMo(String quyMo) {
	    this.quyMo = quyMo;
	}

	public String getNoiApDung() {
	    return noiApDung;
	}

	public void setNoiApDung(String noiApDung) {
	    this.noiApDung = noiApDung;
	}

	public Date getNamBatDau() {
	    return namBatDau;
	}

	public void setNamBatDau(Date namBatDau) {
	    this.namBatDau = namBatDau;
	}

	public Date getNamKetThuc() {
	    return namKetThuc;
	}

	public void setNamKetThuc(Date namKetThuc) {
	    this.namKetThuc = namKetThuc;
	}

	public List<NKH> getThamGia() {
	    return thamGia;
	}

	public void setThamGia(List<NKH> thamGia) {
	    this.thamGia = thamGia;
	}

	
	
}
