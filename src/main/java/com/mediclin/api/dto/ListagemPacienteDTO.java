package com.mediclin.api.dto;

import com.mediclin.api.model.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ListagemPacienteDTO(

        Long id,
        String nome,
        String email,
        String cpf

)
{
    public ListagemPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }


}
