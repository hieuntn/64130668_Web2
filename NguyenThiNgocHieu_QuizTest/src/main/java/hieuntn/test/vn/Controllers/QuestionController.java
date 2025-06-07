package hieuntn.test.vn.Controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hieuntn.test.vn.Model.Question;
import hieuntn.test.vn.Service.QuestionService;
@Controller
public class QuestionController {
	@Autowired
    private QuestionService questionService;

    @GetMapping("/question/create")
    public String showCreateQuestionForm(Model model) {
        model.addAttribute("quizzes", questionService.getAllQuizzes());
        return "question_create";
    }

    @PostMapping("/question/create")
    public String createQuestion(
            @RequestParam("quizId") String quizId,
            @RequestParam("question") String question,
            @RequestParam("marks") BigDecimal marks,
            @RequestParam("options") List<String> options,
            @RequestParam("correctAnswerIndex") int correctAnswerIndex) {
        questionService.createQuestion(quizId, question, marks, options, correctAnswerIndex);
        return "redirect:/admin";
    }
    
    @GetMapping("/question/{quizId}")
    public String showQuizById(@PathVariable String quizId, Model model) {
        List<Question> questions = questionService.getQuestionsByQuizId(quizId);
        model.addAttribute("questions", questions);
        model.addAttribute("quizId", quizId);
        return "question";
    }
    // xóa 1 câu hỏi 
    @PostMapping("/question/delete/{questionId}")
    public String deleteQuestion(@PathVariable Integer questionId, @RequestParam String quizId) {
        questionService.deleteQuestion(questionId);
        return "redirect:/question/" + quizId;
    }
    
    // hiện đáp án sau khi kiểm tra
    @GetMapping("/result/{quizId}")
    public String showResult(@PathVariable String quizId, Model model) {
        List<Question> questions = questionService.getQuestionsByQuizId(quizId);
        model.addAttribute("questions", questions);
        model.addAttribute("quizId", quizId);
        return "question_result"; 
    }

}
