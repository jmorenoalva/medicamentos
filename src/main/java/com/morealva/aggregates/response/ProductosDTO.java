package com.morealva.aggregates.response;

import com.morealva.aggregates.request.ProductosListRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductosDTO {
    List<ProductosListResponse> productos;

    String total;
}
