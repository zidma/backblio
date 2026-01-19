package com.atsoft.backblio.repositories;

import com.atsoft.backblio.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Long> {
}
