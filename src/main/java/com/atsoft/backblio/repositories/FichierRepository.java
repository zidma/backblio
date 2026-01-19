package com.atsoft.backblio.repositories;

import com.atsoft.backblio.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FichierRepository extends JpaRepository<Fichier,Long> {
    Optional<Fichier> findByName(String name);
}
