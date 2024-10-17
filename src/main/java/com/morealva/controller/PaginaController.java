package com.morealva.controller;

import com.morealva.dto.PaginaDTO;
import com.morealva.modelo.Pagina;
import com.morealva.service.IPaginaService;
import com.morealva.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PaginaDTO paginaDTO) {
        Pagina obj = paginaService.save(mapperUtil.map(paginaDTO, Pagina.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPagina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaginaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PaginaDTO paginaDTO) {
        paginaDTO.setIdPagina(id);
        Pagina obj=paginaService.update(id, mapperUtil.map(paginaDTO, Pagina.class));

        return ResponseEntity.ok(mapperUtil.map(obj, PaginaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        paginaService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
