package hieuntn.edu.vn.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tapchikh_htkh")
public class TapChiKH {

    @Id
    @Column(name = "TAPCHI_ID", length = 20)
    private String tapChiId;

    @Column(name = "TEN_TAPCHI", length = 255)
    private String tenTapChi;

    @Column(name = "TOCHUC", length = 200)
    private String toChuc;

    @Column(name = "PHAMVI", length = 200)
    private String phamVi;

    @Column(name = "MUCCHATLUONG", length = 200)
    private String mucChatLuong;

    @Column(name = "NAM_DANG")
    @Temporal(TemporalType.DATE)
    private Date namDang;

    // Constructors
    public TapChiKH() {
    }

    public TapChiKH(String tapChiId, String tenTapChi, String toChuc, String phamVi, String mucChatLuong, Date namDang) {
        this.tapChiId = tapChiId;
        this.tenTapChi = tenTapChi;
        this.toChuc = toChuc;
        this.phamVi = phamVi;
        this.mucChatLuong = mucChatLuong;
        this.namDang = namDang;
    }

    // Getters and Setters
    public String getTapChiId() {
        return tapChiId;
    }

    public void setTapChiId(String tapChiId) {
        this.tapChiId = tapChiId;
    }

    public String getTenTapChi() {
        return tenTapChi;
    }

    public void setTenTapChi(String tenTapChi) {
        this.tenTapChi = tenTapChi;
    }

    public String getToChuc() {
        return toChuc;
    }

    public void setToChuc(String toChuc) {
        this.toChuc = toChuc;
    }

    public String getPhamVi() {
        return phamVi;
    }

    public void setPhamVi(String phamVi) {
        this.phamVi = phamVi;
    }

    public String getMucChatLuong() {
        return mucChatLuong;
    }

    public void setMucChatLuong(String mucChatLuong) {
        this.mucChatLuong = mucChatLuong;
    }

    public Date getNamDang() {
        return namDang;
    }

    public void setNamDang(Date namDang) {
        this.namDang = namDang;
    }
}
