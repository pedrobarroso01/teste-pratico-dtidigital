package br.com.dtidigital.backend.models;

import org.springframework.stereotype.Component;



@Component

public class ModelResponse {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}

