package com.riwi.vacants.entities;

import com.riwi.vacants.utils.enums.StateVacant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "vacants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false, length = 40)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private StateVacant status;

    // ManyToOne - Muchos a uno: quiere decir que muchas vacantes solo puede ser de una empresa.
    // fetchType.Lazy - solo va a traer solo los atributos de la vacante, hasta que le especifiquemos si queremos que traiga toda la imporfación de la compañía
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Empresa empresa;
}
