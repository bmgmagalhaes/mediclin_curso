package com.mediclin.api.controller;

import com.mediclin.api.dto.AtualizaPacienteDTO;
import com.mediclin.api.dto.ListagemPacienteDTO;
import com.mediclin.api.dto.PacienteDTO;
import com.mediclin.api.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/cadastro")
    @Transactional
    public void cadastro(@RequestBody @Valid PacienteDTO pacienteDTO) {

        pacienteService.salvar(pacienteDTO);
    }

    @GetMapping("/listagem")
    // OUTRA FORMA DE ORDENAR OS DADOS DIRETO NA PAGINAÇÃO, AO INVÉS DE SER FEITO PELO REPOSITORIO, COMO ESTÁ EM MÉDICO CONTROLLER
    public Page<ListagemPacienteDTO> listarTodos (
            @PageableDefault(size = 2, sort = "nome") Pageable paginacao) {

        return pacienteService.listarTodos(paginacao);
    }

    @PutMapping("/cadastro")
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaPacienteDTO dados){

        pacienteService.atualizar(dados);

    }
}
