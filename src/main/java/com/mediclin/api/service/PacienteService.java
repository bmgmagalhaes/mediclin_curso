package com.mediclin.api.service;

import com.mediclin.api.dto.AtualizaPacienteDTO;
import com.mediclin.api.dto.ListagemPacienteDTO;
import com.mediclin.api.dto.PacienteDTO;
import com.mediclin.api.model.Paciente;
import com.mediclin.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public void salvar(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente(pacienteDTO);
        pacienteRepository.save(paciente);

    }

    public Page<ListagemPacienteDTO> listarTodos(Pageable paginacao) {

        return pacienteRepository.findAll(paginacao)
                .map(ListagemPacienteDTO::new);

    }

    public void atualizar(AtualizaPacienteDTO dados) {

        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizar(dados);

    }
}
