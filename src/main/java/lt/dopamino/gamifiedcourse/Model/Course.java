package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Course
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	private String name;

    private String description;
	
	private double price;
	
	private Date date;
	
	private int voteSum;
	
	private int votersCount;
	
	private boolean isVisible;

    @ManyToOne
	private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "course")
    private List<CourseSection> courseSections;

    @OneToMany(mappedBy = "course")
    private List<Result> results;

    @OneToMany(mappedBy = "course")
    private List<Post> posts;
}
