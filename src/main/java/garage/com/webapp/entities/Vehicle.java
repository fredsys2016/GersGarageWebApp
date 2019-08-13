package garage.com.webapp.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_vehicle;
	private String vehicle_license;
	private String make;
	
	//Person
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_person")
	private Person person;
	
	
	//id_Engine_Type
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_enginetype")
	private EngineType enginetype;
		
		
	//id_Vehicle_Type
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "id_vehicletype")
	private VehicleType vehicletype;

	
	/**
	 * Getter and setter
	 * 
	 */
	

	public Long getId_vehicle() {
		return id_vehicle;
	}


	public void setId_vehicle(Long id_vehicle) {
		this.id_vehicle = id_vehicle;
	}


	public String getVehicle_license() {
		return vehicle_license;
	}


	public void setVehicle_license(String vehicle_license) {
		this.vehicle_license = vehicle_license;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public EngineType getEnginetype() {
		return enginetype;
	}

	public void setEnginetype(EngineType enginetype) {
		this.enginetype = enginetype;
	}

	public VehicleType getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(VehicleType vehicletype) {
		this.vehicletype = vehicletype;
	}


	


	
}
