package com.joao.cep.services;

import com.joao.cep.dto.CepDataDTO;
import com.joao.cep.entity.CepDataEntity;
import com.joao.cep.model.CepData;
import com.joao.cep.repository.CepDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CepServicesTest {

    @Mock
    private ExternalCepService externalCepService;

    @Mock
    private CepDataRepository cepDataRepository;

    @Mock
    private LogServices logger;

    @InjectMocks
    private CepServices cepServices;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    private static final String CEP = "12345678";

    private static final CepDataEntity CEP_DATA_ENTITY = CepDataEntity.builder()
            .cep(CEP)
            .build();

    private static final CepDataDTO CEP_DATA_DTO = CepDataDTO.builder()
            .cep(CEP)
            .build();

    @Test
    public void testGetCep_FoundInLocalRepository() {
        when(cepDataRepository.findByCep(CEP)).thenReturn(Optional.of(CEP_DATA_ENTITY));

        CepData result = cepServices.getCep(CEP);

        assertNotNull(result);
        assertEquals(CEP, result.getCep());
        verify(cepDataRepository, times(1)).findByCep(CEP);
        verify(externalCepService, never()).getData(anyString());
    }

    @Test
    public void testGetCep_NotFoundInLocalRepository_FetchFromExternalService() {
        when(cepDataRepository.findByCep(CEP)).thenReturn(Optional.empty());
        when(externalCepService.getData(CEP)).thenReturn(CEP_DATA_DTO);

        CepData result = cepServices.getCep(CEP);

        assertNotNull(result);
        assertEquals(CEP, result.getCep());
        verify(cepDataRepository, times(1)).findByCep(CEP);
        verify(externalCepService, times(1)).getData(CEP);
    }

    @Test
    public void testFindAllLocal() {
        List<CepDataEntity> cepDataEntities = Arrays.asList(CEP_DATA_ENTITY);
        when(cepDataRepository.findAll()).thenReturn(cepDataEntities);

        Set<CepData> result = cepServices.findAllLocal();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(cepDataRepository, times(1)).findAll();
    }
}
