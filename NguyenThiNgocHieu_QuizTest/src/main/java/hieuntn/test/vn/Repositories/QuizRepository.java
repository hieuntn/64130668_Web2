package hieuntn.test.vn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hieuntn.test.vn.Model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

}
