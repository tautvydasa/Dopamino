/**
 * @(#) User.java
 */

package lt.dopamino.gamifiedcourse.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String slapyvardis;

	private String elpastas;

	private String slaptazodis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlapyvardis() {
		return slapyvardis;
	}

	public void setSlapyvardis(String slapyvardis) {
		this.slapyvardis = slapyvardis;
	}

	public String getElpastas() {
		return elpastas;
	}

	public void setElpastas(String elpastas) {
		this.elpastas = elpastas;
	}

	public String getSlaptazodis() {
		return slaptazodis;
	}

	public void setSlaptazodis(String slaptazodis) {
		this.slaptazodis = slaptazodis;
	}


	//-------------------------------------------------------------
	public void selectPermissions( )
	{
		
	}
	
	public void selectUsersData( )
	{
		
	}
	
	public void selectUserData( )
	{
		
	}
	
	public void selectUserList( )
	{
		
	}
	
	public void updatePermissionsData( )
	{
		
	}
	
	public void selectPoints( )
	{
		
	}
	
	public void removePoints( )
	{
		
	}
	
	public void insertRegisterData( )
	{
		
	}
	
	public void updateUserData( )
	{
		
	}
	
	
}
