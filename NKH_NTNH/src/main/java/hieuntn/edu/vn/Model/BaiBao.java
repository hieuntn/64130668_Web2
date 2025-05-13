package hieuntn.edu.vn.Model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Table(name = "baibao")
public class BaiBao {

    @Id
    @Column(name = "BAIBAO_ID")
    private String baiBaoId;

    @OneToOne
    @JoinColumn(name = "TAPCHI_ID", referencedColumnName = "TAPCHI_ID")
    private TapChiKH tapChi;

    @Column(name = "TENBAIBAO")
    private String tenBaiBao;

    @Column(name = "LINHVUC")
    private String linhVuc;

    @Column(name = "NOIXUATBAN")
    private String noiXuatBan;

    @Column(name = "NAMDANG")
    private Date namDang;

    @Column(name = "LIENKET", length = 100)
    private String lienKet;
    
    @ManyToMany(mappedBy = "baiBaoSangTac")
    @JsonBackReference
    private Set<NKH> sanXuat = new HashSet<>();

    // Constructors
    public BaiBao() {}

    public BaiBao(String baiBaoId, TapChiKH tapChi, String tenBaiBao, String linhVuc, 
                 String noiXuatBan, Date namDang, String lienKet) {
        this.baiBaoId = baiBaoId;
        this.tapChi = tapChi;
        this.tenBaiBao = tenBaiBao;
        this.linhVuc = linhVuc;
        this.noiXuatBan = noiXuatBan;
        this.namDang = namDang;
        this.lienKet = lienKet;
    }

    // Getters and Setters
    public String getBaiBaoId() {
        return baiBaoId;
    }

    public void setBaiBaoId(String baiBaoId) {
        this.baiBaoId = baiBaoId;
    }

    public TapChiKH getTapChi() {
        return tapChi;
    }

    public void setTapChi(TapChiKH tapChi) {
        this.tapChi = tapChi;
    }

    public String getTenBaiBao() {
        return tenBaiBao;
    }

    public void setTenBaiBao(String tenBaiBao) {
        this.tenBaiBao = tenBaiBao;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getNoiXuatBan() {
        return noiXuatBan;
    }

    public void setNoiXuatBan(String noiXuatBan) {
        this.noiXuatBan = noiXuatBan;
    }

    public Date getNamDang() {
        return namDang;
    }

    public void setNamDang(Date namDang) {
        this.namDang = namDang;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }
    public Set<NKH> getSanXuat() {
        return sanXuat;
    }

    public void setSanXuat(Set<NKH> sanXuat) {
        this.sanXuat = sanXuat;
    }
}