package main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

import tasks.first.PropertyDeserializer;
import tasks.first.Provider;
import tasks.first.ProviderDesiralizer;
import tasks.first.Route;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ParseRouteFile {
	public static Logger logger = Logger.getLogger(ParseRouteFile.class.getSimpleName());
	public static Gson gson = new GsonBuilder().setPrettyPrinting()
			.registerTypeAdapter(tasks.first.Route.PropertyWrapper.class, new PropertyDeserializer())
			.registerTypeAdapter(tasks.first.Provider.class, new ProviderDesiralizer()).create();

	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(args[1])), true));
		} catch (Exception e) {
			logger.log(Level.WARNING, "Unable to use file as stdout:" + args[1], false);
			e.printStackTrace();
		}
		Reader in = null;
		try {
			in = new BufferedReader(new FileReader(args[0]));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to read Json routes file:" + args[0], false);
			System.exit(-1);
		}
		JsonReader reader = new JsonReader(in);
		try {
			reader.beginObject();
			while (reader.hasNext()) {
				String key = reader.nextName();

				if (key.equals("routes")) {
					reader.beginArray();
					while (reader.hasNext()) {
						Route r = gson.fromJson(reader, Route.class);
						r.setType();
						r.setProperties();
						r.pPrint();
					}
					reader.endArray();
				} else if (key.equals("provider_attributes")) {
					Provider[] p = gson.fromJson(reader, Provider.class);
					for (Provider p1 : p) {
						p1.pPrint();
					}
				} else {
					reader.skipValue();
				}

			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Malformed Json routes file:" + args[0], false);
			System.exit(-1);
		}

	}
}