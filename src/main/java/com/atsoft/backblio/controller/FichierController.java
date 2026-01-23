package com.atsoft.backblio.controller;
import com.atsoft.backblio.entities.Fichier;
import com.atsoft.backblio.services.FichierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequestMapping("/api/fichiers")
@RequiredArgsConstructor
public class FichierController {
    private final FichierService fichierService;
    @PostMapping(path = "/add",consumes= MediaType.MULTIPART_FORM_DATA_VALUE )
    public Fichier addFile(@RequestParam("file") MultipartFile file) throws IOException {
        return this.fichierService.saveFile(file);
    }
    public  Fichier[] saveMultipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        return  this.fichierService.saveMultipleFiles(files);
    }
}
