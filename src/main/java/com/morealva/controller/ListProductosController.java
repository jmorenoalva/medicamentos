package com.morealva.controller;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.BaseResponse;
import com.morealva.aggregates.response.ProductosDTO;
import com.morealva.aggregates.response.ProductosListResponse;
import com.morealva.service.IProductoListService;
import com.morealva.service.impl.ProductoListServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listproductos")
public class ListProductosController {

    @Autowired
    private IProductoListService productoListService;

//    public ListProductosController(IProductoListService productoListService) {
//        this.productoListService = productoListService;
//    }

    @PostMapping("/farmaprecios")
    public ProductosDTO getListProductos(@RequestBody ProductosListRequest productosListRequest) {

        return productoListService.getListaProductos(productosListRequest);
    }
}
