package hieuntn.test.vn.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import hieuntn.test.vn.Model.Quiz;
import hieuntn.test.vn.Service.QuizService;

@Controller
public class QuizController {
	@Autowired
	private QuizService quizService;
	// hiện thị danh sách quiz
	@GetMapping("/quiz")
	public String getAllQuizzes(Model model) {
		model.addAttribute("quizzes", quizService.getAllQuizzes());
		return "quiz_list";
	}
	// Hiển thị câu hỏi trắc nghiệm của Quiz đã chọn
    @GetMapping("/quiz/questions")
    public String showQuizQuestions(@RequestParam("quizId") String quizId, Model model) {
        Map<String, Object> quizData = quizService.getQuizQuestions(quizId);
        model.addAttribute("quizId", quizId);
        model.addAttribute("questions", quizData.get("questions"));
        model.addAttribute("questionOptions", quizData.get("questionOptions"));
        return "quiz_question";
    }
    @PostMapping("/check/{quizId}")
    public String checkQuiz(@PathVariable String quizId, 
                           @RequestParam Map<String, String> answers, 
                           Model model) {
        Map<String, Object> result = quizService.checkQuiz(quizId, answers);
        model.addAttribute("quizId", quizId);
        model.addAttribute("result", result);
        return "result";
    }
    // tạo 1 quiz
    @GetMapping("/quiz/create")
    public String showCreateQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "quiz_create";
    }
    
    @PostMapping("/quiz/create")
    public String createQuiz(@ModelAttribute("quiz") Quiz quiz) {
        quizService.createQuiz(quiz);
        return "redirect:/quiz"; 
    
    }
}
