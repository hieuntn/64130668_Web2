package hieuntn.edu.vn.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "nkh")
public class NKH {

    @Id
    @Column(name = "NKH_ID")
    private int nkhId;

    @ManyToOne
    @JoinColumn(name = "TENTAIKHOAN", referencedColumnName = "TENTAIKHOAN")
    private TaiKhoan taiKhoan;

    @Column(name = "HOTEN")
    private String hoTen;

    @Column(name = "GIOITINH")
    private String gioiTinh;

    @Column(name = "NAMSINH")
    private int namSinh;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "HOCVI")
    private String hocVi;

    @Column(name = "NGANHDAOTAO")
    private String nganhDaoTao;

    @Column(name = "LINHVUCNGHIENCUU")
    private String linhVucNghienCuu;

    @Column(name = "CHUYENMON")
    private String chuyenMon;

    @Column(name = "HINHANH")
    private String hinhAnh;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "nghiencuu",
        joinColumns = @JoinColumn(name = "NKH_ID"),
        inverseJoinColumns = @JoinColumn(name = "DETAI_ID")
    )
    @JsonManagedReference
    
    private List<DeTaiKH> nkh_nghiencuu = new ArrayList<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "tacgiasach",
        joinColumns = @JoinColumn(name = "NKH_ID"),
        inverseJoinColumns = @JoinColumn(name = "SACH_ID")
    )
    @JsonManagedReference
    private Set<Sach> tacgia = new HashSet<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "sangtac",
        joinColumns = @JoinColumn(name = "NKH_ID"),
        inverseJoinColumns = @JoinColumn(name = "TENBAIBAO_ID")
    )
    @JsonManagedReference
    private Set<BaiBao> baiBaoSangTac = new HashSet<>();    
    // Getters and Setters
    public int getNkhId() { return nkhId; }
    public void setNkhId(int nkhId) { this.nkhId = nkhId; }
    public TaiKhoan getTaiKhoan() { return taiKhoan; }
    public void setTaiKhoan(TaiKhoan taiKhoan) { this.taiKhoan = taiKhoan; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
    public int getNamSinh() { return namSinh; }
    public void setNamSinh(int namSinh) { this.namSinh = namSinh; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getHocVi() { return hocVi; }
    public void setHocVi(String hocVi) { this.hocVi = hocVi; }
    public String getNganhDaoTao() { return nganhDaoTao; }
    public void setNganhDaoTao(String nganhDaoTao) { this.nganhDaoTao = nganhDaoTao; }
    public String getLinhVucNghienCuu() { return linhVucNghienCuu; }
    public void setLinhVucNghienCuu(String linhVucNghienCuu) { this.linhVucNghienCuu = linhVucNghienCuu; }
    public String getChuyenMon() { return chuyenMon; }
    public void setChuyenMon(String chuyenMon) { this.chuyenMon = chuyenMon; }
    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }
//    public Set<DeTaiKH> getNkh_nghiencuu() { return nkh_nghiencuu; }
//    public void setNkh_nghiencuu(Set<DeTaiKH> nkh_nghiencuu) { this.nkh_nghiencuu = nkh_nghiencuu != null ? nkh_nghiencuu: new HashSet<>(); }
    public List<DeTaiKH> getNkh_nghiencuu() {
        return nkh_nghiencuu;
    }

    // Setter
    public void setNkh_nghiencuu(List<DeTaiKH> nkh_nghiencuu) {
        this.nkh_nghiencuu = nkh_nghiencuu;
    }
    public Set<Sach> getTacGia(){return tacgia;}
    public void setTacGia(Set<Sach> tacgia) {this.tacgia = tacgia;}
    
    public Set<BaiBao> getBaiBaoSangTac() {
        return baiBaoSangTac;
    }

    public void setBaiBaoSangTac(Set<BaiBao> baiBaoSangTac) {
        this.baiBaoSangTac = baiBaoSangTac;
    }
   
    
    public int getTongSoDeTai() {
        return nkh_nghiencuu.size();
    }
    public int getTongSach(){
    	return tacgia.size();
    }
    public int getTongBaiBao() {
    	return baiBaoSangTac.size();
    }
    
}