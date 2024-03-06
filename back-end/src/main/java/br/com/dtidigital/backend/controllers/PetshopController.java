package br.com.dtidigital.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.models.PetshopRequest;
import br.com.dtidigital.backend.repository.PetshopRepository;
import br.com.dtidigital.backend.services.PetshopService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(path="/petshops")
public class PetshopController {
    
    @Autowired
    private PetshopService petshopService;

    @RequestMapping(path="/encontrar",method = RequestMethod.POST)
    public ResponseEntity<?> encontrarMelhorPetshop(@RequestBody PetshopRequest request) {
        ResponseEntity<?> melhorPetshop = petshopService.encontrarMelhorPetshop(request.getData(), request.getQtdPequenos(), request.getQtdGrandes());
        return ResponseEntity.ok(melhorPetshop);
    } 

    @Autowired
    private PetshopRepository pr;

    @RequestMapping(path = "/listar",method = RequestMethod.GET) 
    public Iterable<PetshopModel> listar() {
        return pr.findAll();
    }
}
