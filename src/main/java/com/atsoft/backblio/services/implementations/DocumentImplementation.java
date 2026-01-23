package com.atsoft.backblio.services.implementations;

import com.atsoft.backblio.dtos.DocumentDto;
import com.atsoft.backblio.entities.Document;
import com.atsoft.backblio.entities.Fichier;
import com.atsoft.backblio.repositories.DocRepository;
import com.atsoft.backblio.repositories.FichierRepository;
import com.atsoft.backblio.services.DocumentService;
import com.atsoft.backblio.services.FichierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DocumentImplementation  implements DocumentService {
    private final DocRepository docRepository;
    private final FichierService fichierService;
    private final FichierRepository fichierRepository;
    @Override
    public Document saveDocument(MultipartFile[] files, DocumentDto dto) throws IOException {
        Fichier[] fichiers=fichierService.saveMultipleFiles(files);
         Document document=Document.builder()
                 .auteur(dto.getAuteur())
                 .code(dto.getCode())
                 .titre(dto.getTitle())
                 .type(dto.getType())
                 .preface(dto.getPreface())
                 .build();
         fichiers[0].setDocument(document);
         fichiers[1].setDocument(document);
         this.fichierRepository.save(fichiers[0]);
         this.fichierRepository.save(fichiers[1]);
        return this .docRepository.save(document);
    }

    @Override
    public Document updateDocument(Long id, DocumentDto dto) {
        Document document=this.docRepository.findById(id).orElse(null);
         if(document!=null){
             Document newDocument=Document.builder()
                     .auteur(dto.getAuteur())
                     .code(dto.getCode())
                     .titre(dto.getTitle())
                     .type(dto.getType())
                     .preface(dto.getPreface())
                     .build();
             return this.docRepository.save(newDocument);
         }
        return null;
    }

    @Override
    public Document findById(Long id) {
        return this.docRepository.findById(id).orElse(null);
    }

    @Override
    public List<Document> listeDocuments() {
        return this.docRepository.findAll();
    }
}
