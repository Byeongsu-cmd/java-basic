package org.example.javaBasic.movie.dto;

import lombok.Getter;

@Getter
public class MovieResponse {
    private final Long id;
    private final String title;

    public MovieResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
