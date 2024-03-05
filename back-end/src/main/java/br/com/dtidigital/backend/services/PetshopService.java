package br.com.dtidigital.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.repository.PetshopRepository;

@Service
public class PetshopService {
    
    @Autowired
    private PetshopRepository petshopRepository;

    public PetshopModel encontrarMelhorPetshop() {
        // Implemente a lógica para encontrar o melhor petshop
        // Calcule os preços e considere a distância e o período (se é final de semana)
        return new PetshopModel();
    }
}
