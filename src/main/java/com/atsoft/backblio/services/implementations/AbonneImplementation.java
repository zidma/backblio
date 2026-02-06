package com.atsoft.backblio.services.implementations;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.entities.Fichier;
import com.atsoft.backblio.repositories.AboRepository;
import com.atsoft.backblio.repositories.FichierRepository;
import com.atsoft.backblio.services.AbonneService;
import com.atsoft.backblio.services.FichierService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AbonneImplementation implements AbonneService {
    private final AboRepository aboRepository;
    private final FichierService  fichierService;
    private final FichierRepository fichierRepository;
    @Override
    public Abonne saveAbone(MultipartFile photo,MultipartFile piece, AbonneDto dto) throws IOException {
        Fichier idCard=this.fichierService.saveFile(piece);
        Fichier profilPicture=this.fichierService.saveFile(photo);
       Abonne abonne=this.aboRepository.save(Abonne
               .builder()
               .firstName(dto.getFirstName())
                       .lastName(dto.getLastName())
               .phone(dto.getPhone())
               .school(dto.getSchool())
               .idCard(idCard.getId())
               .picture(profilPicture.getId())
               .build());
       Calendar cal=Calendar.getInstance();
       abonne.setCustomerId(Calendar.getInstance().get(Calendar.YEAR)+"".substring(2)+abonne.getId());
       return this.aboRepository.save(abonne);
    }
    @Override
    public Abonne updateAbonnee(Long id, AbonneDto dto) {
        Abonne abonne=this.aboRepository.findById(id).orElse(null);
         if(abonne!=null){
              Abonne newValue=Abonne.builder()
                      .firstName(dto.getFirstName())
                      .lastName(dto.getLastName())
                      .phone(dto.getPhone())
                      .school(dto.getSchool())
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

    @Override
    @Transactional
    public Abonne updatePicture(MultipartFile picture, Long id) throws IOException {
        Abonne abonne=this.aboRepository.findById(id).orElse(null);
        Fichier pictureToDelete=this.fichierRepository.findById(abonne.getPicture()).orElse(null);
        if(abonne!=null && pictureToDelete!=null){
            Fichier newPicture=this.fichierService.saveFile(picture);
             if(newPicture!=null){
                 this.fichierRepository.delete(pictureToDelete);
                 abonne.setPicture(newPicture.getId());
                 return this.aboRepository.save(abonne);
             }
        }
        return null;
    }

    @Override
    public Abonne updateIdCard(MultipartFile idCard, Long id) throws IOException {
        Abonne abonne=this.aboRepository.findById(id).orElse(null);
        Fichier fileToDelete=this.fichierRepository.findById(abonne.getIdCard()).orElse(null);
        if(abonne!=null && fileToDelete!=null){
            Fichier newFile=this.fichierService.saveFile(idCard);
            if(newFile!=null){
                this.fichierRepository.delete(fileToDelete);
                abonne.setIdCard(newFile.getId());
                return this.aboRepository.save(abonne);
            }
        }
        return null;
    }
}
