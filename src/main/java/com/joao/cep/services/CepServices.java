package com.joao.cep.services;

import com.joao.cep.dto.CepDataDTO;
import com.joao.cep.entity.CepDataEntityAdapter;
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
                .orElseGet(() -> this.getExternalCepInfo(cep));
    }

    public Set<CepData> findAllLocal(){
        return cepDataRepository.findAll().stream()
                .map(CepDataAdapter::from)
                .collect(Collectors.toSet());
    }

    private CepData getExternalCepInfo(final String cep){
        final CepDataDTO cepDataDTO = this.externalCepService.getData(cep);
        this.save(cepDataDTO);
        return CepDataAdapter.from(cepDataDTO);
    }

    private void save(final CepDataDTO cepData){
        this.cepDataRepository.save(CepDataEntityAdapter.from(cepData));
    }

}
