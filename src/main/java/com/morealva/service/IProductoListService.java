package com.morealva.service;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.BaseResponse;
import com.morealva.aggregates.response.ProductosDTO;
import com.morealva.aggregates.response.ProductosListResponse;

import java.util.List;

public interface IProductoListService {

    ProductosDTO getListaProductos(ProductosListRequest request);
}
