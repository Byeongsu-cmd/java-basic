package org.example.javaBasic.movie.controller;


import lombok.RequiredArgsConstructor;
import org.example.javaBasic.movie.dto.MovieRequest;
import org.example.javaBasic.movie.dto.MovieResponse;
import org.example.javaBasic.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/directors/{directorId}/movies")
    public MovieResponse create(
            @RequestBody MovieRequest request,
            @PathVariable Long directorId
    ) {
        return ResponseEntity.ok(movieService.save(request, directorId));
    }

    @GetMapping("/directors/{directorId}/movies")
    public ResponseEntity<List<MovieResponse>> getAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

}

