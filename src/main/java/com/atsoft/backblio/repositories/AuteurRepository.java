package com.atsoft.backblio.repositories;

import com.atsoft.backblio.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur,Long> {
}
