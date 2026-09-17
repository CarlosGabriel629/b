package com.cinemaserver.projetocine.dto;

import jakarta.validation.constraints.NotBlank;

public record CinemaDTO(
        @NotBlank(message = "O nome do cinema é obrigatório")
        String nome,

        @NotBlank(message = "O endereço é obrigatório")
        String endereco
) {}