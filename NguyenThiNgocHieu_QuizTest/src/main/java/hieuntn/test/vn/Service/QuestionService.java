package hieuntn.test.vn.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hieuntn.test.vn.Model.Option;
import hieuntn.test.vn.Model.Question;
import hieuntn.test.vn.Model.Quiz;

import hieuntn.test.vn.Repositories.QuestionRepository;
import hieuntn.test.vn.Repositories.QuizRepository;

@Service
public class QuestionService {
	@Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    
   
    public Question createQuestion(String quizId, String questionName, BigDecimal marks, List<String> options, int correctAnswerIndex) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        Question question = new Question();
        question.setQuestionName(questionName);
        question.setQuestionMark(marks);
        question.setQuiz(quiz);

        List<Option> optionList = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            Option option = new Option();
            option.setOptionName(options.get(i));
            option.setRightAnswer(i == correctAnswerIndex);
            option.setQuestion(question);
            optionList.add(option);
        }
        question.setOptions(optionList);

        return questionRepository.save(question);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
    public List<Question> getQuestionsByQuizId(String quizId) {
        return questionRepository.findByQuizQuizID(quizId);
    }
    
    public void deleteQuestion(Integer questionId) {
        if (!questionRepository.existsById(questionId)) {
            throw new IllegalArgumentException("Câu hỏi không tồn tại với ID: " + questionId);
        }
        questionRepository.deleteById(questionId);
    }
    public void updateQuestion(Integer questionId, Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Câu hỏi không tồn tại với ID: " + questionId));
        
        existingQuestion.setQuestionName(updatedQuestion.getQuestionName());
        existingQuestion.setQuestionMark(updatedQuestion.getQuestionMark());

        // Cập nhật danh sách options
        existingQuestion.getOptions().clear();
        for (Option option : updatedQuestion.getOptions()) {
            option.setQuestion(existingQuestion);
            existingQuestion.getOptions().add(option);
        }

        questionRepository.save(existingQuestion);
    }
}
