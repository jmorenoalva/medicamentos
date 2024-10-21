package com.morealva.controller;

import com.morealva.dto.VigenciaDTO;
import com.morealva.modelo.Vigencia;
import com.morealva.service.IVigenciaService;
import com.morealva.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vigencias")
@RequiredArgsConstructor
public class VigenciaController {

    private final IVigenciaService vigenciaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<VigenciaDTO>> findAll() {
        List<VigenciaDTO> list = mapperUtil.mapList(vigenciaService.findAll(), VigenciaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VigenciaDTO> findById(@PathVariable("id") Integer id) {
        Vigencia obj = vigenciaService.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, VigenciaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VigenciaDTO vigenciaDTO) {
        Vigencia obj = vigenciaService.save(mapperUtil.map(vigenciaDTO, Vigencia.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVigencia()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VigenciaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody VigenciaDTO vigenciaDTO) {
        vigenciaDTO.setIdVigencia(id);
        Vigencia obj= vigenciaService.update(id, mapperUtil.map(vigenciaDTO, Vigencia.class));
        return ResponseEntity.ok(mapperUtil.map(obj, VigenciaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        vigenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
