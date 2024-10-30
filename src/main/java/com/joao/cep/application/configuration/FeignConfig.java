package com.joao.cep.application.configuration;

import com.joao.cep.integration.ViaCepService;
import com.joao.cep.services.decoder.ViaCepDecoder;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${VIA_CEP_URL}")
    private String viaCepUrl;

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(5000, 10000);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ViaCepService viaCepService() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new ViaCepDecoder())
                .options(requestOptions())
                .logger(new feign.slf4j.Slf4jLogger(ViaCepService.class))
                .logLevel(feignLoggerLevel())
                .target(ViaCepService.class, viaCepUrl);
    }
}
