package com.atsoft.backblio.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String resume;
    private String extrait;
    private String type;
    @ManyToOne
    private Auteur auteur;
}
