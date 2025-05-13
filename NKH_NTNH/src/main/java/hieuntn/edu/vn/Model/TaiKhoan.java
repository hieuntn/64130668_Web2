package hieuntn.edu.vn.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @Column(name = "TENTAIKHOAN")
    private String tenTaiKhoan;

    @Column(name = "MATKHAU")
    private String matKhau; 
    
    @Column(name="LOAITAIKHOAN")
    private String loaiTK;
    // Constructors
    public TaiKhoan() {}

    public TaiKhoan(String tenTaiKhoan, String matKhau,String loaiTK) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
    }

    // Getters va  Setters
    public String getTenTaiKhoan() { 
    	return tenTaiKhoan; 
    	}
    public void setTenTaiKhoan(String tenTaiKhoan) {
    	this.tenTaiKhoan = tenTaiKhoan; 
    	}

    public String getMatKhau() { 
    	return matKhau; 
    	}
    public void setMatKhau(String matKhau) {
    	this.matKhau = matKhau; 
    	}
    
    public String getLoaiTK() {
    	return loaiTK;
    }
    public void setLoaiTK(String loaiTK) {
    	this.loaiTK= loaiTK;
    }
}