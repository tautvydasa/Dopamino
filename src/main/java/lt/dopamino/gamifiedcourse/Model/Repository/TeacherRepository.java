package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Course;
import lt.dopamino.gamifiedcourse.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("select m from Teacher m where m.student.id = ?1")
    Teacher getTeacherByStudentId(int id);
}
