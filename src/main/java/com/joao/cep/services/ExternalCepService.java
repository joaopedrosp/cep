package com.joao.cep.services;

import com.joao.cep.dto.CepDataDTO;
import com.joao.cep.integration.ViaCepService;
import com.joao.cep.model.exception.IntegrationException;
import com.joao.cep.model.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExternalCepService {

    private final ViaCepService viaCepService;

    private final LogServices logger;

    public ExternalCepService(ViaCepService viaCepService, LogServices logger) {
        this.viaCepService = viaCepService;
        this.logger = logger;
    }

    public CepDataDTO getData(final String cep){
        logger.info("Inicio consulta externa ExternalCepService - getData()");
        final CepDataDTO cepDataDTO = viaCepService.getCepData(cep);
        if(cepDataDTO.isNull()){
            throw new NotFoundException();
        }
        return cepDataDTO;
    }
}
