package br.com.dtidigital.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dtidigital.backend.models.PetshopModel;

public interface PetshopRepository extends JpaRepository<PetshopModel, Long> {
    // Caso seja útil
}

