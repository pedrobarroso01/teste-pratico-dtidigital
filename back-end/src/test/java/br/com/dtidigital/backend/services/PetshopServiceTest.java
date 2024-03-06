package br.com.dtidigital.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.repository.PetshopRepository;

@SpringBootTest
public class PetshopServiceTest {

    @Autowired
    private PetshopService ps;

    @MockBean
    private PetshopRepository pr;

    @Test
    public void testCalcularPrecoTotal() {
        PetshopModel petshop = new PetshopModel("Meu Canino Feliz", 2000, 20.0, 40.0, 22.0, 44.0);
        String data = "2024-03-05"; //Dia útil 
        int qtdPequenos = 2;
        int qtdGrandes = 3;

        //Preço retornado do calculo
        double precoTotal = ps.calcularPrecoTotal(petshop, data, qtdPequenos, qtdGrandes);

        //Preço esperado para um dia útil
        double precoEsperado = (qtdPequenos * petshop.getPrecoPequeno()) + (qtdGrandes * petshop.getPrecoGrande());

        assertEquals(precoEsperado, precoTotal, 0.001); // 0.001 de margem de erro devido a possíveis arredondamentos
    }

    @Test
    public void testCalcularPrecoTotalFinalDeSemana() {
        PetshopModel petshop = new PetshopModel("Meu Canino Feliz", 2000, 20.0, 40.0, 22.0, 44.0);
        String data = "2024-03-09"; //Final de Semana
        int qtdPequenos = 2;
        int qtdGrandes = 3;

        //Preço retornado do calculo
        double precoTotal = ps.calcularPrecoTotal(petshop, data, qtdPequenos, qtdGrandes);

        //Preço esperado para o final de semana
        double precoEsperado = (qtdPequenos * petshop.getPrecoPequenoFDS()) + (qtdGrandes * petshop.getPrecoGrandeFDS());

        assertEquals(precoEsperado, precoTotal, 0.001); // 0.001 de margem de erro devido a possíveis arredondamentos
    }
}




