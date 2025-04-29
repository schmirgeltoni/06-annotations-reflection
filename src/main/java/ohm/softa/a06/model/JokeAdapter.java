package ohm.softa.a06.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JokeAdapter extends TypeAdapter<Joke> {

	private final Gson gson = new Gson();

	@Override
	public void write(JsonWriter jsonWriter, Joke joke) { }

	@Override
	public Joke read(JsonReader jsonReader) {
		return gson.fromJson(jsonReader, Joke.class);
	}
}
