package org.example.javaBasic.director.controller;

import lombok.RequiredArgsConstructor;
import org.example.javaBasic.director.dto.DirectorResponse;
import org.example.javaBasic.director.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/directors")
    public ResponseEntity<List<DirectorResponse>> getAllDirectors(){
        return ResponseEntity.ok(directorService.findAllDirectors());
    }
}
