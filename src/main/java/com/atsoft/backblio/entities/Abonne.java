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
    private String firstName;
    private String lastName;
    @Column(nullable = true)
    private String school;
    @Column(nullable = true)
    private Long idCard;
    private Long picture;
    private String phone;
    private String customerId;
}
