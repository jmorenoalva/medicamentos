package com.morealva.service;

import com.morealva.aggregates.response.ProductoDTOResponse;
import com.morealva.dto.ProductoDTO;
import com.morealva.modelo.Laboratorio;
import com.morealva.modelo.Producto;
import com.morealva.modelo.Vigencia;

public interface IProductoService extends ICRUD<Producto, Integer> {

    Producto createProductoAutomatico(ProductoDTOResponse productoDtoResponse, Vigencia vigencia);
}
