package com.morealva.aggregates.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductoDTOResponse {

    private Integer id;
    private String nombre;
    private String Laboratorio;
    private String principio;
    private String indicacion;
    private LocalDateTime fechaCreacion;
    private String fechaActualizacion;
    private String estado;
    private String esnuevo;
    private String modificacion;
    private String patologia;
    private String id_patologia;
    List<ProductoPresentacionResponseDTO> presentaciones;
    List<String> banners;
}
