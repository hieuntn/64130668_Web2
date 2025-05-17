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


import hieuntn.edu.vn.Model.DeTaiKH;
import hieuntn.edu.vn.Services.DeTaiKHService;


@Controller
public class DeTaiController {
	@Autowired
	private DeTaiKHService dtService;
	
	@GetMapping("/detai")
	public String getAllDeTaiKH(Model model) {
		model.addAttribute("deTaiKHList",dtService.getAllDeTai());
		return "deTaiList";
	}
	 @GetMapping("/detai/add")
	    public String showAddForm(Model model) {
	        model.addAttribute("deTaiKH", new DeTaiKH());
	        model.addAttribute("nkhList", dtService.getAllNKH());
	        return "create-detai";
	    }

	    @PostMapping("/detai/add")
	    public String addDeTaiKH(@ModelAttribute("deTaiKH") DeTaiKH deTaiKH,
	                             @RequestParam(value = "nkhIds", required = false) List<Integer> nkhIds) {
	    	dtService.saveDeTaiKH(deTaiKH, nkhIds);
	    	return "redirect:/detai";

	    }
	    
	    @GetMapping("/detai/edit/{id}")
	    public String showEditForm(@PathVariable("id") String id, Model model) {
	        DeTaiKH deTaiKH = dtService.getDeTaiById(id).orElse(null);
	        
	        if (deTaiKH != null) {
	            model.addAttribute("deTaiKH", deTaiKH);
	            model.addAttribute("nkhList", dtService.getAllNKH());
	            return "edit_detai";
	        } else {
	            
	            return "redirect:/detai";
	        }
	    }

	    @PostMapping("/detai/edit/{id}")
	    public String updateDeTaiKH(@PathVariable("id") String id,
	                               @ModelAttribute("deTaiKH") DeTaiKH deTaiKH,
	                               @RequestParam(value = "nkhIds", required = false) List<Integer> nkhIds) {
	        deTaiKH.setId(id); 
	        dtService.updateDeTaiKH(deTaiKH, nkhIds);
	        return "redirect:/detai";
	    }
	    @GetMapping("/detai/view/{id}")
	    public String showViewForm(@PathVariable("id") String id, Model model) {
	        DeTaiKH deTaiKH = dtService.getDeTaiById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Đề tài với ID " + id + " không tồn tại."));
	        model.addAttribute("deTaiKH", deTaiKH);
	        model.addAttribute("nkhList", dtService.getAllNKH());
	        return "view_detai";
	    }
	    // tìm kiếm theo tên đề tài khoa học 
	    @GetMapping("/detai/search")
	    public String listProjects(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
	        List<DeTaiKH> deTaiKHList = dtService.searchProjects(keyword);
	        model.addAttribute("deTaiKHList", deTaiKHList);
	        model.addAttribute("keyword", keyword);
	        return "deTaiList"; 
	    }
	    
	    // Chức năng xóa 1 đề tài
	    @GetMapping("detai/delete/{id}")
	    public String deleteProject(@PathVariable String id, Model model) {
	            dtService.deleteDeTaiKH(id);
	            model.addAttribute("deTaiList", dtService.getAllProjects());
	        return "redirect:/detai";
	    }
	   
	
}
