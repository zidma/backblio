package com.atsoft.backblio.controller;
import com.atsoft.backblio.entities.Fichier;
import com.atsoft.backblio.services.FichierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequestMapping("/api/fichiers")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FichierController {
    private final FichierService fichierService;
    @PostMapping(path = "/add",consumes= MediaType.MULTIPART_FORM_DATA_VALUE )
    public Fichier addFile(@RequestParam("file") MultipartFile file) throws IOException {
        return this.fichierService.saveFile(file);
    }
    @PostMapping(path = "/multiples")
    public  Fichier[] saveMultipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        return  this.fichierService.saveMultipleFiles(files);
    }
    @GetMapping(path = "/{id}")
    public byte[] getFileById(@PathVariable Long id){
        return this. fichierService.getById(id);
    }
}
