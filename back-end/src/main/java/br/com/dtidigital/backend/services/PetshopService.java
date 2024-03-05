package br.com.dtidigital.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dtidigital.backend.models.PetshopModel;
import br.com.dtidigital.backend.repository.PetshopRepository;


@Service
public class PetshopService {
    
    @Autowired
    private PetshopRepository petshopRepository;

    public int encontrarMelhorPetshop(String data, int qtdPequenos, int qtdGrandes ) {
        return qtdPequenos;
    }

    public Iterable<PetshopModel> listar() {
        return petshopRepository.findAll();
    }
}
