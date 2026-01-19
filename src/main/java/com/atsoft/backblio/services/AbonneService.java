package com.atsoft.backblio.services;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.entities.Abonne;

import java.util.List;

public interface AbonneService {
    Abonne saveAbone(AbonneDto dto);
    Abonne updateAbonnee(Long id ,AbonneDto dto);
    Abonne findById(Long id);
    List<Abonne>  listeABonnes();
}
