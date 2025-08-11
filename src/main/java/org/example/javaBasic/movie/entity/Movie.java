package org.example.javaBasic.movie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.javaBasic.director.entity.Director;

@Entity
@Getter
@NoArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    public Movie(String title, Director director) {
        this.title = title;
        this.director = director;
    }
}
