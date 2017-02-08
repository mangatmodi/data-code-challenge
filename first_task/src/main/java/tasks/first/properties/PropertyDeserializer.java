package tasks.first.properties;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import tasks.first.Route.PropertyWrapper;
/** extract the Json string for the Route.Property instead of Gson trying to convert it into an object 
 * */
public class PropertyDeserializer implements JsonDeserializer<PropertyWrapper> {
	@Override
	public PropertyWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		// TODO Auto-generated method stub
		return new PropertyWrapper(json.toString());
	}
}