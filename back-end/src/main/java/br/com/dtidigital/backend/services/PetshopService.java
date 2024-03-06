package br.com.dtidigital.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.repository.PetshopRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;



@Service
public class PetshopService {
    
    @Autowired
    private PetshopRepository petshopRepository;

    public String encontrarMelhorPetshop(String data, int qtdPequenos, int qtdGrandes) {
        Iterable<PetshopModel> petshops = listar();
        PetshopModel melhorPetshop = null;
        double melhorPreco = Double.MAX_VALUE;
        int menorDistancia = Integer.MAX_VALUE;

        for(PetshopModel petshop: petshops) {
            double precoTotal = calcularPrecoTotal(petshop, data, qtdPequenos, qtdGrandes);
            if (precoTotal < melhorPreco || (precoTotal == melhorPreco && petshop.getDistancia() < menorDistancia)) {
                menorDistancia = petshop.getDistancia();
                melhorPetshop = petshop;
                melhorPreco = precoTotal;
            }
        }

        return "Melhor petshop: " + melhorPetshop.getNome() + "   |   " + 
        "Preço total: R$ " + melhorPreco;
    }

    public double calcularPrecoTotal (PetshopModel petshop, String data, int qtdPequenos, int qtdGrandes) {
        double precoPequenos = 0.0;
        double precoGrande = 0.0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data_formatada = LocalDate.parse(data, formato);

        DayOfWeek day = data_formatada.getDayOfWeek(); 
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            precoPequenos = petshop.getPrecoPequenoFDS();
            precoGrande = petshop.getPrecoGrandeFDS();

        } else {
            precoPequenos = petshop.getPrecoPequeno();
            precoGrande = petshop.getPrecoGrande();
        }

        double precoTotal = (qtdPequenos * precoPequenos) + (qtdGrandes * precoGrande);

        return precoTotal;
    }

    public Iterable<PetshopModel> listar() {
        return petshopRepository.findAll();
    }
}
