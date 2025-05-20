package hieuntn.test.vn.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hieuntn.test.vn.Model.Option;

public interface OptionRepository extends JpaRepository<Option, Integer> {
    List<Option> findByQuestionQuestionId(Integer questionId);

}
