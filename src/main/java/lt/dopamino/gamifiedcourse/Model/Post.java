/**
 * @(#) Post.java
 */

package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Post
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;
	
	private String description;
	
	private Date date;

	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;

	@ManyToOne
	private Student student;

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "post")
	private List<Comment> comments;
}
