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
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

//    private final IProductoRepo repo;
    private final ILaboratorioRepo laboratorioRepo;
    private final IProductoRepo productoRepo;
    private final IPresentacionRepo presentacionRepo;
    private final IPrincipioActivoRepo principioActivoRepo;
    private final IProductoPrincipioActivoRepo productoPrincipioActivoRepo;
    private final IVigenciaRepo vigenciaRepo;
//    private final IProductoService productoService;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return productoRepo;
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

    @Transactional
    @Override
    public Producto saveTransactional(Producto producto, List<PrincipioActivo> principios){
        productoRepo.save(producto);
        principios.forEach(ex -> productoPrincipioActivoRepo.savePrincipioActivo(producto.getIdProducto(), ex.getIdPrincipio()));
        return producto;
    }

    @Transactional
    @Override
    public Producto updateTransactional(Integer idProducto, Producto producto, List<PrincipioActivo> principios){
        productoPrincipioActivoRepo.deletePrincipioActivo(idProducto);

        Producto productoEncontrado = productoRepo.findById(idProducto).orElse(null);
        Vigencia vigenciaEncontrado = vigenciaRepo.findById(productoEncontrado.getVigencia().getIdVigencia()).orElse(null);
        Laboratorio laboratorioEncontrado = laboratorioRepo.findById(productoEncontrado.getLaboratorio().getIdLaboratorio()).orElse(null);

        //falta vigencia y laboratorio
        productoEncontrado.setVigencia(vigenciaEncontrado);
        productoEncontrado.setLaboratorio(laboratorioEncontrado);
        productoEncontrado.setIdCodigo(producto.getIdCodigo());
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setIndicacion(producto.getIndicacion());
        productoEncontrado.setFechaCreacion(producto.getFechaCreacion());
        productoEncontrado.setPatologia(producto.getPatologia());
        productoEncontrado.setEstado_pagina(producto.getEstado_pagina());
        productoEncontrado.setEstado(producto.getEstado());
        actualizarPresentaciones(productoEncontrado, producto.getPresentaciones());

        productoRepo.save(productoEncontrado);



        principios.forEach(ex -> productoPrincipioActivoRepo.savePrincipioActivo(idProducto, ex.getIdPrincipio()));
        return producto;
    }

    private void actualizarPresentaciones(Producto productoExistente, List<Presentacion> presentacionesActualizadas){
        Map<Integer, Presentacion> presentacionesExistentes = productoExistente.getPresentaciones().stream()
                .collect(Collectors.toMap(Presentacion::getIdPresentacion, p -> p));

        for(Presentacion presentacion : presentacionesActualizadas){
            if (presentacion.getIdPresentacion() == null) {
                presentacion.setProducto(productoExistente);
//                productoExistente.getPresentaciones().add(presentacion);
                presentacionRepo.save(presentacion);
            }else{
                Presentacion presentacionExistente = presentacionesExistentes.get(presentacion.getIdPresentacion());
                presentacionExistente.setIdCodigo(presentacion.getIdCodigo());
                presentacionExistente.setIdCodProd(presentacion.getIdCodProd());
                presentacionExistente.setNombre(presentacion.getNombre());
                presentacionExistente.setPvf(presentacion.getPvf());
                presentacionExistente.setPvp(presentacion.getPvp());
                presentacionExistente.setModificaciones(presentacion.getModificaciones());
                presentacionExistente.setEstado(presentacion.getEstado());
                presentacionRepo.save(presentacionExistente);
            }
        }

        productoExistente.getPresentaciones().removeIf( p ->
                !presentacionesActualizadas.stream()
                        .map(Presentacion::getIdPresentacion)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toSet())
                        .contains(p.getIdPresentacion())

        );

    }

    @Transactional
    @Override
    public void deleteTransactional(Integer idProducto){
        Producto productoDelete = productoRepo.findById(idProducto).orElse(null);
        List<Presentacion> presentacionesDelete = productoDelete.getPresentaciones();

        for(Presentacion presentacionDelete : presentacionesDelete){
            if(presentacionDelete.getIdPresentacion() != null){
                presentacionRepo.delete(presentacionDelete);
            }
        }
        productoPrincipioActivoRepo.deletePrincipioActivo(idProducto);
        productoRepo.deleteById(idProducto);
    }
}
