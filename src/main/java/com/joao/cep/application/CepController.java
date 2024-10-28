package com.joao.cep.application;

import com.joao.cep.model.CepData;
import com.joao.cep.services.CepServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/cep")
public class CepController {

    private static final Logger logger = LogManager.getLogger(CepController.class);

    private final CepServices cepServices;

    public CepController(CepServices cepServices) {
        this.cepServices = cepServices;
    }

    @GetMapping("/{cep}")
    public CepData getCepData(@PathVariable final String cep){
        logger.info("Processando CepController - getCepData()", cep);
        return cepServices.getCep(cep);
    }

    @GetMapping("/findAllLocal")
    public Set<CepData> findAllLocal(){
        return cepServices.findAllLocal();
    }

}
