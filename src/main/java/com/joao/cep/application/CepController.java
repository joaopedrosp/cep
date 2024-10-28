package com.joao.cep.application;

import com.joao.cep.model.CepData;
import com.joao.cep.services.CepServices;
import com.joao.cep.services.LogServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepServices cepServices;

    private final LogServices logger;

    public CepController(CepServices cepServices, LogServices logger) {
        this.cepServices = cepServices;
        this.logger = logger;
    }

    @GetMapping("/{cep}")
    public CepData getCepData(@PathVariable final String cep){
        logger.info("Iniciando CepController - getCepData() para CEP: " + cep);
        return cepServices.getCep(cep);
    }

    @GetMapping("/findAllLocal")
    public Set<CepData> findAllLocal(){
        return cepServices.findAllLocal();
    }

}
