package garage.com.webapp.entities;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

//OneToMany (role --- Person)

@Entity
@Table(name="roles")
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_role;
	private String name;
	
	public Roles() {}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<Person>persons;
	*/
	

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{return name;}

}
