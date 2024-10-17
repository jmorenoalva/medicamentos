package com.morealva.service;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductoListDTOResponse;

public interface IProductoListService {

    ProductoListDTOResponse getListaProductosFarmaprecios(ProductosListRequest request);
}
