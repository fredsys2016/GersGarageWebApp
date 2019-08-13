package garage.com.webapp.entities;


import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="enginetype")
public class EngineType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_enginetype;
	private String name;
	
	public EngineType(){}
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enginetype")
	private List<Vehicle> vehicle;
		*/
	
	public int getId_enginetype() {
		return id_enginetype;
	}


	public void setId_enginetype(int id_enginetype) {
		this.id_enginetype = id_enginetype;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
	public String toString()
	{
		return name;
	}

}
