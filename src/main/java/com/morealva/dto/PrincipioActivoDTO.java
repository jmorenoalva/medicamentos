package com.morealva.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrincipioActivoDTO {

    private Integer idPrincipio;

    @NotNull
    private String nombre;

    @NotNull
    private Boolean estado;
}
