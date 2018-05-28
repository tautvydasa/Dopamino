package lt.dopamino.gamifiedcourse.Model.Repository;

import lt.dopamino.gamifiedcourse.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    @Query("select coalesce(max(m.mark), 0) from Result m where m.courseSection.id = ?1 and m.student.id = ?2")
    double getBestSectionMark(int courseSectionId, int studentId);

    @Query("select count(distinct m.courseSection) from Result m where m.course.id = ?1 and m.student.id = ?2")
    Integer getDoneTestCount(int courseId, int studentId);
}
