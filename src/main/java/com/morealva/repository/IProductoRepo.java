package com.morealva.repository;

import com.morealva.modelo.Producto;
import com.morealva.modelo.Vigencia;

public interface IProductoRepo extends IGenericRepo<Producto, Integer>{

    Producto findByIdCodigoAndVigencia(Integer codigo, Vigencia vigencia);

}
