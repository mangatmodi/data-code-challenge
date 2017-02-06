package tasks.first;

import java.util.HashMap;
import java.util.Map;

public class Route {

	static int routeId = 0;
	static int segmentId = 0;
	static int stopId = 0;

	boolean isPropertyOfRoute;

	public static Map<String, Integer> segmentToId = new HashMap<>();
	static Map<String, Integer> stopToId = new HashMap<>();

	public static enum ROUTE_TYPE {
		PUBLIC_TRANSPORT, CAR_SHARING, PRIVATE_BIKE, BIKE_SHARING, TAXI, UNKOWN;
	}

	private Price price;

	private Segment[] segments;

	private String provider;

	private PropertyWrapper properties;

	private Property propertyObject;
	private String type;
	private ROUTE_TYPE typeEnum;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Segment[] getSegments() {
		return segments;
	}

	public void setSegments(Segment[] segments) {
		this.segments = segments;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Property getProperties() {
		return propertyObject;
	}

	public void setProperties() {
		switch (this.typeEnum) {
		case CAR_SHARING:
			this.propertyObject = Property.create(properties.toString(), CarSharingProperty.class);
			isPropertyOfRoute = true;
			break;
		case BIKE_SHARING:
			this.propertyObject = Property.create(properties.toString(), BikeSharingProperty.class);
			isPropertyOfRoute = true;
			break;
		case TAXI:
			this.propertyObject = Property.create(properties.toString(), TaxiProperty.class);
			isPropertyOfRoute = false;
			break;
		default:
			this.propertyObject = null;
			break;
		}

	}

	public ROUTE_TYPE getType() {
		return typeEnum;
	}

	public void setType() {
		try {
			this.typeEnum = ROUTE_TYPE.valueOf(type.toUpperCase());
		} catch (Exception e) {
			this.typeEnum = ROUTE_TYPE.UNKOWN;
		}
	}

	public void cleanData() {
		if (price == null) {
			price = new Price();
			price.setAmount("");
			price.setCurrency("");
		}
	}

	public void pPrint() {
		routeId++;
		cleanData();
		System.out.println(
				"RouteRow\u0001" + routeId + '\u0001' + price + '\u0001' + '\u0001' + provider + '\u0001' + typeEnum);
		int order = 0;
		for (Segment s : segments) {
			int segId = 0;
			if (segmentToId.containsKey(s.getKey())) {
				segId = segmentToId.get(s.getKey());
			} else {
				s.pPrint();
				Route.segmentId++;
				if (s.getKey() != null || s.getKey() == "") {
					segmentToId.put(s.getKey(), Route.segmentId);
				}
				segId = Route.segmentId;
			}
			order++;
			System.out.println("RouteSegmentRow\u0001" + routeId + '\u0001' + segId + '\u0001' + order);
		}
		if (propertyObject != null) {
			propertyObject.cleanData();
			propertyObject.pPrint(routeId);
		}
	}

	@Override
	public String toString() {
		return "Route [price = " + price + ", segments = " + segments + ", provider = " + provider + ", properties = "
				+ propertyObject + ", type = " + typeEnum + "]";
	}

	public static class PropertyWrapper {
		String propertyString;

		public PropertyWrapper(String propertyString) {
			this.propertyString = propertyString;
		}

		@Override
		public String toString() {
			return propertyString;
		}
	}
}