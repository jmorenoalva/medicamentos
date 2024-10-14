package com.morealva.aggregates.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPresentacionResponseDTO {

    private Integer id;
    private String idprd;
    private String nombre;
    private double pvf;
    private double pvp;
    private String modificaciones;
}
