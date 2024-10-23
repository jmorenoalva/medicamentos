package com.morealva.service.impl;

import com.morealva.aggregates.response.ProductoDTOResponse;
import com.morealva.dto.ProductoDTO;
import com.morealva.modelo.*;
import com.morealva.repository.*;
import com.morealva.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    private final IProductoRepo repo;
    private final ILaboratorioRepo laboratorioRepo;
    private final IProductoRepo productoRepo;
    private final IPresentacionRepo presentacionRepo;
    private final IPrincipioActivoRepo principioActivoRepo;
    private final IProductoPrincipioActivoRepo productoPrincipioActivoRepo;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return repo;
    }

    @Transactional
    @Override
    public Producto createProductoAutomatico(ProductoDTOResponse productoDTOResponse, Vigencia vigencia){

        Laboratorio laboratorio = laboratorioRepo.findByNombre(String.valueOf(productoDTOResponse.getLaboratorio()).trim());

        if(laboratorio == null){
            laboratorio = new Laboratorio();
            laboratorio.setNombre(String.valueOf(productoDTOResponse.getLaboratorio()).trim());
            laboratorio.setAlias(String.valueOf(productoDTOResponse.getLaboratorio()).trim());
            laboratorio.setEstado(true);
            laboratorioRepo.save(laboratorio);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(productoDTOResponse.getFecha_creacion(), formatter);
        LocalDate fechaCreacion = localDateTime.toLocalDate();

        Producto producto = new Producto();
        producto.setIdCodigo(productoDTOResponse.getId());
        producto.setVigencia(vigencia);
        producto.setLaboratorio(laboratorio);
        producto.setNombre(String.valueOf(productoDTOResponse.getNombre()).trim());
        producto.setIndicacion(String.valueOf(productoDTOResponse.getIndicacion()).trim());
        producto.setFechaCreacion(fechaCreacion);
        producto.setPatologia(String.valueOf(productoDTOResponse.getPatologia()).trim());
        producto.setEstado_pagina(productoDTOResponse.getEstado());

        producto.setEstado(true);

        productoRepo.save(producto);

        productoDTOResponse.getPresentacion().forEach(ProductoPresentacionResponseDTO -> {

            Presentacion presentacion = new Presentacion();

            presentacion.setIdCodigo(ProductoPresentacionResponseDTO.getId());
            presentacion.setProducto(producto);
            presentacion.setIdCodProd(productoDTOResponse.getId());
            presentacion.setNombre(String.valueOf(ProductoPresentacionResponseDTO.getNombre()).trim());
            presentacion.setPvf(ProductoPresentacionResponseDTO.getPvf());
            presentacion.setPvp(ProductoPresentacionResponseDTO.getPvp());
            presentacion.setModificaciones(String.valueOf(ProductoPresentacionResponseDTO.getModificaciones()).trim());
            presentacion.setEstado(true);

            presentacionRepo.save(presentacion);

        });


        String principios = productoDTOResponse.getPrincipio();
        if (principios != null && !principios.trim().isEmpty()) {

            List<String> listPrincipios;
            if(principios.contains("+")){
                listPrincipios = Arrays.asList(principios.split("\\+"));
            }else{
                listPrincipios = Arrays.asList(principios.split(","));
            }
            listPrincipios.forEach(principio -> {

                if (principio != null && !principio.trim().isEmpty()) {
                    PrincipioActivo principioActivoExistente = principioActivoRepo.findByNombre(String.valueOf(principio).trim());

                    if (principioActivoExistente == null) {
                        PrincipioActivo principioActivo = new PrincipioActivo();
                        principioActivo.setNombre(String.valueOf(principio).trim());
                        principioActivo.setEstado(true);
                        principioActivoRepo.save(principioActivo);
                        principioActivoExistente = principioActivo;
                    }

                    if(productoPrincipioActivoRepo.findByProductoIdAndPrincipioActivoId(producto.getIdProducto(), principioActivoExistente.getIdPrincipio()) == null) {
                        productoPrincipioActivoRepo.savePrincipioActivo(producto.getIdProducto(), principioActivoExistente.getIdPrincipio());
                    }
                }

            });
        }




        return producto;
    }
}
