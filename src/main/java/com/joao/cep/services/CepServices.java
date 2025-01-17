package com.joao.cep.services;

import com.joao.cep.model.CepData;
import com.joao.cep.model.adapter.CepDataAdapter;
import com.joao.cep.repository.CepDataRepository;
import com.joao.cep.util.CepUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CepServices {

    private final ExternalCepService externalCepService;

    private final CepDataRepository cepDataRepository;

    @Autowired
    public CepServices(ExternalCepService externalCepService, CepDataRepository cepDataRepository) {
        this.externalCepService = externalCepService;
        this.cepDataRepository = cepDataRepository;
    }

    public CepData getCep(final String cep) {
        CepUtil.validate(cep);

        return this.cepDataRepository.findByCep(cep)
                .map(CepDataAdapter::from)
                .orElseGet(() -> CepDataAdapter.from(this.externalCepService.getData(cep)));
    }

    public Set<CepData> findAllLocal(){
        return cepDataRepository.findAll().stream()
                .map(CepDataAdapter::from)
                .collect(Collectors.toSet());
    }

}
