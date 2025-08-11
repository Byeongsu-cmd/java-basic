package org.example.javaBasic.movie.repository;

import org.example.javaBasic.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
