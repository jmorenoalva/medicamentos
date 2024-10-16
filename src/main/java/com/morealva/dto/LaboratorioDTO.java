package com.morealva.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaboratorioDTO {

    private Integer idLaboratorio;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 250, message = "{{nombre.size}}")
    private String nombre;

    @NotNull
    @Size(min = 2, max = 150, message = "{{alias.size}}")
    private String alias;

    @NotNull
    private Boolean estado;

}
