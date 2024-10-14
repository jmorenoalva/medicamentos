package com.morealva.feignclient;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductoListDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "FARMAPRECIOS-ALL", url = "https://www.farmaprecios.com.pe/apirest/")
public interface FarmapreciosAll {
    @PostMapping(value = "/busquedaWhere", consumes = "application/json", produces = "application/json")
    ProductoListDTOResponse busquedaProductos (@RequestBody ProductosListRequest productosListRequest);

}
