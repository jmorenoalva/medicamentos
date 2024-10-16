package com.morealva.controller;

import com.morealva.dto.PaginaDTO;
import com.morealva.modelo.Pagina;
import com.morealva.service.IPaginaService;
import com.morealva.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paginas")
@RequiredArgsConstructor
public class PaginaController {

    private final IPaginaService paginaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<PaginaDTO>> findAll() {
        List<PaginaDTO> list = mapperUtil.mapList(paginaService.findAll(), PaginaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaginaDTO> findById(@PathVariable("id") Integer id) {
        Pagina obj = paginaService.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, PaginaDTO.class));
    }
}
