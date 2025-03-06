package hieuntn.edu.SB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/hieuntn")
	public String StudentInfo(ModelMap model) {
		model.addAttribute("mssv","64130668");
		model.addAttribute("hoTen","Nguyễn Thị Ngọc Hiếu");
		model.addAttribute("namSinh","2004");
		model.addAttribute("gt","Nữ");
		return "infor";
	}
	
}
