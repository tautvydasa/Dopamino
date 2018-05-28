package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class CourseSection
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	private String name;
	
	private String description;
	
	private int weight;

	private String badges;

	@OneToOne
	private CourseSection previousSection;

	@OneToOne
	private CourseSection nextSection;

	@ManyToOne(cascade = CascadeType.ALL)
    private Course course;

	@OneToMany(mappedBy = "courseSection")
	private List<Result> results;

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "courseSection")
	private List<Question> questions;
}
