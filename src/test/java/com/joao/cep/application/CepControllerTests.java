package com.joao.cep.application;

import com.joao.cep.model.CepData;
import com.joao.cep.services.CepServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CepControllerTests {

	@Mock
	private CepServices cepServices;

	@InjectMocks
	private CepController cepController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	private static final CepData CEP_DATA = CepData.builder()
			.cep("12345678")
			.logradouro("Rua 1")
			.build();

	@Test
	public void testGetCepData() {
		String cep = "12345678";
		when(cepServices.getCep(cep)).thenReturn(CEP_DATA);

		CepData result = cepController.getCepData(cep);

		assertNotNull(result);
		assertEquals(cep, result.getCep());
		verify(cepServices, times(1)).getCep(cep);
	}

	@Test
	public void testFindAllLocal() {
		Set<CepData> cepDataSet = new HashSet<>();
		cepDataSet.add(CEP_DATA);
		when(cepServices.findAllLocal()).thenReturn(cepDataSet);

		Set<CepData> result = cepController.findAllLocal();

		assertNotNull(result);
		assertEquals(1, result.size());
		verify(cepServices, times(1)).findAllLocal();
	}

}
