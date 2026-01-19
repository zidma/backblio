package com.atsoft.backblio.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbonneDto {
    private String nom;
    private String prenom;
    private Date naissance;
    @Column(nullable = true)
    private String proffession;
    @Column(nullable = true)
    private String ecole;
    @Column(nullable = true)
    private Long piece;
    private String telephone;
}
