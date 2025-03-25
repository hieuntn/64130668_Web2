package hieuntn.edu.kt.Model;

public class SinhVien {
		String mSSV;
		String hoTen;
		float diemTB;
		    // Constructor
		    public SinhVien(String mSSV, String hoTen, float diemTB) {
		        this.mSSV = mSSV;
		        this.hoTen = hoTen;
		        this.diemTB = diemTB;
		    }

		    
		    public String getMSSV() {
		        return mSSV;
		    }

		    public void setMSSV(String mSSV) {
		        this.mSSV = mSSV;
		    }

		    
		    public String getHoTen() {
		        return hoTen;
		    }

		    public void setHoTen(String hoTen) {
		        this.hoTen = hoTen;
		    }

		    
		    public float getDiemTB() {
		        return diemTB;
		    }

		    public void setDiemTB(float diemTB) {
		        this.diemTB = diemTB;
		    }

		
}
