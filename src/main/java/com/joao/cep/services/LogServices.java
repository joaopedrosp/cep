package com.joao.cep.services;

import com.joao.cep.entity.Log;
import com.joao.cep.model.LogSeverityEnum;
import com.joao.cep.repository.LogRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LogServices {
    private final LogRepository logRepository;

    public LogServices(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional
    public void info(final String content){
        this.save(Log.builder()
                    .uuid(UUID.randomUUID().toString())
                    .severity(LogSeverityEnum.INFO.name())
                    .content(content)
                .build());
    }

    @Transactional
    public void error(final String content){
        this.save(Log.builder()
                .uuid(UUID.randomUUID().toString())
                .severity(LogSeverityEnum.ERROR.name())
                .content(content)
                .build());
    }

    private void save(final Log log){
        logRepository.save(log);
    }
}
