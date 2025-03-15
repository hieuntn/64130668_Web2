// Controller
package hieuntn.edu.BMI.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {
    @GetMapping("/bmi")
    public String formBMI() {
        return "bmi";
    }
    
    @GetMapping("/calculate-bmi")
    public String tinhBMI(
        @RequestParam("chieuCao") double chieuCao,
        @RequestParam("canNang") double canNang,
        Model m) {
        if (chieuCao <= 0 || canNang <= 0) {
            m.addAttribute("error", "Chiều cao và cân nặng phải lớn hơn 0!!");
            return "bmi";
        }
        
        double Bmi = canNang / (chieuCao * chieuCao);
        String xepLoai;
        
        if (Bmi < 18.5) {
            xepLoai = "Gầy";
        } else if (Bmi < 25) {
            xepLoai = "Bình thường";
        } else if (Bmi < 30) {
            xepLoai = "Thừa cân";
        } else {
            xepLoai = "Béo phì";
        }
        
        m.addAttribute("Bmi", String.format("%.2f", Bmi));
        m.addAttribute("xepLoai", xepLoai);
        m.addAttribute("chieuCao", chieuCao);
        m.addAttribute("canNang", canNang);
        
        return "bmi";
    }
}