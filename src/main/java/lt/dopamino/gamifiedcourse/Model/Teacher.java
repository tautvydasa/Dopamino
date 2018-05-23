package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Teacher
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;

	@OneToOne
	private Student student;

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;
}
