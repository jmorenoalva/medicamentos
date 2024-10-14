package com.morealva.aggregates.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductoListDTOResponse {

    List<ProductosListResponse> productos;

    String total;
}
