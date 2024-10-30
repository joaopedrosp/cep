package com.joao.cep.services.decoder;

import com.joao.cep.model.exception.IntegrationException;
import feign.Response;
import feign.jackson.JacksonDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.lang.reflect.Type;

public class ViaCepDecoder extends JacksonDecoder {

    public ViaCepDecoder() {
        super();
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        if (HttpStatus.OK.value() != response.status()) {
            return IntegrationException.of(response);
        }
        return super.decode(response, type);
    }
}
