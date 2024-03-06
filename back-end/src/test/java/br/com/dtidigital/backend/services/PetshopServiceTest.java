package br.com.dtidigital.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.dtidigital.backend.models.ModelResponse;
import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.repository.PetshopRepository;

@SpringBootTest
public class PetshopServiceTest {

    @Autowired
    private PetshopService petshopService;

    @MockBean
    private PetshopRepository petshopRepository;

    @BeforeEach
    void setUp() {
        PetshopModel petshop = new PetshopModel("Meu Canino Feliz", 2000, 20.0, 40.0, 24.0, 48.0);
        when(petshopRepository.findAll()).thenReturn(Arrays.asList(petshop));
    }

    @Test
    public void testEncontrarMelhorPetshopDiaUtil() {
        // Configuração do cenário
        String data = "2024-03-06";
        int qtdPequenos = 2;
        int qtdGrandes = 3;

        // Execução do método sob teste
        ResponseEntity<ModelResponse> response = petshopService.encontrarMelhorPetshop(data, qtdPequenos, qtdGrandes);

        // Verificação do resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Melhor petshop: Meu Canino Feliz   |   Preço total: R$ 160.0", response.getBody().getMensagem());
    }

    @Test
    public void testEncontrarMelhorPetshopFinalDeSemana() {
        // Configuração do cenário
        String data = "2024-03-09";
        int qtdPequenos = 2;
        int qtdGrandes = 3;

        // Execução do método sob teste
        ResponseEntity<ModelResponse> response = petshopService.encontrarMelhorPetshop(data, qtdPequenos, qtdGrandes);

        // Verificação do resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Melhor petshop: Meu Canino Feliz   |   Preço total: R$ 192.0", response.getBody().getMensagem());
    }
}
