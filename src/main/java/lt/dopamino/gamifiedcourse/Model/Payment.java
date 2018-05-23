/**
 * @(#) Payment.java
 */

package lt.dopamino.gamifiedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Payment
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Date date;
	
	private double sum;
	
	private int points;

	@ManyToOne
	private Student student;
	
	
}
