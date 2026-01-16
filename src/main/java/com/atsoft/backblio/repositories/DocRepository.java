package com.atsoft.backblio.repositories;

import com.atsoft.backblio.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Document,Long> {
}
