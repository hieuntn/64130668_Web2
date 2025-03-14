package hieuntn.edu.SB.models;

public class SinhVien {

	     String mssv;
	     String hoTen;
	     int namSinh;
	     String gioiTinh;
	    
	   
	    
	    public SinhVien(String mssv, String hoTen, int namSinh, String gt) {
	        this.mssv = mssv;
	        this.hoTen = hoTen;
	        this.namSinh = namSinh;
	        this.gioiTinh = gt;
	    }
	    
	    // Getters and Setters
	    public String getMssv() {
	        return mssv;
	    }
	    
	    public void setMssv(String mssv) {
	        this.mssv = mssv;
	    }
	    
	    public String getHoTen() {
	        return hoTen;
	    }
	    
	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }
	    
	    public int getNamSinh() {
	        return namSinh;
	    }
	    
	    public void setNamSinh(int namSinh) {
	        this.namSinh = namSinh;
	    }
	    
	    public String getGioiTinh() {
	        return gioiTinh;
	    }
	    
	    public void setGioiTinh(String gioiTinh) {
	        this.gioiTinh = gioiTinh;
	    }
	}


