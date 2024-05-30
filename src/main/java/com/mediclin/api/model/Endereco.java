package com.mediclin.api.model;

import com.mediclin.api.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String cep, String cidade, String uf, String numero, String complemento) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco(EnderecoDTO enderecoDTO) {

        this.logradouro = enderecoDTO.logradouro();
        this.bairro = enderecoDTO.bairro();
        this.cep = enderecoDTO.cep();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();


    }

    public void atualizarInformacoes(EnderecoDTO dados) {
        if (dados.logradouro() != null){

            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null){

            this.bairro = dados.bairro();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();

        }
        if (dados.cidade() != null){

            this.cidade = dados.cidade();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();

        }
        if (dados.numero() != null){
            this.numero = dados.numero();

        }
        if (dados.logradouro() != null){

            this.complemento = dados.complemento();
        }
    }
}
