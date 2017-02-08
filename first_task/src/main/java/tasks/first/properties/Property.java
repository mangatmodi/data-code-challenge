package tasks.first.properties;

import tasks.first.main.ParseRouteFile;
/** Encapsulating Property class for Route.Property. Only at runtime we attach the concrete
 * implementation of the Property class. We also pass contract to concrete implementations.
 **/
public abstract class Property {
	public static <T> Property create(String propertyString, Class<T> c) {
		return (Property) ParseRouteFile.gson.fromJson(propertyString, c);
	}

	public abstract void cleanData();

	public abstract void pPrint(int routeId);
}
