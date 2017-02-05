package tasks.first;

public class Stop {
	private String name;

	private String lng;

	private String property;

	private String datetime;

	private String lat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "ClassPojo [name = " + name + ", lng = " + lng + ", property = " + property + ", datetime = " + datetime
				+ ", lat = " + lat + "]";
	}
}
