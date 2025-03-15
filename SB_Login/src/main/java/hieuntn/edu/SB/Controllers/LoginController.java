package hieuntn.edu.SB.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest; // Sử dụng cho Spring Boot 3.x

@Controller
public class LoginController {

   
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login"; 
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
       
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        
        if ("123456".equals(id) && "aztk".equals(password)) {
            
            return "redirect:/home";
        } else {
           
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login"; 
        }
    }

    // Hiển thị trang chính (home) sau khi đăng nhập thành công
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return "home"; // Trả về template home.html
    }
}