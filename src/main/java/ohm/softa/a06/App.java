package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ohm.softa.a06.model.Joke;
import ohm.softa.a06.model.JokeAdapter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {

		Gson gson = new GsonBuilder().
			registerTypeAdapter(Joke.class, new JokeAdapter()).
			create();

		Retrofit retrofit = new Retrofit.Builder().
			addConverterFactory(GsonConverterFactory.create(gson)).
			baseUrl("https://api.chucknorris.io").
			build();

		CNJDBApi api = retrofit.create(CNJDBApi.class);

		Call<Joke> call = api.getRandomJoke();
		Response<Joke> resp = call.execute();

		if (!resp.isSuccessful())
			throw new IOException("Request failed: " + resp.code());

		Joke j = resp.body();

		if (j == null) {
			System.out.println("Joke not found");
		}
		else {
			System.out.println(j.getContent());
		}

	}

}
