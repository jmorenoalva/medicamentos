package com.morealva.service;

import com.morealva.aggregates.response.ProductoDTOResponse;
import com.morealva.dto.ProductoDTO;
import com.morealva.modelo.Laboratorio;
import com.morealva.modelo.PrincipioActivo;
import com.morealva.modelo.Producto;
import com.morealva.modelo.Vigencia;

import java.util.List;

public interface IProductoService extends ICRUD<Producto, Integer> {

    Producto createProductoAutomatico(ProductoDTOResponse productoDtoResponse, Vigencia vigencia);

    Producto saveTransactional(Producto producto, List<PrincipioActivo> principio);

    Producto updateTransactional(Integer id, Producto producto, List<PrincipioActivo> principio);

    void deleteTransactional(Integer id);
}
