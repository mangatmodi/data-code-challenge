package tasks.first;

import main.ParseRouteFile;

public class Property {
	public static <T> Property create(String propertyString, Class<T> c) {
		return (Property) ParseRouteFile.gson.fromJson(propertyString, c);
	}
}
