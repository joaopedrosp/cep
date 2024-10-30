package com.joao.cep.model.exception;

import feign.Response;
import lombok.Getter;

public class IntegrationException extends RuntimeException {

    private static final String MESSAGE = "Erro na integração com a API externa";

    @Getter
    private Response response;

    private IntegrationException(final Response response){
        super();
        this.response = response;
    }

    public static IntegrationException of(final Response response){
        return new IntegrationException(response);
    }

}
