package com.morealva.service;

import com.morealva.modelo.PrincipioActivo;
import com.morealva.modelo.ProductoPrincipioActivo;

import java.util.List;

public interface IProductoPrincipioActivoService {

    List<PrincipioActivo> getPrincipioActivosByProductoId(Integer id);

    ProductoPrincipioActivo getProductoByIdAndPrincipioActivoById(Integer productoId, Integer principioActivoId);
}
