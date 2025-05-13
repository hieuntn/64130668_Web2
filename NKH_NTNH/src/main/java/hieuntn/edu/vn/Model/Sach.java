package hieuntn.edu.vn.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sach") 
public class Sach {

    @Id
    @Column(name = "SACH_ID")
    private String sachId;

    @Column(name = "TEN_SACH")
    private String tenSach;

    @Column(name = "LOAI_SACH")
    private String loaiSach;

    @Column(name = "NAM_XUAT_BAN")
    @Temporal(TemporalType.DATE)
    private Date namXuatBan;

    @Column(name = "NHA_XUAT_BAN", length = 200)
    private String nhaXuatBan;
    
    @ManyToMany(mappedBy = "tacgia")
    @JsonBackReference
    private Set<NKH> tacGia = new HashSet<>();
    // Constructors
    public Sach() {
    }

    public Sach(String sachId, String tenSach, String loaiSach, Date namXuatBan, String nhaXuatBan) {
        this.sachId = sachId;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
    }

    // Getters and Setters
    public String getSachId() {
        return sachId;
    }

    public void setSachId(String sachId) {
        this.sachId = sachId;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public Date getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(Date namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
    public Set<NKH> getTacGia() {
        return tacGia;
    }

    public void setTacGia(Set<NKH> tacGia) {
        this.tacGia = tacGia;
    }
}