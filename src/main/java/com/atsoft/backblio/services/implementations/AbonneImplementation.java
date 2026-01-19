package com.atsoft.backblio.services.implementations;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.repositories.AboRepository;
import com.atsoft.backblio.services.AbonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AbonneImplementation implements AbonneService {
    private final AboRepository aboRepository;
    @Override
    public Abonne saveAbone(AbonneDto dto) {
       Abonne abonne=Abonne
               .builder()
               .nom(dto.getNom())
               .telephone(dto.getTelephone())
               .ecole(dto.getEcole())
               .proffession(dto.getProffession())
               .naissance(dto.getNaissance())
               .build();
       return this.aboRepository.save(abonne);
    }
    @Override
    public Abonne updateAbonnee(Long id, AbonneDto dto) {
        Abonne abonne=this.aboRepository.findById(id).orElse(null);
         if(abonne!=null){
              Abonne newValue=Abonne.builder()
                      .nom(dto.getNom())
                      .telephone(dto.getTelephone())
                      .ecole(dto.getEcole())
                      .proffession(dto.getProffession())
                      .naissance(dto.getNaissance())
                      .build();
              return this.aboRepository.save(newValue);
         }
        return null;
    }

    @Override
    public Abonne findById(Long id) {
        return this.aboRepository.findById(id).orElse(null);
    }
    @Override
    public List<Abonne> listeABonnes() {
        return this.aboRepository.findAll();
    }
}
