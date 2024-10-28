package com.joao.cep.repository;

import com.joao.cep.entity.CepDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CepDataRepository extends JpaRepository<CepDataEntity, String> {
    Optional<CepDataEntity> findByCep(String cep);
}

