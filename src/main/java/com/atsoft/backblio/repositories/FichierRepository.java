package com.atsoft.backblio.repositories;

import com.atsoft.backblio.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichierRepository extends JpaRepository<Fichier,Long> {
}
