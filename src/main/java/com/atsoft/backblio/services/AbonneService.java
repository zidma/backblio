package com.atsoft.backblio.services;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.entities.Abonne;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
public interface AbonneService {
    Abonne saveAbone( MultipartFile photo,MultipartFile piece, AbonneDto dto) throws IOException;
    Abonne updateAbonnee(Long id ,AbonneDto dto);
    Abonne findById(Long id);
    List<Abonne>  listeABonnes();
    Abonne updatePicture(MultipartFile picture, Long id)throws IOException;
    Abonne updateIdCard( MultipartFile idCard,Long id)throws IOException;
}
