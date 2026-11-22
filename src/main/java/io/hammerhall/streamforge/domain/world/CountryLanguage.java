package io.hammerhall.streamforge.domain.world;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

	private String countryCode;
	private String language;
	private boolean official;
	private double percentage;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		CountryLanguage that = (CountryLanguage) obj;
		return countryCode.equals(that.countryCode) && language.equals(that.language);
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, language);
	}

	@Override
	public String toString() {
		return "CountryLanguage [countryCode=%s, language=%s, official=%s, percentage=%s]"
				.formatted(countryCode, language, official, percentage);
	}
}
