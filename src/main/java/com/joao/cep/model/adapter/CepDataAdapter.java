package com.joao.cep.model.adapter;

import com.joao.cep.dto.CepDataDTO;
import com.joao.cep.entity.CepDataEntity;
import com.joao.cep.model.CepData;


public class CepDataAdapter {

    public static CepData from(final CepDataDTO cepDataDTO){
        return CepData.builder()
                .cep(cepDataDTO.getCep())
                .logradouro(cepDataDTO.getLogradouro())
                .complemento(cepDataDTO.getComplemento())
                .unidade(cepDataDTO.getUnidade())
                .bairro(cepDataDTO.getBairro())
                .localidade(cepDataDTO.getLocalidade())
                .uf(cepDataDTO.getUf())
                .estado(cepDataDTO.getEstado())
                .regiao(cepDataDTO.getRegiao())
                .ibge(cepDataDTO.getIbge())
                .gia(cepDataDTO.getGia())
                .ddd(cepDataDTO.getCep())
                .siafi(cepDataDTO.getSiafi())
                .build();
    }

    public static CepData from(final CepDataEntity cepDataEntity){
        return CepData.builder()
                .cep(cepDataEntity.getCep())
                .logradouro(cepDataEntity.getLogradouro())
                .complemento(cepDataEntity.getComplemento())
                .unidade(cepDataEntity.getUnidade())
                .bairro(cepDataEntity.getBairro())
                .localidade(cepDataEntity.getLocalidade())
                .uf(cepDataEntity.getUf())
                .estado(cepDataEntity.getEstado())
                .regiao(cepDataEntity.getRegiao())
                .ibge(cepDataEntity.getIbge())
                .gia(cepDataEntity.getGia())
                .ddd(cepDataEntity.getCep())
                .siafi(cepDataEntity.getSiafi())
                .build();
    }
}
