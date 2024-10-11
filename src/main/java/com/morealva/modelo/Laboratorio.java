package com.morealva.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idLaboratorio;

    @Column(nullable = false, length = 250)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String alias;

    @Column(nullable = false)
    private Boolean estado;
}
