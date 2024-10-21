package com.morealva.repository;

import com.morealva.modelo.PrincipioActivo;

public interface IPrincipioActivoRepo extends IGenericRepo<PrincipioActivo, Integer>{

    //Vigencia findByPaginaAndFecha(Pagina pagina, LocalDate fecha);
    PrincipioActivo findByNombre(String nombre);
}
