package com.cinemaserver.projetocine.controller;

import com.cinemaserver.projetocine.dto.CinemaDTO;
import com.cinemaserver.projetocine.entity.Cinema;
import com.cinemaserver.projetocine.service.CinemaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping
    public ResponseEntity<Cinema> criar(@RequestBody @Valid CinemaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Cinema>> listarTodos() {
        return ResponseEntity.ok(cinemaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cinemaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cinemaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}