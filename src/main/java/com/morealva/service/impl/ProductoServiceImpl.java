package com.morealva.service.impl;

import com.morealva.aggregates.response.ProductoDTOResponse;
import com.morealva.dto.ProductoDTO;
import com.morealva.modelo.Laboratorio;
import com.morealva.modelo.Producto;
import com.morealva.modelo.Vigencia;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.ILaboratorioRepo;
import com.morealva.repository.IProductoRepo;
import com.morealva.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    private final IProductoRepo repo;
    private final ILaboratorioRepo laboratorioRepo;
    private final IProductoRepo productoRepo;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return repo;
    }

    @Override
    public Producto createProductoAutomatico(ProductoDTOResponse productoDTOResponse, Vigencia vigencia){

        Laboratorio laboratorio = laboratorioRepo.findByNombre(String.valueOf(productoDTOResponse.getLaboratorio()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(productoDTOResponse.getFecha_creacion(), formatter);
        LocalDate fechaCreacion = localDateTime.toLocalDate();

        Producto producto = new Producto();
        producto.setIdCodigo(productoDTOResponse.getId());
        producto.setVigencia(vigencia);
        producto.setLaboratorio(laboratorio);
        producto.setNombre(productoDTOResponse.getNombre());
        producto.setIndicacion(productoDTOResponse.getIndicacion());
        producto.setFechaCreacion(fechaCreacion);
        producto.setPatologia(productoDTOResponse.getPatologia());
        producto.setEstado_pagina(productoDTOResponse.getEstado());

        producto.setEstado(true);

        productoDTOResponse.getPresentacion().forEach(ProductoPresentacionResponseDTO -> {

        });

        productoRepo.save(producto);


        return producto;
    }
}
