package com.atsoft.backblio.controller;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.services.AbonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/abonnes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AbonneController {
    private final AbonneService abonneService;
    @PostMapping(path ="/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Abonne addNew(@RequestParam("photo") MultipartFile photo, @RequestParam("piece") MultipartFile piece, @RequestBody AbonneDto dto) throws IOException {
        return  this.abonneService.saveAbone(photo,piece, dto);
    }
    @PostMapping(path = "/update/{id}")
    public Abonne update(@PathVariable Long id, @RequestBody AbonneDto dto){
        return  this.abonneService.updateAbonnee(id,dto);
    }
    @GetMapping(path = "/{id}")
    public Abonne findById(@PathVariable Long id){
        return  this.abonneService.findById(id);
    }
    @GetMapping(path = "")
    public List<Abonne> allMatieres(){
        return  this.abonneService.listeABonnes();
    }
    @PostMapping(path ="/updatePicture",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Abonne updatePicture(@RequestParam("picture") MultipartFile picture, @PathVariable Long id) throws IOException {
        return this.abonneService .updatePicture(picture,id);
    }
    @PostMapping(path ="/updateIdCard",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Abonne updateIdCard(@RequestParam("picture") MultipartFile picture, @PathVariable Long id) throws IOException {
        return this.abonneService .updateIdCard(picture,id);
    }
}
