package com.morealva.feignclient;

import com.morealva.aggregates.response.ProductosListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "", url = "https://www.farmaprecios.com.pe/apirest/")
public interface FarmapreciosAll {
    @GetMapping("/busquedaWhere")
}
