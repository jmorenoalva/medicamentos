package com.morealva.controller;

import com.morealva.dto.ProductoDTO;
import com.morealva.modelo.Producto;
import com.morealva.service.IProductoService;
import com.morealva.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll() {
        List<ProductoDTO> list = mapperUtil.mapList(productoService.findAll(), ProductoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable("id") Integer id) {
        Producto obj = productoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ProductoDTO.class));
    }

}
