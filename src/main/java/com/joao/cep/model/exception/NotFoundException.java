package com.joao.cep.model.exception;

public class NotFoundException extends RuntimeException {

    private static final String MESSAGE = "A API externa não retornou dados para esse cep!";

    public NotFoundException(){
        super(MESSAGE);
    }

}
