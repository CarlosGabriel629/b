package com.cinemaserver.projetocine.service;

import com.cinemaserver.projetocine.dto.CinemaDTO;
import com.cinemaserver.projetocine.entity.Cinema;
import com.cinemaserver.projetocine.repository.CinemaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema salvar(CinemaDTO dto) {
        Cinema cinema = Cinema.builder()
                .nome(dto.nome())
                .endereco(dto.endereco())
                .build();
        return cinemaRepository.save(cinema);
    }

    public List<Cinema> listarTodos() {
        return cinemaRepository.findAll();
    }

    public Cinema buscarPorId(Long id) {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema não encontrado"));
    }

    public void deletar(Long id) {
        Cinema cinema = buscarPorId(id);
        cinemaRepository.delete(cinema);
    }
}