package io.hammerhall.streamforge.domain.world;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Country {

	private String code;
	private String name;
	private String continent;
	private String region;
	private double surfaceArea;
	private Integer indepYear;
	private int population;
	private Double lifeExpectancy;
	private double gnp;
	private Double gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;
	private List<City> cities;
	private List<CountryLanguage> languages;

	{
		cities = new ArrayList<>();
		languages = new ArrayList<>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Country other = (Country) obj;
		if (code == null) {
            return other.code == null;
		} else return code.equals(other.code);
    }

	@Override
	public String toString() {
		return "Country [ name=%s, population=%d]".formatted(name, population);
	}
}