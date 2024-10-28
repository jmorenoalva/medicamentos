package com.morealva.controller;

import com.morealva.dto.PrincipioActivoDTO;
import com.morealva.dto.ProductoDTO;
import com.morealva.modelo.PrincipioActivo;
import com.morealva.modelo.Producto;
import com.morealva.service.IProductoPrincipioActivoService;
import com.morealva.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productoprincipio")
@RequiredArgsConstructor
public class ProductoPrincipioActivoController {

    private final IProductoPrincipioActivoService productoPrincipioActivoService;
    private final MapperUtil mapperUtil;

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<PrincipioActivoDTO>> getPrincipiosByIdProducto(@PathVariable("idProducto") Integer idProducto){
        List<PrincipioActivo> list = productoPrincipioActivoService.getPrincipioActivosByProductoId(idProducto);
        List<PrincipioActivoDTO> listDTO = mapperUtil.mapList(list, PrincipioActivoDTO.class);
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/principio/{idPrincipio}")
    public ResponseEntity<List<ProductoDTO>> getProductosByIdPrincipios(@PathVariable("idPrincipio") Integer idPrincipio){
        List<Producto> list = productoPrincipioActivoService.getProductoByPrincipioActivoId(idPrincipio);
        List<ProductoDTO> listDTO = mapperUtil.mapList(list, ProductoDTO.class);
        return ResponseEntity.ok(listDTO);
    }

}
