package io.hammerhall.streamforge.domain.movie;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A single acting credit: actor {@code actorId} played {@code role} in movie {@code movieId}.
 * Links are kept by id so that actor↔movie joins remain explicit Stream operations.
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	private int actorId;
	private int movieId;
	private String role;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Role other = (Role) obj;
		return actorId == other.actorId && movieId == other.movieId && Objects.equals(role, other.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, movieId, role);
	}

	@Override
	public String toString() {
		return "Role [actorId=%d, movieId=%d, role=%s]".formatted(actorId, movieId, role);
	}
}
