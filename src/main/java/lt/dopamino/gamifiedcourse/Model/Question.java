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

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "question")
	private List<Answer> answers;

	@ManyToOne(cascade = CascadeType.ALL)
	private CourseSection courseSection;
}
