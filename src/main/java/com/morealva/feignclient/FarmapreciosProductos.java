package com.morealva.feignclient;

import com.morealva.aggregates.response.ProductoDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FARMAPRECIOS-PRODUCTO", url = "https://www.farmaprecios.com.pe/apirest/busquedaProducto/")
public interface FarmapreciosProductos {
    @GetMapping(value = "/{id}")
    ProductoDTOResponse buscarProductoPorId(@PathVariable("id") Integer id);
}
