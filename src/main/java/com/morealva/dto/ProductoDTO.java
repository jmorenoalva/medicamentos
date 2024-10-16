package com.morealva.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.morealva.modelo.Presentacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer idProducto;

    @NotNull
    private VigenciaDTO vigencia;

    @NotNull
    private LaboratorioDTO laboratorio;

    @NotNull
    private Integer idCodigo;

    @NotNull
    @NotBlank
    @NotEmpty
    private String nombre;

    private String indicacion;

    @NotNull
    @NotBlank
    @NotEmpty
    private LocalDateTime fechaCreacion;


    private String patologia;

    @NotNull
    private String estado_pagina;

    @NotNull
    private Boolean estado;

    @NotNull
    @JsonManagedReference
    private List<Presentacion> presentaciones;
}
