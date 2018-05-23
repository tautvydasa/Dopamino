/**
 * @(#) Question.java
 */

package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String text;

	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	@ManyToOne
	private CourseSection courseSection;
}
