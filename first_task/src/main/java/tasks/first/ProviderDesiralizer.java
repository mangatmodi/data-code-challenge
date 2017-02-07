package tasks.first;

import java.lang.reflect.Type;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ProviderDesiralizer implements JsonDeserializer<Provider[]> {

	@Override
	public Provider[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject js = json.getAsJsonObject();
		int i = 0;
		Provider[] pArray = new Provider[js.entrySet().size()];
		for (Entry<String, JsonElement> E : js.entrySet()) {
			Provider p = new Provider(E.getKey());
			p.setAttributes(ProviderAttribute.create(E.getValue().toString()));
			pArray[i] = p;
			i++;
		}
		return pArray;
	}

}
