package com.atsoft.backblio.controller;
import com.atsoft.backblio.dtos.DocumentDto;
import com.atsoft.backblio.entities.Document;
import com.atsoft.backblio.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService abonneService;
    @PostMapping(path = "/add")
    public Document addNew(@RequestParam("files")MultipartFile[] files, @RequestBody DocumentDto dto) throws IOException {
        return  this.abonneService.saveDocument(files,dto);
    }
    @PostMapping(path = "/update/{id}")
    public Document update(@PathVariable Long id, @RequestBody DocumentDto dto){
        return  this.abonneService.updateDocument(id,dto);
    }
    @GetMapping(path = "/{id}")
    public Document findById(@PathVariable Long id){
        return  this.abonneService.findById(id);
    }
    @GetMapping(path = "")
    public List<Document> allMatieres(){
        return  this.abonneService.listeDocuments();
    }
}
