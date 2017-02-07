package tasks.first.properties;

import tasks.first.main.ParseRouteFile;

public abstract class Property {
	public static <T> Property create(String propertyString, Class<T> c) {
		return (Property) ParseRouteFile.gson.fromJson(propertyString, c);
	}

	public abstract void cleanData();

	public abstract void pPrint(int routeId);
}
