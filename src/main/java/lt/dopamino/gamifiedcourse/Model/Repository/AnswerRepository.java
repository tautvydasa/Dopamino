package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select m from Answer m where m.question.id = ?1")
    List<Answer> getAnswerssById(int id);
}
