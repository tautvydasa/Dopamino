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

	private double points;

	@OneToMany(mappedBy = "student")
	private List<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "student")
    private List<Result> results;

    @OneToMany(mappedBy = "student")
    private List<Post> posts;

    @OneToMany(mappedBy = "student")
    private List<Comment> comments;

    @OneToMany(mappedBy = "student")
    private List<Payment> payments;
}
