package com.morealva.controller;

import com.morealva.dto.PrincipioActivoDTO;
import com.morealva.modelo.PrincipioActivo;
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

    @GetMapping("/{idProducto}")
    public ResponseEntity<List<PrincipioActivoDTO>> getProductosById(@PathVariable("idProducto") Integer idProducto){
        List<PrincipioActivo> list = productoPrincipioActivoService.getPrincipioActivosByProductoId(idProducto);
        List<PrincipioActivoDTO> listDTO = mapperUtil.mapList(list, PrincipioActivoDTO.class);
        return ResponseEntity.ok(listDTO);
    }

}
