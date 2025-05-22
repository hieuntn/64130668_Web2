package hieuntn.edu.vn.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hieuntn.edu.vn.Model.CongTrinh;
import hieuntn.edu.vn.Model.DeTaiKH;
import hieuntn.edu.vn.Services.CongTrinhService;

@Controller
public class CongTrinhController {
	@Autowired
	private CongTrinhService ctService;
	
	@GetMapping("/congtrinh")
	public String getAllCongTrinh(Model model) {
		model.addAttribute("congTrinhList",ctService.getAllCongTrinh());
		return "congtrinh_list";
	}
	@GetMapping("/congtrinh/add")
    public String showAddForm(Model model) {
        model.addAttribute("congTrinh", new CongTrinh());
        model.addAttribute("nkhList", ctService.getAllNKH());
        return "congtrinh_add";
    }
	
    @PostMapping("/congtrinh/add")
    public String addCongTrinh(@ModelAttribute("congTrinh") CongTrinh congTrinh,
                               @RequestParam(value = "nkhIds", required = false) List<Integer> nkhIds) {
        ctService.saveCongTrinh(congTrinh, nkhIds);
        return "redirect:/congtrinh";
    }
    
    
    @GetMapping("/congtrinh/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        CongTrinh congTrinh = ctService.getCongTrinhById(id).orElse(null);
        
        if (congTrinh != null) {
            model.addAttribute("congTrinh", congTrinh);
            model.addAttribute("nkhList", ctService.getAllNKH());
            return "congtrinh_edit";
        } else {
            
            return "redirect:/congtrinh";
        }
    }

    @PostMapping("/congtrinh/edit/{id}")
    public String updateDeTaiKH(@PathVariable("id") String id,
                               @ModelAttribute("congTrinh") CongTrinh congTrinh,
                               @RequestParam(value = "nkhIds", required = false) List<Integer> nkhIds) {
        congTrinh.setCongTrinhID(id); 
        ctService.updateCongTrinh(congTrinh, nkhIds);
        return "redirect:/congtrinh";
    }
    // chức năng tìm kiếm
    
    @GetMapping("/congtrinh/search")
    public String traCuuCongTrinh(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<CongTrinh> congTrinhList = ctService.timKiemCongTrinh(keyword);
        model.addAttribute("congTrinhList",congTrinhList);
        model.addAttribute("keyword", keyword);
        return "congtrinh_list"; 
    }
    
 // Chức năng xóa 1 công trình
    @GetMapping("congtrinh/delete/{id}")
    public String deleteProject(@PathVariable String id, Model model) {
            ctService.deleteCongTrinh(id);
            model.addAttribute("congTrinhList", ctService.getAllProjects());
        return "redirect:/congtrinh";
    }
    
}
	


