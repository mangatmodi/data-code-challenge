package tasks.first;

public class Segment {
	private Stop[] stops;

	private String num_stops;

	private String polyline;

	private String color;

	private String description;

	private String name;

	private String icon_url;

	private String travel_mode;

	public Stop[] getStops() {
		return stops;
	}

	public void setStops(Stop[] stops) {
		this.stops = stops;
	}

	public String getNum_stops() {
		return num_stops;
	}

	public void setNum_stops(String num_stops) {
		this.num_stops = num_stops;
	}

	public String getPolyline() {
		return polyline;
	}

	public void setPolyline(String polyline) {
		this.polyline = polyline;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String getTravel_mode() {
		return travel_mode;
	}

	public void setTravel_mode(String travel_mode) {
		this.travel_mode = travel_mode;
	}

	public void cleanData() {
		if (num_stops == null) {
			num_stops = "";
		}
		if (color == null) {
			color = "";
		}
		if (description == null) {
			description = "";
		}
		if (name == null) {
			name = "";
		}
		if (icon_url == null) {
			icon_url = "";
		}
		if (travel_mode == null) {
			travel_mode = "";
		}
		if (polyline == null) {
			polyline = "";
		}
	}

	@Override
	public String toString() {
		return "ClassPojo [stops = " + stops + ", num_stops = " + num_stops + ", polyline = " + polyline + ", color = "
				+ color + ", description = " + description + ", name = " + name + ", icon_url = " + icon_url
				+ ", travel_mode = " + travel_mode + "]";
	}

	public void pPrint() {
		cleanData();
		System.out.println(
				"SegmentRow\u0001" + Route.segmentId + '\u0001' + num_stops + '\u0001' + polyline + '\u0001' + color
						+ '\u0001' + description + '\u0001' + name + '\u0001' + icon_url + '\u0001' + travel_mode);
		int order = 0;
		for (Stop s : stops) {
			int stopId = 0;
			if (Route.stopToId.containsKey(s.getKey())) {
				stopId = Route.stopToId.get(s.getKey());
			} else {
				s.pPrint();
				Route.stopId++;
				Route.stopToId.put(s.getKey(), Route.stopId);
				stopId = Route.stopId;
			}
			order++;
			System.out.println("SegmentStopRow\u0001"+Route.segmentId + '\u0001' + stopId+'\u0001'+order);
		}

	}

	public String getKey() {
		return polyline;
	}
}