package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student extends User
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	private int points;

	@OneToMany(mappedBy = "student")
	private List<StudentCourse> studentCourses;
}
