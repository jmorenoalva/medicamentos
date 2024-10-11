package com.morealva.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vigencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idVigencia;

    @ManyToOne
    @JoinColumn(name = "id_pagina", nullable = false, foreignKey = @ForeignKey(name = "FK_VIGENCIA_PAGINA"))
    private Pagina pagina;

    @Column(nullable = false)
    private Integer anio;

    @Column(length = 2, nullable = false)
    private String mes;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Boolean estado;
}
