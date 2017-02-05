package tasks.first;

public class Route {
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
			break;
		case BIKE_SHARING:
			this.propertyObject = Property.create(properties.toString(), BikeSharingProperty.class);
			break;
		case TAXI:
			this.propertyObject = Property.create(properties.toString(), TaxiProperty.class);
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