package com.atsoft.backblio.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    @Lob
    @Column(length = 1000)
    private byte[]fileData;
    @ManyToOne
    @JoinColumn(name = "id_doc",nullable = true)
    private Document document;
    @ManyToOne
    @JoinColumn(name = "id_ab",nullable = true)
    private Abonne abonne;
}
