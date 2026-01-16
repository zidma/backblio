package com.atsoft.backblio.repositories;

import com.atsoft.backblio.entities.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboRepository extends JpaRepository<Abonne,Long> {
}
