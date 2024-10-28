package com.joao.cep.entity;

import com.joao.cep.dto.CepDataDTO;

public class CepDataEntityAdapter {

    public static CepDataEntity from(final CepDataDTO cepDataDTO){
        return CepDataEntity.builder()
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

}
