package hieuntn.edu.SB.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import hieuntn.edu.SB.models.SinhVien; 
@Controller
public class HomeController {
	
	@GetMapping("/truyenDoiTuong")
	public String getStudentInfo(ModelMap m) {
	    SinhVien sv = new SinhVien("64130668", "Nguyễn Thị Ngọc Hiếu", 2004, "Nữ");
	    m.addAttribute("sinhVien", sv);
	    return "student"; 
	}
    @GetMapping("/truyendsObject")
    public String StudentInfo(ModelMap m) {
    
        List<SinhVien> dsSinhVien = new ArrayList<>();
        dsSinhVien.add(new SinhVien("SV01", "Đỗ Văn An", 2004, "Nam"));
        dsSinhVien.add(new SinhVien("SV02", "Trần Thị Tín", 2004, "Nữ"));
        dsSinhVien.add(new SinhVien("SV03", "Lê Văn Khải", 2004, "Nam"));
        dsSinhVien.add(new SinhVien("SV04", "Nguyễn Văn Hòa", 2004, "Nam"));
        
        m.addAttribute("dssV", dsSinhVien);
        
       
        return "infor";
    }
}