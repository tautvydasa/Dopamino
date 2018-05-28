package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.CourseSection;
import lt.dopamino.gamifiedcourse.Model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    @Query("select m from StudentCourse m where m.student.id = ?1")
    List<StudentCourse> getStudentCourseById(int id);

    @Query("select m from StudentCourse m where m.student.id = ?1 and m.course.id = ?2")
    StudentCourse checkIfAlreadyPurchased(int id, int id2);

    StudentCourse findById(int id);

    @Query("select m from StudentCourse m where m.course.id = ?1 order by m.progress desc")
    List<StudentCourse> getStudentCoursesByCourseId(int id);
}