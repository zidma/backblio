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
    private String firstName;
    private String lastName;
    @Column(nullable = true)
    private String school;
    @Column(nullable = true)
    private String phone;
}
