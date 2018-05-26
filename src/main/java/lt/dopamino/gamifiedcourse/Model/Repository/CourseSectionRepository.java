package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Course;
import lt.dopamino.gamifiedcourse.Model.CourseSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSectionRepository extends JpaRepository<CourseSection, Integer> {
    @Query("select m from CourseSection m where m.course.id = ?1")
    List<CourseSection> getCourseSectionsById(int id);
}
