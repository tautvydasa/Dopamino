/**
 * @(#) Result.java
 */

package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Result
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private double mark;
	
	private Date date;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Course course;

	@ManyToOne
	private CourseSection courseSection;
}
