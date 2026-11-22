package io.hammerhall.streamforge.domain.movie;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Movie {

	private int id;
	private String title;
	private int year;
	private Double rank;
	private List<Genre> genres;
	private List<Director> directors;

	{
		genres = new ArrayList<>();
		directors = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Movie other = (Movie) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Movie [title = %s, year = %d]".formatted(title, year);
	}
}