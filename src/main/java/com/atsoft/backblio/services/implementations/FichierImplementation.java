package com.atsoft.backblio.services.implementations;
import com.atsoft.backblio.entities.Fichier;
import com.atsoft.backblio.repositories.FichierRepository;
import com.atsoft.backblio.services.FichierService;
import com.atsoft.backblio.utils.FileOps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FichierImplementation implements FichierService {
    private final FichierRepository fichierRepository;

    @Override
    public Fichier findByName(String name) {
        return this.fichierRepository.findByName(name).orElse(null);
    }

    @Override
    public Fichier saveFile(MultipartFile file) throws IOException {

     Fichier fichier=   this.fichierRepository.save(Fichier.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(FileOps.compressImage(file.getBytes())).build());
     return  fichier;
    }

    @Override
    public Fichier[] saveMultipleFiles(MultipartFile[] files) throws IOException {
        Fichier[] fichiers=new Fichier[2];
        fichiers[0]=saveFile(files[0]);
        fichiers[1]=saveFile(files[1]);
        return fichiers;
    }

    @Override
    public byte[] retrieveFile(String name) {
        Optional<Fichier> dbImage = this.fichierRepository.findByName(name);
        byte[] image=null;
        if(dbImage.isPresent()){
            image = FileOps.decompressImage(dbImage.get().getFileData());
        }
        return  image;
    }

    @Override
    public Fichier getRealFile(String name) {
        Optional<Fichier> dbImage = this.fichierRepository.findByName(name);
        return   dbImage.map(fileData -> Fichier.builder()
                .name(fileData.getName())
                .type(fileData.getType())
                .fileData(FileOps.decompressImage(fileData.getFileData())).build()).orElse(null);
    }
}
