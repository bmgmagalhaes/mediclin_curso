package com.mediclin.api.model;

public enum Especialidade {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia") ,
    GINECOLOGIA ("ginecologia"),
    DERMATOLOGIA ("dermatologia");

    private String especialidadeTexto;

    Especialidade(String especialidadeTexto) {
        this.especialidadeTexto = especialidadeTexto;
    }


    public static Especialidade converteTextoPraEnum(String texto){

        for (Especialidade e: Especialidade.values()){

            if (e.especialidadeTexto.equalsIgnoreCase(texto)){
                return e;
            }
        }
        throw new IllegalArgumentException("Especialidade não encontrada");
    }
}
