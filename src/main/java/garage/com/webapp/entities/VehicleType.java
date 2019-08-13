package garage.com.webapp.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="vehicletype")
public class VehicleType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_vehicletype;
	
	private String name;
	
	public VehicleType(){}

	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicletype")
	private List<Vehicle> vehicle;
	*/
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_vehicletype() {
		return id_vehicletype;
	}

	public void setId_vehicletype(int id_vehicletype) {
		this.id_vehicletype = id_vehicletype;
	}

}
