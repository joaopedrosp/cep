package com.joao.cep.integration;

import com.joao.cep.dto.CepDataDTO;
import feign.Param;
import feign.RequestLine;

public interface ViaCepService {

    @RequestLine("GET /{cep}/json")
    CepDataDTO getCepData(@Param("cep") final String cep);
}
