package lt.dopamino.gamifiedcourse;

import lt.dopamino.gamifiedcourse.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
