package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StudentCourse
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private double progress;
	
	private double evaluation;
	
	private boolean isEvaluated;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Course course;
}
