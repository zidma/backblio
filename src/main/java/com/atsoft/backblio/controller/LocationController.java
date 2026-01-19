package com.atsoft.backblio.controller;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.dtos.LocationDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.entities.Location;
import com.atsoft.backblio.services.AbonneService;
import com.atsoft.backblio.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationService locationService;
    @PostMapping(path = "/add")
    public Location addNew(@RequestBody LocationDto dto){
        return  this.locationService.saveLocation(dto);
    }
    @PostMapping(path = "/update/{id}")
    public Location update(@PathVariable Long id, @RequestBody LocationDto dto){
        return  this.locationService.updateLocation(id,dto);
    }
    @GetMapping(path = "/{id}")
    public Location findById(@PathVariable Long id){
        return  this.locationService.findById(id);
    }
    @GetMapping(path = "")
    public List<Location> allMatieres(){
        return  this.locationService.listeLocations();
    }
}
