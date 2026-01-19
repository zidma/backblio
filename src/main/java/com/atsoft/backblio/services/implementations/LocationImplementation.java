package com.atsoft.backblio.services.implementations;

import com.atsoft.backblio.dtos.LocationDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.entities.Document;
import com.atsoft.backblio.entities.Location;
import com.atsoft.backblio.repositories.AboRepository;
import com.atsoft.backblio.repositories.DocRepository;
import com.atsoft.backblio.repositories.LocationRepo;
import com.atsoft.backblio.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LocationImplementation implements LocationService {
    private final LocationRepo locationRepo;
    private final AboRepository aboRepository;
    private final DocRepository docRepository;
    @Override
    public Location saveLocation(LocationDto dto) {
        Abonne abonne=this.aboRepository.findById(dto.getAbonnee()).orElse(null);
        Document document =this.docRepository.findById(dto.getDocument()).orElse(null);
        if(abonne!=null){
            Location location=Location.builder()
                    .abonne(abonne)
                    .document(document)
                    .build();
            return this.locationRepo.save(location);
        }

        return null;
    }

    @Override
    public Location updateLocation(Long id, LocationDto dto) {
        Location location=this.locationRepo.findById(id).orElse(null);
         if(location!=null){
             Document document=this.docRepository.findById(dto.getDocument()).orElse(null);
             Abonne abonne=this.aboRepository.findById(dto.getAbonnee()).orElse(null);
              if(document!=null && abonne!=null){
                  location.setAbonne(abonne);
                  location.setDocument(document);
                  return this.locationRepo.save(location);
              }
         }
        return null;
    }

    @Override
    public Location findById(Long id) {
        return this .locationRepo.findById(id).orElse(null);
    }
    @Override
    public List<Location> listeLocations() {
        return this.locationRepo.findAll();
    }
}
