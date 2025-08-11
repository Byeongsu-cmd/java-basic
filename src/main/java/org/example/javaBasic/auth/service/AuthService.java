package org.example.javaBasic.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.javaBasic.auth.dto.AuthRequest;
import org.example.javaBasic.auth.dto.AuthResponse;
import org.example.javaBasic.director.entity.Director;
import org.example.javaBasic.director.repository.DirectorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final DirectorRepository directorRepository;

    @Transactional
    public void signup(AuthRequest request) {
        Director director = new Director(request.getName());
        directorRepository.save(director);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(AuthRequest request) {
        Director director = directorRepository.findByName(request.getName()).orElseThrow(
                () -> new IllegalArgumentException("없는 감독입니다.")
        );
        return new AuthResponse(director.getId());
    }
}
