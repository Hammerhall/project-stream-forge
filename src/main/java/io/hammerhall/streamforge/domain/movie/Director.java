package io.hammerhall.streamforge.domain.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Director {

	private int id;
	private String firstName;
	private String lastName;

	public String getFullName() {
		return (firstName + " " + lastName).trim();
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
		Director other = (Director) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Director [id=%d, firstName=%s, lastName=%s]"
				.formatted(id, firstName, lastName);
	}
}
