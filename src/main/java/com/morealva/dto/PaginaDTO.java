package com.morealva.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginaDTO {

    private Integer idPagina;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 4, message = "{{codigo.size}}")
    private String codigo;

    @NotNull
    @Size(min = 5, max=250, message = "{{nombre.size}}")
    private String nombre;

    @NotNull
    @Size(min = 5, max=250, message = "{{url.size}}")
    private String url;

    @NotNull
    private Boolean estado;
}
