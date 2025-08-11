package org.example.javaBasic.director.service;

import lombok.RequiredArgsConstructor;
import org.example.javaBasic.director.dto.DirectorResponse;
import org.example.javaBasic.director.entity.Director;
import org.example.javaBasic.director.repository.DirectorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Transactional(readOnly = true)
    public List<DirectorResponse> findAllDirectors(){
        List<Director> directors = directorRepository.findAll();
        List<DirectorResponse> dtos = new ArrayList<>();

        for (Director director : directors){
            DirectorResponse directorResponse = new DirectorResponse(
                    director.getId(),
                    director.getName()
            );
            dtos.add(directorResponse);
        }
        return dtos;
    }
}
