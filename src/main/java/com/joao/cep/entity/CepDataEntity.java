package com.joao.cep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "TB_CEP_DATA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CepDataEntity {

    @Id
    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "UNIDADE")
    private String unidade;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LOCALIDADE")
    private String localidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "REGIAO")
    private String regiao;

    @Column(name = "IBGE")
    private String ibge;

    @Column(name = "GIA")
    private String gia;

    @Column(name = "DDD")
    private String ddd;

    @Column(name = "SIAFI")
    private String siafi;

    @Column(name = "DT_CREATION")
    private java.sql.Date dtCreation;
}

