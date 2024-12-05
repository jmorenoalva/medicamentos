package com.morealva.controller;

import com.morealva.dto.ProductoDTO;
import com.morealva.dto.ProductoListPrincipioActivoDTO;
import com.morealva.modelo.PrincipioActivo;
import com.morealva.modelo.Producto;
import com.morealva.service.IProductoService;
import com.morealva.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProductoListPrincipioActivoDTO dto) {
        Producto obj = productoService.saveTransactional(mapperUtil.map(dto.getProducto(), Producto.class), mapperUtil.mapList(dto.getListPrincipioActivo(), PrincipioActivo.class));
        URI locatioin = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();
        return ResponseEntity.created(locatioin).build();
    }

}
