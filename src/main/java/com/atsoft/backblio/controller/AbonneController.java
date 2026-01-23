package com.atsoft.backblio.controller;

import com.atsoft.backblio.dtos.AbonneDto;
import com.atsoft.backblio.entities.Abonne;
import com.atsoft.backblio.services.AbonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RequestMapping("/api/abonnes")
@RequiredArgsConstructor
public class AbonneController {
    private final AbonneService abonneService;
    @PostMapping(path ="/add")
    public Abonne addNew(@RequestParam("file") MultipartFile file, @RequestBody AbonneDto dto) throws IOException {
        return  this.abonneService.saveAbone(file, dto);
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
}
