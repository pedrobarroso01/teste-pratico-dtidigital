package br.com.dtidigital.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.services.PetshopService;

@RestController
@RequestMapping(path="/petshops")
public class PetshopController {
    
    @Autowired
    private PetshopService petshopService;

    public ResponseEntity<PetshopModel> encontrarMelhorPetshop() {
        PetshopModel melhorPetshop = petshopService.encontrarMelhorPetshop();
        return ResponseEntity.ok(melhorPetshop);
    } 
}
