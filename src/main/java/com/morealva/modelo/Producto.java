package com.morealva.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "id_vigencia", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCTO_VIGENCIA"))
    private Vigencia vigencia;

    @ManyToOne
    @JoinColumn(name = "id_laboratorio", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCTO_LABORATORIO"))
    private Laboratorio laboratorio;

    @Column(nullable = false)
    private Integer idCodigo;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 250)
    private String indicacion;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(length = 250)
    private String patologia;

    @Column(nullable = false, length = 1)
    private String estado_pagina;

    @Column(nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Presentacion> presentaciones;
}
