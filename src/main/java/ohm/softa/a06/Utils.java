package ohm.softa.a06;

import ohm.softa.a06.model.Joke;

public class Utils {
	public static String manuallyConvertJokeToJson(Joke joke) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"id\":\"").
			append(joke.getIdentifier()).
			append("\",\"value\":\"").
			append(joke.getContent()).
			append("\",\"categories\":").
			append('[');
		for (int i = 0; i < joke.getRubrics().size(); i++) {
			if (i != joke.getRubrics().size() - 1)
				sb.append("\"").append(joke.getRubrics().get(i)).append("\",");
			else
				sb.append("\"").append(joke.getRubrics().get(i)).append("\"");
		}
		sb.append("]}");

		return sb.toString();
	}
}
