package com.morealva.service.impl;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductoDTOResponse;
import com.morealva.aggregates.response.ProductoListDTOResponse;
import com.morealva.feignclient.FarmapreciosAll;
import com.morealva.feignclient.FarmapreciosProductos;
import com.morealva.modelo.Vigencia;
import com.morealva.service.IProductoListService;
import com.morealva.service.IVigenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoListServiceImpl implements IProductoListService {
    
    private final FarmapreciosAll farmapreciosAll;
    private final FarmapreciosProductos farmapreciosProductos;
    private final IVigenciaService vigenciaService;

    @Override
    public ProductoListDTOResponse getListaProductosFarmaprecios(ProductosListRequest request) {

        Vigencia vigencia =vigenciaService.createVigenciaAutomatico("0001");

        ProductoListDTOResponse productoListDTOResponse = farmapreciosAll.busquedaProductos(request);

        productoListDTOResponse.getProductos().forEach(productoListDTO -> {
            ProductoDTOResponse productoDTOResponse = farmapreciosProductos.buscarProductoPorId(productoListDTO.getId());


            System.out.println(productoDTOResponse);

        });

        return null;
    }
}
