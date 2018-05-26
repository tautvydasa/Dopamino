package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("select m from Question m where m.courseSection.id = ?1")
    List<Question> getQuestionsById(int id);
}
