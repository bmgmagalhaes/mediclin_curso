package com.mediclin.api.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaMedicoDTO(
        @NotNull Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco
) {

}
