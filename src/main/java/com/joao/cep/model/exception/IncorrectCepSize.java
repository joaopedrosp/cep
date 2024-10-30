package com.joao.cep.model.exception;

public class IncorrectCepSize extends RuntimeException{

    private static final String MESSAGE = "Cep deve ter 8 caracteres!";

    public IncorrectCepSize(){
        super(MESSAGE);
    }

}
