package com.atsoft.backblio.services;
import com.atsoft.backblio.dtos.DocumentDto;
import com.atsoft.backblio.entities.Document;

import java.util.List;

public interface DocumentService {
    Document saveDocument(DocumentDto dto);
    Document updateDocument(Long id ,DocumentDto dto);
    Document findById(Long id);
    List<Document> listeDocuments();
}
