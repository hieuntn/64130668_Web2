package hieuntn.edu.vn.Controllers;

import hieuntn.edu.vn.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinhVienController {
    @Autowired
    private SinhVienService sVService;

    @GetMapping("/listSV")
    public String getAllSinhVien(Model model) {
        model.addAttribute("dsSinhVien", sVService.getAllSinhVien());
        return "sv";
    }
}