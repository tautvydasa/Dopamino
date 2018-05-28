/**
 * @(#) Comment.java
 */

package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Comment
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String text;
	
	private Date date;
	
	@ManyToOne
	private Student student;

	@ManyToOne(cascade = CascadeType.ALL)
	private Post post;
}
