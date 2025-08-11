package org.example.javaBasic.movie.service;

import lombok.RequiredArgsConstructor;
import org.example.javaBasic.director.entity.Director;
import org.example.javaBasic.director.repository.DirectorRepository;
import org.example.javaBasic.movie.dto.MovieRequest;
import org.example.javaBasic.movie.dto.MovieResponse;
import org.example.javaBasic.movie.entity.Movie;
import org.example.javaBasic.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    @Transactional
    public MovieResponse save(MovieRequest request, Long directorId) {
        Director director = directorRepository.findById(directorId).orElseThrow(
                () -> new IllegalArgumentException("없는 디렉터입니다.")
        );
        Movie movie = new Movie(
                request.getTitle(),
                director
        );
        Movie savedMovie = movieRepository.save(movie);
        return new MovieResponse(savedMovie.getId(), savedMovie.getTitle());
    }

    @Transactional(readOnly = true)
    public List<MovieResponse> findAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponse> dtos = new ArrayList<>();

        for (Movie movie : movies) {
            MovieResponse movieResponse = new MovieResponse(
                    movie.getId(),
                    movie.getTitle()
            );
            dtos.add(movieResponse);
        }
        return dtos;
    }
}
