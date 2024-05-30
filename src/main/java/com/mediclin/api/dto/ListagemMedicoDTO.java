package com.mediclin.api.dto;

import com.mediclin.api.model.Especialidade;
import com.mediclin.api.model.Medico;

public record ListagemMedicoDTO
       (
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
       ){

       public ListagemMedicoDTO (Medico medico){
              this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
       }
}

