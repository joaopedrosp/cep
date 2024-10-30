package com.joao.cep.application;

import com.joao.cep.model.exception.IncorrectCepSize;
import com.joao.cep.model.exception.IntegrationException;
import com.joao.cep.model.exception.NotFoundException;
import com.joao.cep.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IntegrationException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public final ErrorResponse handleIntegrationException(final IntegrationException integrationException){
        return ErrorResponse.builder()
                .message(integrationException.getMessage())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public final ErrorResponse handleIntegrationException(final NotFoundException notFoundException){
        return ErrorResponse.builder()
                .message(notFoundException.getMessage())
                .build();
    }

    @ExceptionHandler(IncorrectCepSize.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ErrorResponse handleIntegrationException(final IncorrectCepSize incorrectCepSize){
        return ErrorResponse.builder()
                .message(incorrectCepSize.getMessage())
                .build();
    }

}
