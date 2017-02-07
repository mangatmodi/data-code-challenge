package tasks.first.properties;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import tasks.first.Route.PropertyWrapper;

public class PropertyDeserializer implements JsonDeserializer<PropertyWrapper> {
	@Override
	public PropertyWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		// TODO Auto-generated method stub
		return new PropertyWrapper(json.toString());
	}
}