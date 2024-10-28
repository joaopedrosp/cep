package com.joao.cep.services;

import com.joao.cep.dto.CepDataDTO;
import com.joao.cep.integration.ViaCepService;
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
        try{
            return viaCepService.getCepData(cep);
        } catch (Exception ex){
            logger.error("Erro ao buscar dados do CEP na API externa ExternalCepService - getData()");
            throw new RuntimeException("Erro ao buscar dados do CEP na API externa ExternalCepService - getData()");
        }
    }
}
