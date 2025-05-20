package hieuntn.test.vn.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hieuntn.test.vn.Model.Option;
import hieuntn.test.vn.Model.Question;
import hieuntn.test.vn.Model.Quiz;
import hieuntn.test.vn.Repositories.OptionRepository;
import hieuntn.test.vn.Repositories.QuestionRepository;
import hieuntn.test.vn.Repositories.QuizRepository;

@Service
public class QuizService {
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
    private QuestionRepository questionRepository;
	@Autowired
    private OptionRepository optionRepository;
	
	public Optional<Quiz> getQuizById(String quizId) {
        return quizRepository.findById(quizId);
    }
	public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
	// Lấy danh sách câu hỏi và các lựa chọn của một Quiz
    public Map<String, Object> getQuizQuestions(String quizId) {
        List<Question> questions = questionRepository.findByQuizQuizID(quizId);
        Map<Integer, List<Option>> questionOptions = new HashMap<>();

        for (Question question : questions) {
            List<Option> options = optionRepository.findByQuestionQuestionId(question.getQuestionId());
            questionOptions.put(question.getQuestionId(), options);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("questions", questions);
        result.put("questionOptions", questionOptions);
        return result;
    }
    
    public Map<String, Object> checkQuiz(String quizId, Map<String, String> answers) {
        // Lấy danh sách câu hỏi
        List<Question> questions = questionRepository.findByQuizQuizID(quizId);
        
        // Lưu kết quả: câu nào đúng, sai
        Map<Integer, Boolean> userResults = new HashMap<>();
        
        // Đếm số câu đúng
        int score = 0;

        // Xem từng câu hỏi
        for (Question question : questions) {
            // Lấy đáp án người dùng chọn
            String selectedOptionId = answers.get("question_" + question.getQuestionId());
            
            // Mặc định là sai
            boolean isCorrect = false;

            // Nếu có đáp án
            if (selectedOptionId != null) {
                // Chuyển đáp án thành số
                int selectedId = Integer.parseInt(selectedOptionId);
                
                // Kiểm tra các lựa chọn của câu hỏi
                for (Option option : question.getOptions()) {
                    if (option.getOptionId() == selectedId && option.getRightAnswer()) {
                        isCorrect = true;
                        score++;
                        break; // Tìm thấy đáp án đúng, thoát vòng lặp
                    }
                }
            }

            // Lưu kết quả cho câu hỏi
            userResults.put(question.getQuestionId(), isCorrect);
        }

        // Tính tỷ lệ phần trăm
        int total = questions.size();
        double percentage = total > 0 ? (double) score / total * 100 : 0;

        // Tạo kết quả trả về
        Map<String, Object> result = new HashMap<>();
        result.put("questions", questions);
        result.put("userResults", userResults);
        result.put("score", score);
        result.put("total", total);
        result.put("percentage", String.format("%.2f", percentage)); // Định dạng 2 chữ số thập phân

        return result;
    }
	
}
