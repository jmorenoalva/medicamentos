package com.morealva.controller;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductoListDTOResponse;
import com.morealva.service.IProductoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listproductos")
public class ListProductosController {

    @Autowired
    private IProductoListService productoListService;

    @PostMapping("/farmaprecios")
    public ProductoListDTOResponse getListProductos(@RequestBody ProductosListRequest productosListRequest) {

        return productoListService.getListaProductosFarmaprecios(productosListRequest);
    }
}
