package org.example.javaBasic.director.dto;

import lombok.Getter;

@Getter
public class DirectorResponse {
    private final Long id;
    private final String name;

    public DirectorResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
