package hieuntn.edu.vn.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "detaikh")
public class DeTaiKH {

    @Id
    @Column(name = "DETAI_ID", length = 50)
    private String id;

    @Column(name = "TENDETAI", length = 300)
    private String tenDeTai;

    @Column(name = "CAPDETAI", length = 100)
    private String capDeTai;

    @Column(name = "DONVICHUTRI", length = 100)
    private String donViChuTri;

    @Column(name = "MUCTIEU", columnDefinition = "TEXT")
    private String mucTieu;

    @Column(name = "NOIDUNG", columnDefinition = "TEXT")
    private String noiDung;

    @Column(name = "KETQUA", columnDefinition = "TEXT")
    private String ketQua;

    @Column(name = "NAMBATDAU")
    @Temporal(TemporalType.DATE)
    private Date namBatDau;

    @Column(name = "NAMKETTHUC")
    @Temporal(TemporalType.DATE)
    private Date namKetThuc;

    @Column(name = "TINHTRANG", length = 100)
    private String tinhTrang;

    @Column(name = "XEPLOAI", length = 50)
    private String xepLoai;

    @ManyToMany(mappedBy = "nkh_nghiencuu")
    @JsonBackReference
    private Set<NKH> nghienCuu = new HashSet<>();

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
    public Set<NKH> getNghienCuu() { return nghienCuu; }
    public void setNghienCuu(Set<NKH> nghienCuu) { this.nghienCuu = nghienCuu; }
}