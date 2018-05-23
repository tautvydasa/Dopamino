/**
 * @(#) Answer.java
 */

package lt.dopamino.gamifiedcourse.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String text;

	private boolean isCorrect;

	@ManyToOne
	private Question question;
}
