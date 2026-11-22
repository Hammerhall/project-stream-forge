package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.movie.*;
import java.util.Collection;

public interface MovieService {

    Collection<Movie> findAllMovies();

    Collection<Genre> findAllGenres();

    Collection<Director> findAllDirectors();

    Collection<Actor> findAllActors();

    Collection<Role> findAllRoles();

    Collection<DirectorGenre> findAllDirectorGenres();
}
