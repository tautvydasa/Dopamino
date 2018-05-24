package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Course;
import lt.dopamino.gamifiedcourse.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    //@Query("select c from Course c join c.studentCourses sc join sc.")
    //List<Course> findCoursesByStudentId(int studentId);

    List<Course> findAll();
}
