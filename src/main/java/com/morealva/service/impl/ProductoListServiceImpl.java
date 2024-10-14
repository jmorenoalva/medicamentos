package com.morealva.service.impl;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductoListDTOResponse;
import com.morealva.feignclient.FarmapreciosAll;
import com.morealva.service.IProductoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoListServiceImpl implements IProductoListService {

    @Autowired
    private FarmapreciosAll farmapreciosAll;

    @Override
    public ProductoListDTOResponse getListaProductos(ProductosListRequest request) {
        return farmapreciosAll.busquedaProductos(request);
    }
}
