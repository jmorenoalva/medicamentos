package com.morealva.feignclient;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductosDTO;
import com.morealva.aggregates.response.ProductosListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "FARMAPRECIOS-ALL", url = "https://www.farmaprecios.com.pe/apirest/")
public interface FarmapreciosAll {
    @PostMapping(value = "/busquedaWhere", consumes = "application/json", produces = "application/json")
    ProductosDTO busquedaProductos (@RequestBody ProductosListRequest productosListRequest);

}
