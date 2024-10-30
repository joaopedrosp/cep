package com.joao.cep.util;

import com.joao.cep.model.exception.IncorrectCepSize;

public class CepUtil {

    private static final Integer CEP_SIZE = 8;

    public static void validate(final String cep){
        validateSize(cep);
    }

    private static void validateSize(final String cep){
        if(!CEP_SIZE.equals(cep.length())){
            throw new IncorrectCepSize();
        }
    }

}
