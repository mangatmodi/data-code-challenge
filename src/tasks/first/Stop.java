package tasks.first;

public class Stop {
	private String name;

	private String lng;

	private Object property;

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

	public Object getProperty() {
		return property;
	}

	public void setProperty(Object property) {
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

	public String getKey() {
		return lat + "_" + lng + "_" + name;
	}

	public void pPrint() {
		cleanData();
		String sString = "StopRow\u0001" + Route.stopId + '\u0001' + name + '\u0001' + lng + '\u0001' + lat + '\u0001'
				+ property + '\u0001' + datetime;
		System.out.println(sString);

	}

	private void cleanData() {
		if (name == null) {
			name = "";
		}
		if (lng == null) {
			lng = "";
		}
		if (lat == null) {
			lat = "";
		}
		if (property == null) {
			property = "";
		}
		if (datetime == null) {
			datetime = "";
		}

	}
}
