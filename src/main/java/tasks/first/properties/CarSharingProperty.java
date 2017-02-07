package tasks.first.properties;
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
		return (doors == null ? "" : doors).toString() + '\u0001' + license_plate + '\u0001' + model + '\u0001' + address
 + '\u0001' + description + '\u0001' + fuel_level + '\u0001' + engine_type + '\u0001'
				+ (seats == null ? "" : seats) + '\u0001' + internal_cleanliness;
	}

	@Override
	public void cleanData() {
		if (license_plate == null) {
			license_plate = "";
		}
		if (model == null) {
			model = "";
		}
		if (address == null) {
			address = "";
		}
		if (description == null) {
			description = "";
		}
		if (fuel_level == null) {
			fuel_level = "";
		}
		if (engine_type == null) {
			engine_type = "";
		}
		if (internal_cleanliness == null) {
			internal_cleanliness = "";
		}

	}

	@Override
	public
	void pPrint(int routeId) {
		System.out.println("CarSharingProperty\u0001" + routeId + '\u0001' + this);
	}
}
