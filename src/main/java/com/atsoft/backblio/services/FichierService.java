package com.atsoft.backblio.services;
import com.atsoft.backblio.entities.Fichier;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface FichierService {
    Fichier findByName(String name);
    Fichier saveFile(MultipartFile file) throws IOException;
    Fichier[] saveMultipleFiles (MultipartFile[] files) throws IOException;
    byte[] retrieveFile(String name);
    Fichier getRealFile(String name);
}
