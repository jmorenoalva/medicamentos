package com.morealva.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosListRequest {

    private Integer pagina;
    private Integer limit;
}
