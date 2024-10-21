package com.morealva.service;

import com.morealva.modelo.PrincipioActivo;

import java.util.List;

public interface IProductoPrincipioActivoService {

    List<PrincipioActivo> getPrincipioActivosByProductoId(Integer id);
}
