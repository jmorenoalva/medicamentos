package com.morealva.controller;

import com.morealva.dto.PrincipioActivoDTO;
import com.morealva.modelo.PrincipioActivo;
import com.morealva.service.IPrincipioActivoService;
import com.morealva.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/principiosactivos")
@RequiredArgsConstructor
public class PrincipioActivoController {

    private final IPrincipioActivoService principioActivoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<PrincipioActivoDTO>> findAll() {
        List<PrincipioActivoDTO> list = mapperUtil.mapList(principioActivoService.findAll(), PrincipioActivoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrincipioActivoDTO> findById(@PathVariable("id") Integer id) {
        PrincipioActivo obj = principioActivoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, PrincipioActivoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PrincipioActivoDTO principioActivoDTO) {
        PrincipioActivo obj = principioActivoService.save(mapperUtil.map(principioActivoDTO, PrincipioActivo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPrincipio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrincipioActivoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PrincipioActivoDTO principioActivoDTO) {
        principioActivoDTO.setIdPrincipio(id);
        PrincipioActivo obj = principioActivoService.update(id, mapperUtil.map(principioActivoDTO, PrincipioActivo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, PrincipioActivoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        principioActivoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
