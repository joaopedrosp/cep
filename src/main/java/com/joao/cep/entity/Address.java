package com.joao.cep.entity;


//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;

import java.time.LocalDate;


//@Entity
//@Table(name = "TB_ADDRESS")
//@Data
//@AllArgsConstructor
public class Address {
//    @Id
//    @Column(name = "CEP", nullable = false)
    private String cep;

//    @Column(name = "PLACE", nullable = false)
    private String place;

//    @Column(name = "DT_CREATION", nullable = false)
    private LocalDate creationDate;
}
