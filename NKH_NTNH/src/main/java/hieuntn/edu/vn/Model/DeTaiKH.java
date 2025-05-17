package hieuntn.edu.vn.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detaikh")
public class DeTaiKH {

    @Id
    @Column(name = "DETAI_ID")
    private String id;

    @Column(name = "TENDETAI")
    private String tenDeTai;

    @Column(name = "CAPDETAI")
    private String capDeTai;

    @Column(name = "DONVICHUTRI") 
    private String donViChuTri;

    @Column(name = "MUCTIEU", columnDefinition = "TEXT")
    private String mucTieu;

    @Column(name = "NOIDUNG", columnDefinition = "TEXT")
    private String noiDung;

    @Column(name = "KETQUA", columnDefinition = "TEXT")
    private String ketQua;

    @Column(name = "NAMBATDAU")
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date namBatDau;

    @Column(name = "NAMKETTHUC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date namKetThuc;

    @Column(name = "TINHTRANG")
    private String tinhTrang;

    @Column(name = "XEPLOAI")
    private String xepLoai;

    @ManyToMany(mappedBy = "nkh_nghiencuu")
    @JsonBackReference
    private List<NKH> nghienCuu = new ArrayList<>();

    // Constructors
    public DeTaiKH() {}

    public DeTaiKH(String id, String tenDeTai, String capDeTai, String donViChuTri,
                   String mucTieu, String noiDung, String ketQua, Date namBatDau,
                   Date namKetThuc, String tinhTrang, String xepLoai) {
        this.id = id;
        this.tenDeTai = tenDeTai;
        this.capDeTai = capDeTai;
        this.donViChuTri = donViChuTri;
        this.mucTieu = mucTieu;
        this.noiDung = noiDung;
        this.ketQua = ketQua;
        this.namBatDau = namBatDau;
        this.namKetThuc = namKetThuc;
        this.tinhTrang = tinhTrang;
        this.xepLoai = xepLoai;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTenDeTai() { return tenDeTai; }
    public void setTenDeTai(String tenDeTai) { this.tenDeTai = tenDeTai; }
    public String getCapDeTai() { return capDeTai; }
    public void setCapDeTai(String capDeTai) { this.capDeTai = capDeTai; }
    public String getDonViChuTri() { return donViChuTri; }
    public void setDonViChuTri(String donViChuTri) { this.donViChuTri = donViChuTri; }
    public String getMucTieu() { return mucTieu; }
    public void setMucTieu(String mucTieu) { this.mucTieu = mucTieu; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public String getKetQua() { return ketQua; }
    public void setKetQua(String ketQua) { this.ketQua = ketQua; }
    public Date getNamBatDau() { return namBatDau; }
    public void setNamBatDau(Date namBatDau) { this.namBatDau = namBatDau; }
    public Date getNamKetThuc() { return namKetThuc; }
    public void setNamKetThuc(Date namKetThuc) { this.namKetThuc = namKetThuc; }
    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }
    public String getXepLoai() { return xepLoai; }
    public void setXepLoai(String xepLoai) { this.xepLoai = xepLoai; }
    public List<NKH> getNghienCuu() {
        return nghienCuu;
    }

    public void setNghienCuu(List<NKH> nghienCuu) {
        this.nghienCuu = nghienCuu;
    }


}