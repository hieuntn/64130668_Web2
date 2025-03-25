package hieuntn.edu.kt.Controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hieuntn.edu.kt.Model.SinhVien;

import org.springframework.ui.ModelMap;
@ Controller
public class OnTapGiuaKi {
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	 static List<SinhVien> dsSV = new ArrayList<SinhVien>();
	 static{
		 dsSV.add(new SinhVien("001","Nguyễn Văn Nam",8.0f));
		 dsSV.add(new SinhVien("002","Nguyễn Hoài Thu",7.0f));
		 dsSV.add(new SinhVien("003","Nguyễn Văn Tuấn",8.5f));
		 dsSV.add(new SinhVien("004","Nguyễn Trần Văn Minh",7.0f));
		 dsSV.add(new SinhVien("005","Trần Trung Quân",6.5f));
	 }
	@GetMapping("/studentList")
	public String listSV(ModelMap m) {
		m.addAttribute("dsSinhVien",dsSV);
		return "listSV";
		
	}
	@GetMapping("/addNew")
	public String formAddNew(ModelMap m) {
	    SinhVien sv = new SinhVien();
	    m.addAttribute("sinhVienMoi", sv); 
	    return "form";
	}

	@PostMapping("/addNew")
	public String submitForm(@ModelAttribute("sinhVienMoi") SinhVien sv) {
	    dsSV.add(sv);
	    return "redirect:/studentList"; 
	}

}
