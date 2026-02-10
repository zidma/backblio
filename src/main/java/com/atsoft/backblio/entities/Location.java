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
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date date;
    @ManyToOne
    private Abonne abonne;
    @ManyToOne
    private Document document;
    private boolean retour=false;
}
