package com.morealva.service.impl;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.BaseResponse;
import com.morealva.aggregates.response.ProductosDTO;
import com.morealva.aggregates.response.ProductosListResponse;
import com.morealva.feignclient.FarmapreciosAll;
import com.morealva.service.IProductoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoListServiceImpl implements IProductoListService {

    @Autowired
    private FarmapreciosAll farmapreciosAll;

    @Override
    public ProductosDTO getListaProductos(ProductosListRequest request) {
        return farmapreciosAll.busquedaProductos(request);
    }
}
