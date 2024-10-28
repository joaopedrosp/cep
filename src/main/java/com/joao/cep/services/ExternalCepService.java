package com.joao.cep.services;

import com.joao.cep.dto.CepDataDTO;
import com.joao.cep.entity.CepDataEntityAdapter;
import com.joao.cep.integration.ViaCepService;
import com.joao.cep.repository.CepDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ExternalCepService {

    private final ViaCepService viaCepService;

    private final CepDataRepository cepDataRepository;

    public ExternalCepService(ViaCepService viaCepService, CepDataRepository cepDataRepository) {
        this.viaCepService = viaCepService;
        this.cepDataRepository = cepDataRepository;
    }

    public CepDataDTO getData(final String cep){
        final CepDataDTO cepDataDTO = viaCepService.getCepData(cep);
        cepDataRepository.save(CepDataEntityAdapter.from(cepDataDTO));
        return cepDataDTO;
    }
}
