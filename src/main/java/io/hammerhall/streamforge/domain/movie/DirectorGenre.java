package io.hammerhall.streamforge.domain.movie;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Director's affinity for a genre: {@code prob} is the share of the director's work in {@code genreId}.
 * Links are kept by id so that director↔genre joins remain explicit Stream operations.
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectorGenre {

	private int directorId;
	private int genreId;
	private double prob;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		DirectorGenre other = (DirectorGenre) obj;
		return directorId == other.directorId && genreId == other.genreId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(directorId, genreId);
	}

	@Override
	public String toString() {
		return "DirectorGenre [directorId=%d, genreId=%d, prob=%s]".formatted(directorId, genreId, prob);
	}
}
