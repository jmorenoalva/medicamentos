package com.morealva.controller;

import com.morealva.dto.LaboratorioDTO;
import com.morealva.modelo.Laboratorio;
import com.morealva.service.ILaboratorioService;
import com.morealva.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/laboratorios")
@RequiredArgsConstructor
public class LaboratorioController {

    private final ILaboratorioService laboratorioService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<LaboratorioDTO>> findAll() {
        List<LaboratorioDTO> list = mapperUtil.mapList(laboratorioService.findAll(), LaboratorioDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioDTO> findById(@PathVariable("id") Integer id) {
        Laboratorio obj = laboratorioService.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, LaboratorioDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody LaboratorioDTO laboratorioDTO) {
        Laboratorio obj = laboratorioService.save(mapperUtil.map(laboratorioDTO, Laboratorio.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdLaboratorio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaboratorioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody LaboratorioDTO laboratorioDTO) {
        laboratorioDTO.setIdLaboratorio(id);
        Laboratorio obj=laboratorioService.update(id, mapperUtil.map(laboratorioDTO, Laboratorio.class));

        return ResponseEntity.ok(mapperUtil.map(obj, LaboratorioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        laboratorioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
