package com.morealva.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VigenciaDTO {

    private Integer idVigencia;

    @JsonBackReference
    private PaginaDTO pagina;

    @NotNull
    private Integer anio;

    @NotNull
    private String mes;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private Boolean estado;

}
