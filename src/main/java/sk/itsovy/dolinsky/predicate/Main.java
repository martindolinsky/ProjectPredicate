package sk.itsovy.dolinsky.predicate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Martin Dolinsky
 */
public class Main {
	private static List<City> cities;

	public static void main(String[] args) throws IOException {

		String itsovy = "http://itsovy.sk:5000/data";

		URL url = new URL(itsovy);
		URLConnection request = url.openConnection();
		request.connect();

		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonArray worldx = jsonObject.get("world_x").getAsJsonArray();

		System.out.println(worldx.get(1));

		if (cities == null) {
			cities = new ArrayList<>();
			for (int i = 0; i < worldx.size(); i++) {
				City city = new City(((JsonObject) worldx.get(i)).get("name").getAsString(),
						((JsonObject) worldx.get(i)).get("district").getAsString(),
						((JsonObject) worldx.get(i)).get("code").getAsString(),
						((JsonObject) worldx.get(i)).get("pop").getAsInt());
				cities.add(city);

			}
		}

		for (City c : cities) {
			if (c.getCode().equals("NLD") && c.getPopulation() > 100000)
				System.out.println(c);
		}

		System.out.println("\n\n\n\n\n");
		FromNLD<String> predicateCode = new FromNLD<>();
		Predicate<City> moreThan1 = city -> city.getPopulation() > 100000;
		cities.stream().filter(predicateCode.and(moreThan1)).forEach(System.out::println);

	}
}
