package io.hammerhall.streamforge.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

	private int id;
	private String firstName;
	private String lastName;
	private String gender;

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
		Actor other = (Actor) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Actor [id=%d, firstName=%s, lastName=%s, gender=%s]".formatted(id, firstName, lastName, gender);
	}
}
