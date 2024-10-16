package com.morealva.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresentacionDTO {

    private Integer idPresentacion;

    @NotNull
    private Integer idCodigo;

    @JsonBackReference
    private ProductoDTO producto;

    @NotNull
    private Integer idCodProd;

    @NotNull
    private String nombre;

    @NotNull
    private Double pvf;

    @NotNull
    private Double pvp;

    @NotNull
    private String modificaciones;

    @NotNull
    private Boolean estado;
}
