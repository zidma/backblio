package com.atsoft.backblio.entities;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Abonne {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date naissance;
    private String proffession;
    @Column(nullable = true)
    private String ecole;
    private Long profile;
    private String telephone;
}
