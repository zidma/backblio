package com.atsoft.backblio.services.implementations;

import com.atsoft.backblio.dtos.DocumentDto;
import com.atsoft.backblio.entities.Document;
import com.atsoft.backblio.repositories.DocRepository;
import com.atsoft.backblio.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DocumentImplementation  implements DocumentService {
    private final DocRepository docRepository;
    @Override
    public Document saveDocument(DocumentDto dto) {
         Document document=Document.builder()
                 .auteur(dto.getAuteur())
                 .code(dto.getCode())
                 .titre(dto.getTitle())
                 .type(dto.getType())
                 .preface(dto.getPreface())
                 .build();
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
