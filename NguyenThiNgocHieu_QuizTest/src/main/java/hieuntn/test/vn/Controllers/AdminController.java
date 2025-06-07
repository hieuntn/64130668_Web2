package hieuntn.test.vn.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import hieuntn.test.vn.Service.QuizService;

@Controller
public class AdminController {
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/admin")
    public String getAllQuizzes(Model model) {
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        return "admin_page";
    }

    
	 
	

}
