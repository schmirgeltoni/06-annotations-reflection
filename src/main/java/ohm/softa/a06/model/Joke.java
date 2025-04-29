package ohm.softa.a06.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/9/17.
 */
public final class Joke {

	@SerializedName("id") private String identifier;
	@SerializedName("value") private String content;
	@SerializedName("categories") private List<String> rubrics;

	public String getIdentifier() {
		return identifier;
	}

	public String getContent() {
		return content;
	}

	public List<String> getRubrics() {
		return rubrics;
	}

	public Joke(String identifier, String content, List<String> rubrics){
		this.identifier = identifier;
		this.content = content;
		this.rubrics = rubrics;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Joke)) return false;

		Joke joke1 = (Joke) o;

		return new EqualsBuilder()
			.append(getIdentifier(), joke1.getIdentifier())
			.append(getContent(), joke1.getContent())
			.append(getRubrics(), joke1.getRubrics())
			.append(rubrics, joke1.rubrics)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getIdentifier())
			.append(getContent())
			.append(getRubrics())
			.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("identifier", identifier)
			.append("content", content)
			.append("rubrics", rubrics)
			.toString();
	}
}
