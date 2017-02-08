package tasks.first.properties;

public class BikeSharingProperty extends Property {
	String id;
	Integer available_bikes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAvailableBikes() {
		return available_bikes;
	}

	public void setAvailableBikes(Integer availableBikes) {
		this.available_bikes = availableBikes;
	}

	@Override
	public String toString() {
		return id + '\u0001' + (available_bikes == null ? "" : available_bikes);
	}

	@Override
	public void cleanData() {
		if (id == null) {
			id = "";
		}
	}

	@Override
	public void pPrint(int routeId) {
		System.out.println("BikeSharingProperty\u0001" + routeId + '\u0001' + this);		
	}

}
