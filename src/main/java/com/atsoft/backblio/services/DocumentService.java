package com.atsoft.backblio.services;
import com.atsoft.backblio.dtos.DocumentDto;
import com.atsoft.backblio.entities.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {
    Document saveDocument(MultipartFile[] files, DocumentDto dto) throws IOException;
    Document updateDocument(Long id ,DocumentDto dto);
    Document findById(Long id);
    List<Document> listeDocuments();
}
