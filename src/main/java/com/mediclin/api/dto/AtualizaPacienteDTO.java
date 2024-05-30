package com.mediclin.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizaPacienteDTO(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco
) {
}
