package com.mediclin.api.service;

import com.mediclin.api.dto.AtualizaMedicoDTO;
import com.mediclin.api.dto.ListagemMedicoDTO;
import com.mediclin.api.dto.MedicoDTO;
import com.mediclin.api.model.Medico;
import com.mediclin.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastrar(MedicoDTO medicoDTO) {

        Medico medico = new Medico(medicoDTO);
        medicoRepository.save(medico);
    }




    public Page<ListagemMedicoDTO> listarTodosAtivos(Pageable paginacao) {

        var medicos = medicoRepository.findAllByAtivoTrueOrderByNome(paginacao);

        return medicos.map(ListagemMedicoDTO::new);
    }

    public void atualizar(AtualizaMedicoDTO dados) {

        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

//    public void deletar(Long id) {
//        medicoRepository.deleteById(id);
//    }

    public void desativar(Long id) {

        var medico = medicoRepository.getReferenceById(id);

        medico.desativar();
    }


//    // MÉTODO SUBSTITUÍDO POR LISTAGEM COM PAGINAÇÃO DO SPRING
//    public List<ListagemMedicoDTO> listarMedicosCadastrados() {
//
//        List<Medico> medicos = medicoRepository.findAllByOrderByNome();
//
//        return medicos.stream()
//                .map(m -> new ListagemMedicoDTO(m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade()))
//                .collect(Collectors.toList());
//    }
}
