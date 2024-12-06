package com.morealva.repository;

import com.morealva.modelo.Pagina;

public interface IPaginaRepo extends IGenericRepo<Pagina, Integer>{

    Pagina findByCodigo(String codigo);
}
