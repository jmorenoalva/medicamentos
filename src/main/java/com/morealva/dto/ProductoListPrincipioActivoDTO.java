package com.morealva.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoListPrincipioActivoDTO {

    @NotNull
    private ProductoDTO producto;

    @NotNull
    private List<PrincipioActivoDTO> listPrincipioActivo;
}
