package com.mediclin.api.controller;

import com.mediclin.api.dto.AtualizaMedicoDTO;
import com.mediclin.api.dto.ListagemMedicoDTO;
import com.mediclin.api.dto.MedicoDTO;
import com.mediclin.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping("/cadastro")
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO medicoDTO){
        medicoService.cadastrar(medicoDTO);

    }

    @PutMapping("/cadastro")
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaMedicoDTO atualizaMedicoDTO){
        medicoService.atualizar(atualizaMedicoDTO);

    }

    @GetMapping("/listagem")
    public Page<ListagemMedicoDTO> listarTodosAtivos(Pageable paginacao){
        return medicoService.listarTodosAtivos(paginacao);

    }


    // EXCLUSAO LÓGICA: TORNAR CADASTRO INATIVO
    @PutMapping("/cadastro/{id}")
    @Transactional
    public void excluir(@PathVariable ("id") Long id){
        medicoService.desativar(id);

    }

    // EXCLUSÃO TRADICIONAL, NÃO RECOMENDADA
//    @DeleteMapping("/cadastro/{id}")
//    @Transactional
//    public void excluir(@PathVariable("id") Long id){
//        medicoService.deletar(id);
//
//    }



}
