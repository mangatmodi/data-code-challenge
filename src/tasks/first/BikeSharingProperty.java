package tasks.first;

public class BikeSharingProperty extends Property{
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
		return "BikeSharingProperty [id=" + id + ", availableBikes=" + available_bikes + "]";
	}
	
}
