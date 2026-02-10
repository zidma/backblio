package com.atsoft.backblio.services;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.dtos.LocationDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.entities.Location;

import java.util.List;

public interface LocationService {
    Location saveLocation(LocationDto dto);
    Location updateLocation(Long id ,LocationDto dto);
    Location findById(Long id);
    List<Location> listeLocations();
    List<Location> addMultiple(Long abonne,Long[] docs);
}
