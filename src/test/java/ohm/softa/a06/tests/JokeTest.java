package ohm.softa.a06.tests;

import com.google.gson.Gson;
import ohm.softa.a06.Utils;
import ohm.softa.a06.model.Joke;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokeTest {

	private static final Logger logger = LogManager.getLogger(JokeTest.class);

	private final Gson gson = new Gson();

	@Test
	void gsonShouldSerializeFieldsAccordingToSerializedNameAnnotation() {
		Joke j = new Joke("0", "funny", Collections.emptyList());
		String gsonJoke = gson.toJson(j);
		logger.info("Gson: {}", gsonJoke);
		String utilsJoke = Utils.manuallyConvertJokeToJson(j);
		logger.info("Util: {}", utilsJoke);
		assertEquals(gsonJoke, utilsJoke);

	}

}
