package hieuntn.test.vn.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hieuntn.test.vn.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findByQuizQuizID(String quizID);
}
