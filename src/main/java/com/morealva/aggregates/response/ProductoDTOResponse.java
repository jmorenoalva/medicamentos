package com.morealva.aggregates.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDTOResponse {

    private Integer id;
    private String nombre;
    private String Laboratorio;
    private String principio;
    private String indicacion;
    private String fecha_creacion;
    private String fecha_actualizacion;
    private String estado;
    private String esnuevo;
    private String modificacion;
    private String patologia;
    private String id_patologia;
    List<ProductoPresentacionResponseDTO> presentacion;
}
