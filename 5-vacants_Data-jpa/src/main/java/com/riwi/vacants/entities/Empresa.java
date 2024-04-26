package com.riwi.vacants.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false)
    private String locacion;
    @Column(nullable = false, length = 14)
    private String contacto;
    // @OneToMany - uno a muchos: Una empresa puede tener muchas vacantes.
    // mappedBy - es para especificar en la otra entidad cual atributo es el que va a guardar la información de la relación.
    // FetchType.EAGER - Join Implicito, o sea que si invocamos una empresa traemos todas las vacantes de ella misma
    // orphanRemoval si es true, se eliminarán todas las vacantes de la compañía junto a ella, y si es false, se elimina toda la compañía pero se quedan las vacantes.
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacante> vacantes;
}
