package tasks.first;

import tasks.first.Property;

public class CarSharingProperty extends Property {

	CarSharingProperty(String propertyStrings) {

	}

	private Integer doors;

	private String license_plate;

	private String model;

	private String address;

	private String description;

	private String fuel_level;

	private String engine_type;

	private Integer seats;

	private String internal_cleanliness;

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFuel_level() {
		return fuel_level;
	}

	public void setFuel_level(String fuel_level) {
		this.fuel_level = fuel_level;
	}

	public String getEngine_type() {
		return engine_type;
	}

	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getInternal_cleanliness() {
		return internal_cleanliness;
	}

	public void setInternal_cleanliness(String internal_cleanliness) {
		this.internal_cleanliness = internal_cleanliness;
	}

	@Override
	public String toString() {
		return "ClassPojo [doors = " + doors + ", license_plate = " + license_plate + ", model = " + model
				+ ", address = " + address + ", description = " + description + ", fuel_level = " + fuel_level
				+ ", engine_type = " + engine_type + ", seats = " + seats + ", internal_cleanliness = "
				+ internal_cleanliness + "]";
	}
}
