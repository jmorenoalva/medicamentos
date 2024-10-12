package com.morealva.aggregates.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosListResponse {
    private Integer id;
    private String nombre;
    private String laboratorio;
    private String principio;
    private String indicacion;
    private String patologia;
}
